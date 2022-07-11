package com.example.doclele;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Pakar1 extends AppCompatActivity {
    TextView tv_nama, tv_alamat, tv_pekerjaan, tv_deskripsi, tv_wa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pakar1);
        String nama         = getIntent().getStringExtra("intent_nama");
        String alamat       = getIntent().getStringExtra("intent_alamat");
        String pekerjaan    = getIntent().getStringExtra("intent_pekerjaan");
        String deskrisi     = getIntent().getStringExtra("intent_deskripsi");
        String wa           = getIntent().getStringExtra("intent_wa");
//        Log.d(TAG, nama);

        tv_nama          = findViewById(R.id.tv_isi_Nama);
        tv_alamat        = findViewById(R.id.tv_isi_Alamat);
        tv_pekerjaan     = findViewById(R.id.tv_isi_Pekerjaan);
        tv_deskripsi     = findViewById(R.id.tv_isi_Pengalaman);
        tv_wa            = findViewById(R.id.tv_isi_wa);

        tv_nama.setText(nama);
        tv_alamat.setText(alamat);
        tv_pekerjaan.setText(pekerjaan);
        tv_deskripsi.setText(deskrisi);
        tv_wa.setText(wa);
    }
}