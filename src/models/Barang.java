public class Barang {
    private int id;
    private String nama;
    private double harga;

    public Barang(int id, String nama, double harga){
        this.id = id;
        this.nama = nama;
        this.harga = harga;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        String id = "ID       : " + this.id + "\n";
        String nm = "Name     : " + this.nama + "\n";
        String hr = "Harga    : " + this.harga + "\n";
        return id + nm + hr;
    }
}
