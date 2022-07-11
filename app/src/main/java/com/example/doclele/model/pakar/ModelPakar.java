package com.example.doclele.model.pakar;

import java.util.List;

public class ModelPakar {

    private List <Result> result;

    public List<Result> getResult(){
        return result;
    }
    public void setResult(List<Result>result){
        this.result = result;
    }

    public class Result{
        private int id;
        private String nama, alamat, pekerjaan, deskripsi,wa;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNama() {
            return nama;
        }

        public void setNama(String nama) {
            this.nama = nama;
        }

        public String getAlamat() {
            return alamat;
        }

        public void setAlamat(String alamat) {
            this.alamat = alamat;
        }

        public String getPekerjaan() {
            return pekerjaan;
        }

        public void setPekerjaan(String pekerjaan) {
            this.pekerjaan = pekerjaan;
        }

        public String getDeskripsi() {
            return deskripsi;
        }

        public void setDeskripsi(String deskripsi) {
            this.deskripsi = deskripsi;
        }

        public String getWa() {
            return wa;
        }

        public void setWa(String wa) {
            this.wa = wa;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "id=" + id +
                    ", nama='" + nama + '\'' +
                    ", alamat='" + alamat + '\'' +
                    ", pekerjaan='" + pekerjaan + '\'' +
                    ", deskripsi='" + deskripsi + '\'' +
                    ", wa='" + wa + '\'' +
                    '}';
        }
    }
}
