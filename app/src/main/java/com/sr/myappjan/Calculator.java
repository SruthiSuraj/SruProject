package com.sr.myappjan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Calculator extends AppCompatActivity
{

    TextView answer,equation;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);

        Button num1 = (Button) findViewById(R.id.one);
        Button num2 = (Button) findViewById(R.id.two);
        Button sum = (Button) findViewById(R.id.plus);
        Button equal = (Button) findViewById(R.id.equ);

        answer = (TextView) findViewById(R.id.answer);
        equation = (TextView)findViewById(R.id.equation);

        num1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String n1 = num1.getText().toString();
                equation.setText(n1);
            }
        });

        num2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String n2 = num2.getText().toString();
                equation.setText(n2);
            }
        });

        sum.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String o = sum.getText().toString();
            }
        });

        equal.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String s = equation.getText().toString();
                String s1 = equation.getText().toString();
                int a1 = Integer.parseInt(s);
                int a2 = Integer.parseInt(s1);
                int add = a1 + a2;
                answer.setText(add);
            }
        });
    }
}