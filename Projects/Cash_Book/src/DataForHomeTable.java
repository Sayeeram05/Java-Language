import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataForHomeTable {

    private static final String URL = "jdbc:mysql://localhost:3306/cashbook";
    private static final String USER = "root";
    private static final String PASSWORD = "7418022289";

    int Income = 0,Expense = 0,Balance = 0;

    DataForHomeTable(){
        
        String Query = "SELECT Income FROM cashin;";
        try(Connection Connect = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement St = Connect.createStatement()){

            ResultSet Rs = St.executeQuery(Query);
    
            while(Rs.next()){
                int temp = Rs.getInt("Income");
                Income += temp;  
            }  
        }catch(SQLException exception){
            System.err.println(exception);
        }

        Query = "SELECT Expense FROM cashout;";
        try(Connection Connect = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement St = Connect.createStatement()){

            ResultSet Rs = St.executeQuery(Query);
    
            while(Rs.next()){
                int temp = Rs.getInt("Expense");
                Expense += temp;  
            }
        }catch(SQLException exception){
            System.err.println(exception);
        }

        Balance = Income - Expense;

        // System.out.println(Income);
        // System.out.println(Expense);
        // System.out.println(Balance);
        
        
    } 
    
}
