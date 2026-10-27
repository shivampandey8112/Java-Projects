// Question.java
// This class stores ONE quiz question with its 4 options.
public class Question {

    private String text;
    private String[] options;   // the 4 answer options
    private int correctOption;  // correct option number (1 to 4)

    // Constructor
    public Question(String text, String[] options, int correctOption) {
        this.text = text;
        this.options = options;
        this.correctOption = correctOption;
    }

    // Show the question and its options on the screen
    public void display(int number) {
        System.out.println();
        System.out.println("Q" + number + ". " + text);
        for (int i = 0; i < options.length; i++) {
            System.out.println("   " + (i + 1) + ". " + options[i]);
        }
    }

    // Check if the answer given by the player is correct
    public boolean isCorrect(int answer) {
        return answer == correctOption;
    }

    // Get the text of the correct option (to show if the player is wrong)
    public String getCorrectText() {
        return options[correctOption - 1];
    }
}
