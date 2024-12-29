package views.admin;

import java.util.Scanner;

import controllers.ControllerUser;
import databases.sources.SourceUser;
import models.ModelUser;
import utils.Enums.Role;

public class ViewUser {
    int ch;
    int id;
    String nama;
    String email;
    String pass;
    Role role;
    ModelUser user;
    String yn;

    Scanner input = new Scanner(System.in);
    ControllerUser controller;

    public void menuUser() {
        do {

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
            ch = input.nextInt();
            input.nextLine();

            switch (ch) {
                case 1:
                    addUser();
                    break;

                case 2:
                    editUser();
                    break;

                case 3:
                    deleteUser();
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
                    input.nextLine();
                    break;
            }
        } while (ch != 0);

    }

    public void addUser() {
        System.out.println("==============================");
        System.out.println("         TAMBAH USER          ");
        System.out.println("==============================");
        System.out.print("Nama     : ");
        nama = input.nextLine();
        System.out.print("Email    : ");
        email = input.nextLine();
        System.out.print("Password : ");
        pass = input.nextLine();
        System.out.print("Role     : ");
        role = Role.ADMIN;

        controller.addUser(id, nama, email, pass, role);
    }

    public void editUser() {
        System.out.println("==============================");
        System.out.println("           EDIT USER          ");
        System.out.println("==============================");
        System.out.print("Masukkan ID : ");
        id = input.nextInt();
        input.nextLine();

        user = controller.idSearchUser(id);

        System.out.print("Nama     : ");
        nama = input.nextLine();
        System.out.print("Email    : ");
        email = input.nextLine();
        System.out.print("Password : ");
        pass = input.nextLine();
        System.out.print("Role     : ");
        role = Role.ADMIN;

        do {
            System.out.print("\nYakin ingin mengubah? (y/n) : ");
            yn = input.nextLine();

            if (yn.equals("y")) {
                controller.editUser(user, nama, email, pass, role);;
            } else if (yn.equals("n")) {
                System.out.println("[ Operasi Dibatalkan ]");
            } else {
                System.out.println("Pilih y/n");
            }
        } while (!yn.equals("y") && !yn.equals("n"));
        
    }

    public void deleteUser() {
        System.out.println("==============================");
        System.out.println("          HAPUS USER          ");
        System.out.println("==============================");
        System.out.print("Masukkan ID : ");
        id = input.nextInt();
        input.nextLine();

        user = controller.idSearchUser(id);

        do {
            System.out.print("Yakin ingin menghapus? (y/n) : ");
            yn = input.nextLine();

            if (yn.equals("y")) {
                controller.deleteUser(user);
            } else if (yn.equals("n")) {
                System.out.println("[ Operasi Dibatalkan ]");
            } else {
                System.out.println("Pilih y/n");
            }
        } while (!yn.equals("y") && !yn.equals("n"));

    }

    public void cariUser() {
        System.out.println("==============================");
        System.out.println("          CARI USER           ");
        System.out.println("==============================");
        System.out.print("Masukkan ID : ");
        id = input.nextInt();
        input.nextLine();

        user = controller.idSearchUser(id);

        controller.showUser(user);
    }

    public void semuaUser() {
        System.out.println("==============================");
        System.out.println("          SEMUA USER          ");
        System.out.println("==============================");

        controller.showAllUser();
    }

    public ControllerUser getcontroller(){
        return controller;
    }

}
