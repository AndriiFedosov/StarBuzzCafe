package com.example.andry.starbuzzcafe;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;
import android.database.Cursor;
import android.widget.CursorAdapter;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Andry on 11.06.2017.
 */
    //создаем активность для выбора напитка и наследуемся от ListActivity
    // для того чтобы не создавать макет
    //регистрируем данную активность в AndroidManifest.xml


public class DrinkCategoryActivity extends ListActivity{
    private SQLiteDatabase db;
    private Cursor cursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //в методе создния активности создаем лист перечисления
        ListView listDrink= getListView();
        //созадем Адаптер который преобразует наш список напитков в лист
        try {
            SQLiteOpenHelper starbuzzDatabaseHelper = new StarbuzzDatabaseHelper(this);
            db = starbuzzDatabaseHelper.getReadableDatabase();

            cursor = db.query("DRINK",
                                new String[]{"_id","NAME"},
                                null,null,null,null,null);
            CursorAdapter listAdapter = new SimpleCursorAdapter(this,
                    android.R.layout.simple_list_item_1,
                    cursor,
                    new String[]{"NAME"},
                    new int[]{android.R.id.text1},
                    0){
            };
            listDrink.setAdapter(listAdapter);

        }catch (SQLiteException e){
            Toast toast =Toast.makeText(this,"Database is unvariable!!!",Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        cursor.close();
        db.close();
    }

    //создаем метод слушатель событий
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        //при нажатии на какой либо элемент списка будет создаваться нова актвиность
        Intent intent = new Intent(DrinkCategoryActivity.this, DrinkActivity.class);
        //в активность будет передано номер элемента в массиве
        intent.putExtra(DrinkActivity.EXTRA_DRINKNO,(int)id);
        //запуск новой активности
        startActivity(intent);
    }
}
