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

public class DrinkCategoryActivity extends ListActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListView listDrink= getListView();
        ArrayAdapter<Drink> listAdapter =
                new ArrayAdapter<Drink>(this,android.
                        R.layout.simple_list_item_1,Drink.drinks);
        listDrink.setAdapter(listAdapter);

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Intent intent = new Intent(DrinkCategoryActivity.this, DrinkActivity.class);
        intent.putExtra(DrinkActivity.EXTRA_DRINKNO,(int)id);
        startActivity(intent);
    }
}
