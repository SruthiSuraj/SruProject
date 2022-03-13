package com.sr.myappjan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class FruitList extends AppCompatActivity {

    String fruits[] = {"Mango","Banana","Grapes","Apple","Orange","Pineapple","Kiwi Fruit","Lemon"};
    int fruitimg[]= {R.drawable.mango,R.drawable.banana,R.drawable.grapes,R.drawable.apple,
                     R.drawable.orange,R.drawable.pineapple,R.drawable.kiwi,R.drawable.lemon};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fruit_list);

        ListView fruit = (ListView) findViewById(R.id.fruitlist);

        CustomFruits customFruits = new CustomFruits(getApplicationContext(),fruits,fruitimg);
        fruit.setAdapter(customFruits);
    }
}