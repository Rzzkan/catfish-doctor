package com.example.doclele.model.gejala;

import java.util.List;

public class ModelGejala {

    private List<Result> result;

    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }

    public class Result{
        private int id_ciri;
        private String ciri_ciri, nilai_ciri;

        public int getId_ciri() {
            return id_ciri;
        }

        public void setId_ciri(int id_ciri) {
            this.id_ciri = id_ciri;
        }

        public String getCiri_ciri() {
            return ciri_ciri;
        }

        public void setCiri_ciri(String ciri_ciri) {
            this.ciri_ciri = ciri_ciri;
        }

        public String getNilai_ciri() {
            return nilai_ciri;
        }

        public void setNilai_ciri(String nilai_ciri) {
            this.nilai_ciri = nilai_ciri;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "id_ciri=" + id_ciri +
                    ", ciri_ciri='" + ciri_ciri + '\'' +
                    ", nilai_ciri='" + nilai_ciri + '\'' +
                    '}';
        }
    }
}
