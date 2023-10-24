package Controller;

import java.util.Hashtable;

/**
 * Class quản lí bán hoa quả bao gồm thêm sản phẩm mới, hiển thị hoá đơn, và mua
 * hàng.
 *
 * @verison 1.0
 * @author Admin
 */
public class ShopManager {

    /**
     * danh sách hoa quả trong cửa hàng.
     */
    private final FruitList fruitList;

    /**
     * hashtable chứa tên khách hàng(key) và danh sách hoá đơn của khách
     * hàng(value).
     */
    private final Hashtable<String, OrderList> customerOrders;

    /**
     * hàm khởi tạo cho một cửa hàng mới.
     */
    public ShopManager() {
        this.fruitList = new FruitList();
        this.customerOrders = new Hashtable<>();
    }

    /**
     * thêm một sản phẩm mới vào danh sách các sản phẩm.
     * <p>
     * sau khi thêm 1 sản phẩm, hỏi xem có muốn tiếp tục hay không.
     * <p>
     * sau khi thêm hoàn tất, hiển thị ra tất cả sản phẩm có sẵn.
     */
    public void createProduct() {
        do {
            fruitList.addNewFruit();
        } while (wantToAddMoreFruit());
        fruitList.viewList();
    }

    /**
     * hiển thị hoá đơn của từng khách hàng đã mua hàng.
     * <p>
     * kiểm tra xem hoá đơn có rỗng hay không, nếu có in ra thông báo empty, nếu
     * không in ra danh sách hoá đơn của từng khách hàng.
     */
    public void viewOrders() {
        if (customerOrders.isEmpty()) {
            System.out.println("Empty list!");
        } else {
            System.out.println("-------View orders---------");
            for (String name : customerOrders.keySet()) {
                System.out.println("Customer: " + name);
                customerOrders.get(name).display();
            }
        }
    }

    /**
     * phương thức mua hàng dành cho khách hàng.
     * <p>
     * đầu tiên là tạo ra 1 giỏ hàng mới cho khách hàng.
     * <p>
     * sau đó kiểm tra xem cửa hàng có bán gì hay không, và chọn sản phẩm vào
     * giỏ hàng, sau khi thêm 1 đơn hàng vào giỏ hàng, hỏi xem có muốn thanh
     * toán hay không, nếu không, tiếp tục mua hàng.
     * <p>
     * kết thúc mua hàng, kiểm tra giỏ hàng có sản phẩm hay không, nếu có, thêm
     * hoá đơn và tên khách hàng vào bảng các đơn hàng.
     */
    public void shopping() {
        OrderList cart = new OrderList();
        if (fruitList.hasProducts()) {
            do {
                cart.addFruitFrom(fruitList);
            } while (wantToContinueBuying());
            if (cart.hasProducts()) {
                cart.display();
                addNewCustomerWithOrderList(cart);
            }
        }
    }

    /**
     * thêm một khách hàng mới và thêm hoá đơn của khách hàng đó vào hashtable.
     *
     * @param cart hoá đơn của khách hàng.
     */
    void addNewCustomerWithOrderList(OrderList cart) {
        String name = getNewCustomer();
        customerOrders.put(name, cart);
    }

    /**
     * thêm một khách hàng mới với tên không trùng lặp.
     *
     * @return trả về tên của khách hàng mới.
     */
    private String getNewCustomer() {
        String name;
        while (true) {
            name = Inputter.getNonBlankString("your name");
            if (!customerOrders.containsKey(name)) {
                return name;
            }
            System.out.println("This name already exists, please enter another name!");
        }
    }

    private boolean wantToAddMoreFruit() {
        return Inputter.askYesNo("Do you want to continue (Y/N)? ");
    }

    private boolean wantToContinueBuying() {
        return !(Inputter.askYesNo("Do you want to order now (Y/N)? "));
    }
}
