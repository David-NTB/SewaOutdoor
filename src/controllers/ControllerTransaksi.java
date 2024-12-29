package controllers;

import databases.lists.ListTransaksi;
import databases.nodes.NodeBarang;
import models.ModelBarang;
import models.ModelTransaksi;
import models.ModelUser;
import utils.Enums.StatusTransaksi;

public class ControllerTransaksi {
    final ListTransaksi data = new ListTransaksi();
    final ControllerBarang barang = new ControllerBarang();

    public ModelTransaksi addTransaksi(int id, ModelUser user, double totalHarga, StatusTransaksi status) {
        return data.insert(new ModelTransaksi(id, user, totalHarga, status));
    }

    public void addItemTransaksi(ModelTransaksi transaksi, ModelBarang newBarang) {
        transaksi.getListBarang().insert(newBarang);
    }

    public void hitungHarga(ModelTransaksi transaksi) {
        double totalHarga = 0;
        NodeBarang list = transaksi.getListBarang().getHead();
        while (list != null) {
            totalHarga += list.getData().getHarga();
            list = list.getNext();
        }
        transaksi.setTotalHarga(totalHarga);
    }

    public void editItemTransaksi(ModelTransaksi transaksi) {
        transaksi.setListBarang(null); // ono salah
    }

    public ModelTransaksi searchTransaksi(int id) {
        return data.search(id);
    }

    public void editStatusTransaksi(ModelTransaksi transaksi, StatusTransaksi status) {
        transaksi.setStatus(status);
    }

    public ModelBarang searchBarang(int id) {
        return barang.searchBarang(id);
    }

    public void deleteTransaksi(ModelTransaksi user) {
        data.delete(user);
    }

    public void showTransaksi(ModelTransaksi user) {
        System.out.println(user.toString());
    }

    public void showAllTransaksi() {
        data.printList();
    }
}
