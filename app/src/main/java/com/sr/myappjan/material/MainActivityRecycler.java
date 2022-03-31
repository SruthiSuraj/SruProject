package com.sr.myappjan.material;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.sr.myappjan.R;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivityRecycler extends AppCompatActivity
{
    ArrayList<String> personName = new ArrayList<>(Arrays.asList("Person 1", "Person 2", "Person 3",
            "Person 4", "Person 5", "Person 6","Person 7",
            "Person 8","Person 9","Person 10","Person 11","Person 12","Person 13","Person 14"));

    ArrayList<Integer> personImage = new ArrayList<>(Arrays.asList(R.drawable.rm, R.drawable.jin,R.drawable.suga,
            R.drawable.jhope,R.drawable.jimin,R.drawable.v,R.drawable.jk,R.drawable.rm, R.drawable.jin,R.drawable.suga,
            R.drawable.jhope,R.drawable.jimin,R.drawable.v,R.drawable.jk));

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_recycler_activity);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 3,
                LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(gridLayoutManager);

        CustomAdapterRecycler customAdapterRecycler = new CustomAdapterRecycler(MainActivityRecycler.this, personName,personImage);
        recyclerView.setAdapter(customAdapterRecycler);
    }
}