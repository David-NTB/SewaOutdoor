import models.ModelUser;
import utils.Input;
import views.Auth;
import views.Dashboard;
import views.admin.ViewBarang;
import views.admin.ViewLaporan;
import views.admin.ViewTransaksi;
import views.admin.ViewUser;

public class App {
    Init init;

    private Auth auth;
    private ViewUser viewUser;
    private ViewBarang viewBarang;
    private ViewTransaksi viewTransaksi;
    private ViewLaporan viewLaporan;

    public static void main(String[] args) {
        App run = new App();
        run.init = new Init();

        run.init.insertDatasource();
        run.createApp();
        run.homePage();
    }

    public void createApp() {
        this.auth = new Auth(this.init.controllerUser);
        this.viewUser = new ViewUser(this.init.controllerUser);
        this.viewBarang = new ViewBarang(this.init.controllerBarang);
        this.viewTransaksi = new ViewTransaksi(this.init.controllerUser, this.init.controllerBarang,
        this.init.controllerTransaksi);
        this.viewLaporan = new ViewLaporan(this.init.controllerUser, this.init.controllerBarang,
        this.init.controllerTransaksi, this.init.controllerLaporan);
    }

    public void homePage() {
        while (true) {
            Input.cls();
            int ch;

            System.out.println("==============================");
            System.out.println("           TRAVELIKU          ");
            System.out.println("==============================");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("0. Keluar");

            System.out.print("\nPilihan : ");
            ch = Input.readInt();

            ModelUser loginUser;

            switch (ch) {
                case 1:
                    loginUser = auth.login();

                    if (loginUser == null) {
                        System.out.println("[ Login Gagal ]");
                    } else {
                        System.out.println("[ Login Berhasil ]");
                        new Dashboard(loginUser, viewUser, viewBarang, viewTransaksi);
                    }
                    break;

                case 2:
                    loginUser = auth.register();
                    if (loginUser == null) {
                        System.out.println("[ Register Gagal ]");
                    } else {
                        System.out.println("[ Register Berhasil ]");
                        new Dashboard(loginUser, viewUser, viewBarang, viewTransaksi);
                    }
                    break;

                case 0:
                    System.out.println("[ Menutup Aplikasi ]");
                    System.exit(0);
                    break;

                default:
                    System.out.println("\n[ Pilihan Tidak ada ]");
                    Input.pressEnter();
                    break;
            }
        }
    }

}
