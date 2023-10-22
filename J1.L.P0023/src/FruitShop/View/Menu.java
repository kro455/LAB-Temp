package View;

import Controller.Inputter;

/**
 * class menu
 *
 * @author Admin
 */
public class Menu {

    /**
     * hiển thị ra menu và trả về lựa chọn
     *
     * @return trả về lựa chọn trong menu từ 1 -> 4
     */
    public static int display() {
        System.out.println("|---------FRUIT SHOP SYSTEM----------|");
        System.out.println("|1. Create Fruit                     |");
        System.out.println("|2. View orders                      |");
        System.out.println("|3. Shopping (for buyer)             |");
        System.out.println("|4. Exit                             |");
        System.out.println("|------------------------------------|");
        return Inputter.getInt("your choice", 1, 4);
    }

    /**
     * xoá hàm khởi tạo mặc định.
     */
    private Menu() {
    }
}
