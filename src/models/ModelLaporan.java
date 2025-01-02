package models;

import java.time.LocalDateTime;

import databases.lists.ListTransaksi;

public class ModelLaporan {
    private int id;
    private LocalDateTime dateTime;
    private ListTransaksi transaksi;
    
    public ModelLaporan(int id, LocalDateTime dateTime, ListTransaksi transaksi) {
        this.id = id;
        this.dateTime = dateTime;
        this.transaksi = transaksi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ListTransaksi getTransaksi() {
        return transaksi;
    }

    public void setTransaksi(ListTransaksi transaksi) {
        this.transaksi = transaksi;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String info() {
        String id = "ID Laporan      : " + this.id + "\n";
        String dt = "Tanggal Laporan : " + this.dateTime + "\n";
        String aa = "\n------------------------------\n";
        String lt = "List Transaksi  : \n" + this.transaksi.printList();
        return id + dt + aa + lt;
    }

    public String infoo() {
        String id = "ID Laporan      : " + this.id + "\n";
        String dt = "Tanggal Laporan : " + this.dateTime + "\n";
        String aa = "\n------------------------------\n";
        return id + dt + aa;
    }
}
