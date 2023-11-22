package com.example.mastermind;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EasyLevelActivity extends AppCompatActivity {

    private Button level01;
    private Button level02;
    private Button level03;
    private Button level04;
    private Button level05;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_level);
//        LEVEL One
        level01 = findViewById(R.id.level01_btn);
        level01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EasyLevelActivity.this,EasyActivity.class);
                startActivity(intent);
            }
        });
//        LEVEL OneEnds

//        LEVEL Two

        level02 = findViewById(R.id.level02_btn);
        level02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EasyLevelActivity.this,EasyActivity2.class);
                startActivity(intent);
            }
        });
//        LEVEL TwoEnds

//        LEVEL Three

        level03 = findViewById(R.id.level03_btn);
        level03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EasyLevelActivity.this,EasyActivity3.class);
                startActivity(intent);
            }
        });
//        LEVEL ThreeEnds

//        LEVEL Four

        level04 = findViewById(R.id.level04_btn);
        level04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EasyLevelActivity.this,EasyActivity4.class);
                startActivity(intent);
            }
        });
//        LEVEL FourEnds

//        LEVEL Five

        level05 = findViewById(R.id.level05_btn);
        level05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EasyLevelActivity.this,EasyActivity5.class);
                startActivity(intent);
            }
        });
//        LEVEL FiveEnds


    }
}