package controllers;

import databases.lists.ListBarang;
import databases.lists.ListLaporan;
import databases.lists.ListTransaksi;
import databases.sources.SourceLaporan;
import databases.sources.SourceTransaksi;
import models.ModelBarang;
import models.ModelTransaksi;
import models.ModelUser;
import utils.Enums.StatusTransaksi;

public class ControllerLaporan {
    SourceLaporan sourceLaporan = new SourceLaporan();
    ListLaporan listLaporan;

    public ControllerLaporan(SourceLaporan source) {
        listLaporan = source.getListLaporan();
    }

    public ModelTransaksi addTransaksi(int id, ModelUser user, ListBarang listItem, double totalHarga, StatusTransaksi status) {
        ModelTransaksi modelTransaksi =  listTransaksi.insert(new ModelTransaksi(id, user, listItem, totalHarga, status));
        if (modelTransaksi == null) {
            System.out.println("\n[ Transaksi Gagal Ditambahkan ]");
        } else {
            System.out.println("\n[ Transaksi Ditambahkan ]");
        }
        return modelTransaksi;
    }

    public void addItemTransaksi(ModelTransaksi transaksi, ModelBarang newBarang) {
        transaksi.getListBarang().insert(newBarang);
    }


    public ModelTransaksi idSearchTransaksi(int id) {
        ModelTransaksi modelTransaksi = listTransaksi.searchId(id);
        if (modelTransaksi != null) {;
            System.out.println("\n[ Transaksi Ditemukan ]");
        } else {
            System.out.println("\n[ Transaksi Tidak Ditemukan ]");
        }
        return modelTransaksi;
        
    }

    public void editStatusTransaksi(ModelTransaksi transaksi, StatusTransaksi status) {
        transaksi.setStatus(status); // Salah
    }

    public void cancelTransaksi(ModelTransaksi transaksi) {
        listTransaksi.setStatusCancel(transaksi);
    }

    public void showTransaksi(ModelTransaksi transaksi) {
        if (transaksi != null) {
            System.out.println(transaksi.info());
        }
    }

    public void showAllTransaksi() {
        if (listTransaksi.getHead() == null) {
            System.out.println("\n[ Transaksi Tidak Ditemukan ]");
        } else {
            listTransaksi.printList();
        }
        
    }
}
