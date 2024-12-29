package models;

import utils.Enums.StatusBarang;

public class ModelBarang {
    private int id;
    private String nama;
    private double harga;
    private StatusBarang status;

    public ModelBarang(int id, String nama, double harga, StatusBarang status){
        this.id = id;
        this.nama = nama;
        this.harga = harga;
        this.status = status;
    }

    @Override
    public String toString() {
        String id = "ID       : " + this.id + "\n";
        String nm = "Name     : " + this.nama + "\n";
        String hr = "Harga    : " + this.harga + "\n";
        String st = "Status   : " + this.status + "\n";
        return id + nm + hr + st;
    }

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

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public StatusBarang getStatus() {
        return status;
    }

    public void setStatus(StatusBarang status) {
        this.status = status;
    }
}
