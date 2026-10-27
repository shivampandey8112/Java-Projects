// Main.java
// This is the starting point of the program. It shows the menu.

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
        StudentManager manager = new StudentManager();
        int choice;

        System.out.println("=== Student Record Management System ===");

        do {
            System.out.println();
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by Name");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    int roll = readInt("Enter roll number: ");
                    System.out.print("Enter name: ");
                    String name = sc.nextLine().trim();
                    System.out.print("Enter course: ");
                    String course = sc.nextLine().trim();
                    int marks = readInt("Enter marks (0-100): ");

                    // Simple validation
                    if (name.isEmpty() || course.isEmpty()) {
                        System.out.println("Name and course cannot be empty.");
                    } else if (marks < 0 || marks > 100) {
                        System.out.println("Marks must be between 0 and 100.");
                    } else if (manager.addStudent(new Student(roll, name, course, marks))) {
                        System.out.println("Student added successfully.");
                    } else {
                        System.out.println("This roll number already exists.");
                    }
                    break;

                case 2:
                    manager.showAll();
                    break;

                case 3:
                    System.out.print("Enter name to search: ");
                    manager.searchByName(sc.nextLine().trim());
                    break;

                case 4:
                    int deleteRoll = readInt("Enter roll number to delete: ");
                    if (manager.deleteStudent(deleteRoll)) {
                        System.out.println("Student deleted.");
                    } else {
                        System.out.println("Roll number not found.");
                    }
                    break;

                case 5:
                    System.out.println("Thank you! Goodbye.");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter 1 to 5.");
            }
        } while (choice != 5);
    }
}
