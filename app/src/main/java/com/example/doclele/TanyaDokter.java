package com.example.doclele;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.doclele.adapter.GejalaAdapter;
import com.example.doclele.api.ApiClient;
import com.example.doclele.api.ApiInterface;
import com.example.doclele.model.RuleModel;
import com.example.doclele.model.gejala.ModelGejala;
import com.google.android.material.card.MaterialCardView;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TanyaDokter extends AppCompatActivity {
    TextView tvOutput;
    private final String TAG = "TanyaDokter";
    ApiInterface apiInterface;
    private Button btn_proses;
    private Button btn_reset;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private GejalaAdapter gejalaAdapter;
    private List<ModelGejala.Result> results = new ArrayList<>();
    private ArrayList<String> listGejala = new ArrayList<>();
    private ArrayList<RuleModel.Result> listRule= new ArrayList<>();
    private ArrayList<Double> countGejala = new ArrayList<>();
    private ArrayList<Integer> userCf = new ArrayList<>();
    private String disease = "";
    private int count = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tanya_dokter);
        setupView();
        setupRecyclerView();
        getDataFromApi();
        valueChange();

        tvOutput    = findViewById(R.id.textView);

        btn_proses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
            }
        });

        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });

        tvOutput.setText("");
    }

    private void setupView() {
        recyclerView    = findViewById(R.id.rvDiagnosis);
        progressBar     = findViewById(R.id.progressBar);
        btn_proses      = findViewById(R.id.buttonProses);
        btn_reset      = findViewById(R.id.buttonReset);
    }

    private void setupRecyclerView() {
        gejalaAdapter = new GejalaAdapter(this, results);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(gejalaAdapter);

    }

    private void getDataFromApi() {
        progressBar.setVisibility(View.VISIBLE);
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<com.example.doclele.model.gejala.ModelGejala>
                modelGejalaCall = apiInterface.getGejala();
        modelGejalaCall.enqueue(new Callback<ModelGejala>() {
            @Override
            public void onResponse(Call<ModelGejala> call, Response<ModelGejala> response) {
                progressBar.setVisibility(View.GONE);
                Log.d(TAG, response.toString());
                if (response.isSuccessful()){
                    List<ModelGejala.Result> results = response.body().getResult();
                    Log.d(TAG, results.toString());
                    for (int i=0; i<results.size(); i++){
                        userCf.add(0);
                    }
                    gejalaAdapter.setData(results);

                }
            }

            @Override
            public void onFailure(Call<ModelGejala> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Log.d(TAG, t.toString());

            }
        });

        Call<RuleModel> rule = apiInterface.getRule();
        rule.enqueue(new Callback<RuleModel>() {
            @Override
            public void onResponse(Call<RuleModel> call, Response<RuleModel> response) {
                progressBar.setVisibility(View.GONE);
                Log.d(TAG, response.toString());
                if (response.isSuccessful()){
                    listRule = response.body().getResult();
                    Log.d(TAG, results.toString());

                }
            }

            @Override
            public void onFailure(Call<RuleModel> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Log.d(TAG, t.toString());
            }
        });
    }



    private void valueChange(){
        gejalaAdapter.setOnVaueChangeListener(new GejalaAdapter.OnValueChangeListener() {
            @Override
            public void onValueChange(ModelGejala.Result obj, int position, Boolean checked) {
                if (checked){
                    listGejala.add(String.valueOf(obj.getId_ciri()));
                    userCf.set(position, 1);
                }else {
                    listGejala.remove(String.valueOf(obj.getId_ciri()));
                    userCf.set(position, 0);
                }
            }
        });
    }

    private void calculate(){
        countGejala.clear();
        disease = "";
        for (int i=0; i<results.size(); i++){
            Double calculate = Double.valueOf(results.get(i).getNilai_ciri())*userCf.get(i);
            countGejala.add(calculate);
        }

        if (((userCf.get(0)!=0) && userCf.get(2)!=0 && userCf.get(3)!=0  && userCf.get(10)!=0) ||
                (userCf.get(0)!=0  && userCf.get(1)!=0  && userCf.get(5)!=0  && userCf.get(6)!=0  && userCf.get(7)!=0  && userCf.get(8)!=0)||
                (userCf.get(2)!=0 && userCf.get(11)!=0  && userCf.get(12)!=0 )||
                (userCf.get(6)!=0  && userCf.get(9)!=0  && userCf.get(11)!=0  && userCf.get(14)!=0 )||
                (userCf.get(6)!=0  && userCf.get(9)!=0  && userCf.get(11)!=0  && userCf.get(14)!=0 )||
                (userCf.get(0)!=0  && userCf.get(1)!=0  && userCf.get(4)!=0  && userCf.get(9)!=0  && userCf.get(10)!=0)
        ){
            multipleSelect();
        }else {
            onlyOneSelect();
        }
        showDialog(disease);
    }
    private void showDialog(String text){
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // before
        dialog.setContentView(R.layout.dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.setCancelable(true);

        TextView tvTittle = dialog.findViewById(R.id.tvTittle);

        tvTittle.setText(text);
        dialog.show();
    }

    private void onlyOneSelect(){
        for (int i=0; i< userCf.size(); i++){
            if (userCf.get(i)!=0){
                if (i==0||i==2||i==3||i==10){
                    Double combineCF = countGejala.get(i)/4;
                    disease += "\n"+ String.format("%.2f",combineCF*100)+ "%"+"Penyakit Jamur";
                }

                if (i==0||i==1||i==5||i==6||i==7||i==8){
                    Double combineCF = countGejala.get(i)/6;
                    disease += "\n"+ String.format("%.2f",combineCF*100)+ "%"+"Penyakit Aeromonas Atau Sirip Merah";
                }

                if (i==2||i==11||i==12){
                    Double combineCF = countGejala.get(i)/3;
                    disease += "\n"+ String.format("%.2f",combineCF*100)+ "%"+"Penyakit Kuning";
                }

                if (i==6||i==9||i==11||i==14){
                    Double combineCF = countGejala.get(i)/4;
                    disease += "\n"+ String.format("%.2f",combineCF*100)+ "%"+"Usus Pecah";
                }

                if (i==2|i==11||i==13||i==14){
                    Double combineCF = countGejala.get(i)/4;
                    disease += "\n"+ String.format("%.2f",combineCF*100)+ "%"+"Stress Berlebihan";
                }

                if (i==0|i==1||i==4||i==9||i==10){
                    Double combineCF = countGejala.get(i)/5;
                    disease += "\n"+ String.format("%.2f",combineCF*100)+ "%"+"Penyakit Channel Catfish Virus";
                }
                break;
            }
        }
    }

    private void multipleSelect(){
        if ((userCf.get(0)!=0) &&
                userCf.get(2)!=0 &&
                userCf.get(3)!=0  &&
                userCf.get(10)!=0 ){
            Double combine_CF1_CF3 = countGejala.get(0)+countGejala.get(2)*(1-countGejala.get(0));
            Double combine_CF3_CF4 = combine_CF1_CF3 + countGejala.get(3) * (1-combine_CF1_CF3);
            Double combine_CF4_CF11 = combine_CF3_CF4 + countGejala.get(10) * (1-combine_CF3_CF4);

            disease += "\n"+ String.format("%.2f",combine_CF4_CF11*100)+ "%"+"Penyakit Jamur";
        }

        if((userCf.get(0)!=0  &&
                userCf.get(1)!=0  &&
                userCf.get(5)!=0  &&
                userCf.get(6)!=0  &&
                userCf.get(7)!=0  &&
                userCf.get(8)!=0
        )){
            Double combine_CF1_CF2 = countGejala.get(0)+countGejala.get(1)*(1-countGejala.get(0));
            Double combine_CF2_CF6 = combine_CF1_CF2 + countGejala.get(5)*(1-combine_CF1_CF2);
            Double combine_CF6_CF7 = combine_CF2_CF6 + countGejala.get(6)*(1-combine_CF2_CF6);
            Double combine_CF7_CF8 = combine_CF6_CF7 + countGejala.get(7)*(1-combine_CF6_CF7);
            Double combine_CF8_CF9 = combine_CF7_CF8 + countGejala.get(8)*(1-combine_CF7_CF8);

            disease += "\n"+ String.format("%.2f",combine_CF8_CF9*100)+ "%"+"Penyakit Aeromonas Atau Sirip Merah";
        }

        if ((userCf.get(2)!=0 &&
                userCf.get(11)!=0  &&
                userCf.get(12)!=0 )){
            Double combine_CF3_CF12 = countGejala.get(2)+ countGejala.get(11)*(1-countGejala.get(2));
            Double combine_CF12_CF13 = combine_CF3_CF12 + countGejala.get(11)*(1-combine_CF3_CF12);

            disease += "\n"+ String.format("%.2f",combine_CF12_CF13*100)+ "%"+"Penyakit Kuning";
        }

        if ((userCf.get(6)!=0  &&
                userCf.get(9)!=0  &&
                userCf.get(11)!=0  &&
                userCf.get(14)!=0 )){
            Double combine_CF7_CF10 = countGejala.get(6) + countGejala.get(9)*(1-countGejala.get(6));
            Double combine_CF10_CF12 = combine_CF7_CF10 + countGejala.get(11)*(1-combine_CF7_CF10);
            Double combine_CF12_CF15 = combine_CF10_CF12 + countGejala.get(11)*(1-combine_CF10_CF12);

            disease += "\n"+ String.valueOf(combine_CF12_CF15*100)+ "%"+"Usus Pecah";
        }

        if ((userCf.get(2)!=0  &&
                userCf.get(11)!=0 ) &&
                userCf.get(13)!=0  &&
                userCf.get(14)!=0 ){
            Double combine_CF3_CF12 = countGejala.get(2)+countGejala.get(11)*(1-countGejala.get(11));
            Double combine_CF12_CF14 = combine_CF3_CF12 + countGejala.get(13)*(1-combine_CF3_CF12);
            Double combine_CF14_CF15 = combine_CF12_CF14 + countGejala.get(14)*(1-combine_CF12_CF14);

            disease += "\n"+ String.format("%.2f",combine_CF14_CF15*100)+ "%"+"Stress Berlebihan";
        }

        if ((userCf.get(0)!=0  &&
                userCf.get(1)!=0  &&
                userCf.get(4)!=0  &&
                userCf.get(9)!=0  &&
                userCf.get(10)!=0
        )){
            Double combine_CF1_CF2 = countGejala.get(0) + countGejala.get(1) * (1-countGejala.get(0));
            Double combine_CF2_CF5 = combine_CF1_CF2 + countGejala.get(4) * (1-combine_CF1_CF2);
            Double combine_CF5_CF10 = combine_CF2_CF5 + countGejala.get(9) * (1-combine_CF2_CF5);
            Double combine_CF10_CF11 = combine_CF5_CF10 + countGejala.get(10) * (1-combine_CF5_CF10);

            disease += "\n"+ String.format("%.2f",combine_CF10_CF11*100)+ "%"+"Penyakit Channel Catfish Virus";
        }
    }


}