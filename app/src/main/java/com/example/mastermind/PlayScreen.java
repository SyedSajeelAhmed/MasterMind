package com.example.mastermind;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class PlayScreen extends AppCompatActivity {
    private Button btn_easy;
    private Button btn_medium;
    Button btn_hard;
    ImageButton btn_back;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_screen);

//    Easy fragment
        btn_easy = findViewById(R.id.btn_Easy);
        btn_easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PlayScreen.this, EasyLevelActivity.class);
                startActivity(intent);
            }
        });

//    Easy fragment ends

//    Medium fragment
        btn_medium = findViewById(R.id.btn_Medium);
        btn_medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PlayScreen.this, MediumLevelActivity.class);
                startActivity(intent);
            }
        });

//    Medium fragment ends

//    Hard fragment
        btn_hard = findViewById(R.id.btn_Hard);
        btn_hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PlayScreen.this, HardLevelActivity.class);
                startActivity(intent);
            }
        });





//    Hard fragment ends

//        Back button
         btn_back = findViewById(R.id.back_playScreen);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
//        Back button Ends
    }
}
