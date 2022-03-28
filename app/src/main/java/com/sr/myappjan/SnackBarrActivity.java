package com.sr.myappjan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class SnackBarrActivity extends AppCompatActivity
{

    Button btn;
    CoordinatorLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.snack_bar_activity);

        btn = findViewById(R.id.btnDlt);
        layout = findViewById(R.id.layout);

        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //create Snack bar
                Snackbar snackbar = Snackbar.make(layout,"Message deleted",Snackbar.LENGTH_LONG).setAction("UNDO", new View.OnClickListener()
                {
                    @Override
                    public void onClick(View view)
                    {
                        Toast.makeText(SnackBarrActivity.this,"Undo clicked",Toast.LENGTH_SHORT).show();
                    }
                });
                snackbar.show();
            }
        });
    }
}