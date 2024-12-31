package views.admin;

import controllers.ControllerUser;
import models.ModelUser;
import utils.Input;
import utils.Enums.Role;

public class ViewUser {
    private ControllerUser controller;

    public ViewUser(ControllerUser controller) {
        this.controller = controller;
    }

    public void menuUser(ModelUser loginUser) {
        int ch = -1;

        while (ch != 0) {
            Input.cls();

            System.out.println("==============================");
            System.out.println("              USER            ");
            System.out.println("==============================");
            System.out.println("1. Tambah User");
            System.out.println("2. Edit User");
            System.out.println("3. Hapus User");
            System.out.println("4. Cari User");
            System.out.println("5. Semua User");
            System.out.println("0. Kembali");

            System.out.print("\nPilihan : ");
            ch = Input.readInt();

            switch (ch) {
                case 1:
                    addUser();
                    break;

                case 2:
                    editUser(loginUser);
                    break;

                case 3:
                    deleteUser(loginUser);
                    break;

                case 4:
                    cariUser();
                    break;

                case 5:
                    semuaUser();
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

    public void addUser() {
        Input.cls();

        System.out.println("==============================");
        System.out.println("         TAMBAH USER          ");
        System.out.println("==============================");
        System.out.print("Nama     : ");
        String nama = Input.readLine();
        System.out.print("Email    : ");
        String email = Input.readLine();
        System.out.print("Password : ");
        String pass = Input.readLine();
        System.out.print("Role     : ");
        Role role = Input.setRole();

        controller.addUser(0, nama, email, pass, role);

        Input.pressEnter();
    }

    public void editUser(ModelUser loginUser) {
        Input.cls();

        System.out.println("==============================");
        System.out.println("           EDIT USER          ");
        System.out.println("==============================");
        System.out.print("Masukkan ID : ");
        int id = Input.readInt();

        ModelUser user = controller.idSearchUser(id);

        if (user != loginUser) {
            if (user != null) {
                System.out.print("\nNama     : ");
                String nama = Input.readLine();
                System.out.print("Email    : ");
                String email = Input.readLine();
                System.out.print("Password : ");
                String pass = Input.readLine();
                System.out.print("Role     : ");
                Role role = Input.setRole();
        
                controller.editUser(user, nama, email, pass, role);;
            }
        } else {
            System.out.println("\n[ User Sedang Login ]");
        }

        Input.pressEnter();
    }

    public void deleteUser(ModelUser loginUser) {
        Input.cls();

        System.out.println("==============================");
        System.out.println("          HAPUS USER          ");
        System.out.println("==============================");
        System.out.print("Masukkan ID : ");
        int id = Input.readInt();

        ModelUser user = controller.idSearchUser(id);

        if (user != loginUser) {
            if (user != null) {
                controller.deleteUser(user);
            }
        } else {
            System.out.println("\n[ User Sedang Login ]");
        }

        Input.pressEnter();
    }

    public void cariUser() {
        Input.cls();

        System.out.println("==============================");
        System.out.println("          CARI USER           ");
        System.out.println("==============================");
        System.out.print("Masukkan ID : ");
        int id = Input.readInt();

        ModelUser user = controller.idSearchUser(id);

        controller.showUser(user);

        Input.pressEnter();
    }

    public void semuaUser() {
        Input.cls();

        System.out.println("==============================");
        System.out.println("          SEMUA USER          ");
        System.out.println("==============================");

        controller.showAllUser();

        Input.pressEnter();
    }

    public ControllerUser getController() {
        return controller;
    }
}
