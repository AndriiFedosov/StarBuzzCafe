package com.example.andry.starbuzzcafe;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.example.andry.starbuzzcafe.R;

public class TopLevelActivity extends Activity {

    private SQLiteDatabase db;
    private Cursor cursorFavorite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_level);
        //создаем адаптер и метод выбора позиции из списка
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    //создаем интен смены активности при выбори заданой позиции из списка
                    Intent intent = new Intent(TopLevelActivity.this,DrinkCategoryActivity.class);
                    //указываем какой интет будет стартовать при нажатии на позицию из списка
                    startActivity(intent);
                }
            }
        };
        //создаем список который связан с ресурсным массивм переменных по id
        ListView listView = (ListView)findViewById(R.id.list_options);
        //указываем что будет происходить при выборе данного элемента из списка
        listView.setOnItemClickListener(itemClickListener);

        ListView listFavorites = (ListView)findViewById(R.id.list_favorite);
        try {
            SQLiteOpenHelper dbhelper = new StarbuzzDatabaseHelper(this);
            db = dbhelper.getReadableDatabase();
            cursorFavorite = db.query("DRINK",
                    new String[]{"_id","NAME"},
                    "FAVORITE=1",null,null,null,null);

            CursorAdapter favoriteAdapter = new SimpleCursorAdapter(TopLevelActivity.this,
                    android.R.layout.simple_list_item_1,
                    cursorFavorite,
                    new String[]{"NAME"},
                    new int[android.R.id.text1],0);
            listFavorites.setAdapter(favoriteAdapter);
            }
            catch (SQLiteException e){
                Toast toast = Toast.makeText(this,"Database is unvariable",Toast.LENGTH_SHORT);
                toast.show();
        }
        listFavorites.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(TopLevelActivity.this,DrinkActivity.class);
                intent.putExtra(DrinkActivity.EXTRA_DRINKNO,(int) id);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        try {
            StarbuzzDatabaseHelper dbhelper = new StarbuzzDatabaseHelper(this);
            db = dbhelper.getReadableDatabase();
            Cursor newCursor= db.query("DRINK",
                    new String[]{"_id","NAME"},
                    "FAVORITE=1",null,null,null,null);
            ListView listFavorites = (ListView)findViewById(R.id.list_favorite);
            CursorAdapter adapter = (CursorAdapter)listFavorites.getAdapter();
            adapter.changeCursor(newCursor);
            cursorFavorite =newCursor;
        }
        catch (SQLiteException e){
            Toast toast = Toast.makeText(this,"Database is unvariable",Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        cursorFavorite.close();
        db.close();
    }
}
