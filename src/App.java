import utils.Input;
import views.Auth;

public class App {
    private final Auth auth = new Auth();
    private final Init init = new Init();

    public static void main(String[] args) {
        App run = new App();

        run.homePage();
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

            switch (ch) {
                case 1:
                    auth.login();
                    break;

                case 2:
                    auth.register();
                    break;

                case 0:
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
