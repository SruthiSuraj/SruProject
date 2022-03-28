package com.sr.myappjan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class OptionMenuEx extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.option_menu_ex);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.option,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        Toast.makeText(getApplicationContext(), "Selected : " +item.getTitle(), Toast.LENGTH_SHORT).show();

        switch (item.getItemId())
        {
            case R.id.search:
                //write code
                return true;

            case R.id.upload:
                //write code
                return true;

            case R.id.copy:
                //write code
                return true;

            case R.id.print:
                //write code
                return true;

            case R.id.share:
                //write code
                return true;

            case R.id.bookmark:
                //write code
                return true;

            case R.id.exit:
                finish();
                return true;

            default:


                return super.onOptionsItemSelected(item);
        }
    }
}