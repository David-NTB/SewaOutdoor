package views;

import controllers.ControllerAuth;
import models.ModelUser;
import utils.Input;
import utils.Enums.Role;

public class Auth {
    final ControllerAuth controller = new ControllerAuth();
    Dashboard dashboard;

    public void login() {
        Input.cls();
        String email, pass;

        System.out.println("==============================");
        System.out.println("          LOGIN MENU          ");
        System.out.println("==============================");
        System.out.print("Email       : ");
        email = Input.readLine();
        System.out.print("Password    : ");
        pass = Input.readLine();

        final ModelUser user = controller.cekLogin(email, pass);

        if (user != null) {
            Input.pressEnter();
            dashboard = new Dashboard(user);
        } else {
            Input.pressEnter();
        }
    }

    public void register() {
        Input.cls();
        String nama, email, pass;
        Role role;

        System.out.println("==============================");
        System.out.println("        REGISTER MENU         ");
        System.out.println("==============================");
        System.out.print("Nama        : ");
        nama = Input.readLine();
        System.out.print("Email       : ");
        email = Input.readLine();
        System.out.print("Password    : ");
        pass = Input.readLine();
        System.out.print("Role        : ");
        role = Input.setRole();

        final ModelUser user = controller.register(nama, email, pass, role);

        if (user != null) {
            Input.pressEnter();
            dashboard = new Dashboard(user);
        } else {
            Input.pressEnter();
        }
    }

    public Dashboard getDashboard() {
        return dashboard;
    }
}
