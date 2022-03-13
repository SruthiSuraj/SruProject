package com.sr.myappjan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

public class Grid extends AppCompatActivity {

    String fruits[] = {"Mango","Banana","Grapes","Apple","Orange","Pineapple","Kiwi Fruit","Lemon"};
    int fruitimg[]= {R.drawable.mango,R.drawable.banana,R.drawable.grapes,R.drawable.apple,
            R.drawable.orange,R.drawable.pineapple,R.drawable.kiwi,R.drawable.lemon};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid);

        GridView gv = (GridView) findViewById(R.id.grid);

        CustomGrid customGrid = new CustomGrid(getApplicationContext(),fruits,fruitimg);
        gv.setAdapter(customGrid);
    }
}