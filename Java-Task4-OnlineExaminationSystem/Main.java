import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Student student = new Student(
                "gauri",
                "gauri123",
                "Gauri Patil"
        );

        System.out.println("================================");
        System.out.println(" ONLINE EXAMINATION SYSTEM");
        System.out.println("================================");

        int attempts = 0;
        boolean loggedIn = false;

        while (attempts < 3) {

            System.out.print("Enter username: ");
            String username = scanner.nextLine().trim();

            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            if (student.login(username, password)) {
                loggedIn = true;
                break;
            }

            attempts++;

            System.out.println("Invalid login. Attempts left: "
                    + (3 - attempts));
        }

        if (loggedIn) {

            System.out.println("\nLogin successful!");
            System.out.println("Welcome, "
                    + student.getStudentName());

            ExamSystem exam = new ExamSystem(scanner);

            exam.startExam(student.getStudentName());

            System.out.println("\nLogout successful.");

        } else {

            System.out.println(
                    "Maximum login attempts reached.");
            System.out.println("Access denied.");
        }

        scanner.close();
    }
}