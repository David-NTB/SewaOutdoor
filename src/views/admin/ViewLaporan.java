package views.admin;

import controllers.ControllerLaporan;
import controllers.ControllerTransaksi;
import models.ModelLaporan;
import utils.Input;

public class ViewLaporan {
    private ControllerTransaksi controllerTransaksi;
    private ControllerLaporan controller;

    public ViewLaporan(ControllerTransaksi controllerTransaksi, ControllerLaporan controller) {
        this.controllerTransaksi = controllerTransaksi;
        this.controller = controller;
    }

    public void menuLaporan() {
        int ch = -1;

        while (ch != 0) {
            Input.cls();

            System.out.println("==============================");
            System.out.println("            LAPORAN           ");
            System.out.println("==============================");
            System.out.println("1. Buat Laporan");
            System.out.println("2. Cari Laporan");
            System.out.println("3. Semua Laporan");
            System.out.println("0. Kembali");

            System.out.print("\nPilihan : ");
            ch = Input.readInt();

            switch (ch) {
                case 1:
                    addLaporan();
                    break;

                case 2:
                    searchLaporan();
                    break;

                case 3:
                    showAllLaporan();
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

    public void addLaporan() {
        ModelLaporan modelLaporan = controller.addLaporan(controllerTransaksi.generateLaporan());
        controller.showLaporan(modelLaporan);

        Input.pressEnter();
    }

    public void searchLaporan() {
        Input.cls();

        System.out.println("==============================");
        System.out.println("         LIHAT LAPORAN        ");
        System.out.println("==============================");
        System.out.print("Masukkan ID : ");
        int id = Input.readInt();

        ModelLaporan modelLaporan = controller.idSearchLaporan(id);

        controller.showLaporan(modelLaporan);

        Input.pressEnter();
    }

    public void showAllLaporan() {
        Input.cls();

        System.out.println("==============================");
        System.out.println("       HISTORY LAPORAN        ");
        System.out.println("==============================");

        controller.showAllLaporan();

        Input.pressEnter();
    }

}
