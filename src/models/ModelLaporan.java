package models;

import java.time.LocalDateTime;

import databases.nodes.NodeTransaksi;

public class ModelLaporan {
    private int id;
    private LocalDateTime dateTime;
    private NodeTransaksi transaksi;
    
    public ModelLaporan(int id, LocalDateTime dateTime, NodeTransaksi transaksi) {
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

    public NodeTransaksi getTransaksi() {
        return transaksi;
    }

    public void setTransaksi(NodeTransaksi transaksi) {
        this.transaksi = transaksi;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

}
