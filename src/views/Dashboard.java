package views;

import models.ModelUser;
import utils.Enums.Role;
import utils.Enums.StatusTransaksi;
import utils.Input;
import views.admin.ViewBarang;
import views.admin.ViewLaporan;
import views.admin.ViewTransaksi;
import views.admin.ViewUser;

public class Dashboard {
    private ModelUser loginUser;
    private ViewUser viewUser;
    private ViewBarang viewBarang;
    private ViewTransaksi viewTransaksi;
    private ViewLaporan viewLaporan;

    public Dashboard(
            ModelUser loginUser,
            ViewUser viewUser,
            ViewBarang viewBarang,
            ViewTransaksi viewTransaksi,
            ViewLaporan viewLaporan) {

        this.loginUser = loginUser;
        this.viewUser = viewUser;
        this.viewBarang = viewBarang;
        this.viewTransaksi = viewTransaksi;
        this.viewLaporan = viewLaporan;

        if (this.loginUser.getRole() == Role.CUSTOMER) {
            dashboardCustomer();
        } else if (this.loginUser.getRole() == Role.ADMIN) {
            dashboardAdmin();
        } else {
            System.out.println("[ Login Error ]");
        }
    }

    public void dashboardAdmin() {
        int ch;

        do {
            Input.cls();

            System.out.println("==============================");
            System.out.println("           DASHBOARD          ");
            System.out.println("==============================");
            System.out.println("1. Menu User");
            System.out.println("2. Menu Barang");
            System.out.println("3. Menu Transaksi");
            System.out.println("4. Menu Laporan");
            System.out.println("9. Login Info");
            System.out.println("0. Logout");

            System.out.print("\nPilihan : ");
            ch = Input.readInt();

            switch (ch) {
                case 1:
                    viewUser.menuUser(loginUser);
                    break;

                case 2:
                    viewBarang.menuBarang();
                    break;

                case 3:
                    viewTransaksi.menuTransaksi();
                    break;

                case 4:
                    viewLaporan.menuLaporan();
                    break;

                case 9:
                    loginInfo();
                    break;

                case 0:
                    System.out.println("\n[ Logout ]");
                    Input.pressEnter();
                    break;

                default:
                    System.out.println("\n[ Pilihan Tidak ada ]");
                    Input.pressEnter();
                    break;
            }
        } while (ch != 0);
    }

    public void dashboardCustomer() {
        int ch;

        do {
            Input.cls();

            System.out.println("==============================");
            System.out.println("           CUSTOMER           ");
            System.out.println("==============================");
            System.out.println("1. Lihat Barang");
            System.out.println("2. Buat Transaksi");
            System.out.println("3. Transaksi Belum Dibayar");
            System.out.println("4. Transaksi Berlangsung");
            System.out.println("5. Transaksi Selesai");
            System.out.println("0. Logout");

            System.out.print("\nPilihan : ");
            ch = Input.readInt();

            switch (ch) {
                case 1:
                    viewBarang.semuaBarang();
                    break;

                case 2:
                    viewTransaksi.addTransaksi();
                    break;

                case 3:
                    viewTransaksi.searchStatusTransaksi(StatusTransaksi.PENDING);
                    break;

                case 4:
                    viewTransaksi.searchStatusTransaksi(StatusTransaksi.ONGOING);
                    break;

                case 5:
                    viewTransaksi.searchStatusTransaksi(StatusTransaksi.DONE);
                    break;

                case 9:
                    loginInfo();
                    break;

                case 0:
                    System.out.println("\n[ Logout ]");
                    Input.pressEnter();
                    break;

                default:
                    System.out.println("\n[ Pilihan Tidak ada ]");
                    Input.pressEnter();
                    break;
            }
        } while (ch != 0);
    }

    public void loginInfo() {
        Input.cls();

        System.out.println("==============================");
        System.out.println("          LOGIN INFO          ");
        System.out.println("==============================");
        viewUser.getController().showUser(loginUser);

        Input.pressEnter();
    }
}
