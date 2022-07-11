package com.example.doclele.model;

import com.example.doclele.model.gejala.ModelGejala;

import java.util.ArrayList;
import java.util.List;

public class RuleModel {
    private ArrayList<Result> result;

    public ArrayList<Result> getResult() {
        return result;
    }

    public void setResult(ArrayList<Result> result) {
        this.result = result;
    }

    public class Result{
        private int id_ps;
        private String ciri, penyakit, solusii;

        public int getId_ps() {
            return id_ps;
        }

        public void setId_ps(int id_ps) {
            this.id_ps = id_ps;
        }

        public String getCiri() {
            return ciri;
        }

        public void setCiri(String ciri) {
            this.ciri = ciri;
        }

        public String getPenyakit() {
            return penyakit;
        }

        public void setPenyakit(String penyakit) {
            this.penyakit = penyakit;
        }

        public String getSolusii() {
            return solusii;
        }

        public void setSolusii(String solusii) {
            this.solusii = solusii;
        }


//        @Override
//        public String toString() {
//            return "Result{" +
//                    "id_ciri=" + id_ciri +
//                    ", ciri_ciri='" + ciri_ciri + '\'' +
//                    ", nilai_ciri='" + nilai_ciri + '\'' +
//                    '}';
//        }
    }
}
