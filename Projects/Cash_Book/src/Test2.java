
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Test2 {
    // Database connection details
    private static final String URL = "jdbc:mysql://localhost:3306/cashbook";
    private static final String USER = "root";
    private static final String PASSWORD = "7418022289";

    public static void main(String[] args) {

        String A = "S.NO";
        String B = "4";
        String Query = "SELECT * FROM history WHERE `" + A + "` = "+ B +" ;";
    
        try(Connection connect = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement st = connect.createStatement()){
            
            ResultSet RS = st.executeQuery(Query);

            while(RS.next()){
                System.out.println(RS.getString("S.NO")+RS.getString("CashType")+RS.getString("Amount")+RS.getString("Category")+RS.getString("Date"));
            }
            
        }catch(SQLException exp){
            System.out.println(exp);
        }

        
    }
}
