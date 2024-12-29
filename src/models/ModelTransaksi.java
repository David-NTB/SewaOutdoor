package models;

import databases.lists.ListBarang;
import utils.Enums.StatusTransaksi;

public class ModelTransaksi {
    private int id;
    private ModelUser user;
    private ListBarang listBarang;
    private double totalHarga;
    private StatusTransaksi status;

    public ModelTransaksi(int id, ModelUser user, double totalHarga, StatusTransaksi status) {
        this.id = id;
        this.user = user;
        this.listBarang = new ListBarang();
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
        return listBarang;
    }

    public void setListBarang(ListBarang listBarang) {
        this.listBarang = listBarang;
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

}
