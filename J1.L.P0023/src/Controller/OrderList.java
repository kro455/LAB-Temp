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
    void addFruitFrom(FruitList fruitList) {
        System.out.println("--------Shopping-----------");
        Fruit selectedFruit = fruitList.getFruitBySelect();
        if (selectedFruit.isInStock()) {
            int quantity = chooseQuantityFrom(selectedFruit);
            updateOrder(selectedFruit, quantity);
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
    private void updateOrder(Fruit fruit, int quantity) {
        if (quantity > 0) {
            Order order = getOrderById(fruit.getId());
            if (order != null) {
                order.upQuantity(quantity);
            } else {
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
     * kiểm tra xem danh sách có rỗng hay không, nếu rỗng in ra thông báo.
     *
     * @return trả về false và in ra thông báo nếu rỗng.
     */
    boolean hasProducts() {
        if (isEmpty()) {
            System.out.println("You do not buy anything yet!");
            return false;
        }
        return true;
    }

    /**
     * hiển thị danh sách hoá đơn và tổng giá tiền.
     */
    void display() {
        System.out.println("   Product  | Quantity | Price | Amount");
        int count = 0;
        for (Order order : this) {
            System.out.println(++count + ". " + order);
        }
        System.out.println("Total: " + getTotal() + "$\n");
    }

    /**
     * tính tổng tiền các sản phẩm đặt hàng.
     *
     * @return tổng số tiền cần thanh toán.
     */
    private int getTotal() {
        int sum = 0;
        for (Order o : this) {
            sum += o.getAmount();
        }
        return sum;
    }
}
