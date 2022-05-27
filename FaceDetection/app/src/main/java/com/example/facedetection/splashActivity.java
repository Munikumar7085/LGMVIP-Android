package com.example.facedetection;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.widget.VideoView;

@SuppressLint("CustomSplashScreen")
public class splashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        VideoView videoView =findViewById(R.id.splash_video);
        String videoPath= "android.resource://" +
                getPackageName() +
                "/raw/facedetectionapp";
        videoView.setVideoPath(videoPath);
        videoView.setOnCompletionListener(mediaPlayer -> new Handler().postDelayed(
                () -> {
                    startActivity(new Intent(splashActivity.this,MainActivity.class));
                    finish();
                },0
        ));
        videoView.start();
    }
}