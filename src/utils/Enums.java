package utils;

public class Enums {
    public enum StatusTransaksi {
        PENDING,
        ONGOING,
        DONE,
        CANCELED
    }
    
    public static enum StatusBarang {
        AVAILABLE,
        RECOVERY,
        UNAVAILABLE
    }
    
    public static enum Role {
        ADMIN,
        CUSTOMER
    }
}
