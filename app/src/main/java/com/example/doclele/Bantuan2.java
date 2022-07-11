package com.example.doclele;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class Bantuan2 extends AppCompatActivity {

    RelativeLayout Kembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bantuan2);

        Kembali = findViewById(R.id.rl_back);

        Kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Bantuan2.this, Bantuan1.class));
                finish();
            }
        });
    }
}