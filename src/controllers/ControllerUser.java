package controllers;

import databases.lists.ListUser;
import databases.sources.SourceUser;
import models.ModelUser;
import utils.Enums.Role;
import utils.Input;

public class ControllerUser {
    SourceUser sourceUser = new SourceUser();
    ListUser listUser;

    public ControllerUser(SourceUser source) {
        listUser = source.getListUser();
    }

    public ModelUser addUser(int id, String nama, String email, String password, Role role) {
        ModelUser modelUser = listUser.insert(new ModelUser(id, nama, email, password, role));
        if (modelUser == null) {
            System.out.println("\n[ User Gagal Ditambahkan ]");
        } else {
            System.out.println("\n[ User Ditambahkan ]");
        }
        return modelUser;
    }

    public ModelUser idSearchUser(int id) {
        ModelUser modelUser = listUser.searchId(id);
        if (modelUser != null) {
            System.out.println("\n[ User Ditemukan ]");
        } else {
            System.out.println("\n[ User Tidak Ditemukan ]");
        }
        return modelUser;
    }

    public ModelUser emailSearchUser(String email) {
        return listUser.searchEmail(email);
    }

    public void editUser(ModelUser user, String nama, String email, String pass, Role role) {
        System.out.print("\nYakin ingin mengubah? (y/n) : ");
        String yn = Input.readLine();

        if (yn.equals("y")) {
            user.setNama(nama);
            user.setEmail(email);
            user.setPassword(pass);
            user.setRole(role);
            System.out.println("\n[ User Diperbarui ]");

        } else if (yn.equals("n")) {
            System.out.println("\n[ Operasi Dibatalkan ]");
        } else {
            System.out.println("Pilih y/n");
        }
    }

    public void deleteUser(ModelUser user) {
        System.out.print("\nYakin ingin menghapus? (y/n) : ");
        String yn = Input.readLine();

        if (yn.equals("y")) {
            listUser.delete(user);
            System.out.println("\n[ User Dihapus ]");
        } else if (yn.equals("n")) {
            System.out.println("\n[ Operasi Dibatalkan ]");
        } else {
            System.out.println("Pilih y/n");
        }
    }

    public void showUser(ModelUser user) {
        if (user != null) {
            System.out.print(user.info());
        }
    }

    public void showAllUser() {
        if (listUser.getHead() == null) {
            System.out.println("\n[ User Tidak Ditemukan ]");
        } else {
            listUser.printList();
        }
    }

    public ModelUser verifikasiLogin(String email, String pass) {
        ModelUser modelUser = listUser.searchEmail(email);

        if (modelUser == null) {
            System.out.println("\n[ Username atau password salah ]");
            return null;

        } else if (modelUser.getPassword().equals(pass)) {
            System.out.println("\n[ Login Berhasil ]");
            return modelUser;

        } else {
            System.out.println("\n[ Username atau password salah ]");
            return null;
        }
    }

    public ModelUser register(String nama, String email, String pass, Role role) {
        return addUser(0, nama, email, pass, role);
    }
}
