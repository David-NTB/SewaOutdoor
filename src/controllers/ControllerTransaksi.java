package controllers;

import databases.lists.ListBarang;
import databases.lists.ListTransaksi;
import databases.sources.SourceTransaksi;
import models.ModelBarang;
import models.ModelTransaksi;
import models.ModelUser;
import utils.Enums.StatusTransaksi;

public class ControllerTransaksi {
    SourceTransaksi sourceTransaksi = new SourceTransaksi();
    ListTransaksi listTransaksi;

    public ControllerTransaksi(SourceTransaksi source) {
        listTransaksi = source.getListTransaksi();
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
        ModelTransaksi modelTransaksi = listTransaksi.idSearchTransaksi(id);
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

    public void accTransaksi(ModelTransaksi transaksi) {
        listTransaksi.setStatusOngoing(transaksi);
    }

    public void doneTransaksi(ModelTransaksi transaksi) {
        listTransaksi.setStatusDone(transaksi);
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
            System.out.println(listTransaksi.printList());
        }
    }

    public void showStatusTransaksi(StatusTransaksi statusTransaksi) {
        if (listTransaksi.getHead() == null) {
            System.out.println("\n[ Transaksi Tidak Ditemukan ]");
        } else {
            System.out.println(listTransaksi.printStatus(statusTransaksi));
        }
    }

    public ListTransaksi generateLaporan() {
        ListTransaksi laporan = listTransaksi;
        listTransaksi = sourceTransaksi.getListTransaksi();
        return laporan;
    }
}
