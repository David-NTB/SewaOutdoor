package views.admin;

import java.util.Scanner;

import controllers.ControllerBarang;
import models.ModelBarang;
import utils.Enums.StatusBarang;

public class ViewBarang {
    int ch;
    int id;
    String nama;
    double harga;
    String kategori;
    StatusBarang status;
    ModelBarang service;
    String yn;

    Scanner input = new Scanner(System.in);
    final ControllerBarang controller = new ControllerBarang();

    public void menuService() {
        do {
            System.out.println("==============================");
            System.out.println("            SERVICE           ");
            System.out.println("==============================");
            System.out.println("1. Tambah Service");
            System.out.println("2. Edit Service");
            System.out.println("3. Hapus Service");
            System.out.println("4. Cari Service");
            System.out.println("5. Semua Service");
            System.out.println("0. Kembali");

            System.out.print("\nPilihan : ");
            ch = input.nextInt();
            input.nextLine();

            switch (ch) {
                case 1:
                    addService();
                    break;

                case 2:
                    editService();
                    break;

                case 3:
                    deleteService();
                    break;

                case 4:
                    cariService();
                    break;

                case 5:
                    semuaService();
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

    public void addService() {
        System.out.println("==============================");
        System.out.println("       TAMBAH SERVICE         ");
        System.out.println("==============================");
        System.out.print("Nama     : ");
        nama = input.nextLine();
        System.out.print("Harga    : ");
        harga = input.nextInt();
        input.nextLine();
        System.out.print("Kategori : ");
        kategori = input.nextLine();
        System.out.print("Status   : ");
        status = StatusBarang.AVAILABLE;

        controller.addBarang(id, nama, harga, status);
    }

    public void editService() {
        System.out.println("==============================");
        System.out.println("         EDIT SERVICE         ");
        System.out.println("==============================");
        System.out.print("Masukkan ID : ");
        id = input.nextInt();
        input.nextLine();

        service = controller.searchBarang(id);

        System.out.print("Nama     : ");
        nama = input.nextLine();
        System.out.print("Harga    : ");
        harga = input.nextInt();
        input.nextLine();
        System.out.print("Kategori : ");
        kategori = input.nextLine();
        System.out.print("Status   : ");
        status = StatusBarang.AVAILABLE;

        do {
            System.out.print("\nYakin ingin mengubah? (y/n) : ");
            yn = input.nextLine();

            if (yn.equals("y")) {
                controller.editBarang(service, nama, harga, status);
            } else if (yn.equals("n")) {
                System.out.println("[ Operasi Dibatalkan ]");
            } else {
                System.out.println("Pilih y/n");
            }
        } while (!yn.equals("y") && !yn.equals("n"));

    }

    public void deleteService() {
        System.out.println("==============================");
        System.out.println("         HAPUS SERVICE        ");
        System.out.println("==============================");
        System.out.print("Masukkan ID : ");
        id = input.nextInt();
        input.nextLine();

        service = controller.searchBarang(id);

        do {
            System.out.print("Yakin ingin menghapus? (y/n) : ");
            yn = input.nextLine();

            if (yn.equals("y")) {
                controller.deleteBarang(service);
            } else if (yn.equals("n")) {
                System.out.println("[ Operasi Dibatalkan ]");
            } else {
                System.out.println("Pilih y/n");
            }
        } while (!yn.equals("y") && !yn.equals("n"));
    }

    public void cariService() {
        System.out.println("==============================");
        System.out.println("         CARI SERVICE         ");
        System.out.println("==============================");
        System.out.print("Masukkan ID : ");
        id = input.nextInt();
        input.nextLine();

        service = controller.searchBarang(id);

        controller.showBarang(service);
    }

    public void semuaService() {
        System.out.println("==============================");
        System.out.println("         SEMUA SERVICE        ");
        System.out.println("==============================");

        controller.showAllBarang();
    }

}
