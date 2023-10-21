package Controller;

import Model.Fruit;
import Model.Order;
import java.util.ArrayList;

/**
 * danh sách chứa các thông tin đặt hàng.
 *
 * @version 1.0
 * @author Admin
 */
class OrderList extends ArrayList<Order> {

    /**
     * phương thức chọn một sản phầm từ danh sách sản phẩm trong cửa hàng vào
     * giỏ hàng.
     *
     * @param fruitList danh sách sản phẩm để lựa chọn.
     */
    void chooseFruitFrom(FruitList fruitList) {
        System.out.println("--------Shopping-----------");

        //chọn 1 sản phẩm từ danh sách.
        Fruit selectedFruit = fruitList.getFruitBySelect();

        //nếu sản phầm còn hàng. 
        if (selectedFruit.stocking()) {
            
            //chọn số lượng sản phẩm muốn mua.
            int quantity = chooseQuantityFrom(selectedFruit);

            //thêm sản phẩm và số lượng vào danh sách đặt hàng.
            addNewOrder(selectedFruit, quantity);

            //giảm số lượng của sản phẩm đã chọn trong cửa hàng.
            selectedFruit.downQuantity(quantity);
        }
    }

    /**
     * cập nhật lại số lượng nếu sản phảm đã có sẵn trong danh sách đơn hàng,
     * ngược lại, thêm một sản phẩm mới vào danh sách.
     *
     * @param fruit sản phẩm được chọn.
     * @param quantity số lượng mua hàng từ fruit.
     */
    private void addNewOrder(Fruit fruit, int quantity) {

        //nếu số lượng > 0 thì cập nhật sản phẩm vào giỏ hàng. 
        if (quantity > 0) {

            //kiểm tra xem giỏ hàng đã có sẵn sản phẩm đó hay chưa. 
            Order order = getOrderById(fruit.getId());
            if (order != null) {

                //nếu đã có sản phẩm trong giỏ hàng, chỉ cần cập nhật lại số lượng.
                order.upQuantity(quantity);
            } else {

                //ngược lại, thêm một sản phẩm mới vào giỏ hàng cùng với số lượng đã chọn. 
                add(new Order(fruit.getId(), fruit.getName(), quantity, fruit.getPrice()));
            }
        }
    }

    /**
     * chọn số lượng từ [0, số lượng có sẵn] của sản phẩm trong cửa hàng.
     *
     * @param fruit sản phẩm được chọn.
     */
    private int chooseQuantityFrom(Fruit fruit) {
        return Inputter.getInt("Please input quantity: ", 0, fruit.getQuantity());
    }

    /**
     * lấy một hoá đơn bằng Id.
     *
     * @param id tìm với
     * @return trả về một hoá đơn bằng id. trả về null nếu không tìm thấy.
     */
    Order getOrderById(String id) {
        for (Order order : this) {
            if (order.getId().equals(id)) {
                return order;
            }
        }
        return null;
    }

    /**
     * hiển thị danh sách hoá đơn và tổng giá tiền.
     */
    void display() {
        System.out.println("   Product  | Quantity | Price | Amount");
        int count = 0;
        int sum = 0;
        for (Order order : this) {
            System.out.println(++count + ". " + order);
            sum += order.getAmount();
        }
        System.out.println("Total: " + sum + "$\n");
    }

    /**
     * kiểm tra xem danh sách có rỗng hay không, nếu rỗng in ra thông báo.
     *
     * @return trả về false và in ra thông báo nếu rỗng.
     */
    boolean haveProduct() {
        if (isEmpty()) {
            System.out.println("You do not buy anything yet!");
            return false;
        }
        return true;
    }
}
