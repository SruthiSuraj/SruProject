package com.sr.myappjan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomFruits extends BaseAdapter
{

    Context context;
    String fruits[];
    int fruitimg[];
    LayoutInflater inflater;

    public CustomFruits(Context applicationContext, String[] fruits, int[] fruitimg)
    {
        context = applicationContext;
        this.fruits=fruits;
        this.fruitimg=fruitimg;
    }

    @Override
    public int getCount() {
        return fruits.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View clayout, ViewGroup viewGroup)
    {
        inflater = LayoutInflater.from(context);
        clayout = inflater.inflate(R.layout.customlist,null);
        ImageView image = (ImageView)clayout.findViewById(R.id.imgview);
        TextView text = (TextView)clayout.findViewById(R.id.txt);
        image.setImageResource(fruitimg[i]);
        text.setText(fruits[i]);
        return clayout;
    }
}
