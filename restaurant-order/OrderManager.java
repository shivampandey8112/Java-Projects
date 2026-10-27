// OrderManager.java
// This class manages the menu, the current order and the placed orders.
import java.util.ArrayList;

public class OrderManager {

    private ArrayList<MenuItem> menu = new ArrayList<>();           // all menu items
    private ArrayList<OrderItem> currentOrder = new ArrayList<>();  // items in the current order
    private ArrayList<String> placedOrders = new ArrayList<>();     // summary of placed orders

    // Constructor - adds 6 items to the menu
    public OrderManager() {
        menu.add(new MenuItem("Paneer Butter Masala", 220));
        menu.add(new MenuItem("Veg Biryani", 180));
        menu.add(new MenuItem("Butter Naan", 40));
        menu.add(new MenuItem("Masala Dosa", 120));
        menu.add(new MenuItem("Cold Coffee", 90));
        menu.add(new MenuItem("Gulab Jamun", 60));
    }

    public int getMenuSize() {
        return menu.size();
    }

    // Show the menu
    public void showMenu() {
        System.out.println("---------------- MENU ----------------");
        for (int i = 0; i < menu.size(); i++) {
            System.out.printf("%d. %-22s Rs. %d%n", i + 1, menu.get(i).getName(), menu.get(i).getPrice());
        }
    }

    // Add a menu item to the current order
    public void addToOrder(int menuNumber, int quantity) {
        MenuItem chosen = menu.get(menuNumber - 1);

        // If the item is already in the order, just increase the quantity
        for (OrderItem o : currentOrder) {
            if (o.getItem().getName().equals(chosen.getName())) {
                o.addQuantity(quantity);
                System.out.println("Quantity updated.");
                return;
            }
        }
        currentOrder.add(new OrderItem(chosen, quantity));
        System.out.println(chosen.getName() + " added to your order.");
    }

    // Calculate the total bill of the current order
    public int getTotal() {
        int total = 0;
        for (OrderItem o : currentOrder) {
            total = total + o.getTotal();
        }
        return total;
    }

    // Show the current order and the total
    public void showCurrentOrder() {
        if (currentOrder.isEmpty()) {
            System.out.println("Your order is empty.");
            return;
        }
        System.out.println("-------------- YOUR ORDER --------------");
        for (OrderItem o : currentOrder) {
            System.out.printf("%-22s x %-3d Rs. %d%n", o.getItem().getName(), o.getQuantity(), o.getTotal());
        }
        System.out.println("Total bill: Rs. " + getTotal());
    }

    // Place the order. Returns false if the order is empty.
    public boolean placeOrder(String customerName) {
        if (currentOrder.isEmpty()) {
            return false;
        }
        String summary = "Order #" + (placedOrders.size() + 1) + " - " + customerName
                + " - " + currentOrder.size() + " item(s) - Rs. " + getTotal();
        placedOrders.add(summary);
        currentOrder.clear(); // start a fresh order
        return true;
    }

    // Show all placed orders
    public void showPlacedOrders() {
        if (placedOrders.isEmpty()) {
            System.out.println("No orders placed yet.");
            return;
        }
        System.out.println("------------ PLACED ORDERS ------------");
        for (String s : placedOrders) {
            System.out.println(s);
        }
    }
}
