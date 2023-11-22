package com.example.mastermind;

import static com.example.mastermind.R.id.backH_btn;
import static com.example.mastermind.R.id.questionH1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.Random;

public class MediumActivity3 extends AppCompatActivity {
    LinearLayout WinGame_layout;
    ImageButton back;
    private int prescounter = 0;
    private int maxprescounter = 5;
    private String[] keys = {"A","T","E","S","L"};
    private String textAnswer="TALES";
    Dialog mDialog;
    Button btn_tryagain;
    ImageButton Question_h1;
    Button btn_next;
    //timer
    LinearLayout linearLayout;
    private static final long Start_time_in_millis = 60000;
    private TextView mTextviewCountdown;
    private CountDownTimer mCountDownTimer;
    private Boolean mTimerRunning;
    private Long mTimeLeftinmillis = Start_time_in_millis;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medium3);



//           Quesion

        mDialog = new Dialog(this);
        Question_h1 = findViewById(questionH1);
        Question_h1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDialog.setContentView(R.layout.mquestion3);
                mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                mDialog.show();

            }
        });
//        QuestionEnds



//        BtnNextLevel

        WinGame_layout = findViewById(R.id.WinGame_layout);

        btn_next= findViewById(R.id.btn_next);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediumActivity3.this,MediumActivity4.class);
                startActivity(intent);
                finish();
            }
        });
        btn_tryagain = findViewById(R.id.btn_tryagain);
        btn_tryagain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent intent = new Intent(MediumActivity3.this,MediumActivity3.class);
                startActivity(intent);
            }

        });
//        BtnNextLevelEnds


//        backButton
        back = findViewById(backH_btn);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
//        backButtonEnds

//        Hard EditText
        keys = shuffleArrays(keys);
        for(String key : keys){
            addView(((LinearLayout) findViewById(R.id.layout_parent)), key, ((EditText) findViewById(R.id.edit_textH)));
        }
        maxprescounter = 5;


//    Timer
        linearLayout = findViewById(R.id.ingameLinearlayout);
        mTextviewCountdown = findViewById(R.id.timerH1);
        starttimer();


        updateCountdownText();
    }

    private void starttimer(){
        mCountDownTimer = new CountDownTimer(mTimeLeftinmillis,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftinmillis = millisUntilFinished;
                updateCountdownText();
            }

            @Override
            public void onFinish() {
                mTimerRunning = false;
                linearLayout.setVisibility(View.GONE);
                btn_tryagain.setVisibility(View.VISIBLE);
                Question_h1.setClickable(false);
            }
        }.start();

        mTimerRunning = true;

    }
    private void updateCountdownText(){

        int minutes = (int) (mTimeLeftinmillis/1000)/60;
        int seconds= (int) (mTimeLeftinmillis/1000)%60;
        String timeLeftFormatted = String.format(Locale.getDefault(),"%02d:%02d",minutes,seconds);
        mTextviewCountdown.setText(timeLeftFormatted);

    }

//    TimerEnds


    private String[] shuffleArrays(String[] ar){
        Random rnd = new Random();
        for (int i = ar.length - 1; i>0;i--){
            int index = rnd.nextInt(i + 1);
            String a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
        return ar;
    }
    private void addView(LinearLayout viewparent, final String text , final EditText editText){
        LinearLayout.LayoutParams linearLayoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);

        linearLayoutParams.rightMargin = 20;
        final TextView textView = new TextView(this);
        textView.setLayoutParams(linearLayoutParams);
        textView.setBackgroundColor(this.getResources().getColor(R.color.transparent));
        textView.setTextColor(this.getResources().getColor(R.color.white));
        textView.setGravity(Gravity.CENTER);
        textView.setText(text);
        textView.setClickable(true);
        textView.setFocusable(true);
        textView.setTextSize(55);
        textView.setPadding(10,10,10,10);



        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (prescounter < maxprescounter){
                    if (prescounter==0)
                        editText.setText("");
//                            editText.startAnimation(bigsmallforth);
                    editText.setText(editText.getText().toString() + text);
                    textView.animate().alpha(0).setDuration(300);
                    prescounter++;

                    if (prescounter == maxprescounter)
                        doValidate();
                    textView.setClickable(false);
                }
            }
        });
        viewparent.addView(textView);


    }

    private void doValidate() {
        prescounter = 0;
        EditText editText = findViewById(R.id.edit_textH);
        LinearLayout linearLayout = findViewById(R.id.layout_parent);
        if (editText.getText().toString().equals(textAnswer)) {
            Toast.makeText(this, "Excellent", Toast.LENGTH_SHORT).show();
            editText.setText("great");
            mCountDownTimer.cancel();
            mTimerRunning = false;
            btn_next.setVisibility(View.VISIBLE);
            Question_h1.setClickable(false);
            WinGame_layout.setVisibility(View.VISIBLE);
            linearLayout.setVisibility(View.GONE);
        } else {
            Toast.makeText(this, "Wrong!!", Toast.LENGTH_SHORT).show();
            editText.setText("");
            keys = shuffleArrays(keys);
            linearLayout.removeAllViews();
            for (String key : keys) {
                addView(linearLayout, key, editText);
            }
        }
    }

}
//        Hard EditText Ends
