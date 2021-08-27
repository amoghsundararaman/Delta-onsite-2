package com.example.livewire;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    public ImageButton play;
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        play = findViewById(R.id.imageButton2);

        mp =MediaPlayer.create(MainActivity.this,R.raw.wire_intro);
        mp.setLooping(true);
        mp.start();


    }

    public void startplay(View view) {
        mp.stop();
        Intent intent =new Intent(this,gamepage.class);
        startActivity(intent);
        finish();
    }
}
