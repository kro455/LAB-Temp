/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package convernumber;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Input {

    private static final Scanner sc = new Scanner(System.in);

    public static int getInt(String msg, int min, int max) {
        int data = 0;
        do {
            try {
                System.out.print(msg + "[" + min + ", " + max + "]: ");
                data = Integer.parseInt(sc.nextLine());
                if (data < min || data > max) {
                    System.out.println("enter only within range[" + min + ", " + max + "]");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid format!");
            }
        } while (data < min || data > max);
        return data;
    }

    public static String getValue(String msg, int k) {
        String data;
        do {
            System.out.print(msg);
            data = sc.nextLine().toUpperCase();
            if (Number.isBase(data, k)) {
                break;
            }
            System.out.println("Invalid base " + k + " format!");
        } while (true);
        return data;
    }

    public static void askEnter() {
        System.out.print("Pess Enter to continue....");
        sc.nextLine();
    }
}
