package models;

import databases.lists.ListBarang;
import utils.Enums.StatusTransaksi;

public class ModelTransaksi {
    private int id;
    private ModelUser user;
    private ListBarang listItem;
    private double totalHarga;
    private StatusTransaksi status;

    public ModelTransaksi(int id, ModelUser user, ListBarang listItem, double totalHarga, StatusTransaksi status) {
        this.id = id;
        this.user = user;
        this.listItem = listItem;
        this.totalHarga = totalHarga;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ModelUser getUser() {
        return user;
    }

    public void setUser(ModelUser user) {
        this.user = user;
    }

    public ListBarang getListBarang() {
        return listItem;
    }

    public void setListBarang(ListBarang listItem) {
        this.listItem = listItem;
    }

    public double getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(double totalHarga) {
        this.totalHarga = totalHarga;
    }

    public StatusTransaksi getStatus() {
        return status;
    }

    public void setStatus(StatusTransaksi status) {
        this.status = status;
    }

    public String info() {
        String id = "ID Transaksi   : " + this.id;
        String aa = "\n------------------------------\n";
        String us = "User : \n" + this.user.info();
        String bb = "\n------------------------------\n";
        String lb = "List Barang : " + this.listItem.printItem(this.listItem);
        String cc = "\n------------------------------\n";
        String th = "Harga Total      : " + this.totalHarga + "\n";
        String st = "Status Transaksi : " + this.status + "\n";
        return id + aa + us + bb + lb + cc + th + st;
    }
}
