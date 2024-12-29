package views.admin;

import java.util.Scanner;

public class ViewPayment {
    int ch;
    int id;
    int id_user;
    int id_transaksi;
    int id_service;
    double harga;
    String status;
    int jumlah;
    Scanner input = new Scanner(System.in);

    public void menuPayment() {
        do {
            System.out.println("==============================");
            System.out.println("            PAYMENT           ");
            System.out.println("==============================");
            System.out.println("1. Lakukan Pembayaran");
            System.out.println("2. Lihat Pembayaran");
            System.out.println("0. Kembali");

            System.out.print("\nPilihan : ");
            ch = input.nextInt();
            input.nextLine();

            switch (ch) {
                case 1:
                    payment();
                    break;

                case 2:
                    showPayment();
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

    public void payment() {
        System.out.println("==============================");
        System.out.println("      LAKUKAN PEMBAYARAN      ");
        System.out.println("==============================");
        System.out.print("ID User      : ");
        id_user = input.nextInt();
        input.nextLine();
        System.out.print("ID Transaksi : ");
        id_transaksi = input.nextInt();
        input.nextLine();

        // searchTransaksi()

        System.out.print("Bayar : ");
        jumlah = input.nextInt();
        input.nextLine();
        System.out.println("Yakin? (y/n)");

        // prosesPembayaran()
    }

    public void showPayment() {
        System.out.println("==============================");
        System.out.println("       LIHAT PEMBAYARAN       ");
        System.out.println("==============================");
        System.out.print("Masukkan ID : ");
        id = input.nextInt();
        input.nextLine();
    }
}
