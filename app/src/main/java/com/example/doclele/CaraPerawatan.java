package com.example.doclele;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.card.MaterialCardView;

public class CaraPerawatan extends AppCompatActivity {

    MaterialCardView bibit, remaja;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cara_perawatan);

        bibit   = findViewById(R.id.perawatanlelebibit);
        remaja  = findViewById(R.id.perawtanlelebesar);

        bibit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CaraPerawatan.this, PerawatanBibit.class));
            }
        });
        remaja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CaraPerawatan.this, PerawatanRemaja.class));
            }
        });

    }
}