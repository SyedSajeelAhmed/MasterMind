package com.example.mastermind;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

import java.security.PublicKey;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private TextView name;
    Dialog mDialog;
    ImageButton music_play;
    boolean isResume;
    MediaPlayer music;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        Play button
        Intent intent = new Intent(this, PlayScreen.class);

        button = findViewById(R.id.btn_play);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });
//        Play button End


//        Exit App
        btn2 = findViewById(R.id.btn_Exit);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                music.release();
                finish();
            }
        });
//        Exit App End


//        Help Popup
        btn3 = findViewById(R.id.btn_Help);
        mDialog = new Dialog(this);

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDialog.setContentView(R.layout.popup);
                mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                mDialog.show();
            }
        });
//        Help Popup End

//  Music
        music_play = findViewById(R.id.Music_play);
        if (!isResume){
            isResume=true;
            music = MediaPlayer.create(MainActivity.this,R.raw.music);
            music.start();
            music.setLooping(true);
        }


        music_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isResume){
                        music.start();
                        isResume=true;
                        music_play.setImageDrawable(getResources().getDrawable(
                                R.drawable.ic_sound_play
                        ));
                }

                else {
                    isResume=false;
                    onpause();
                    music_play.setImageDrawable(getResources().getDrawable(
                    R.drawable.ic_sound_pause
                    ));

                }
            }

        });
 
// Music End
    }
protected void onpause(){
        super.onPause();
        music.pause();
    }

}