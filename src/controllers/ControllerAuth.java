package controllers;

import databases.sources.SourceUser;
import models.ModelUser;
import utils.Enums.Role;

public class ControllerAuth {
    ControllerUser data = new ControllerUser(new SourceUser());
    
    public ModelUser cekLogin(String email, String pass){
        ModelUser user = data.data.emailSearch(email);
        if (user == null) {
            System.out.println("\n[ Username atau password salah ]");
            return null;
        } else if (user.getPassword().equals(pass)) {
            System.out.println("\n[ Login Berhasil ]");
            return user;
        } else {
            System.out.println("\n[ Username atau password salah ]");
            return null;
        }
    }
    
    public ModelUser register(String nama, String email, String pass, Role role){
        ModelUser user = data.data.insert(new ModelUser(0, nama, email, pass, role));
        
        if (user != null) {
            System.out.println("\n[ User Ditambahkan ]");
        }
        return user;
    }
}
