import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class CategoryTable extends JPanel implements ActionListener{

    private static final String URL = "jdbc:mysql://localhost:3306/cashbook";
    private static final String USER = "root";
    private static final String PASSWORD = "7418022289";
    
    JLabel DataLabel = new JLabel("CATEGORY");
    JTextField DataValue = new JTextField();
    GradientButton DataButton = new GradientButton(Color.decode("#283048"), Color.decode("#859398"));

    JPanel TablePanel = new JPanel();

    JScrollPane CashInTableScrollPanel;
    String[] CashInTableColumnName = {"S.NO","CASH IN CATEGOTY"};

    JTable CashInTable;
    List<String[]> CashInList;
    String[][] CashInData;

    JScrollPane CashOutTableScrollPanel;
    String[] CashOutTableColumnName = {"S.NO","CASH OUT CATEGOTY"};

    JTable CashOutTable;
    List<String[]> CashOutList;
    String[][] CashOutData;

    String Check = "CASH IN - ADD";


    public CategoryTable() {
        // Content Panel
        setBounds(0, 380, 1440, 505);
        setBackground(new Color(240, 240, 240));//  new Color(206, 230, 243)
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        // setVisible(false);

        // Initilizing Components
        JPanel CategoryDataPanel = new JPanel();
        

        CategoryDataPanel.setPreferredSize(new Dimension(1420, 75));
        // CategoryDataPanel.setBounds(0,0,1440, 75);
        CategoryDataPanel.setBackground(Color.decode("#0779E4"));// new Color(240, 240, 240) new Color(206 , 230, 243)
        CategoryDataPanel.setLayout(null);
        CategoryDataPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        // CategoryDataPanel.setVisible(false);


        // Data Label
        DataLabel.setFont(new Font("Roboto", Font.BOLD, 30));
        DataLabel.setBounds(250, 12, 220,50);
        DataLabel.setForeground(Color.BLACK);

        // Data Value
        DataValue.setBounds(450, 15, 500, 45);
        DataValue.setBorder(BorderFactory.createLoweredBevelBorder());
        DataValue.setFont(new Font("Roboto", Font.BOLD, 30));
        DataValue.setForeground(Color.decode("#004FF9"));

        // Data Button
        DataButton.setBounds(1000, 15, 250, 45);
        DataButton.setBorder(BorderFactory.createEmptyBorder());
        DataButton.setText("ADD");
        DataButton.setFont(new Font("Roboto", Font.BOLD, 30));
        DataButton.setForeground(new Color(240, 240, 240));
        DataButton.setFocusable(false);
        DataButton.addActionListener(this);
        

        // Adding Components in Category Data Panel
        CategoryDataPanel.add(DataLabel);
        CategoryDataPanel.add(DataValue);
        CategoryDataPanel.add(DataButton);

        TablePanel.setPreferredSize(new Dimension(1440, 415));
        TablePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        TablePanel.setBackground(Color.decode("#f2f3f4"));



        CashInList = this.AddData("incategory");
        CashInData = CashInList.toArray(new String[0][0]);
        CashInTable = new JTable(CashInData,CashInTableColumnName);
        JTableHeader Header = CashInTable.getTableHeader();
        Header.setDefaultRenderer(new TableCellRenderer() {
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

        CashInTable();

        CashInTable.setFont(new Font("Roboto", Font.BOLD, 28));
        CashInTable.setRowHeight(45);
        CashInTable.setBackground(Color.decode("#f2f3f4"));
        CashInTable.setPreferredScrollableViewportSize(new Dimension(1400, 500));
        CashInTable.getTableHeader().setReorderingAllowed(false);
        CashInTable.setEnabled(false);
        CashInTable.getTableHeader().setEnabled(false);
        


        CashInTableScrollPanel = new JScrollPane(CashInTable);

        CashInTableScrollPanel.setPreferredSize(new Dimension(700, 385));
        CashOutList = this.AddData("outcategory");
        CashOutData = CashOutList.toArray(new String[0][0]);
        CashOutTable = new JTable(CashOutData,CashOutTableColumnName);
        Header = CashOutTable.getTableHeader();
        Header.setDefaultRenderer(new TableCellRenderer() {
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

        
        CashOutTable();

        CashOutTable.setFont(new Font("Roboto", Font.BOLD, 28));
        CashOutTable.setRowHeight(45);
        CashOutTable.setBackground(Color.decode("#f2f3f4"));
        CashOutTable.setPreferredScrollableViewportSize(new Dimension(1400, 500));
        CashOutTable.getTableHeader().setReorderingAllowed(false);
        CashOutTable.setEnabled(false);
        CashOutTable.getTableHeader().setEnabled(false);
        


        CashOutTableScrollPanel = new JScrollPane(CashOutTable);

        CashOutTableScrollPanel.setPreferredSize(new Dimension(700, 385));

        
        TablePanel.add(CashInTableScrollPanel,BorderLayout.WEST);
        TablePanel.add(CashOutTableScrollPanel,BorderLayout.EAST);

        // Adding Compnents in Content Panel
        add(CategoryDataPanel,BorderLayout.NORTH);
        add(TablePanel,BorderLayout.SOUTH);

    }

    public List<String[]> AddData(String TabelName){
        List<String[]> Data = new ArrayList<>();

        String Query = "SELECT * FROM "+ TabelName +";";
        try(Connection Connect = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement St = Connect.createStatement()){

            ResultSet Rs = St.executeQuery(Query);
    
            while(Rs.next()){
                String[] Row = {Rs.getString("S.NO"),Rs.getString("category")};
                
                Data.add(Row);  
            }
            
            
        }catch(SQLException exception){
            System.err.println(exception);
        }

        return Data;
    }

    public void CashInTable(){
        TableColumn column = CashInTable.getColumnModel().getColumn(0);
        column.setPreferredWidth(150);
        column.setMaxWidth(150);

        // Create a cell renderer to center text
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        // Apply the cell renderer to each column
        for (int i = 0; i < CashInTable.getColumnCount(); i++) {
            CashInTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }

    public void CashOutTable(){
        TableColumn column = CashOutTable.getColumnModel().getColumn(0);
        column.setPreferredWidth(150);
        column.setMaxWidth(150);

        // Create a cell renderer to center text
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        // Apply the cell renderer to each column
        for (int i = 0; i < CashOutTable.getColumnCount(); i++) {
            CashOutTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == DataButton){     
            if(Check.equals("CASH IN - ADD") || Check.equals("CASH OUT - ADD")){
                String Table = "outcategory";
                if(Check.equals("CASH IN - ADD")){
                    Table = "incategory";
                }
                String Category = DataValue.getText();

                if(Category.isEmpty()){
                    new MessageBox(Check, "EMPTY CATEGORY IN ADD CATEGORY");
                }
                else{
                    String Query = "INSERT INTO "+ Table +" (category) VALUES (?);";
                    try(Connection Connect = DriverManager.getConnection(URL, USER, PASSWORD);
                        PreparedStatement Statemet = Connect.prepareCall(Query)){

                        Statemet.setString(1, Category);

                        Statemet.executeUpdate(); 

                    }catch(SQLException exception){
                        System.err.println(exception);
                    } 
                }
            }
            else if (Check.equals("CASH IN - REMOVE") || Check.equals("CASH OUT - REMOVE")) {
                try {
                    String Table = "outcategory";
                    if(Check.equals("CASH IN - REMOVE")){
                        Table = "incategory";
                    }
                    if(DataValue.getText().isEmpty()){
                        new MessageBox(Check, "EMPTY 'CATEGORY' IN REMOVE CATEGORY");
                    }
                    else{
                        int S_No = Integer.parseInt(DataValue.getText());
                        System.out.println(S_No);
                        String Query = "DELETE FROM "+ Table + " WHERE (`S.NO` = ?);";
                        try(Connection Connect = DriverManager.getConnection(URL, USER, PASSWORD);
                            PreparedStatement Statemet = Connect.prepareCall(Query)){

                            Statemet.setInt(1, S_No);
                            
                            Statemet.executeUpdate(); 

                        }catch(SQLException exception){
                            System.err.println(exception);
                        } 
                    }

                    
                }catch (NumberFormatException exception) {
                    System.out.println(exception);
                    new MessageBox(Check, "INVALID S.NO NUMBER");
                }
            }

            DataValue.setText("");
            
            CashInList = this.AddData("incategory");
            CashInData = CashInList.toArray(new String[0][0]);
            CashInTable.setModel(new DefaultTableModel(CashInData, CashInTableColumnName));

            CashInTable();

            CashOutList = this.AddData("outcategory");
            CashOutData = CashOutList.toArray(new String[0][0]);
            CashOutTable.setModel(new DefaultTableModel(CashOutData, CashOutTableColumnName));

            CashOutTable();
        }
    }

    
    
}
