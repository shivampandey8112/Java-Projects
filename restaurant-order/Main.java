// Main.java
// This is the starting point of the restaurant program.
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    // Read a whole number from the user (keeps asking until the input is valid)
    static int readInt(String message) {
        while (true) {
            System.out.print(message);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number only.");
            }
        }
    }

    public static void main(String[] args) {
        OrderManager manager = new OrderManager();
        int choice;

        System.out.println("=== Restaurant Order Management System ===");

        do {
            System.out.println();
            System.out.println("1. View Menu");
            System.out.println("2. Add Item to Order");
            System.out.println("3. View Current Order");
            System.out.println("4. Place Order");
            System.out.println("5. View Placed Orders");
            System.out.println("6. Exit");
            choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    manager.showMenu();
                    break;

                case 2:
                    manager.showMenu();
                    int number = readInt("Enter item number: ");
                    if (number < 1 || number > manager.getMenuSize()) {
                        System.out.println("Invalid item number.");
                        break;
                    }
                    int quantity = readInt("Enter quantity: ");
                    if (quantity < 1) {
                        System.out.println("Quantity must be at least 1.");
                        break;
                    }
                    manager.addToOrder(number, quantity);
                    break;

                case 3:
                    manager.showCurrentOrder();
                    break;

                case 4:
                    System.out.print("Enter customer name: ");
                    String customer = sc.nextLine().trim();
                    if (customer.isEmpty()) {
                        System.out.println("Customer name cannot be empty.");
                    } else if (manager.placeOrder(customer)) {
                        System.out.println("Order placed successfully!");
                    } else {
                        System.out.println("Please add at least one item first.");
                    }
                    break;

                case 5:
                    manager.showPlacedOrders();
                    break;

                case 6:
                    System.out.println("Thank you! Goodbye.");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter 1 to 6.");
            }
        } while (choice != 6);
    }
}
