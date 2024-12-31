package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import utils.Enums.Role;
import utils.Enums.StatusBarang;
import utils.Enums.StatusTransaksi;

public class Input {
    public static final BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public static String readLine() {
        try {
            return input.readLine();
        } catch (IOException e) {
            return null;
        }
    }

    public static int readInt() {
        try {
            return Integer.parseInt(input.readLine());
        } catch (IOException | NumberFormatException e) {
            System.out.println("\n[ Input Salah ]");
            return -1;
        }
    }

    public static double readDouble() {
        try {
            return Double.parseDouble(input.readLine());
        } catch (IOException | NumberFormatException e) {
            System.out.println("\n[ Input Salah ]");
            return -1;
        }
    }

    public static void closeInput() {
        try {
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Enums.Role setRole() {
        String role = readLine();

        switch(role) {
            case "ADMIN" : return Role.ADMIN;
            case "CUSTOMER" : return Role.CUSTOMER;
            default : setRole();
        }

        return null;
    }

    public static Enums.StatusBarang setStatusBarang() {
        String statusBarang = readLine();

        switch(statusBarang) {
            case "AVAILABLE" : return StatusBarang.AVAILABLE;
            case "RECOVERY" : return StatusBarang.RECOVERY;
            case "UNAVAILABLE" : return StatusBarang.UNAVAILABLE;
            default : setStatusBarang();
        }

        return null;
    }

    public static Enums.StatusTransaksi setStatusTransaksi() {
        String statusTransaksi = readLine();

        switch(statusTransaksi) {
            case "PENDING" : return StatusTransaksi.PENDING;
            case "ONGOING" : return StatusTransaksi.ONGOING;
            case "DONE" : return StatusTransaksi.DONE;
            case "CANCELED" : return StatusTransaksi.CANCELED;
            default : setStatusBarang();
        }

        return null;
    }

    public static void cls() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void pressEnter() {
        System.out.println("\n==============================");
        System.out.print("\nPress ENTER to Continue");
        try {
            utils.Input.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
