package com.example.sharita.miomedellin;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class Splash extends AppCompatActivity {
    private static final long SPLASH_DELAY = 4000;
    protected TextView customFont;
    protected TextView customFont2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        /*this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        WindowManager.LayoutParams.FLAG_FULLSCREEN;
        /*android.support.v7.app.ActionBar actionBar=getSupportActionBar();
        actionBar.hide();                                                   */

        setContentView(R.layout.activity_splash);
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Intent i = new Intent().setClass(Splash.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        };

        Timer timer = new Timer();
        timer.schedule(task, SPLASH_DELAY);
        customFont= (TextView) findViewById(R.id.fuente);
        Typeface font= Typeface.createFromAsset(getAssets(), "gloriahallelujah.ttf");
        customFont.setTypeface(font);
        customFont2= (TextView) findViewById(R.id.fuente2);
        Typeface font2= Typeface.createFromAsset(getAssets(), "gloriahallelujah.ttf");
        customFont2.setTypeface(font2);
    }
}
