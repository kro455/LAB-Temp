package Login;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Ebank ebank = new Ebank();
        int choice = getChoice();
        switch (choice) {
            case 1:
                ebank.setLocale(new Locale("vi"));
                break;
            case 2:
                ebank.setLocale(Locale.US);
                break;
            default:
                return;
        }
        ebank.login();
    }

    static int getChoice() {
        System.out.println("-------Login Program-------");
        System.out.println("1. Vietnamese");
        System.out.println("2. English");
        System.out.println("3. Exit");
        return inputInt("Please choice one option: ", 1, 3);
    }

    static int inputInt(String msg, int min, int max) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.print(msg);
                int result = Integer.parseInt(sc.nextLine());
                if ((result < min) || (result > max)) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.out.println("pls enter in ranger[" + min + ", " + max + "]");
            }
        }
    }
}