package ConverNumber;

/**
 *
 * @author Admin
 */
public class App {

    public static void main(String[] args) {
        ConvertNumber convert = new ConvertNumber();
        do {
            int choice = Menu.display();
            switch (choice) {
                case 1:
                    // input base number
                    convert.setInputNumber();
                    break;
                case 2:
                    // conver to new base and display results
                    convert.setOutputNumber();
                    break;
                default:
                    return;
            }
        } while (true);
    }
}
