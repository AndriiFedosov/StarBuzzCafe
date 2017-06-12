package com.example.andry.starbuzzcafe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andry on 11.06.2017.
 */

public class Drink {

    private String name;
    private String description;
    private int imageID;

    public static final Drink[] drinks={
            new Drink("Еспрессо","Гарна кава. але її чомусь дуже мало в наше время в цьому горнятку",R.drawable.espresso),
            new Drink("Амерікано","В принципі добра кава, налито в ній на 50 мл більше ніж в еспрессо",R.drawable.americano),
            new Drink("Лате","Його полюбляють усі дівчатка та й в принципі добра кавушка",R.drawable.late),
            new Drink("Матте ","Теж саме що й латте тільлки більше молока і воно згущене",R.drawable.mate),
            new Drink("Мокіато","Типовий напіток хіпстерів та гопників",R.drawable.mokiato),
            new Drink("Капучіно","Нетиповий напіток хіпстерів та гопників",R.drawable.cuppuchino),
            new Drink("Какао","Цей напіток для того щоб сидіти дома в дощ та зігріватись в одіяльці",R.drawable.cacao),
            new Drink("Зелений чай","Дуже смачана заварена зелена трава існує з різними смаками,але добра",R.drawable.greantea),
            new Drink("Чорний чай","Його пьють самі аристократи з англіі та під овсянку",R.drawable.blacktea),
            new Drink("Чорничний чай","В принципі не погана альтернатива компоту",R.drawable.raspberrytea)
    };




    public Drink(String name, String description, int imageID) {
        this.name = name;
        this.description = description;
        this.imageID = imageID;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImageID() {
        return imageID;
    }


    @Override
    public String toString() {
        return this.name;
    }
}
