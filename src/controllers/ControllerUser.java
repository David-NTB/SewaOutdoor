package controllers;

import databases.lists.ListUser;
import databases.sources.SourceUser;
import models.ModelUser;
import utils.Enums.Role;

public class ControllerUser {
    ListUser data;

    public ControllerUser(SourceUser source) {
        data = source.getListUser();
    }

    public void addUser(int id, String nama, String email, String password, Role role) {
        ModelUser user = data.insert(new ModelUser(id, nama, email, password, role));
        if (user == null) {
            System.out.println("[ User Gagal Ditambahkan ]");
        } else {
            System.out.println("[ User Ditambahkan ]");
        }
    }

    public ModelUser idSearchUser(int id) {
        return data.idSearch(id);
    }
    
    public ModelUser emailSearchUser(String email) {
        return data.emailSearch(email);
    }
    
    public void editUser(ModelUser user, String nama, String email, String password, Role role) {
        user.setNama(nama);
        user.setEmail(email);
        user.setPassword(password);
        user.setRole(role);
    }
    
    public void deleteUser(ModelUser user) {
        data.delete(user);
    }

    public void showUser(ModelUser user){
        System.out.print(user.toString());
    }

    public void showAllUser() {
        data.printList();
   }
   
}
