package com.example.doclele;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.doclele.api.ApiClient;
import com.example.doclele.api.ApiInterface;
import com.example.doclele.model.login.LoginData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity implements View.OnClickListener{

    EditText etusernameLg, etpasswordLg;
    Button btn_login;
    String Username, Password;
    TextView tvRegister;
    ApiInterface apiInterface;
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
            //deklarrisa variable
        etusernameLg    = findViewById(R.id.etusernameLg);
        etpasswordLg    = findViewById(R.id.etpasswordLg);
        btn_login       = findViewById(R.id.btn_login);
        tvRegister      = findViewById(R.id.tvSingUp);

              //Membuat Fungsi tombol saat ditekan
        btn_login.setOnClickListener(this);
        tvRegister.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_login: //fungsi tombol login
                Username = etusernameLg.getText().toString();
                Password = etpasswordLg.getText().toString();
                login(Username, Password);

                break;
            case R.id.tvSingUp:
                Intent intent = new Intent(this, Register.class);
                startActivity(intent);
                finish();
        }
    }

    private void login(String username, String password) {

        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<com.example.doclele.model.login.Login>
                loginCall = apiInterface.loginResponse(username, password);
        loginCall.enqueue(new Callback<com.example.doclele.model.login.Login>() {
            @Override
            public void onResponse(Call<com.example.doclele.model.login.Login> call, Response<com.example.doclele.model.login.Login> response) {
                if (response.body() != null && response.isSuccessful() && response.body().isStatus()){
                    sessionManager = new SessionManager(Login.this);
                    LoginData loginData = response.body().getLoginData();
                    sessionManager.createLoginSession(loginData);

                    Toast.makeText(Login.this, response.body().getLoginData().getName(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Login.this, Dashboard.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(Login.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();

                }

            }

            @Override
            public void onFailure(Call<com.example.doclele.model.login.Login> call, Throwable t) {
                Toast.makeText(Login.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();


            }
        });

    }
}