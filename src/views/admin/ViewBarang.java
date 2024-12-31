package views.admin;

import controllers.ControllerBarang;
import models.ModelBarang;
import utils.Input;
import utils.Enums.StatusBarang;

public class ViewBarang {
    private ControllerBarang controller;

    public ViewBarang(ControllerBarang controller) {
        this.controller = controller;
    }

    public void menuBarang() {
        int ch = -1;

        while (ch != 0) {
            Input.cls();

            System.out.println("==============================");
            System.out.println("            SERVICE           ");
            System.out.println("==============================");
            System.out.println("1. Tambah Barang");
            System.out.println("2. Edit Barang");
            System.out.println("3. Hapus Barang");
            System.out.println("4. Cari Barang");
            System.out.println("5. Semua Barang");
            System.out.println("0. Kembali");

            System.out.print("\nPilihan : ");
            ch = Input.readInt();

            switch (ch) {
                case 1:
                    addBarang();
                    break;

                case 2:
                    editBarang();
                    break;

                case 3:
                    deleteBarang();
                    break;

                case 4:
                    cariBarang();
                    break;

                case 5:
                    semuaBarang();
                    break;

                case 0:

                    break;

                default:
                    System.out.println("\n[ Pilihan Tidak ada ]");
                    Input.pressEnter();
                    break;
            }
        }
    }

    public void addBarang() {
        Input.cls();

        System.out.println("==============================");
        System.out.println("       TAMBAH SERVICE         ");
        System.out.println("==============================");
        System.out.print("Nama     : ");
        String nama = Input.readLine();
        System.out.print("Harga    : ");
        double harga = Input.readDouble();
        System.out.print("Status   : ");
        StatusBarang status = Input.setStatusBarang();

        controller.addBarang(0, nama, harga, status);

        Input.pressEnter();
    }

    public void editBarang() {
        Input.cls();

        System.out.println("==============================");
        System.out.println("          EDIT BARANG         ");
        System.out.println("==============================");
        System.out.print("Masukkan ID : ");
        int id = Input.readInt();

        ModelBarang barang = controller.idSearchBarang(id);

        if (barang != null) {
            System.out.print("\nNama     : ");
            String nama = Input.readLine();
            System.out.print("Harga    : ");
            double harga = Input.readDouble();
            System.out.print("Status   : ");
            StatusBarang statusBarang = Input.setStatusBarang();

            controller.editBarang(barang, nama, harga, statusBarang);
        }
        Input.pressEnter();
    }

    public void deleteBarang() {
        Input.cls();

        System.out.println("==============================");
        System.out.println("         HAPUS SERVICE        ");
        System.out.println("==============================");
        System.out.print("Masukkan ID : ");
        int id = Input.readInt();

        ModelBarang barang = controller.idSearchBarang(id);

        if (barang != null) {
            controller.deleteBarang(barang);
        }

        Input.pressEnter();
    }

    public void cariBarang() {
        Input.cls();

        System.out.println("==============================");
        System.out.println("         CARI SERVICE         ");
        System.out.println("==============================");
        System.out.print("Masukkan ID : ");
        int id = Input.readInt();

        ModelBarang barang = controller.idSearchBarang(id);

        controller.showBarang(barang);

        Input.pressEnter();
    }

    public void semuaBarang() {
        Input.cls();

        System.out.println("==============================");
        System.out.println("         SEMUA SERVICE        ");
        System.out.println("==============================");

        controller.showAllBarang();

        Input.pressEnter();
    }

}
