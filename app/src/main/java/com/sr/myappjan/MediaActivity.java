package com.sr.myappjan;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class MediaActivity extends AppCompatActivity
{
    private ImageButton forwardbtn, backwardbtn, pausebtn, playbtn;
    private MediaPlayer mPlayer;
    private TextView songName, startTime, songTime;
    private SeekBar songPrgs;
    private static int oTime = 0, sTime = 0, eTime = 0, fTime = 5000, bTime = 5000;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.media_activity);
        forwardbtn = (ImageButton) findViewById(R.id.btnForward);
        backwardbtn = (ImageButton) findViewById(R.id.btnBackward);
        pausebtn = (ImageButton) findViewById(R.id.btnPause);
        playbtn = (ImageButton) findViewById(R.id.btnPlay);

        songName = (TextView) findViewById(R.id.txtSname);
        songName.setText("Quite Time");

        startTime =(TextView) findViewById(R.id.txtStartTime);
        songTime =(TextView) findViewById(R.id.txtSongTime);

        mPlayer = MediaPlayer.create(this, R.raw.music);

        songPrgs = (SeekBar) findViewById(R.id.sBar);
        songPrgs.setClickable(false);

        pausebtn.setEnabled(false);

        playbtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(MediaActivity.this, "Playing Audio", Toast.LENGTH_SHORT).show();
                mPlayer.start();
                eTime = mPlayer.getDuration();
                sTime = mPlayer.getCurrentPosition();

                if(oTime == 0)
                {
                    songPrgs.setMax(eTime);
                    oTime = 1;
                }
                songTime.setText(String.format("%d:%d", TimeUnit.MILLISECONDS.toMinutes(eTime),
                        TimeUnit.MILLISECONDS.toSeconds(eTime) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(eTime))));
                startTime.setText(String.format("%d:%d", TimeUnit.MILLISECONDS.toMinutes(sTime),
                        TimeUnit.MILLISECONDS.toSeconds(sTime) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(sTime))));
                songPrgs.setProgress(sTime);
                handler.postDelayed(updateSongTime,100);
                pausebtn.setEnabled(true);
                playbtn.setEnabled(false);
            }
        });

        pausebtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                mPlayer.pause();
                pausebtn.setEnabled(false);
                playbtn.setEnabled(true);
                Toast.makeText(getApplicationContext(),"Pausing Audio", Toast.LENGTH_SHORT).show();
            }
        });

        forwardbtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if((sTime + fTime) <= eTime)
                {
                    sTime = sTime + fTime;
                    mPlayer.seekTo(sTime);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Cannot forward the audio", Toast.LENGTH_SHORT).show();
                }
                if(!playbtn.isEnabled())
                {
                    playbtn.setEnabled(true);
                }
            }
        });

        backwardbtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if((sTime - bTime) > 0)
                {
                    sTime = sTime - bTime;
                    mPlayer.seekTo(sTime);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Cannot backward the audio", Toast.LENGTH_SHORT).show();
                }
                if(!playbtn.isEnabled())
                {
                    playbtn.setEnabled(true);
                }
            }
        });

    }
    private Runnable updateSongTime = new Runnable()
    {
        @Override
        public void run()
        {
            sTime = mPlayer.getCurrentPosition();
            startTime.setText(String.format("%d:%d", TimeUnit.MILLISECONDS.toMinutes(sTime),
                    TimeUnit.MILLISECONDS.toSeconds(sTime) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(sTime))));
            songPrgs.setProgress(sTime);
            handler.postDelayed(this,100);
        }
    };
}