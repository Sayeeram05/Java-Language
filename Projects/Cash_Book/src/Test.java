import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test {

    private static final String URL = "jdbc:mysql://localhost:3306/cashbook";
    private static final String USER = "root";
    private static final String PASSWORD = "7418022289";


    public static void AddDataInCashIn(){
        int InAmount = 1000;
        String InCategory = "Income 1";
        String Date = "2024-07-23" ;
        String Remark =  "Test";
        String Query = "INSERT INTO cashin (Income, InCategory, Date, Remark) VALUES (?,?,?,?);";
        try(Connection Connect = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement Statemet = Connect.prepareCall(Query)){

                Statemet.setInt(1, InAmount);
                Statemet.setString(2, InCategory);
                Statemet.setString(3, Date);
                Statemet.setString(4, Remark);

            int Row = Statemet.executeUpdate();
            System.out.println(Row);
            
        }catch(SQLException exception){
            System.err.println(exception);
        }
    } 
    public static void main(String[] args) {
        AddDataInCashIn();
    }
    
}
