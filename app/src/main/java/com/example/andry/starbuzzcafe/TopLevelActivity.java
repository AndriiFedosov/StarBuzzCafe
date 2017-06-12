package com.example.andry.starbuzzcafe;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.andry.starbuzzcafe.R;

public class TopLevelActivity extends Activity {

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


    }
}
