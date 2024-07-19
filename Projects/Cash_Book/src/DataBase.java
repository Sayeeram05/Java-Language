import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBase {
    
    // Database connection details
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/cashbook";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "7418022289";

    public static void main(String[] args) {
        if (isValidUser("Admin", "Admin@123")) {
            System.out.println("Login successful.");
        } else {
            System.out.println("Login failed.");
        }
    }

    public static boolean isValidUser(String UserName,String password){

        String query = "SELECT * FROM login WHERE username = ? AND password = ?";

        try(Connection con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            PreparedStatement statement = con.prepareStatement(query)){

                statement.setString(1, UserName);
                statement.setString(2, password);

                ResultSet result = statement.executeQuery();

                // System.out.println(result.next());

                return result.next();
        }catch(SQLException exp){
            System.out.println(exp);
            return false;
        }
    }
}
