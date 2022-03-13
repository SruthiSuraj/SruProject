package com.sr.myappjan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login2 extends AppCompatActivity implements View.OnClickListener
{
    EditText user1, pswd;
    Button cancel;
    String us;
    String ps;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login2);

        user1 = (EditText) findViewById(R.id.textView8);
        pswd = (EditText) findViewById(R.id.editTextTextPassword2);

        cancel = (Button) findViewById(R.id.cancel);
        cancel.setOnClickListener(this);

        Intent inr = getIntent();
        us = inr.getStringExtra("username");
        ps = inr.getStringExtra("password");
        user1.setText(us);
        pswd.setText(ps);
    }

    public void click_to_login(View view)
    {
        String uname = user1.getText().toString();
        String pass = pswd.getText().toString();

        if(uname.equals(us) && pass.equals(ps))
        {
            Intent i = new Intent(getApplicationContext(),FruitList.class);
            startActivity(i);
        }
        else
        {
            Toast.makeText(getApplicationContext(),"User Name or Password Incorrect",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onClick(View view)
    {
        Intent r = new Intent(getApplicationContext(),Registration.class);
        startActivity(r);
    }

}