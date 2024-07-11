import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBase {
    
    // Database connection details
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/cashbook";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "741802229";

    public static void main(String[] args) {
        if (isValidUser("Admin", "Admin@123")) {
            System.out.println("Login successful.");
        } else {
            System.out.println("Login failed.");
        }
    }

    public static boolean isValidUser(String username, String password) {
        String query = "SELECT * FROM login WHERE username = ? AND password = ?";
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
             
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet.next();
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }
}
