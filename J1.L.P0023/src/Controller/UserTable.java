package Controller;

import java.util.Hashtable;

/**
 * hashtable chứa tên khách hàng(key) và danh sách hoá đơn của khách
 * hàng(value).
 *
 * @version 1.0
 * @author Admin
 */
public class UserTable extends Hashtable<String, OrderList> {

    /**
     * thêm một khách hàng mới và thêm hoá đơn của khách hàng đó vào hashtable.
     *
     * @param cart hoá đơn của khách hàng.
     */
    void addNewCustomerWithOrderList(OrderList cart) {
        String name = getNewCusTomer();
        put(name, cart);

    }

    /**
     * thêm một khách hàng mới với tên không trùng lặp.
     *
     * @return trả về tên của khách hàng mới.
     */
    private String getNewCusTomer() {
        String name;
        while (true) {
            name = Inputter.getNonBlankString("your name");
            if (!containsKey(name)) {
                return name;
            }
            System.out.println("This name already exists, please enter another name!");
        }
    }

    /**
     * hiển thị danh sách khách hàng với hoá đơn của khách hàng.
     */
    void display() {
        System.out.println("-------View orders---------");
        for (String name : keySet()) {
            System.out.println("Customer: " + name);
            get(name).display();
        }
    }

}
