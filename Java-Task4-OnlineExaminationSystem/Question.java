public class Question {

    private String questionText;
    private String[] options;
    private char correctAnswer;

    public Question(String questionText, String[] options,
                    char correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer =
                Character.toUpperCase(correctAnswer);
    }

    public void displayQuestion(int number) {
        System.out.println("\nQ" + number + ". "
                + questionText);

        for (int i = 0; i < options.length; i++) {
            System.out.println((char) ('A' + i)
                    + ". " + options[i]);
        }
    }

    public boolean isCorrect(char answer) {
        return Character.toUpperCase(answer)
                == correctAnswer;
    }
}