package com.example.doclele;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class Bantuan1 extends AppCompatActivity {
    RelativeLayout Berikutnya;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bantuan1);

        Berikutnya  = findViewById(R.id.rl_next);

        Berikutnya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Bantuan1.this, Bantuan2.class));
            }
        });
    }
}