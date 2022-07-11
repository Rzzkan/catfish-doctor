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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register extends AppCompatActivity implements View.OnClickListener {
    EditText etUsername, etPassword, etName ;
    Button btn_Register;
    TextView tvLogin;
    String Username, Password, Name ;
    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
            //Deklarasi Variable
        etUsername      = findViewById(R.id.etUsernameRg);
        etPassword      = findViewById(R.id.etPasswordRg);
        etName          = findViewById(R.id.etNameRg);

        btn_Register    = findViewById(R.id.btn_register);
        tvLogin         = findViewById(R.id.tvLogin);

            //Fungsi click
        btn_Register.setOnClickListener(this);
        tvLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_register:
                Username    = etUsername.getText().toString() ;
                Password    = etPassword.getText().toString();
                Name        = etName.getText().toString();

                register(Username,Password, Name );
                break;
            case R.id.tvLogin:
                Intent intent = new Intent(this, Login.class);
                startActivity(intent);
                finish();
                break;
        }

    }

    private void register(String username, String name, String password) {
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<com.example.doclele.model.register.Register>
                Call = apiInterface.registerResponse(username, name, password);
        Call.enqueue(new Callback<com.example.doclele.model.register.Register>() {
            @Override
            public void onResponse(retrofit2.Call<com.example.doclele.model.register.Register> call, Response<com.example.doclele.model.register.Register> response) {
                if (response.body() != null && response.isSuccessful() && response.body().isStatus()) {
                    Toast.makeText(Register.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Register.this, Login.class);
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(Register.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(retrofit2.Call<com.example.doclele.model.register.Register> call, Throwable t) {

            }
        });


    }
}