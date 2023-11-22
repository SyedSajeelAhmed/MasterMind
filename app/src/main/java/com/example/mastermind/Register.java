package com.example.mastermind;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

public class Register extends AppCompatActivity {
    GoogleSignInOptions gso;
    GoogleSignInClient gsc;
    ImageView Btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

//        SignIn and SignOut
        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this,gso);

        Btn1 = findViewById(R.id.google_btn);
        Btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
            }
        });
    }

    void signIn(){
        Intent signInIntent = gsc.getSignInIntent();
        startActivityForResult(signInIntent,1000);
 }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1000){
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                task.getResult(ApiException.class);
                changeactivity();
            } catch (ApiException e) {
                Toast.makeText(getApplicationContext(),"Something Went Wrong",Toast.LENGTH_SHORT).show();
            }
        }
    }

    void changeactivity(){
        finish();
        Intent intent = new Intent(Register.this,MainActivity.class);
        startActivity(intent);
    }
//        SignIn and SignOut End

}


