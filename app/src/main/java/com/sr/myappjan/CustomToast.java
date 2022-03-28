package com.sr.myappjan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CustomToast extends AppCompatActivity
{

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_toast);

        button = (Button) findViewById(R.id.btnemail);

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.custom_toast_design,(ViewGroup) findViewById(R.id.customToastLayout));
                TextView tv = (TextView) layout.findViewById(R.id.txtemail);
                tv.setText("Email Notification...");
                Toast toast = new Toast(getApplicationContext());
                toast.setGravity(Gravity.TOP,0,100);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setView(layout);
                toast.show();
            }
        });
    }
}