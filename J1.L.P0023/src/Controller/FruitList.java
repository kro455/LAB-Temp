package Controller;

import Model.Fruit;
import java.util.ArrayList;

/**
 * FruitList là danh sách chứa các đơn hàng hoa quả trong cửa hàng.
 *
 * @version 1.0
 * @author Admin
 */
public class FruitList extends ArrayList<Fruit> {

    /**
     * khởi tạo danh sách mới và thêm 1 vài sản phẩm vào danh sách.
     */
    public FruitList() {
        add(new Fruit("01", "Apple", 5, 5, "china"));
        add(new Fruit("02", "Banana", 2, 7, "merica"));
        add(new Fruit("03", "Orange", 1, 15, "japan"));
        add(new Fruit("04", "Lemon", 3, 30, "vietnam"));
    }

    /**
     * thêm một sản phẩm mới từ bàn phím với id không trùng lặp.
     */
    void addNewFruit() {
        System.out.println("-------Create Product-------");
        String id = getNewID();
        String name = Inputter.getNonBlankString("Fruit Name");
        int price = Inputter.getInt("Enter Price: ", 0);
        int quantity = Inputter.getInt("Enter Quantity: ", 0);
        String origin = Inputter.getNonBlankString("Origin");
        add(new Fruit(id, name, price, quantity, origin));
    }

    /**
     * kiểm tra xem cửa hàng có bán gì hay không, nếu không, in ra thông báo.
     *
     * @return trả về false và in ra thông báo nếu không bán gì cả.
     */
    boolean haveProduct() {
        if (isEmpty()) {
            System.out.println("Cửa hàng này chưa bán gì cả!");
            return false;
        }
        return true;
    }

    /**
     * phương thức hiển thị danh sách dành cho khách hàng.
     */
    void viewShoppingList() {
        System.out.println("| ++ Item ++ | ++ Fruit Name ++ | ++ Origin ++ | ++ Price ++ |");
        int count = 0;
        for (Fruit x : this) {
            System.out.printf("     %-13d%-19s%-15s%s$\n",
                    ++count, x.getName(), x.getOrigin(), x.getPrice());
        }
    }

    /**
     * phương thức hiển thị các sản phẩm hiện đang có trong cửa hàng.
     */
    void viewList() {
        System.out.println("Here the list of all fruits has been created.");
        System.out.println("   id     name       price     quantity     origin");
        for (Fruit x : this) {
            System.out.println(x);
        }
    }

    /**
     * phương thức chọn một sản phẩm từ danh sách các sản phẩm bằng chọn theo số
     * thứ tự của sản phẩm dành cho khách hàng.
     *
     * @return trả về một sản phẩm mà khách hàng đã chọn. trả về null nếu list
     * rỗng.
     */
    Fruit getFruitBySelect() {
        if (!isEmpty()) {
            viewShoppingList();
            int choice = Inputter.getInt("Enter your choice: ", 1, size());
            Fruit selectedFruit = get(choice - 1);
            System.out.println("You selected: " + selectedFruit.getName());
            return selectedFruit;
        }
        return null;
    }

    /**
     * lấy thông tin sản phẩm bằng id của sản phẩm.
     *
     * @param id là id của sản phẩm cần tìm.
     * @return trả về sản phẩm trùng với id, trả về null nếu không tồn tại sản
     * phẩm nào có id cần tìm.
     */
    Fruit getFruitById(String id) {
        for (Fruit fruit : this) {
            if (fruit.getId().equals(id)) {
                return fruit;
            }
        }
        return null;
    }

    /**
     * lấy một id mới từ bàn phím, yêu cầu nhập lại id khác nếu id đã có sẵn
     * trong danh sách.
     *
     * @return trả về một id mới không trùng lặp.
     */
    private String getNewID() {
        String id;
        do {
            id = Inputter.getNonBlankString("Fruit Id");
            if (getFruitById(id) != null) {
                System.out.println("This ID already exists, please enter another name!");
            } else {
                return id;
            }
        } while (true);
    }
}
