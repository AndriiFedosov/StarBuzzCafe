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

//регистрируем данную активность в AndroidManifest.xml
public class DrinkActivity extends Activity{

    //строковая переменная для передачи ресурса в нашем случаее номера элемента массива
    public static final String EXTRA_DRINKNO ="drinkNo";

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

        //в переменную номера напитка принимаем данные из другой активности по ключу
        int drinkNo = (Integer)getIntent().getExtras().get(EXTRA_DRINKNO);

        //указываем какой именно напиток из массива будет показанж
        Drink thisdrink = Drink.drinks[drinkNo];

        //создаем макет изображения и находим его по id
        ImageView imageView = (ImageView) findViewById(R.id.photo);
        //указываем что ресурсом изображения будет ссылка на изображение выбраного напитка
        imageView.setImageResource(thisdrink.getImageID());
        //указываем что ресурсом описания будет имя выбраного напитка
        imageView.setContentDescription(thisdrink.getName());

        //создаем текстовое поле и находим его по id
        TextView name = (TextView)findViewById(R.id.name);
        //указываем что ресурсом имени будет ссылка на имя выбраного напитка
        name.setText(thisdrink.getName());

        //создаем текстовое поле и находим его по id
        TextView description = (TextView)findViewById(R.id.description);
        //указываем что ресурсом описания будет ссылка на описание выбраного напитка
        description.setText(thisdrink.getDescription());




    }
}
