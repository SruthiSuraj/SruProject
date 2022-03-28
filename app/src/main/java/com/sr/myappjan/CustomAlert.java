package com.sr.myappjan;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class CustomAlert extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_alert);
    }

    public void simpleAlert(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Simple Alert");
        builder.setMessage("You have a Message");
        builder.setPositiveButton("OK",
                new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        Toast.makeText(getApplicationContext(),"OK was clicked",Toast.LENGTH_SHORT).show();
                    }
                });
        builder.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                Toast.makeText(getApplicationContext(), android.R.string.no, Toast.LENGTH_SHORT).show();
            }
        });
        builder.setCancelable(false);
        builder.show();
    }

    public void withItems(View view)
    {
        final String[] items= {"Apple","Banana","Orange"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("List of Items").setItems(items, new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                Toast.makeText(getApplicationContext(),items[i]+ "is clicked", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setPositiveButton("OK",null);
        builder.setNegativeButton("Cancel",null);
        builder.setNeutralButton("Exit",null);
        builder.setPositiveButtonIcon(getResources().getDrawable(android.R.drawable.btn_plus,getTheme()));
        //builder.setIcon(getResources().getDrawable(android.R.drawable.xxx,getTheme()));

        AlertDialog alertDialog = builder.create();
        alertDialog.show();

        Button button = alertDialog.getButton(DialogInterface.BUTTON_POSITIVE);
        button.setBackgroundColor(Color.BLACK);
        button.setPadding(0,0,20,0);
        button.setTextColor(Color.WHITE);
    }

    public void withMultiChoiceItems(View view)
    {
        final String[] items= {"Apple","Banana","Orange"};
        final ArrayList<Integer> selectedList = new ArrayList<>();

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("List Choice Dialog Box");
        builder.setMultiChoiceItems(items, null, new DialogInterface.OnMultiChoiceClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean isChecked)
            {
                if(isChecked)
                {
                    Log.d("API123","which"+i);
                    selectedList.add(i);
                }
                else if(selectedList.contains(i))
                {
                    selectedList.remove(Integer.valueOf(i));
                }
            }
        });

        builder.setPositiveButton("Done", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                ArrayList<String> selectedString = new ArrayList<>();

                for(int j=0;j<selectedList.size();j++)
                {
                    selectedString.add(items[selectedList.get(j)]);
                }
                Toast.makeText(getApplicationContext(),
                        "Selected items are " +Arrays.toString(selectedString.toArray()), Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }

    public void withEditText(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("With Edit Text");

        final EditText input = new EditText(CustomAlert.this);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        input.setLayoutParams(lp);
        builder.setView(input);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                Toast.makeText(getApplicationContext(),"Text Entered is " +input.getText(),Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }

    public void withImageView(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogLayout = inflater.inflate(R.layout.alert_image,null);
        builder.setPositiveButton("OK",null);
        builder.setView(dialogLayout);
        builder.show();
    }

    public void withSeekBar(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("With Seek Bar");
        final SeekBar seekBar = new SeekBar(CustomAlert.this);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        seekBar.setLayoutParams(lp);
        builder.setView(seekBar);
        builder.setOnDismissListener(new DialogInterface.OnDismissListener()
        {
            @Override
            public void onDismiss(DialogInterface dialogInterface)
            {
                Toast.makeText(getApplicationContext(), "Alert Dialog is Dismissed", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                Toast.makeText(getApplicationContext(),"Progress is " +seekBar.getProgress(),Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }

    public void withRatingBar(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        builder.setTitle("Rating Bar");
        View dialogLayout = inflater.inflate(R.layout.alert_ratingbar,null);
        final RatingBar ratingBar = dialogLayout.findViewById(R.id.ratingBar);
        builder.setView(dialogLayout);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                Toast.makeText(getApplicationContext(),"Rating is " +ratingBar.getRating(),Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }
}