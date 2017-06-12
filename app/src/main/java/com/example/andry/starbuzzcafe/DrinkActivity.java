package com.example.andry.starbuzzcafe;

import android.app.Activity;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Andry on 11.06.2017.
 */

public class DrinkActivity extends Activity{

    public static final String EXTRA_DRINKNO ="drinkNo";

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

        int drinkNo = (Integer)getIntent().getExtras().get(EXTRA_DRINKNO);
        Drink thisdrink = Drink.drinks[drinkNo];

        ImageView imageView = (ImageView) findViewById(R.id.photo);
        imageView.setImageResource(thisdrink.getImageID());
        imageView.setContentDescription(thisdrink.getName());

        TextView name = (TextView)findViewById(R.id.name);
        name.setText(thisdrink.getName());

        TextView description = (TextView)findViewById(R.id.description);
        description.setText(thisdrink.getDescription());




    }
}
