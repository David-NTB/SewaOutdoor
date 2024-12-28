import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
        } catch (IOException e) {
            System.out.println("[ Input Salah ]");
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

    public static void cls() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void pressEnter() {
        System.out.print("\nPress ENTER to Continue");
        try {
            utils.Input.cls();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
