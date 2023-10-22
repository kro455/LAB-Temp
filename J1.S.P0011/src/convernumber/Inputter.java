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
public class Inputter {

    private static final Scanner SC = new Scanner(System.in);

    public static int getInt(String msg, int min, int max) {
        int data = 0;
        do {
            try {
                System.out.print(msg + "[" + min + ", " + max + "]: ");
                data = Integer.parseInt(SC.nextLine());
                if (data < min || data > max) {
                    System.out.println("enter only within range[" + min + ", " + max + "]");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid format!");
            }
        } while (data < min || data > max);
        return data;
    }

    public static String getValue(String msg, int base) {
        String data;
        do {
            System.out.print(msg);
            data = SC.nextLine().toUpperCase();
            if (Number.checkBaseNumber(data, base)) {
                break;
            }
            System.out.println("Invalid base " + base + " format!");
        } while (true);
        return data;
    }

    public static void askEnter() {
        System.out.print("Pess Enter to continue....");
        SC.nextLine();
    }

    private Inputter() {
    }
}
