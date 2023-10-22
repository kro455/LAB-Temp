package Model;

/**
 * class chứa thuộc tính của đơn hàng.
 *
 * @author Admin
 */
public class Order {

    private String id;
    private String name;
    private int quantity;
    private int price;

    public Order(String id, String name, int quantity, int price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getAmount() {
        return quantity * price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * cập nhật thêm số lượng.
     *
     * @param quantity số lượng cần thêm vào.
     */
    public void upQuantity(int quantity) {
        this.quantity += quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%-11s%-11s%-8s%d$", name, quantity, price + "$", getAmount());
    }
}
