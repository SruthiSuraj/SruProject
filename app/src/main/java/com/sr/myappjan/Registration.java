package com.sr.myappjan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class Registration extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton radioButton;
    CheckBox mal, eng, hi;
    String dist[] = {"Kasarkode","Kannur","Kozhikode","Wayanad","Malappuram","Palakkad","Thrissur"};
    Spinner district;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);
        radioGroup = (RadioGroup)findViewById(R.id.ge);

        mal = (CheckBox)findViewById(R.id.malayalam);
        eng = (CheckBox)findViewById(R.id.english);
        hi = (CheckBox)findViewById(R.id.hindi);

        Button btn = (Button)findViewById(R.id.submit);
        district = (Spinner)findViewById(R.id.spinnerdist);
        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_dropdown_item_1line,dist);
        district.setAdapter(adapter);
        district.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {
                Toast.makeText(getApplicationContext(),dist[i],Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                EditText fn = (EditText)findViewById(R.id.FirstName);
                EditText p = (EditText)findViewById(R.id.pswd);
                String user = fn.getText().toString();
                String pw = p.getText().toString();
                Intent i = new Intent(getApplicationContext(),Login2.class);
                i.putExtra("username",user);
                i.putExtra("password",pw);
                startActivity(i);
            }
//            {
//                String language = "Selected Language";
//
//                if(mal.isChecked())
//                {
//                    language += "\nMalayalam";
//                }
//                if(eng.isChecked())
//                {
//                    language += "\nEnglish";
//                }
//                if(hi.isChecked())
//                {
//                    language += "\nHindi";
//                }
//                Toast.makeText(getApplicationContext(),language,Toast.LENGTH_LONG).show();
//            }
        });

    }

//    public void sub(View view)
//    {
//        radioButton = (RadioButton)findViewById(radioGroup.getCheckedRadioButtonId());
//        String gen = radioButton.getText().toString();
//        Toast.makeText(getApplicationContext(),"Your gender is" +gen,Toast.LENGTH_SHORT).show();
//    }
}