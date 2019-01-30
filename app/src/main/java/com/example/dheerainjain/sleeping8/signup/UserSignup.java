package com.example.dheerainjain.sleeping8.signup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.dheerainjain.sleeping8.R;
import com.example.dheerainjain.sleeping8.retrofit.RetrofitSingleton;
import com.example.dheerainjain.sleeping8.UserLogin;
import com.example.dheerainjain.sleeping8.model.SignupPojo;
import com.example.dheerainjain.sleeping8.model.SignupResult;
import com.example.dheerainjain.sleeping8.retrofit.SignupApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserSignup extends Activity {

    EditText email,password,confirmPass,phone,username;

    Button signup;

    LinearLayout login,explorer,corporate;

    ImageView checkExp,checkCorp;

    String selectedKind="explorer";

    RetrofitSingleton retrofitSingleton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //Remove notification bar
        //this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_signup);


        retrofitSingleton=new RetrofitSingleton();

         username =  findViewById(R.id.username);
         email =  findViewById(R.id.email);
         password =  findViewById(R.id.password);
         confirmPass =  findViewById(R.id.confirmPass);
         phone =  findViewById(R.id.phone);

         login=findViewById(R.id.login);

         explorer=findViewById(R.id.explorer);
         corporate=findViewById(R.id.corporate);

         checkExp=findViewById(R.id.checkExp);
         checkCorp=findViewById(R.id.checkCorp);

         explorer.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
            selectedKind="explorer";
            phone.setVisibility(View.VISIBLE);

                 checkExp.setVisibility(View.VISIBLE);
            checkCorp.setVisibility(View.INVISIBLE);
             }
         });
            corporate.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                         phone.setVisibility(View.GONE);


                 selectedKind="corporate";
                 checkExp.setVisibility(View.INVISIBLE);
                 checkCorp.setVisibility(View.VISIBLE);
             }
         });

         signup=findViewById(R.id.signup);
         login=findViewById(R.id.login);

         login.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 startActivity(new Intent(UserSignup.this,UserLogin.class));
             }
         });

         signup.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 makeApiCall();
             }
         });

        username.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_user, 0, 0, 0);
        email.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_mail, 0, 0, 0);
        password.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_locked, 0, 0, 0);
        confirmPass.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_locked, 0, 0, 0);
        phone.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_phone, 0, 0, 0);
    }

    private void makeApiCall() {

        SignupPojo signupPojo=new SignupPojo();
        signupPojo.setContactNumber(phone.getText().toString().trim());
        signupPojo.setEmailAddress(email.getText().toString());
        signupPojo.setFullName(username.getText().toString());
        signupPojo.setPassword(password.getText().toString());
        signupPojo.setUserType(selectedKind+"");

        SignupApi signupApi=retrofitSingleton.createService(SignupApi.class);

        signupApi.signupUser(signupPojo).enqueue(new Callback<SignupResult>() {
            @Override
            public void onResponse(Call<SignupResult> call, Response<SignupResult> response) {
                if(response.isSuccessful()){
                    if(response.body().getOutputCode()==200){
                        Toast.makeText(UserSignup.this, ""+response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(UserSignup.this, ""+response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(UserSignup.this, ""+"some error occured", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<SignupResult> call, Throwable t) {

                Toast.makeText(UserSignup.this, "Fail"+t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }
}
