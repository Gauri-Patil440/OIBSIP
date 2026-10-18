public class Student {

    private String username;
    private String password;
    private String studentName;

    public Student(String username, String password,
                   String studentName) {
        this.username = username;
        this.password = password;
        this.studentName = studentName;
    }

    public boolean login(String enteredUsername,
                         String enteredPassword) {
        return username.equals(enteredUsername)
                && password.equals(enteredPassword);
    }

    public String getStudentName() {
        return studentName;
    }
}