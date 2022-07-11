package com.example.doclele;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.example.doclele.adapter.PakarAdapter;
import com.example.doclele.api.ApiClient;
import com.example.doclele.api.ApiInterface;
import com.example.doclele.model.pakar.ModelPakar;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DaftarPakar extends AppCompatActivity {

    MaterialCardView btnsatu, btndua, btntiga, btnempat;
    private final String TAG = "DaftarPakar";
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private PakarAdapter pakarAdapter;
    private List<ModelPakar.Result> results = new ArrayList<>();
    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_pakar);
        setupView();
        setupRecyclerView();
        getDataFromApi();
    }



    private void setupView() {
        recyclerView = findViewById(R.id.recyclerView);
        progressBar  = findViewById(R.id.progressBar);
    }
    private void setupRecyclerView() {
        pakarAdapter = new PakarAdapter(results, new PakarAdapter.OnAdapterListener() {
            @Override
            public void onClick(ModelPakar.Result result) {
                Intent intent = new Intent(DaftarPakar.this, Pakar1.class);
                intent.putExtra("intent_nama", result.getNama());
                intent.putExtra("intent_alamat", result.getAlamat());
                intent.putExtra("intent_pekerjaan", result.getPekerjaan());
                intent.putExtra("intent_deskripsi", result.getDeskripsi());
                intent.putExtra("intent_wa", result.getWa());
                startActivity(intent);
            }
        });

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter( pakarAdapter );
    }

    private void getDataFromApi() {
        progressBar.setVisibility(View.VISIBLE);
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<com.example.doclele.model.pakar.ModelPakar>
                modelPakarCall = apiInterface.getData();
        modelPakarCall.enqueue(new Callback<ModelPakar>() {
            @Override
            public void onResponse(Call<ModelPakar> call, Response<ModelPakar> response) {
                progressBar.setVisibility(View.GONE);
                if (response.isSuccessful()){
                    List<ModelPakar.Result> results = response.body().getResult();
                    Log.d(TAG, results.toString());
                    pakarAdapter.setData(results);
                }
            }

            @Override
            public void onFailure(Call<ModelPakar> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Log.d(TAG, t.toString());

            }
        });

    }
}