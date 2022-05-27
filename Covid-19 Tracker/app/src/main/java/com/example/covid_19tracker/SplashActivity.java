package com.example.covid_19tracker;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.VideoView;

import com.example.covid_19tracker.databinding.ActivitySplashBinding;


@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {
    ActivitySplashBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

      binding=ActivitySplashBinding.inflate(getLayoutInflater());
        View root=binding.getRoot();
        setContentView(root);
        String uriPath = "android.resource://"+getPackageName()+"/"+R.raw.covid;
        Uri uri = Uri.parse(uriPath);
       binding.splashVideo.setVideoURI(uri);
       binding.splashVideo.setZOrderOnTop(true);
        binding.splashVideo.setOnCompletionListener(mediaPlayer -> new Handler().postDelayed(
                () -> {
                    startActivity(new Intent(SplashActivity.this,MainActivity.class));
                    finish();
                },0
        ));
        binding.splashVideo.start();
    }
}