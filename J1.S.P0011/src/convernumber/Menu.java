/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package convernumber;

/**
 *
 * @author Admin
 */
public class Menu {

    public static int display() {
        System.out.println("|-----Convert number program----|");
        System.out.println("|1. Input Base number to Convert|");
        System.out.println("|2. Convert number to other base|");
        System.out.println("|3. Exit                        |");
        System.out.println("|-------------------------------|");
        return Inputter.getInt("Enter your choice: ", 1, 3);
    }

    private Menu() {
    }
}
