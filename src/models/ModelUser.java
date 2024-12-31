package models;

import utils.Enums;

public class ModelUser {
    private int id;
    private String nama;
    private String email;
    private String pass;
    private Enums.Role role;

    public ModelUser(int id, String nama, String email, String pass, Enums.Role role) {
        this.id = id;
        this.nama = nama;
        this.email = email;
        this.pass = pass;
        this.role = role;
    }

    @Override
    public String toString() {
        String id = this.id + "\t";
        String nm = this.nama + "\t";
        String ps = this.pass + "\t";
        String em = this.email + "\t";
        String rl = this.role + "\n";
        return id + nm + ps + em + rl;
    }

    public String info() {
        String id = "ID         : " + this.id + "\n";
        String nm = "Nama       : " + this.nama + "\n";
        String ps = "Password   : " + this.pass + "\n";
        String em = "Email      : " + this.email + "\n";
        String rl = "Role       : " + this.role + "\n";
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
        return pass;
    }

    public void setPassword(String pass) {
        this.pass = pass;
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
