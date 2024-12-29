package views.admin;

import java.util.Scanner;

import controllers.ControllerBarang;
import controllers.ControllerTransaksi;
import controllers.ControllerUser;
import models.ModelBarang;
import utils.Enums.StatusTransaksi;

public class ViewTransaksi {
    int ch;
    int id;
    int id_user;
    int id_service;
    double harga;
    StatusTransaksi status;
    int jumlah;
    ModelBarang item;

    Scanner input = new Scanner(System.in);
    final ControllerTransaksi controller = new ControllerTransaksi();
    ControllerUser user;
    final ControllerBarang barang = new ControllerBarang();

    public void menuTransaksi() {
        do {
            System.out.println("==============================");
            System.out.println("           TRANSAKSI          ");
            System.out.println("==============================");
            System.out.println("1. Tambah Transaksi");
            System.out.println("2. Batalkan Transaksi");
            System.out.println("3. Lihat Transaksi");
            System.out.println("4. History Transaksi");
            System.out.println("0. Kembali");

            System.out.print("\nPilihan : ");
            ch = input.nextInt();
            input.nextLine();

            switch (ch) {
                case 1:
                    addTransaksi();
                    break;

                case 2:
                    deleteTransaksi();
                    break;

                case 3:
                    showTransaksi();
                    break;

                case 4:
                    historyTransaksi();
                    break;

                case 0:

                    break;

                default:
                    System.out.println("\n[ Pilihan Tidak ada ]");
                    input.nextLine();
                    break;
            }
        } while (ch != 0);
    }

    public void addTransaksi() {
        String yn = null;

        System.out.println("==============================");
        System.out.println("      TAMBAH TRANSAKSI        ");
        System.out.println("==============================");
        System.out.print("ID User     : ");
        id_user = input.nextInt();
        input.nextLine();

        if(user.idSearchUser(id) != null){
            do {
                controller.addTransaksi(id, null, harga, status);
    
                System.out.print("ID Service    : ");
                id_service = input.nextInt();
                input.nextLine();
    
                item = barang.searchBarang(id_service);
    
                if (barang != null) {
                    System.out.print("Jumlah : ");
                    jumlah = input.nextInt();
                    input.nextLine();
    
                    // detail.tambahService(item, jumlah);
                    
                    System.out.println("Tambah barang? (y/n)");
                }
    
            } while (!yn.equals("y") && !yn.equals("n"));
    
            // harga = controller.hitungTotalHarga();
    
            System.out.println("Harga   : " + harga);
            System.out.println("Lanjutkan transaksi? (y/n)");
    
            // createPayment()
    
            // addTransaksi()

        }

    }

    public void deleteTransaksi() {
        System.out.println("==============================");
        System.out.println("      BATALKAN TRANSAKSI      ");
        System.out.println("==============================");
        System.out.print("Masukkan ID : ");
        id = input.nextInt();
        input.nextLine();

        // searchTransaksi()

        System.out.println("Yakin ingin membatalkan transaksi ini? (y/n)");

        // cancelTransaksi()
    }

    public void showTransaksi() {
        System.out.println("==============================");
        System.out.println("        LIHAT TRANSAKSI       ");
        System.out.println("==============================");
        System.out.print("Masukkan ID : ");
        id = input.nextInt();
        input.nextLine();

        // searchUser()

        // showTransaksi("ONGOING")

    }

    public void historyTransaksi() {
        System.out.println("==============================");
        System.out.println("       HISTORY TRANSAKSI      ");
        System.out.println("==============================");
        System.out.print("Masukkan ID : ");
        id = input.nextInt();
        input.nextLine();

        // searchUser()

        // showTransaksi("DONE")
    }

}
