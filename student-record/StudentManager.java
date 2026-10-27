// StudentManager.java
// This class manages the list of students (add, show, search, delete).
import java.util.ArrayList;

public class StudentManager {

    // ArrayList to store all Student objects
    private ArrayList<Student> students = new ArrayList<>();

    // Add a student. Returns false if the roll number already exists.
    public boolean addStudent(Student newStudent) {
        for (Student s : students) {
            if (s.getRoll() == newStudent.getRoll()) {
                return false; // duplicate roll number
            }
        }
        students.add(newStudent);
        return true;
    }

    // Print the table heading
    private void printHeading() {
        System.out.printf("%-8s %-20s %-10s %-8s %-6s%n", "Roll", "Name", "Course", "Marks", "Result");
        System.out.println("----------------------------------------------------------");
    }

    // Show all students
    public void showAll() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        printHeading();
        for (Student s : students) {
            s.display();
        }
    }

    // Search students by name (works with part of the name too)
    public void searchByName(String text) {
        boolean found = false;
        for (Student s : students) {
            if (s.getName().toLowerCase().contains(text.toLowerCase())) {
                if (!found) {
                    printHeading(); // print heading only once
                }
                s.display();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No student found with that name.");
        }
    }

    // Delete a student using the roll number. Returns true if deleted.
    public boolean deleteStudent(int roll) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getRoll() == roll) {
                students.remove(i);
                return true;
            }
        }
        return false;
    }
}
