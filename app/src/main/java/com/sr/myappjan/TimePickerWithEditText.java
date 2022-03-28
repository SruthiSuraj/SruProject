package com.sr.myappjan;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class TimePickerWithEditText extends AppCompatActivity
{
    TimePickerDialog picker;
    EditText eText;
    Button btnGet;
    TextView tvw;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.time_picker_with_edit_text);

        tvw = (TextView) findViewById(R.id.texttime);
        eText = (EditText) findViewById(R.id.TimeEdit);

        eText.setInputType(InputType.TYPE_NULL);
        eText.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                final Calendar cldr = Calendar.getInstance();
                int hour = cldr.get(Calendar.HOUR_OF_DAY);
                int min = cldr.get(Calendar.MINUTE);

                picker = new TimePickerDialog(TimePickerWithEditText.this, new TimePickerDialog.OnTimeSetListener()
                {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1)
                    {
                        eText.setText(i+ ":" +i1);
                    }
                },hour,min,true);

                picker.show();
            }
        });

        btnGet = (Button) findViewById(R.id.timeget);
        btnGet.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                tvw.setText("Selected Time : " +eText.getText());
            }
        });
    }
}