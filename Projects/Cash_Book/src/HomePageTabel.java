import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;


public class HomePageTabel extends JPanel{
    private static final String URL = "jdbc:mysql://localhost:3306/cashbook";
    private static final String USER = "root";
    private static final String PASSWORD = "7418022289";

    JTable CashInTable;
    List<String[]> CashInList;
    String[][] CashInData;

    JTable CashOutTable;
    List<String[]> CashOutList;
    String[][] CashOutData;


    public HomePageTabel() {

        DataForHomeTable function = new DataForHomeTable();
        

        setBounds(30, 460, 1440, 505);
        setBackground(Color.decode("#616a6b"));//  new Color(206, 230, 243)
        setLayout(null);
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        

        JPanel HeadingPanel = new JPanel();

        JPanel TotalCashInPanel = new JPanel();
        JLabel TotalCashInTitle = new JLabel("INCOME");
        JLabel TotalCashInValue = new JLabel(String.valueOf(function.Income));
        
        JPanel TotalCashOutPanel = new JPanel();
        JLabel TotalCashOutTitle = new JLabel("EXPENSE");
        JLabel TotalCashOutValue = new JLabel(String.valueOf(function.Expense));

        JPanel BalancePanel = new JPanel();
        JLabel BalanceTitle = new JLabel("BALANCE");
        JLabel BalanceValue = new JLabel(String.valueOf(function.Balance));


        JPanel CashInTableHeadingPanel = new JPanel();
        JLabel CashInTableHeading = new JLabel("CASH IN");
        JPanel CashInTableBasePanel = new JPanel();

        String[] CashInColumnName = {"INCOME","CATEGORY","DATE"};
        
        CashInList = this.CashInAddData();

        CashInData = CashInList.toArray(new String[0][0]);

        CashInTable = new JTable(CashInData,CashInColumnName);

        JTableHeader CashInHeader = CashInTable.getTableHeader();
        CashInHeader.setDefaultRenderer(new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JLabel label = new JLabel(value.toString());
                label.setFont(new Font("Roboto", Font.BOLD, 30)); // Set your desired font
                label.setForeground(Color.decode("#ecf0f1")); // Set your desired font color
                label.setHorizontalAlignment(SwingConstants.CENTER); // Center align the header text
                label.setBackground(Color.decode("#2e86c1")); // Set your desired background color
                label.setOpaque(true); // Necessary for background color to display
                label.setBorder(BorderFactory.createRaisedBevelBorder());
                return label;
            }
        });

        // Create a cell renderer to center text
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        // Apply the cell renderer to each column
        for (int i = 0; i < CashInTable.getColumnCount(); i++) {
            CashInTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        JScrollPane CashInTableScrollPanel = new JScrollPane(CashInTable);

        JPanel CashOutTabelHeadingPanel = new JPanel();
        JLabel CashOutTableHeading = new JLabel("CASH OUT");
        JPanel CashOutTableBasePanel = new JPanel();

        String[] CashOutColumnName = {"EXPENSE","CATEGORY","DATE"};

        CashOutList = this.CashOutAddData();

        CashOutData = CashOutList.toArray(new String[0][0]);

        CashOutTable = new JTable(CashOutData,CashOutColumnName);
        
        JTableHeader CashOutHeader = CashOutTable.getTableHeader();
        CashOutHeader.setDefaultRenderer(new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JLabel label = new JLabel(value.toString());
                label.setFont(new Font("Roboto", Font.BOLD, 30)); // Set your desired font
                label.setForeground(Color.decode("#ecf0f1")); // Set your desired font color
                label.setHorizontalAlignment(SwingConstants.CENTER); // Center align the header text
                label.setBackground(Color.decode("#2e86c1")); // Set your desired background color
                label.setOpaque(true); // Necessary for background color to display
                label.setBorder(BorderFactory.createRaisedBevelBorder());
                return label;
            }
        });

        // Apply the cell renderer to each column
        for (int i = 0; i < CashOutTable.getColumnCount(); i++) {
            CashOutTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        JScrollPane CashOutTableScrollPanel = new JScrollPane(CashOutTable);

        
        

        

        // Defining Heading Panel
        HeadingPanel.setBounds(0,0,1440, 76);
        HeadingPanel.setBackground(Color.decode("#0065C4"));// new Color(240, 240, 240) new Color(206 , 230, 243)0065C4 #0779E4
        HeadingPanel.setLayout(null);
        HeadingPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));

        TotalCashInPanel.setBounds(0, 0, 455, 76);
        TotalCashInPanel.setBackground(Color.decode("#007CF1"));//  new Color(206, 230, 243)
        TotalCashInPanel.setLayout(null);
        TotalCashInPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));

        // TotalCashInTitle
        TotalCashInTitle.setFont(new Font("Roboto", Font.BOLD, 30));
        TotalCashInTitle.setBounds(40, 13, 220,50);
        TotalCashInTitle.setForeground(Color.BLACK);

        // TotalCashInValue
        TotalCashInValue.setFont(new Font("Roboto", Font.BOLD, 30));
        TotalCashInValue.setBounds(190, 13, 220,50);
        TotalCashInValue.setForeground(Color.decode("#17A589"));
        TotalCashInValue.setOpaque(true);
        TotalCashInValue.setBackground(Color.decode("#E5E7E9"));
        TotalCashInValue.setBorder(BorderFactory.createRaisedBevelBorder());
        TotalCashInValue.setHorizontalAlignment(0);

        TotalCashInPanel.add(TotalCashInTitle);
        TotalCashInPanel.add(TotalCashInValue);

        TotalCashOutPanel.setBounds(492, 0, 455, 76);
        TotalCashOutPanel.setBackground(Color.decode("#007CF1"));//  new Color(206, 230, 243)
        TotalCashOutPanel.setLayout(null);
        TotalCashOutPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));

        // TotalCashOutTitle
        TotalCashOutTitle.setFont(new Font("Roboto", Font.BOLD, 30));
        TotalCashOutTitle.setBounds(30, 13, 220,50);
        TotalCashOutTitle.setForeground(Color.BLACK);

        // TotalCashOutValue
        TotalCashOutValue.setFont(new Font("Roboto", Font.BOLD, 30));
        TotalCashOutValue.setBounds(200, 13, 220,50);
        TotalCashOutValue.setForeground(Color.decode("#CB4335"));
        TotalCashOutValue.setOpaque(true);
        TotalCashOutValue.setBackground(Color.decode("#E5E7E9"));
        TotalCashOutValue.setBorder(BorderFactory.createRaisedBevelBorder());
        TotalCashOutValue.setHorizontalAlignment(0);

        TotalCashOutPanel.add(TotalCashOutTitle);
        TotalCashOutPanel.add(TotalCashOutValue);

        BalancePanel.setBounds(985, 0, 455, 76);
        BalancePanel.setBackground(Color.decode("#007CF1"));//  new Color(206, 230, 243)
        BalancePanel.setLayout(null);
        BalancePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));

        // BalanceTitle
        BalanceTitle.setFont(new Font("Roboto", Font.BOLD, 30));
        BalanceTitle.setBounds(25, 13, 220,50);
        BalanceTitle.setForeground(Color.BLACK);

        // BalanceValue
        BalanceValue.setFont(new Font("Roboto", Font.BOLD, 30));
        BalanceValue.setBounds(200, 13, 220,50);
        BalanceValue.setForeground(Color.decode("#0779E4"));
        BalanceValue.setOpaque(true);
        BalanceValue.setBackground(Color.decode("#E5E7E9"));
        BalanceValue.setBorder(BorderFactory.createRaisedBevelBorder());
        BalanceValue.setHorizontalAlignment(0);

        BalancePanel.add(BalanceTitle);
        BalancePanel.add(BalanceValue);


        HeadingPanel.add(TotalCashInPanel);
        HeadingPanel.add(TotalCashOutPanel);
        HeadingPanel.add(BalancePanel);


        // CashInTableHeadingPanel
        CashInTableHeadingPanel.setBounds(20,93,690, 60);
        CashInTableHeadingPanel.setBackground(Color.decode("#a6acaf"));
        CashInTableHeadingPanel.setLayout(null);
        CashInTableHeadingPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));

        CashInTableHeading.setFont(new Font("Roboto", Font.BOLD, 37));
        CashInTableHeading.setForeground(Color.BLACK);
        CashInTableHeading.setBounds(255, 12, 200, 38);

        CashInTableHeadingPanel.add(CashInTableHeading);

        CashInTableBasePanel.setBounds(21,154,688, 342);
        CashInTableBasePanel.setBackground(Color.decode("#a6acaf"));

        CashInTableScrollPanel.setPreferredSize(new Dimension(675,330));
        CashInTableScrollPanel.setBorder(BorderFactory.createEmptyBorder());
        
        CashInTable.setFont(new Font("Roboto", Font.BOLD, 28));
        CashInTable.setRowHeight(45);
        CashInTable.setBackground(Color.decode("#f2f3f4"));
        CashInTable.setPreferredScrollableViewportSize(new Dimension(300,200));
        CashInTable.getTableHeader().setReorderingAllowed(false);
        CashInTable.setEnabled(false);
        CashInTable.getTableHeader().setEnabled(false);


        CashInTableBasePanel.add(CashInTableScrollPanel);

        
        // CashOutTabelHeadingPanel
        CashOutTabelHeadingPanel.setBounds(730,93,690, 60);
        CashOutTabelHeadingPanel.setBackground(Color.decode("#a6acaf"));
        CashOutTabelHeadingPanel.setLayout(null);
        CashOutTabelHeadingPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));

        CashOutTableHeading.setFont(new Font("Roboto", Font.BOLD, 37));
        CashOutTableHeading.setForeground(Color.BLACK);
        CashOutTableHeading.setBounds(240, 12, 200, 38);

        CashOutTabelHeadingPanel.add(CashOutTableHeading);

        
        CashOutTableBasePanel.setBounds(731,154,688, 342);
        CashOutTableBasePanel.setBackground(Color.decode("#a6acaf"));

        CashOutTableScrollPanel.setPreferredSize(new Dimension(675,330));
        CashOutTableScrollPanel.setBorder(BorderFactory.createEmptyBorder());

        CashOutTable.setFont(new Font("Roboto", Font.BOLD, 28));
        CashOutTable.setRowHeight(45);
        CashOutTable.setBackground(Color.decode("#f2f3f4"));
        CashOutTable.setPreferredScrollableViewportSize(new Dimension(300,200));
        CashOutTable.getTableHeader().setReorderingAllowed(false);
        CashOutTable.setEnabled(false);
        CashOutTable.getTableHeader().setEnabled(false);

        CashOutTableBasePanel.add(CashOutTableScrollPanel);
        




        // Adding defined components to the ContentPanel
        // add(Cash_In);
        // add(Cash_Out);
        // add(History);
        add(HeadingPanel);

        add(CashInTableHeadingPanel);
        add(CashOutTabelHeadingPanel);
        add(CashInTableBasePanel);
        add(CashOutTableBasePanel);

    }

    public List<String[]> CashInAddData(){
        List<String[]> Data = new ArrayList<>();

        String Query = "SELECT Income,InCategory,Date FROM cashin;";
        try(Connection Connect = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement St = Connect.createStatement()){

            ResultSet Rs = St.executeQuery(Query);
    
            while(Rs.next()){
                String[] Row = {Rs.getString("Income"),Rs.getString("InCategory"),Rs.getString("Date")};
                
                Data.add(Row);  
            }
            
            
        }catch(SQLException exception){
            System.err.println(exception);
        }

        return Data;
    }

    public List<String[]> CashOutAddData(){
        List<String[]> Data = new ArrayList<>();

        String Query = "SELECT Expense,OutCategory,Date FROM cashout;";
        try(Connection Connect = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement St = Connect.createStatement()){

            ResultSet Rs = St.executeQuery(Query);
    
            while(Rs.next()){
                String[] Row = {Rs.getString("Expense"),Rs.getString("OutCategory"),Rs.getString("Date")};
                
                Data.add(Row);  
            }
            
            
        }catch(SQLException exception){
            System.err.println(exception);
        }

        return Data;
    }

 
}
