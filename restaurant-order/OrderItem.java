// OrderItem.java
// This class stores ONE line of an order: a menu item and its quantity.
public class OrderItem {

    private MenuItem item;
    private int quantity;

    public OrderItem(MenuItem item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public MenuItem getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    // Used when the same item is added again
    public void addQuantity(int extra) {
        quantity = quantity + extra;
    }

    // Price x quantity
    public int getTotal() {
        return item.getPrice() * quantity;
    }
}
