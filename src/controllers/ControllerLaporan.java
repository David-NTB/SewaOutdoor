package controllers;

import java.time.LocalDateTime;

import databases.lists.ListLaporan;
import databases.lists.ListTransaksi;
import databases.sources.SourceLaporan;
import models.ModelLaporan;
 
public class ControllerLaporan {
    SourceLaporan sourceLaporan = new SourceLaporan();
    ListLaporan listLaporan;

    public ControllerLaporan(SourceLaporan source) {
        listLaporan = source.getListLaporan();
    }

    public ModelLaporan addLaporan(ListTransaksi listTransaksi){
        ModelLaporan modelLaporan = listLaporan.insert(new ModelLaporan(0, getDateTime(), listTransaksi));
        if (modelLaporan == null) {
            System.out.println("\n[ Laporan Gagal Ditambahkan ]");
        } else {
            System.out.println("\n[ Laporan Ditambahkan ]");
        }
        return modelLaporan;
    }

    public LocalDateTime getDateTime(){
        LocalDateTime dateTime = LocalDateTime.now();
        return dateTime;
    }

    public ModelLaporan idSearchLaporan(int id) {
        ModelLaporan modelLaporan = listLaporan.idSearchLaporan(id);
        if (modelLaporan != null) {;
            System.out.println("\n[ Laporan Ditemukan ]");
        } else {
            System.out.println("\n[ Laporan Tidak Ditemukan ]");
        }
        return modelLaporan;
        
    }

    public void showLaporan(ModelLaporan modelLaporan){
        if (listLaporan != null) {
            System.out.println(modelLaporan.info());
        }
    }

    public void showAllLaporan() {
        if (listLaporan == null) {
            System.out.println("\n[ Laporan Tidak Ditemukan ]");
        }else{
            listLaporan.printAll();
        }
    }
}
