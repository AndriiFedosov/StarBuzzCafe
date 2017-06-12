package com.example.andry.starbuzzcafe;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Andry on 11.06.2017.
 */
    //создаем активность для выбора напитка и наследуемся от ListActivity
    // для того чтобы не создавать макет
    //регистрируем данную активность в AndroidManifest.xml
public class DrinkCategoryActivity extends ListActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //в методе создния активности создаем лист перечисления
        ListView listDrink= getListView();
        //созадем Адаптер который преобразует наш список напитков в лист
        ArrayAdapter<Drink> listAdapter =
                new ArrayAdapter<Drink>(this,android.
                        R.layout.simple_list_item_1,Drink.drinks);
        //указываем что лист перечислений будет использывать адаптер созданый ранее
        listDrink.setAdapter(listAdapter);

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
