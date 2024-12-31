package controllers;

import databases.lists.ListBarang;
import databases.sources.SourceBarang;
import models.ModelBarang;
import utils.Enums.StatusBarang;
import utils.Input;

public class ControllerBarang {
    SourceBarang source = new SourceBarang();
    ListBarang listBarang;

    public ControllerBarang(SourceBarang source) {
        listBarang = source.getListBarang();
    }

    public void addBarang(int id, String nama, double harga, StatusBarang status) {
        ModelBarang modelBarang = listBarang.insert(new ModelBarang(id, nama, harga, status));
        if (modelBarang == null) {
            System.out.println("\n[ Barang Gagal Ditambahkan ]");
        } else {
            System.out.println("\n[ Barang Ditambahkan ]");
        }
    }

    public ModelBarang idSearchBarang(int id) {
        ModelBarang modelBarang = listBarang.searchId(id);
        if (modelBarang != null) {
            System.out.println("\n[ Barang Ditemukan ]");
        } else {
            System.out.println("\n[ Barang Tidak Ditemukan ]");
        }
        return modelBarang;
    }

    public void editBarang(ModelBarang barang, String nama, double harga, StatusBarang status) {
        System.out.print("\nYakin ingin mengubah? (y/n) : ");
        String yn = Input.readLine();

        if (yn.equals("y")) {
            barang.setNama(nama);
            barang.setHarga(harga);
            barang.setStatus(status);
            System.out.println("\n[ Barang Diperbarui ]");

        } else if (yn.equals("n")) {
            System.out.println("\n[ Operasi Dibatalkan ]");

        } else {
            System.out.println("Pilih y/n");
        }
    }

    public void deleteBarang(ModelBarang barang) {
        System.out.print("\nYakin ingin menghapus? (y/n) : ");
        String yn = Input.readLine();

        if (yn.equals("y")) {
            listBarang.delete(barang);
            System.out.println("\n[ Barang Dihapus ]");
        } else if (yn.equals("n")) {
            System.out.println("\n[ Operasi Dibatalkan ]");
        } else {
            System.out.println("Pilih y/n");
        }
    }

    public void showBarang(ModelBarang barang) {
        if (barang != null) {
            System.out.print(barang.info());
        }
    }

    public void showAllBarang() {
        if (listBarang.getHead() == null) {
            System.out.println("\n[ Barang Tidak Ditemukan ]");
        } else {
            listBarang.printList();
        }
    }

    public void showAllItem() {
        System.out.println();
        if (listBarang.getHead() == null) {
            System.out.println("\n[ Barang Tidak Ditemukan ]");
        } else {
            listBarang.printList();
        }
    }
    
    public ListBarang newListItem() {
        return new ListBarang();
    }

    public ListBarang addItem(ListBarang listItem, ModelBarang item) {
        listItem.insertItem(item);
        return listItem;
    }

    public double hitungHarga(ListBarang listItem, int jumlah) {
        return listItem.getHarga(listItem) * jumlah;
    }
}
