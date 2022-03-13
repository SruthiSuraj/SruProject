package com.sr.myappjan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.ThemedSpinnerAdapter;

public class ProgressBarActivity extends AppCompatActivity {

    int progress =0;
    ProgressBar progressBar;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progress_bar);

        b = (Button) findViewById(R.id.b);
        progressBar = (ProgressBar) findViewById(R.id.progressBar2);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setProgressValue(progress);
            }
        });
    }
    private void setProgressValue(int progress)
    {
       progressBar.setProgress(progress);

       Thread thread = new Thread(new Runnable()
       {
           @Override
           public void run()
           {
               try
               {
                   Thread.sleep(1000);
               }
               catch (InterruptedException e)
               {
                   e.printStackTrace();
               }
               setProgressValue(progress + 10);
           }
       });
       thread.start();
    }
}