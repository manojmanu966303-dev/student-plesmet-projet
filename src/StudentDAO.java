import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class StudentDAO {

    public void addStudent(student student) {

        String sql =
                "INSERT INTO students " +
                "(id, name, email, cgpa, branch) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (
            Connection connection =
                    DBConnection.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(sql)
        ) {

            statement.setInt(1, student.getId());
            statement.setString(2, student.getName());
            statement.setString(3, student.getEmail());
            statement.setDouble(4, student.getCgpa());
            statement.setString(5, student.getBranch());

            int rows =
                    statement.executeUpdate();

            if (rows > 0) {
                System.out.println(
                        "Student added successfully!"
                );
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public student login(String email, String password) {

        String sql =
                "SELECT * FROM students WHERE email = ? AND password = ?";

        try (
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)
        ) {

            statement.setString(1, email);
            statement.setString(2, password);

            try (ResultSet result = statement.executeQuery()) {

                if (result.next()) {
                    // Construct student from result set
                    return new student(
                            result.getInt("id"),
                            result.getString("name"),
                            result.getString("email"),
                            result.getDouble("cgpa"),
                            result.getString("branch")
                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
