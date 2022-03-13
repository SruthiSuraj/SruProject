package com.sr.myappjan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity implements View.OnClickListener {

    EditText user1, pswd;
    Button login;
    String us = "admin";
    String ps = "123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        user1 = (EditText) findViewById(R.id.editTextTextPersonName);
        pswd = (EditText) findViewById(R.id.editTextTextPassword);

        login = (Button) findViewById(R.id.button);
        login.setOnClickListener(this);

    }

    @Override
    public void onClick(View view)
    {
        String uname = user1.getText().toString();
        String pass = pswd.getText().toString();
        if (us.equals(uname) && ps.equals(pass))
        {
            Intent i = new Intent(getApplicationContext(), FruitList.class);
            startActivity(i);
        }
        else
        {
            Toast.makeText(getApplicationContext(), "User name or password incorrect", Toast.LENGTH_SHORT).show();
        }
    }
}
