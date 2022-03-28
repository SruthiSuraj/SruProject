package com.sr.myappjan;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.NumberPicker;
import android.widget.TextView;

public class NumberPickerActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.number_picker_activity);

        final TextView tv = (TextView) findViewById(R.id.tv);
        NumberPicker np = (NumberPicker) findViewById(R.id.np);

        tv.setTextColor(Color.parseColor("#FFD56B3B"));

        np.setMinValue(0);
        np.setMaxValue(50);

        //Gets whether the selector wheel wraps when reaching the min/max value
        np.setWrapSelectorWheel(false);

        np.setOnValueChangedListener(new NumberPicker.OnValueChangeListener()
        {
            @Override
            public void onValueChange(NumberPicker numberPicker, int oldVal, int newVal)
            {
                tv.setText("Selected Number : " +newVal);
            }
        });
    }
}