package com.sr.myappjan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class ActivityLifecycle extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);
        Log.d("Life Cycle", "OnCreate Executed");
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        Log.d("Life Cycle", "OnStart Executed");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Life Cycle", "OnResume Executed");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Life Cycle", "OnPause Executed");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Life Cycle", "OnStop Executed");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Life Cycle", "OnRestart Executed");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Life Cycle", "OnDestroy Executed");
    }
}