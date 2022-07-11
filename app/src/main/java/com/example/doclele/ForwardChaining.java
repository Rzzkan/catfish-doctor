package com.example.doclele;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class ForwardChaining extends AppCompatActivity {
    CheckBox Chck1, Chck2, Chck3, Chck4, Chck5, Chck6, Chck7;

    Button btnProsesDeteksi;
    TextView tvOutputNamaPenyakit, tvOutput2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forward_chaining);

        Chck1 = (CheckBox) findViewById(R.id.checkBox);
        Chck2 = (CheckBox) findViewById(R.id.checkBox2);
        Chck3 = (CheckBox) findViewById(R.id.checkBox3);
        Chck4 = (CheckBox) findViewById(R.id.checkBox4);
        Chck5 = (CheckBox) findViewById(R.id.checkBox5);
        Chck6 = (CheckBox) findViewById(R.id.checkBox6);
        Chck7 = (CheckBox) findViewById(R.id.checkBox7);


        btnProsesDeteksi = (Button) findViewById(R.id.button);
        tvOutputNamaPenyakit = (TextView) findViewById(R.id.textView);
        tvOutput2 = findViewById(R.id.textView2);

        // Kosongkan textView Nama Penyakit Saat membuka program Sisitem Pakar
        tvOutputNamaPenyakit.setText("");
        tvOutput2.setText("");

        btnProsesDeteksi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String NamaPenyakit = "";
                String Eror = "Coba Lagi";



                if (Chck1.isChecked() || Chck2.isChecked() || Chck3.isChecked()) {

                    NamaPenyakit += "Ikan Menderita : \nPenyakit Kuning" +
                            "\nPenanganan :\n1. Pisahkan ikan dengan yang sehat lalu beri dau pepeya sebagai obat penambah nafsu makan\n2. Pemberian pakan yang baik tidak melebihi atau mendekati masa exp\n3. Sering kuras kolam dan ganti air kolam dengan yang baru";
                    tvOutputNamaPenyakit.setText(""+NamaPenyakit);
                }

                 if (Chck2.isChecked() || Chck5.isChecked() || Chck6.isChecked() || Chck7.isChecked()) {
                    NamaPenyakit += "\nIkan Menderita :\nUsus Pecah"+"\nPenanganan :"+
                            "\n1. Pemberian pakan pada ikan secukupnya jangan berlebihan agar dapat dicerna oleh ikan\n2. Hindari pemberian pakan yang dekat pada tanggal exp";
                    tvOutputNamaPenyakit.setText(""+NamaPenyakit);
                }



                 if (Chck1.isChecked() || Chck2.isChecked() || Chck5.isChecked() ||
                        Chck4.isChecked()) {
                    NamaPenyakit += "\nIkan Menderita :\nStress Berlebihan"+"Penanganan :" +
                    "1. Ganti air setiap hari agar terjaga kebersihan air\n2. Beri daun pepaya";
                tvOutputNamaPenyakit.setText(""+NamaPenyakit);
                }

                // Tampilkan Hasil Nama Penyakit di textView



            }
        });
    }


    // Pemanis
    public void onCheckboxClicked123 (View view) {
        boolean checked = ((CheckBox) view).isChecked();
        String str = "";

        switch (view.getId()) {
//            case R.id.checkBox:
//                str = checked ? "Gejala Nafsu Makan Berkurang Diseleksi " : "Gejala Nafsu Makan Berkurang Tidak Diseleksi";
//                break;
//            case R.id.checkBox2:
//                str = checked ? "Gejala Ikan Menggantung Tegak Dipermukaan Diseleksi " : "Gejala Ikan Menggantung Tegak Dipermukan Tidak Diseleksi";
//                break;
//            case R.id.checkBox3:
//                str = checked ? "Gejala Kulit Berwarna kuning Diseleksi " : "Gejala Kulit Berwarna Kuning Tidak Diseleksi";
//                break;
//            case R.id.checkBox4:
//                str = checked ? "Gejala Air Keruh Diseleksi " : "Gejala Air Keruh Tidak Diseleksi";
//                break;
//            case R.id.checkBox5:
//                str = checked ? "Gejala Tidak Banyak Gerak Diseleksi " : "Gejala Tidak Banyak Gerak Tidak Diseleksi";
//                break;
//            case R.id.checkBox6:
//                str = checked ? "Gejala Perut Ikan Mengembung Besar Diseleksi " : "Gejala Perut Ikan Mengembung Besar Tidak Diseleksi";
//                break;
//            case R.id.checkBox7:
//                str = checked ? "Gejala Usia Ikan Masih Bibit Diseleksi " : "Gejala Usia Ikan Masih Bibit Tidak Diseleksi";
//                break;
        }

//        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
}
