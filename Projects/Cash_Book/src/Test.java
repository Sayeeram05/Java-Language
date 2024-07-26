import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Test {

    private static final String URL = "jdbc:mysql://localhost:3306/cashbook";
    private static final String USER = "root";
    private static final String PASSWORD = "7418022289";


    public static void AddDataInCashIn(){
        List<String[]> Data = new ArrayList<>();

        String Query = "SELECT Income,InCategory,Date FROM cashin;";
        try(Connection Connect = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement St = Connect.createStatement()){

            ResultSet Rs = St.executeQuery(Query);
    
            while(Rs.next()){
                String[] Row = {Rs.getString("Income"),Rs.getString("InCategory"),Rs.getString("Date")};
                
                Data.add(Row);

                
            }
            for(String[] Rows : Data){
                for(String Row : Rows)
                System.out.println(Row);
            }
            
        }catch(SQLException exception){
            System.err.println(exception);
        }
    } 
    public static void main(String[] args) {
        AddDataInCashIn();
        
    }
    
}
