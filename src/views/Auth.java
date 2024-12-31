package views;

import controllers.ControllerUser;
import models.ModelUser;
import utils.Input;
import utils.Enums.Role;

public class Auth {
    final ControllerUser controller;

    public Auth(ControllerUser controller) {
        this.controller = controller;
    }

    public ModelUser login() {
        Input.cls();

        System.out.println("==============================");
        System.out.println("          LOGIN MENU          ");
        System.out.println("==============================");
        System.out.print("Email       : ");
        String email = Input.readLine();
        System.out.print("Password    : ");
        String pass = Input.readLine();

        ModelUser loginUser = controller.verifikasiLogin(email, pass);

        Input.pressEnter();

        return loginUser;
    }

    public ModelUser register() {
        Input.cls();

        System.out.println("==============================");
        System.out.println("        REGISTER MENU         ");
        System.out.println("==============================");
        System.out.print("Nama        : ");
        String nama = Input.readLine();
        System.out.print("Email       : ");
        String email = Input.readLine();
        System.out.print("Password    : ");
        String pass = Input.readLine();
        System.out.print("Role        : ");
        Role role = Input.setRole();

        ModelUser loginUser = controller.register(nama, email, pass, role);

        Input.pressEnter();

        return loginUser;
    }
}
