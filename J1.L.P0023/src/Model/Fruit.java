package Model;

/**
 * Class chứa thuộc tính của hoa quả
 *
 * @author Admin
 */
public class Fruit {

    private String id;
    private String name;
    private int price;
    private int quantity;
    private String origin;

    public Fruit(String id, String name, int price, int quantity, String origin) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.origin = origin;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * giảm số lượng của sản phẩm.
     * 
     * @param quantity số lượng cần được giảm.
     */
    public void downQuantity(int quantity) {
        this.quantity -= quantity;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    /**
     * kiểm tra xem sản phẩm còn hàng trong kho hay không.
     *
     * @return trả về false và in ra thông báo nếu hết hàng.
     */
    public boolean stocking() {
        if (quantity == 0) {
            System.out.println("Run out of Stock!");
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("   %-7s%-11s%-10s%-13d%s", id, name, price + "$", quantity, origin);
    }

}
