package com.example.livewire;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.TextView;

import com.example.livewire.views.GameView;

public class gamepage extends AppCompatActivity {
    MediaPlayer backmp;

    public static TextView timerv;
    public static Button submit;
    public CountDownTimer counter;
    public boolean timerun;
    public long timeleft = 60000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_gamepage);
        setContentView(new GameView(this));
        timerv = findViewById(R.id.timer);

        submit = findViewById(R.id.button);



        backmp = MediaPlayer.create(this,R.raw.bgm);
        if (backmp != null) {
            backmp.start();
            backmp.setLooping(true);
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (backmp != null) {
            backmp.start();
            backmp.setLooping(true);
        }


    }

    private void startstop () {
        if (timerun) {
            stopTimer();
        } else {
            startTimer();
        }
    }

    public void stopTimer() {
        counter.cancel();
        timerun = false;
    }

    public void startTimer() {
        counter = new CountDownTimer(timeleft,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeleft = millisUntilFinished;
                updateTimer();
            }

            @Override
            public void onFinish() {

            }
        }.start();
        timerun = true;
    }

    public void updateTimer() {
        int minutes = (int) timeleft/60000;
        int seconds = (int) (timeleft % 60000)/1000;
        String timetext;
        timetext = "" + minutes;
        timetext += ":";
        if (seconds < 10) {
            timetext += "0";
        }
        timetext += seconds;
        timerv.setText(timetext);

    }


}