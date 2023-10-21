package View;

import Controller.ShopManager;

/**
 * class chính của chương trình.
 *
 * @author Admin
 */
public class Main {

    public static void main(String[] args) {
        int choice;
        ShopManager manger = new ShopManager();
        while (true) {
            choice = Menu.display();
            switch (choice) {
                case 1:
                    manger.createProduct();
                    break;
                case 2:
                    manger.viewOrders();
                    break;
                case 3:
                    manger.shopping();
                    break;
                default:
                    return;
            }
        }
    }
}
