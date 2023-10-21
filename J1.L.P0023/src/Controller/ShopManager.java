package Controller;

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
     * bảng các đơn hàng của khách hàng.
     */
    private final UserTable userOrders;

    /**
     * hàm khởi tạo cho một cửa hàng mới.
     */
    public ShopManager() {
        this.fruitList = new FruitList();
        this.userOrders = new UserTable();
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

            //nhập và thêm 1 sản phẩm mới vào danh sách.
            fruitList.addNewFruit();

            //nếu chọn Y(Yes), tiếp tục thêm một sản phẩm mới. 
        } while (Inputter.askYesNo("Do you want to continue (Y/N)? "));

        //hiển thị ra tất cả sản phẩm có sẵn.
        fruitList.viewList();
    }

    /**
     * hiển thị hoá đơn của từng khách hàng đã mua hàng.
     * <p>
     * kiểm tra xem hoá đơn có rỗng hay không, nếu có in ra thông báo empty, nếu
     * không in ra danh sách hoá đơn của từng khách hàng.
     */
    public void viewOrders() {

        //nếu danh sách rỗng,
        if (userOrders.isEmpty()) {

            // in ra thông báo. 
            System.out.println("Empty list!");
        } else {

            //danh sách hoá đơn của từng khách hàng.
            userOrders.display();
        }
    }

    /**
     * phương thức mua hàng dành cho khách hàng.
     * <p>
     * đầu tiên là tạo ra 1 giỏ hàng mới cho khách hàng.
     *
     * <p>
     * sau đó kiểm tra xem cửa hàng có bán gì hay không, và chọn sản phẩm vào
     * giỏ hàng, sau khi thêm 1 đơn hàng vào giỏ hàng, hỏi xem có muốn thanh
     * toán hay không, nếu không, tiếp tục mua hàng.
     * <p>
     * kết thúc mua hàng, kiểm tra giỏ hàng có sản phẩm hay không, nếu có, thêm
     * hoá đơn và tên khách hàng vào bảng các đơn hàng.
     */
    public void shopping() {

        //tạo ra một giỏ hàng mới. 
        OrderList cart = new OrderList();

        //nếu cửa hàng có sản phẩm.
        if (fruitList.haveProduct()) {
            do {

                //chọn sản phẩm từ cửa hàng và thêm vào giỏ hàng. 
                cart.chooseFruitFrom(fruitList);

                //nếu người dùng chọn N(No) thì tiếp tục mua hàng.
            } while (!Inputter.askYesNo("Do you want to order now (Y/N)? "));

            //nếu giỏ hàng có sản phẩm,
            if (cart.haveProduct()) {

                //hiển thị hoá đơn. 
                cart.display();

                //thêm một khách hàng mới cùng với giỏ hàng vào bảng đơn hàng
                userOrders.addNewCustomer(cart);
            }
        }
    }
}
