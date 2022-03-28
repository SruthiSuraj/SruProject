package com.sr.myappjan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class PopupMenuEx extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_menu_ex);

        Button btn = (Button) findViewById(R.id.popup);
        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                PopupMenu popup = new PopupMenu(PopupMenuEx.this, view);
                popup.setOnMenuItemClickListener(PopupMenuEx.this);
                popup.inflate(R.menu.popup);
                popup.show();
            }
        });
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem)
    {
        Toast.makeText(this, "Selected Item: " +menuItem.getTitle(), Toast.LENGTH_SHORT).show();

        switch (menuItem.getItemId())
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
                return super.onOptionsItemSelected(menuItem);
        }
    }
}