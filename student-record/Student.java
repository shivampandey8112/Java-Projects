// Student.java
// This class stores the details of ONE student (an "entity" class).
public class Student {

    // Private variables - they can only be used inside this class
    private int roll;
    private String name;
    private String course;
    private int marks;

    // Constructor - runs when we create a new Student object
    public Student(int roll, String name, String course, int marks) {
        this.roll = roll;
        this.name = name;
        this.course = course;
        this.marks = marks;
    }

    // Getter methods - used to read the private variables
    public int getRoll() {
        return roll;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public int getMarks() {
        return marks;
    }

    // A student passes if marks are 40 or more
    public String getResult() {
        if (marks >= 40) {
            return "Pass";
        } else {
            return "Fail";
        }
    }

    // Print the student's details in one line
    public void display() {
        System.out.printf("%-8d %-20s %-10s %-8d %-6s%n", roll, name, course, marks, getResult());
    }
}
