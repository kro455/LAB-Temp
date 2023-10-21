package Controller;

import java.util.Hashtable;

/**
 * bảng chứa tên khách hàng và danh sách hoá đơn của khách hàng.
 *
 * @version 1.0
 * @author Admin
 */
public class UserTable extends Hashtable<String, OrderList> {

    /**
     * hiển thị danh sách khách hàng với hoá đơn của khách hàng.
     */
    void display() {
        System.out.println("-------View orders---------");
        for (String key : keySet()) {
            System.out.println("Customer: " + key);
            get(key).display();
        }
    }

    /**
     * thêm một khách hàng mới và thêm hoá đơn của khách hàng đó vào danh sách.
     *
     * @param cart hoá đơn của khách hàng.
     */
    void addNewCustomer(OrderList cart) {
        String name;
        do {
            //nhập tên khách hàng.
            name = Inputter.getNonBlankString("your name");
            //nếu tên đã tồn tại, yêu cầu nhập một tên khác.
            if (containsKey(name)) {
                System.out.println("This name already exists, please enter another name!");
            } else {
                //thêm tên khách hàng cùng với đơn hàng vào danh sách.
                put(name, cart);
                break;
            }
        } while (true);
    }

}
