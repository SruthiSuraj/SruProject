package com.sr.myappjan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class ContextMenuEx extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.context_menu_ex);

        ImageView img = (ImageView) findViewById(R.id.imgmenu);
        registerForContextMenu(img);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.setHeaderTitle("Context Menu");
        menu.add(0,v.getId(), 0,"Share");
        menu.add(0,v.getId(), 0,"Delete");
        menu.add(0,v.getId(), 0,"Edit");
        menu.add(0,v.getId(), 0,"Copy");
        menu.add(0,v.getId(), 0,"Move");
        menu.add("Select");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item)
    {
        Toast.makeText(this, "Selected Item: " +item.getTitle(), Toast.LENGTH_SHORT).show();
        return true;
    }
}