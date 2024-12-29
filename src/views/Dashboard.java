package views;

import models.ModelUser;
import utils.Enums.Role;
import utils.Input;
import views.admin.ViewPayment;
import views.admin.ViewBarang;
import views.admin.ViewTransaksi;
import views.admin.ViewUser;

public class Dashboard {
    final ViewUser user = new ViewUser();
    final ViewBarang service = new ViewBarang();
    final ViewTransaksi transaksi = new ViewTransaksi();
    final ViewPayment payment = new ViewPayment();

    private ModelUser loginUser;

    public Dashboard(ModelUser loginUser) {
        this.loginUser = loginUser;

        if (loginUser.getRole() == Role.ADMIN) {
            dashboardAdmin();

        } else if (loginUser.getRole() == Role.CUSTOMER) {
            dashboardCustomer();

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
            System.out.println("2. Menu Service");
            System.out.println("3. Menu Transaksi");
            System.out.println("4. Menu Payment");
            System.out.println("0. Logout");

            System.out.print("\nPilihan : ");
            ch = Input.readInt();

            switch (ch) {
                case 1:
                    user.menuUser();
                    break;

                case 2:
                    service.menuService();
                    break;

                case 3:
                    transaksi.menuTransaksi();
                    break;

                case 4:
                    payment.menuPayment();
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
            System.out.println("1. Menu User");
            System.out.println("2. Menu Service");
            System.out.println("3. Menu Transaksi");
            System.out.println("4. Menu Payment");
            System.out.println("0. Logout");

            System.out.print("\nPilihan : ");
            ch = Input.readInt();

            switch (ch) {
                case 1:
                    user.menuUser();
                    break;

                case 2:
                    service.menuService();
                    break;

                case 3:
                    transaksi.menuTransaksi();
                    break;

                case 4:
                    payment.menuPayment();
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
        user.getcontroller().showUser(loginUser);

        Input.pressEnter();
    }

    public ViewUser getUser() {
        return user;
    }

    public ViewBarang getService() {
        return service;
    }

    public ViewTransaksi getTransaksi() {
        return transaksi;
    }

    public ViewPayment getPayment() {
        return payment;
    }
}
