package com.example.doclele.api;



import com.example.doclele.model.RuleModel;
import com.example.doclele.model.gejala.ModelGejala;
import com.example.doclele.model.login.Login;
import com.example.doclele.model.pakar.ModelPakar;
import com.example.doclele.model.register.Register;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("login.php")
    Call<Login> loginResponse(
            @Field("username") String username,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("register.php")
    Call<Register> registerResponse(
            @Field("username") String username,
            @Field("password") String password,
            @Field("name") String name

    );

    @GET("retrieve.php")
    Call<ModelPakar> getData();


    @GET("ciricf.php")
    Call<ModelGejala> getGejala();

    @GET("rule.php")
    Call<RuleModel> getRule();


}