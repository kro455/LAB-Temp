/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package convernumber;

/**
 *
 * @author Admin
 */
public class App {

    public static void main(String[] args) {
        MangerNumber mangerNumber=new MangerNumber();
        do {
            int choice=Menu.display();
            switch (choice) {
                case 1:
                    //input base number
                    mangerNumber.setInputNumber();
                    break;
                case 2:
                    // conver to new base and display results
                    mangerNumber.setOutputNumber();
                    break;
                default:
                    return;
            }
        } while (true);
    }
}
