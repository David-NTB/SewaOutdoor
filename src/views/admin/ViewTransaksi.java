package views.admin;

import controllers.ControllerBarang;
import controllers.ControllerTransaksi;
import controllers.ControllerUser;
import databases.lists.ListBarang;
import models.ModelBarang;
import models.ModelTransaksi;
import models.ModelUser;
import utils.Input;
import utils.Enums.StatusTransaksi;

public class ViewTransaksi {
    private ControllerUser controllerUser;
    private ControllerBarang controllerBarang;
    private ControllerTransaksi controller;

    public ViewTransaksi(ControllerUser controllerUser, ControllerBarang controllerBarang,
            ControllerTransaksi controller) {
        this.controllerUser = controllerUser;
        this.controllerBarang = controllerBarang;
        this.controller = controller;
    }

    public void menuTransaksi() {
        int ch = -1;

        while (ch != 0) {
            Input.cls();

            System.out.println("==============================");
            System.out.println("           TRANSAKSI          ");
            System.out.println("==============================");
            System.out.println("1. Tambah Transaksi");
            System.out.println("2. Batalkan Transaksi");
            System.out.println("3. Cari Transaksi");
            System.out.println("4. Semua Transaksi");
            System.out.println("0. Kembali");

            System.out.print("\nPilihan : ");
            ch = Input.readInt();

            switch (ch) {
                case 1:
                    addTransaksi();
                    break;

                case 2:
                    cancelTransaksi();
                    break;

                case 3:
                    searchTransaksi();
                    break;

                case 4:
                    historyTransaksi();
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

    public void addTransaksi() {
        Input.cls();

        System.out.println("==============================");
        System.out.println("      TAMBAH TRANSAKSI        ");
        System.out.println("==============================");
        System.out.print("ID User     : ");
        int id_user = Input.readInt();

        ModelUser user = controllerUser.idSearchUser(id_user);

        if (user != null) {
            String yn = "y";
            ListBarang listItem = controllerBarang.newListItem();
            double harga = 0;

            // Tampilkan seluruh listbarang
            while (yn.equals("y")) {

                System.out.print("\nID Barang    : ");
                int id_barang = Input.readInt();

                ModelBarang item = controllerBarang.idSearchBarang(id_barang);

                if (item != null) {

                    listItem = controllerBarang.addItem(listItem, item);

                }
                System.out.print("\nTambah barang? (y/n) : ");
                yn = Input.readLine();
            }
            System.out.print("\nLama Sewa (hari) : ");
            int jumlah = Input.readInt();

            harga = controllerBarang.hitungHarga(listItem, jumlah);
            System.out.println("Harga Total : " + harga);
            System.out.print("\nLanjutkan transaksi? (y/n) : ");
            String ys = Input.readLine();

            if (ys.equals("y")) {
                // createPayment()
                controller.addTransaksi(0, user, listItem, harga, StatusTransaksi.PENDING);
            } else {
                System.out.println("[ Transaksi Dibatalkan ]");
            }

        }
        Input.pressEnter();
    }

    public void cancelTransaksi() {
        Input.cls();

        System.out.println("==============================");
        System.out.println("      BATALKAN TRANSAKSI      ");
        System.out.println("==============================");
        System.out.print("Masukkan ID : ");
        int id = Input.readInt();

        ModelTransaksi modelTransaksi = controller.idSearchTransaksi(id);

        if (modelTransaksi != null) {
            System.out.print("\nYakin ingin membatalkan transaksi? (y/n) : ");
            String yn = Input.readLine();

            if (yn.equals("y")) {
                controller.cancelTransaksi(modelTransaksi);
                System.out.println("\n[ Transaksi Dibatalkan ]");

            } else if (yn.equals("n")) {
                System.out.println("\n[ Operasi Dibatalkan ]");

            } else {
                System.out.println("Pilih y/n");
            }
        }

        Input.pressEnter();
    }

    public void searchTransaksi() {
        Input.cls();

        System.out.println("==============================");
        System.out.println("        LIHAT TRANSAKSI       ");
        System.out.println("==============================");
        System.out.print("Masukkan ID : ");
        int id = Input.readInt();

        ModelTransaksi modelTransaksi = controller.idSearchTransaksi(id);

        controller.showTransaksi(modelTransaksi);

        Input.pressEnter();
    }

    public void historyTransaksi() {
        Input.cls();

        System.out.println("==============================");
        System.out.println("       HISTORY TRANSAKSI      ");
        System.out.println("==============================");

        controller.showAllTransaksi();

        Input.pressEnter();
    }

    public void searchStatusTransaksi(StatusTransaksi statusTransaksi) {
        Input.cls();

        System.out.println("==============================");
        System.out.println("        LIHAT TRANSAKSI       ");
        System.out.println("==============================");

        controller.showStatusTransaksi(statusTransaksi);

        Input.pressEnter();
    }

}
