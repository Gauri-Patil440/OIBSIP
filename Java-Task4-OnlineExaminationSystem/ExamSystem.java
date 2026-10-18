import java.util.Scanner;

public class ExamSystem {

    private Scanner scanner;
    private Question[] questions;
    private final int timeLimitSeconds = 120;

    public ExamSystem(Scanner scanner) {
        this.scanner = scanner;

        questions = new Question[] {

            new Question(
                "Which language runs on the JVM?",
                new String[]{
                    "Python", "Java", "HTML", "CSS"
                }, 'B'
            ),

            new Question(
                "Which keyword creates an object?",
                new String[]{
                    "class", "void", "new", "static"
                }, 'C'
            ),

            new Question(
                "Which is not a primitive type in Java?",
                new String[]{
                    "int", "boolean", "char", "String"
                }, 'D'
            ),

            new Question(
                "Which loop executes at least once?",
                new String[]{
                    "for", "while", "do-while", "nested for"
                }, 'C'
            ),

            new Question(
                "Which method starts a Java program?",
                new String[]{
                    "start()", "main()", "run()", "init()"
                }, 'B'
            )
        };
    }

    public void startExam(String studentName) {

        int score = 0;
        int attempted = 0;

        long startTime = System.currentTimeMillis();
        long endTime = startTime
                + timeLimitSeconds * 1000L;

        System.out.println("\n================================");
        System.out.println("       ONLINE EXAMINATION");
        System.out.println("================================");
        System.out.println("Student: " + studentName);
        System.out.println("Total Questions: " + questions.length);
        System.out.println("Time Limit: "
                + timeLimitSeconds + " seconds");
        System.out.println("Each correct answer carries 1 mark.");
        System.out.println("Enter A, B, C or D.");

        for (int i = 0; i < questions.length; i++) {

            long remaining =
                    endTime - System.currentTimeMillis();

            if (remaining <= 0) {
                System.out.println("\nTime is over!");
                break;
            }

            System.out.println("\nTime remaining: "
                    + (remaining / 1000) + " seconds");

            questions[i].displayQuestion(i + 1);

            System.out.print("Your answer: ");
            String input = scanner.nextLine().trim();

            if (System.currentTimeMillis() >= endTime) {
                System.out.println(
                        "Time is over. Answer not counted.");
                break;
            }

            if (input.length() != 1
                    || "ABCD".indexOf(
                    input.toUpperCase().charAt(0)) == -1) {
                System.out.println(
                        "Invalid answer. No mark awarded.");
                continue;
            }

            attempted++;

            char answer =
                    Character.toUpperCase(input.charAt(0));

            if (questions[i].isCorrect(answer)) {
                System.out.println("Correct answer!");
                score++;
            } else {
                System.out.println("Incorrect answer.");
            }
        }

        showResult(studentName, score, attempted);
    }

    private void showResult(String studentName,
                            int score, int attempted) {

        System.out.println("\n================================");
        System.out.println("          EXAM RESULT");
        System.out.println("================================");

        System.out.println("Student: " + studentName);
        System.out.println("Total Questions: " + questions.length);
        System.out.println("Attempted: " + attempted);
        System.out.println("Correct Answers: " + score);

        System.out.println("Incorrect/Unanswered: "
                + (questions.length - score));

        System.out.println("Final Score: "
                + score + "/" + questions.length);

        double percentage =
                score * 100.0 / questions.length;

        System.out.printf("Percentage: %.2f%%%n",
                percentage);

        if (percentage >= 40) {
            System.out.println("Result: PASS");
        } else {
            System.out.println("Result: FAIL");
        }

        System.out.println("================================");
    }
}