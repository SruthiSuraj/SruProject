package com.sr.myappjan.material;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.sr.myappjan.R;

public class SecondActivityRecycler extends AppCompatActivity
{
    ImageView selectedImage;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity_recycler);

        selectedImage = (ImageView) findViewById(R.id.selectedImg);
        Intent intent = getIntent();
        selectedImage.setImageResource((intent.getIntExtra("image",0)));
        startActivity(intent);
    }

}
