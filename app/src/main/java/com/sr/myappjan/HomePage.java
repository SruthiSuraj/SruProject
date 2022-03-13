package com.sr.myappjan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class HomePage extends AppCompatActivity implements View.OnClickListener
{

    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);


        Button go = (Button)findViewById(R.id.go);
        go.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                EditText url = (EditText)findViewById(R.id.url);
                String data = url.getText().toString();

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("http://www."+data+".com"));
                startActivity(i);
            }
        });

        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        finish();
    }
}