package models;

import utils.Enums;

public class ModelUser {
    private int id;
    private String nama;
    private String email;
    private String password;
    private Enums.Role role;

    public ModelUser(int id, String nama, String email, String password, Enums.Role role) {
        this.id = id;
        this.nama = nama;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    @Override
    public String toString() {
        String id = "ID       : " + this.id + "\n";
        String nm = "Name     : " + this.nama + "\n";
        String ps = "Password : " + this.password + "\n";
        String em = "Email    : " + this.email + "\n";
        String rl = "Role     : " + this.role + "\n";
        return id + nm + ps + em + rl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Enums.Role getRole() {
        return role;
    }

    public void setRole(Enums.Role role) {
        this.role = role;
    }
}
