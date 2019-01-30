package com.example.dheerainjain.sleeping8.signup;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.dheerainjain.sleeping8.R;
import com.example.dheerainjain.sleeping8.UserLogin;

public class Signup extends Activity {

    Button login,signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);


        this.setContentView(R.layout.activity_signup);
        findElements();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Signup.this,UserLogin.class);
                startActivity(intent);
            }
        });
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Signup.this,UserSignup.class);
                startActivity(intent);
            }
        });
    }

    private void findElements() {

        login=findViewById(R.id.login);
        signUp=findViewById(R.id.signup);

    }
}
