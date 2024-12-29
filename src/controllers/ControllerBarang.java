package controllers;

import databases.lists.ListBarang;
import models.ModelBarang;
import utils.Enums.StatusBarang;

public class ControllerBarang {
    final ListBarang data = new ListBarang();

    public void addBarang(int id, String nama, double harga, StatusBarang status) {
        data.insert(new ModelBarang(id, nama, harga, status));
    }

    public ModelBarang searchBarang(int id) {
        return data.search(id);
    }

    public void editBarang(ModelBarang barang, String nama, double harga, StatusBarang status) {
        barang.setNama(nama);
        barang.setHarga(harga);
        barang.setStatus(status);
    }
    
    public void deleteBarang(ModelBarang barang) {
        data.delete(barang);
    }
        
    public void showBarang(ModelBarang barang){
        System.out.println(barang.toString());
    }

    public void showAllBarang() {
        data.printList();
   }
}
