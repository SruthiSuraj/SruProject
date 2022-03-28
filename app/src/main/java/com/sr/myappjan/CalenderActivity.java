package com.sr.myappjan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.TextView;

public class CalenderActivity extends AppCompatActivity
{

    CalendarView calender;
    TextView date;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calender_activity);

        calender = (CalendarView) findViewById(R.id.calendarView);
        date = (TextView) findViewById(R.id.textView9);

        calender.setOnDateChangeListener(new CalendarView.OnDateChangeListener()
        {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2)
            {
                String Date = i2+ "/" +(i1+1)+ "/" +i;
                date.setText(Date);
            }
        });
    }
}