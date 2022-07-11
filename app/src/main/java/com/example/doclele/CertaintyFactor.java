package com.example.doclele;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class CertaintyFactor extends AppCompatActivity {
    Button btnProses;
    TextView tvOutput;
    CheckBox chkGejala1, chkGejala2, chkGejala3, chkGejala4, chkGejala5, chkGejala6, chkGejala7, chkGejala8, chkGejala9,
             chkGejala10, chkGejala11;
    AutoCompleteTextView txtNilaiGejala1, txtNilaiGejala2, txtNilaiGejala3, txtNilaiGejala4, txtNilaiGejala5, txtNilaiGejala6,
                         txtNilaiGejala7, txtNilaiGejala8, txtNilaiGejala9, txtNilaiGejala10, txtNilaiGejala11;

    String[] nilaiKeyakinanGejala1 = {"", "0", "0.2", "0.4", "0.6", "0.8", "1"};
    String[] nilaiKeyakinanGejala2 = {"", "0", "0.2", "0.4", "0.6", "0.8", "1"};
    String[] nilaiKeyakinanGejala3 = {"", "0", "0.2", "0.4", "0.6", "0.8", "1"};
    String[] nilaiKeyakinanGejala4 = {"", "0", "0.2", "0.4", "0.6", "0.8", "1"};
    String[] nilaiKeyakinanGejala5 = {"", "0", "0.2", "0.4", "0.6", "0.8", "1"};
    String[] nilaiKeyakinanGejala6 = {"", "0", "0.2", "0.4", "0.6", "0.8", "1"};
    String[] nilaiKeyakinanGejala7 = {"", "0", "0.2", "0.4", "0.6", "0.8", "1"};
    String[] nilaiKeyakinanGejala8 = {"", "0", "0.2", "0.4", "0.6", "0.8", "1"};
    String[] nilaiKeyakinanGejala9 = {"", "0", "0.2", "0.4", "0.6", "0.8", "1"};
    String[] nilaiKeyakinanGejala10 = {"", "0", "0.2", "0.4", "0.6", "0.8", "1"};
    String[] nilaiKeyakinanGejala11 = {"", "0", "0.2", "0.4", "0.6", "0.8", "1"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_certainty_factor);

        btnProses   = (Button)findViewById(R.id.button);
        tvOutput    = (TextView)findViewById(R.id.textView);

        chkGejala1  = (CheckBox)findViewById(R.id.checkBox);
        chkGejala2  = (CheckBox)findViewById(R.id.checkBox2);
        chkGejala3  = (CheckBox)findViewById(R.id.checkBox3);
        chkGejala4  = (CheckBox)findViewById(R.id.checkBox4);
        chkGejala5  = (CheckBox)findViewById(R.id.checkBox5);
        chkGejala6  = (CheckBox)findViewById(R.id.checkBox6);
        chkGejala7  = (CheckBox)findViewById(R.id.checkBox7);
        chkGejala8  = (CheckBox)findViewById(R.id.checkBox8);
        chkGejala9  = (CheckBox)findViewById(R.id.checkBox9);
        chkGejala10  = (CheckBox)findViewById(R.id.checkBox10);
        chkGejala11  = (CheckBox)findViewById(R.id.checkBox11);

        txtNilaiGejala1 = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);
        txtNilaiGejala2 = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView2);
        txtNilaiGejala3 = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView3);
        txtNilaiGejala4 = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView4);
        txtNilaiGejala5 = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView5);
        txtNilaiGejala6 = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView6);
        txtNilaiGejala7 = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView7);
        txtNilaiGejala8 = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView8);
        txtNilaiGejala9 = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView9);
        txtNilaiGejala10 = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView10);
        txtNilaiGejala11 = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView11);


        final ArrayAdapter<String> adapterGejala1 = new ArrayAdapter<String>
                (this,android.R.layout.select_dialog_item, nilaiKeyakinanGejala1);
        txtNilaiGejala1.setThreshold(1);
        txtNilaiGejala1.setAdapter(adapterGejala1);

        final ArrayAdapter<String> adapterGejala2 = new ArrayAdapter<String>
                (this,android.R.layout.select_dialog_item, nilaiKeyakinanGejala2);
        txtNilaiGejala2.setThreshold(1);
        txtNilaiGejala2.setAdapter(adapterGejala2);

        final ArrayAdapter<String> adapterGejala3 = new ArrayAdapter<String>
                (this,android.R.layout.select_dialog_item, nilaiKeyakinanGejala3);
        txtNilaiGejala3.setThreshold(1);
        txtNilaiGejala3.setAdapter(adapterGejala3);

        final ArrayAdapter<String> adapterGejala4 = new ArrayAdapter<String>
                (this,android.R.layout.select_dialog_item, nilaiKeyakinanGejala4);
        txtNilaiGejala4.setThreshold(1);
        txtNilaiGejala4.setAdapter(adapterGejala4);

        final ArrayAdapter<String> adapterGejala5 = new ArrayAdapter<String>
                (this,android.R.layout.select_dialog_item, nilaiKeyakinanGejala5);
        txtNilaiGejala5.setThreshold(1);
        txtNilaiGejala5.setAdapter(adapterGejala5);

        final ArrayAdapter<String> adapterGejala6 = new ArrayAdapter<String>
                (this,android.R.layout.select_dialog_item, nilaiKeyakinanGejala6);
        txtNilaiGejala6.setThreshold(1);
        txtNilaiGejala6.setAdapter(adapterGejala6);

        final ArrayAdapter<String> adapterGejala7 = new ArrayAdapter<String>
                (this,android.R.layout.select_dialog_item, nilaiKeyakinanGejala7);
        txtNilaiGejala7.setThreshold(1);
        txtNilaiGejala7.setAdapter(adapterGejala7);

        final ArrayAdapter<String> adapterGejala8 = new ArrayAdapter<String>
                (this,android.R.layout.select_dialog_item, nilaiKeyakinanGejala8);
        txtNilaiGejala8.setThreshold(1);
        txtNilaiGejala8.setAdapter(adapterGejala8);

        final ArrayAdapter<String> adapterGejala9 = new ArrayAdapter<String>
                (this,android.R.layout.select_dialog_item, nilaiKeyakinanGejala9);
        txtNilaiGejala9.setThreshold(1);
        txtNilaiGejala9.setAdapter(adapterGejala9);

        final ArrayAdapter<String> adapterGejala10 = new ArrayAdapter<String>
                (this,android.R.layout.select_dialog_item, nilaiKeyakinanGejala10);
        txtNilaiGejala10.setThreshold(1);
        txtNilaiGejala10.setAdapter(adapterGejala10);

        final ArrayAdapter<String> adapterGejala11 = new ArrayAdapter<String>
                (this,android.R.layout.select_dialog_item, nilaiKeyakinanGejala11);
        txtNilaiGejala11.setThreshold(1);
        txtNilaiGejala11.setAdapter(adapterGejala11);

        txtNilaiGejala1.setOnClickListener(new View.OnClickListener() {
                                               @Override
                                               public void onClick(View v) {
                                                   new AlertDialog.Builder(CertaintyFactor.this).setTitle("Pilihlah Nilai Gejala 1").
                                                           setAdapter(adapterGejala1, new DialogInterface.OnClickListener() {
                                                               @Override
                                                               public void onClick(DialogInterface dialog, int which) {
                                                                   txtNilaiGejala1.setText(nilaiKeyakinanGejala1[which].toString());
                                                                   dialog.dismiss();
                                                               }
                                                           }).create().show();
                                               }
                                           }
        );

        txtNilaiGejala2.setOnClickListener(new View.OnClickListener() {
                                               @Override
                                               public void onClick(View v) {
                                                   new AlertDialog.Builder(CertaintyFactor.this).setTitle("Pilihlah Nilai Gejala 2").
                                                           setAdapter(adapterGejala2, new DialogInterface.OnClickListener() {
                                                               @Override
                                                               public void onClick(DialogInterface dialog, int which) {
                                                                   txtNilaiGejala2.setText(nilaiKeyakinanGejala2[which].toString());
                                                                   dialog.dismiss();
                                                               }
                                                           }).create().show();
                                               }
                                           }
        );

        txtNilaiGejala3.setOnClickListener(new View.OnClickListener() {
                                               @Override
                                               public void onClick(View v) {
                                                   new AlertDialog.Builder(CertaintyFactor.this).setTitle("Pilihlah Nilai Gejala 3").
                                                           setAdapter(adapterGejala3, new DialogInterface.OnClickListener() {
                                                               @Override
                                                               public void onClick(DialogInterface dialog, int which) {
                                                                   txtNilaiGejala3.setText(nilaiKeyakinanGejala3[which].toString());
                                                                   dialog.dismiss();
                                                               }
                                                           }).create().show();
                                               }
                                           }
        );

        txtNilaiGejala4.setOnClickListener(new View.OnClickListener() {
                                               @Override
                                               public void onClick(View v) {
                                                   new AlertDialog.Builder(CertaintyFactor.this).setTitle("Pilihlah Nilai Gejala 4").
                                                           setAdapter(adapterGejala4, new DialogInterface.OnClickListener() {
                                                               @Override
                                                               public void onClick(DialogInterface dialog, int which) {
                                                                   txtNilaiGejala4.setText(nilaiKeyakinanGejala4[which].toString());
                                                                   dialog.dismiss();
                                                               }
                                                           }).create().show();
                                               }
                                           }
        );

        txtNilaiGejala5.setOnClickListener(new View.OnClickListener() {
                                               @Override
                                               public void onClick(View v) {
                                                   new AlertDialog.Builder(CertaintyFactor.this).setTitle("Pilihlah Nilai Gejala 5").
                                                           setAdapter(adapterGejala5, new DialogInterface.OnClickListener() {
                                                               @Override
                                                               public void onClick(DialogInterface dialog, int which) {
                                                                   txtNilaiGejala5.setText(nilaiKeyakinanGejala5[which].toString());
                                                                   dialog.dismiss();
                                                               }
                                                           }).create().show();
                                               }
                                           }
        );

        txtNilaiGejala6.setOnClickListener(new View.OnClickListener() {
                                               @Override
                                               public void onClick(View v) {
                                                   new AlertDialog.Builder(CertaintyFactor.this).setTitle("Pilihlah Nilai Gejala 6").
                                                           setAdapter(adapterGejala6, new DialogInterface.OnClickListener() {
                                                               @Override
                                                               public void onClick(DialogInterface dialog, int which) {
                                                                   txtNilaiGejala6.setText(nilaiKeyakinanGejala6[which].toString());
                                                                   dialog.dismiss();
                                                               }
                                                           }).create().show();
                                               }
                                           }
        );
        txtNilaiGejala7.setOnClickListener(new View.OnClickListener() {
                                               @Override
                                               public void onClick(View v) {
                                                   new AlertDialog.Builder(CertaintyFactor.this).setTitle("Pilihlah Nilai Gejala 7").
                                                           setAdapter(adapterGejala7, new DialogInterface.OnClickListener() {
                                                               @Override
                                                               public void onClick(DialogInterface dialog, int which) {
                                                                   txtNilaiGejala7.setText(nilaiKeyakinanGejala7[which].toString());
                                                                   dialog.dismiss();
                                                               }
                                                           }).create().show();
                                               }
                                           }
        );
        txtNilaiGejala8.setOnClickListener(new View.OnClickListener() {
                                               @Override
                                               public void onClick(View v) {
                                                   new AlertDialog.Builder(CertaintyFactor.this).setTitle("Pilihlah Nilai Gejala 8").
                                                           setAdapter(adapterGejala8, new DialogInterface.OnClickListener() {
                                                               @Override
                                                               public void onClick(DialogInterface dialog, int which) {
                                                                   txtNilaiGejala8.setText(nilaiKeyakinanGejala8[which].toString());
                                                                   dialog.dismiss();
                                                               }
                                                           }).create().show();
                                               }
                                           }
        );
        txtNilaiGejala9.setOnClickListener(new View.OnClickListener() {
                                               @Override
                                               public void onClick(View v) {
                                                   new AlertDialog.Builder(CertaintyFactor.this).setTitle("Pilihlah Nilai Gejala 9").
                                                           setAdapter(adapterGejala9, new DialogInterface.OnClickListener() {
                                                               @Override
                                                               public void onClick(DialogInterface dialog, int which) {
                                                                   txtNilaiGejala9.setText(nilaiKeyakinanGejala9[which].toString());
                                                                   dialog.dismiss();
                                                               }
                                                           }).create().show();
                                               }
                                           }
        );
        txtNilaiGejala10.setOnClickListener(new View.OnClickListener() {
                                               @Override
                                               public void onClick(View v) {
                                                   new AlertDialog.Builder(CertaintyFactor.this).setTitle("Pilihlah Nilai Gejala 10").
                                                           setAdapter(adapterGejala10, new DialogInterface.OnClickListener() {
                                                               @Override
                                                               public void onClick(DialogInterface dialog, int which) {
                                                                   txtNilaiGejala10.setText(nilaiKeyakinanGejala10[which].toString());
                                                                   dialog.dismiss();
                                                               }
                                                           }).create().show();
                                               }
                                           }
        );
        txtNilaiGejala11.setOnClickListener(new View.OnClickListener() {
                                               @Override
                                               public void onClick(View v) {
                                                   new AlertDialog.Builder(CertaintyFactor.this).setTitle("Pilihlah Nilai Gejala 11").
                                                           setAdapter(adapterGejala11, new DialogInterface.OnClickListener() {
                                                               @Override
                                                               public void onClick(DialogInterface dialog, int which) {
                                                                   txtNilaiGejala11.setText(nilaiKeyakinanGejala11[which].toString());
                                                                   dialog.dismiss();
                                                               }
                                                           }).create().show();
                                               }
                                           }
        );


        btnProses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String NamaPenyakit = "Ikan Menderita Penyakit :";

                // AND && dan OR ||
                if (chkGejala2.isChecked() && chkGejala5.isChecked() && chkGejala10.isChecked() && chkGejala11.isChecked()){

                    //  Nilai dari PAKAR / AHLINYA
                    double nilaiGejala2 = 0.8;
                    double nilaiGejala5 = 1;
                    double nilaiGejala10 = 0.8;
                    double nilaiGejala11 = 0.4;


                    // Nilai Inputan dari USER
                    double doubleGejala2 = Double.parseDouble(txtNilaiGejala2.getText().toString());
                    double doubleGejala5 = Double.parseDouble(txtNilaiGejala5.getText().toString());
                    double doubleGejala10 = Double.parseDouble(txtNilaiGejala10.getText().toString());
                    double doubleGejala11 = Double.parseDouble(txtNilaiGejala11.getText().toString());


                    double hasilHitunganGejala2 = nilaiGejala2 * doubleGejala2;
                    double hasilHitunganGejala5 = nilaiGejala5 * doubleGejala5;
                    double hasilHitunganGejala10 = nilaiGejala10 * doubleGejala10;
                    double hasilHitunganGejala11 = nilaiGejala11 * doubleGejala11;


                    double Combine_CF2_CF5  = hasilHitunganGejala2 + hasilHitunganGejala5 * (1 - hasilHitunganGejala2);
                    double Combine_CFold_CF10  = Combine_CF2_CF5 + hasilHitunganGejala10 * (1 - Combine_CF2_CF5);
                    double Combine_CFold_CF11 = Combine_CFold_CF10 + hasilHitunganGejala11 * (1 - Combine_CFold_CF10);


                    String hasilHitungGejalaPenyakitA = String.valueOf((Combine_CFold_CF11 * 100));

                    NamaPenyakit += "\nChannel Cat Fish"+"\n"+hasilHitungGejalaPenyakitA+" %"+"\nPenanganan :"+
                                    "\n1. Pemberian makanan bergizi\n2. Penjagaan kwalitas air pada kolam\n3. Jaga kebersihan kolam ikan";



                }

                if (chkGejala1.isChecked() && chkGejala8.isChecked() && chkGejala9.isChecked() && chkGejala7.isChecked()){

                    //  Nilai dari PAKAR / AHLINYA
                    double nilaiGejala1 = 0.6;
                    double nilaiGejala2 = 0.8;
                    double nilaiGejala6 = 0.8;
                    double nilaiGejala8 = 1;
                    double nilaiGejala9 = 0.8;
                    double nilaiGejala7 = 0.6;


                    // Nilai Inputan dari  USER
                    double doubleGejala1 = Double.parseDouble(txtNilaiGejala1.getText().toString());
                    double doubleGejala2 = Double.parseDouble(txtNilaiGejala2.getText().toString());
                    double doubleGejala6 = Double.parseDouble(txtNilaiGejala6.getText().toString());
                    double doubleGejala8 = Double.parseDouble(txtNilaiGejala8.getText().toString());
                    double doubleGejala9 = Double.parseDouble(txtNilaiGejala9.getText().toString());
                    double doubleGejala7 = Double.parseDouble(txtNilaiGejala7.getText().toString());


                    double hasilHitunganGejala1 = nilaiGejala1 * doubleGejala1;
                    double hasilHitunganGejala2 = nilaiGejala2 * doubleGejala2;
                    double hasilHitunganGejala6 = nilaiGejala6 * doubleGejala6;
                    double hasilHitunganGejala8 = nilaiGejala8 * doubleGejala8;
                    double hasilHitunganGejala9 = nilaiGejala9 * doubleGejala9;
                    double hasilHitunganGejala7 = nilaiGejala7 * doubleGejala7;


                    double Combine_CF1_CF2  = hasilHitunganGejala1 + hasilHitunganGejala2 * (1- hasilHitunganGejala1);
                    double Combine_CFold_CF6= Combine_CF1_CF2 + hasilHitunganGejala6 *(1 - Combine_CF1_CF2);
                    double Combine_CFold_CF8= Combine_CFold_CF6 + hasilHitunganGejala8 *(1 - Combine_CFold_CF6);
                    double Combine_CFold_CF9= Combine_CFold_CF8 + hasilHitunganGejala9 * (1 - Combine_CFold_CF8);
                    double  Combine_CFold_CF7= Combine_CFold_CF9 + hasilHitunganGejala7 * (1 - Combine_CFold_CF9);


                    String hasilHitungGejalaPenyakitB = String.valueOf((Combine_CFold_CF7 * 100));

                    NamaPenyakit += "\nAeromonas"+"\n"+hasilHitungGejalaPenyakitB+" %" +"\nPenanganan :"+"\n1. Isi air kloam hingga 30cm\n2. Taburkan garam kasar pada kolam lalu tunggu 30 menit isi penuh\n3. Tambahkan antibiotik 50mg/hari berikan selama 7 hari";

                }

                if (chkGejala1.isChecked() && chkGejala3.isChecked() && chkGejala4.isChecked() && chkGejala11.isChecked()){

                    //  Nilai dari PAKAR / AHLINYA
                    double nilaiGejala1 = 0.6;
                    double nilaiGejala3 = 0.4;
                    double nilaiGejala4 = 1;
                    double nilaiGejala11 = 0.6;


                    // Nilai Inputan dari PASIEN / USER
                    double doubleGejala1 = Double.parseDouble(txtNilaiGejala1.getText().toString());
                    double doubleGejala3 = Double.parseDouble(txtNilaiGejala3.getText().toString());
                    double doubleGejala4 = Double.parseDouble(txtNilaiGejala4.getText().toString());
                    double doubleGejala11 = Double.parseDouble(txtNilaiGejala11.getText().toString());


                    double hasilHitunganGejala1 = nilaiGejala1 * doubleGejala1;
                    double hasilHitunganGejala3 = nilaiGejala3 * doubleGejala3;
                    double hasilHitunganGejala4 = nilaiGejala4 * doubleGejala4;
                    double hasilHitunganGejala11 = nilaiGejala11 * doubleGejala11;



                    double Combine_CF1_CF2  = hasilHitunganGejala1 + hasilHitunganGejala3 * (1 - hasilHitunganGejala1);
                    double Combine_CFold_CF4  = Combine_CF1_CF2 + hasilHitunganGejala4 * (1 - Combine_CF1_CF2);
                    double Combine_CFold_CF11  = Combine_CFold_CF4 + hasilHitunganGejala11 * (1 - Combine_CFold_CF4);




                    String hasilHitungGejalaPenyakitC = String.valueOf((Combine_CFold_CF11 * 100));

                    NamaPenyakit += "\nJamur"+"\n"+hasilHitungGejalaPenyakitC+" %"+"\nPenanganan :"+
                    "\n1. Angkat ikan dari kolam pindahkan ke kolam lain\n2.Bersihkan kolam ikan lalu berikan kapur pada kolam ikan\n3. Dan jemur kolam selama satu hari";

                }

                // Output Semua hasil
                tvOutput.setText(""+NamaPenyakit);
            }
        });



    }
}