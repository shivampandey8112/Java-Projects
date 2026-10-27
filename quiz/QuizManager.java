// QuizManager.java
// This class keeps all the questions and runs the quiz.
import java.util.ArrayList;
import java.util.Scanner;

public class QuizManager {

    // ArrayList to store all the questions
    private ArrayList<Question> questions = new ArrayList<>();

    // Constructor - adds the 5 questions when the manager is created
    public QuizManager() {
        questions.add(new Question("What is the capital of India?",
                new String[]{"Mumbai", "New Delhi", "Kolkata", "Chennai"}, 2));
        questions.add(new Question("Which language is used to style web pages?",
                new String[]{"HTML", "Java", "CSS", "Python"}, 3));
        questions.add(new Question("How many days are there in a leap year?",
                new String[]{"365", "364", "366", "360"}, 3));
        questions.add(new Question("Which planet is known as the Red Planet?",
                new String[]{"Venus", "Mars", "Jupiter", "Saturn"}, 2));
        questions.add(new Question("What does CPU stand for?",
                new String[]{"Central Processing Unit", "Computer Personal Unit",
                             "Central Program Utility", "Control Process Unit"}, 1));
    }

    public int getTotalQuestions() {
        return questions.size();
    }

    // Ask all the questions one by one and return the score
    public int startQuiz(Scanner sc) {
        int score = 0;

        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            q.display(i + 1);

            // Keep asking until the player enters a number from 1 to 4
            int answer = 0;
            while (answer < 1 || answer > 4) {
                System.out.print("Your answer (1-4): ");
                try {
                    answer = Integer.parseInt(sc.nextLine().trim());
                } catch (NumberFormatException e) {
                    answer = 0;
                }
                if (answer < 1 || answer > 4) {
                    System.out.println("Please enter a number from 1 to 4.");
                }
            }

            if (q.isCorrect(answer)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong. The correct answer is: " + q.getCorrectText());
            }
        }
        return score;
    }

    // Give a grade message based on the score
    public String getGrade(int score) {
        if (score == questions.size()) {
            return "Excellent!";
        } else if (score >= 3) {
            return "Good job!";
        } else {
            return "Keep practising.";
        }
    }
}
