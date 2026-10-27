// Main.java
// This is the starting point of the quiz program.
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QuizManager quiz = new QuizManager();

        System.out.println("=== Online Quiz Management System ===");
        System.out.print("Enter your name: ");
        String name = sc.nextLine().trim();

        String again;
        do {
            int score = quiz.startQuiz(sc);

            System.out.println();
            System.out.println("-------- RESULT --------");
            System.out.println("Player : " + name);
            System.out.println("Score  : " + score + " out of " + quiz.getTotalQuestions());
            System.out.println("Grade  : " + quiz.getGrade(score));

            System.out.print("\nDo you want to play again? (yes/no): ");
            again = sc.nextLine().trim();
        } while (again.equalsIgnoreCase("yes"));

        System.out.println("Thank you for playing, " + name + "!");
    }
}
