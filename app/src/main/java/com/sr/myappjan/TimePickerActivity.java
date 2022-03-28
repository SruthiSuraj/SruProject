package com.sr.myappjan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class TimePickerActivity extends AppCompatActivity
{

    TimePicker picker;
    Button btnGet;
    TextView tvw;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.time_picker_activity);

        tvw = (TextView) findViewById(R.id.textView6);
        picker = (TimePicker) findViewById(R.id.TimePicker1);
        picker.setIs24HourView(true);

        btnGet = (Button) findViewById(R.id.getTime);
        btnGet.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                int hour, min;
                String am_pm;

                if(Build.VERSION.SDK_INT >= 23)
                {
                    hour = picker.getHour();
                    min = picker.getMinute();
                }
                else
                {
                    hour = picker.getCurrentHour();
                    min = picker.getCurrentMinute();
                }
                if(hour>12)
                {
                    am_pm = "PM";
                    hour = hour - 12 ;
                }
                else
                {
                    am_pm = "AM";
                }
                tvw.setText("Selected Time : " +hour+ ":" +min+ " " +am_pm);
            }
        });
    }
}