public class User {
    private int id;
    private String nama;
    private String password;
    private String email;
    private String role;

    public User(int id, String nama, String password, String email, String role) {
        this.id = id;
        this.nama = nama;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public int getId() {
        return id;
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
}
