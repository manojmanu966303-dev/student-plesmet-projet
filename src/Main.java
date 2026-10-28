public class Main {

    public static void main(String[] args) {

        student student = new student(
                101,
                "Manoj",
                "manoj@gmail.com",
                8.8,
                "CSE"
        );

        StudentDAO studentDAO =
                new StudentDAO();

        studentDAO.addStudent(student);
    }
}