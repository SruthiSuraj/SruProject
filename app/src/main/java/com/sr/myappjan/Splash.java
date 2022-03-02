package com.sr.myappjan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Splash extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        ImageView iv = (ImageView)findViewById(R.id.imageView);
        Animation fade = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade);
        iv.startAnimation(fade);

//        Thread obj = new Thread()
//        {
//            @Override
//            public void run()
//            {
//                try {
//                    sleep(5000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                Intent i = new Intent(getApplicationContext(),Login.class);
//                startActivity(i);
//                finish();
//            }
//        };
//        obj.start();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                Intent i = new Intent(getApplicationContext(), Login2.class);
                startActivity(i);
                finish();
            }
        }, 3000);
    }
}