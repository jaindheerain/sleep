package com.example.dheerainjain.sleeping8.retrofit;

import com.example.dheerainjain.sleeping8.model.SignupPojo;
import com.example.dheerainjain.sleeping8.model.SignupResult;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface SignupApi {

        @POST("signup")
        Call<SignupResult> signupUser (@Body SignupPojo signup);

}
