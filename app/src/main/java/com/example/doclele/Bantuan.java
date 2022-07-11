package com.example.doclele;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.card.MaterialCardView;

public class Bantuan extends AppCompatActivity {
    MaterialCardView mc_satu, mc_dua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bantuan);

        mc_satu = findViewById(R.id.mc_cardsatu);
        mc_dua  = findViewById(R.id.mc_carddua);

        mc_satu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Bantuan.this, Bantuan1.class));
            }
        });
        mc_dua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Bantuan.this, Bantuan2.class));
            }
        });

    }
}