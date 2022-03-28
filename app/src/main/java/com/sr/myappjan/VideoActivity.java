package com.sr.myappjan;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_activity);

        VideoView videoView = (VideoView) findViewById(R.id.videoView);

        MediaController mediaController = new MediaController(this);
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/" +R.raw.vid);
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();
    }
}