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

public class DeleteTable extends JPanel implements ActionListener{

    private static final String URL = "jdbc:mysql://localhost:3306/cashbook";
    private static final String USER = "root";
    private static final String PASSWORD = "7418022289";
    

    JLabel DataLabel = new JLabel("SERIAL NO");
    JTextField DataValue = new JTextField();
    GradientButton DataButton = new GradientButton(Color.decode("#283048"), Color.decode("#859398"));

    JScrollPane TableScrollPanel;
    String[] TableColumnName = {"S.NO","AMOUNT","CATEGORY","DATE","REMARK"};

    JTable Table;
    List<String[]> List;
    String[][] Data;

    String TableName = "";

    public DeleteTable(String Tableinput) {
        this.TableName = Tableinput;

        if(TableName.equals("history")){
            TableColumnName[1] = "CASH TYPE";
            TableColumnName[2] = "AMOUNT";
            TableColumnName[3] = "CATEGORY";
            TableColumnName[4] = "DATE";
        }

        setBounds(0, 380, 1440, 510);
        setBackground(Color.decode("#616a6b"));//  new Color(206, 230, 243)
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));


        // Initilizing Components
        JPanel CategoryDataPanel = new JPanel();
    

        CategoryDataPanel.setPreferredSize(new Dimension(1420, 75));
        // CategoryDataPanel.setBounds(0,0,1440, 75);
        CategoryDataPanel.setBackground(Color.decode("#0779E4"));// new Color(240, 240, 240) new Color(206 , 230, 243)
        CategoryDataPanel.setLayout(null);
        CategoryDataPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));


        // Data Label
        DataLabel.setFont(new Font("Roboto", Font.BOLD, 30));
        DataLabel.setBounds(340, 12, 220,50);
        DataLabel.setForeground(Color.BLACK);

        // Data Value
        DataValue.setBounds(525, 15, 300, 45);
        DataValue.setBorder(BorderFactory.createLoweredBevelBorder());
        DataValue.setFont(new Font("Roboto", Font.BOLD, 30));
        DataValue.setForeground(Color.decode("#004FF9"));

        // Data Button
        DataButton.setBounds(900, 15, 280, 45);
        DataButton.setBorder(BorderFactory.createEmptyBorder());
        DataButton.setText("DELETE");
        DataButton.setFont(new Font("Roboto", Font.BOLD, 30));
        DataButton.setForeground(new Color(240, 240, 240));
        DataButton.setFocusable(false);
        DataButton.addActionListener(this);
        

        // Adding Components in Category Data Panel
        CategoryDataPanel.add(DataLabel);
        CategoryDataPanel.add(DataValue);
        CategoryDataPanel.add(DataButton);



        List = this.AddData(this.TableName);
        Data = List.toArray(new String[0][0]);
        Table = new JTable(Data,TableColumnName);
        JTableHeader Header = Table.getTableHeader();
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

        CentreRow();

        Table.setFont(new Font("Roboto", Font.BOLD, 28));
        Table.setRowHeight(45);
        Table.setBackground(Color.decode("#f2f3f4"));
        Table.setPreferredScrollableViewportSize(new Dimension(1400, 510));
        Table.getTableHeader().setReorderingAllowed(false);
        Table.setEnabled(false);
        Table.getTableHeader().setEnabled(false);
        

        TableScrollPanel = new JScrollPane(Table);

        TableScrollPanel.setPreferredSize(new Dimension(1420,410));
        TableScrollPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));


        // Adding Compnents in Content Panel
        add(CategoryDataPanel,BorderLayout.NORTH);
        add(TableScrollPanel,BorderLayout.SOUTH);

    }

    public List<String[]> AddData(String TabelName){
        List<String[]> Data = new ArrayList<>();

        String Query = "SELECT * FROM "+ TabelName +";";
        try(Connection Connect = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement St = Connect.createStatement()){

            ResultSet Rs = St.executeQuery(Query);

            if(TabelName.equals("cashin")){
                while(Rs.next()){
                    String[] Row = {Rs.getString("S.NO"),Rs.getString("Income"),Rs.getString("InCategory"),Rs.getString("Date"),Rs.getString("Remark")};
                    
                    Data.add(Row);  
                }    
            }
            else if(TabelName.equals("cashout")){
                while(Rs.next()){
                    String[] Row = {Rs.getString("S.NO"),Rs.getString("Expense"),Rs.getString("OutCategory"),Rs.getString("Date"),Rs.getString("Remark")};
                    Data.add(Row);  
                }
            }
            else if(TabelName.equals("history")){
                while(Rs.next()){
                    String[] Row = {Rs.getString("S.NO"),Rs.getString("CashType"),Rs.getString("Amount"),Rs.getString("Category"),Rs.getString("Date")};
                    Data.add(Row);  
                }
            }
    
        }catch(SQLException exception){
            System.err.println(exception);
        }

        return Data;
    }


    public void CentreRow(){
        TableColumn column = Table.getColumnModel().getColumn(0);
        column.setPreferredWidth(150);
        column.setMaxWidth(150);

        // Create a cell renderer to center text
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        // Apply the cell renderer to each column
        for (int i = 0; i < Table.getColumnCount(); i++) {
            Table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == DataButton){ 
            String SerialNumString = DataValue.getText();
            String temp = TableName.toUpperCase();
            if(SerialNumString.isEmpty()){
                if(temp.equals("CASHIN")){
                    temp = "CASH IN";
                }
                else if(temp.equals("CASHOUT")){
                    temp = "CASH OUT";
                }
                
                new MessageBox(temp, "EMPTY CATEGORY IN ADD CATEGORY");
            }

            else{
                int SNO = -1;
                try {
                    SNO = Integer.parseInt(SerialNumString);
                } catch (NumberFormatException exception) {
                    System.out.println(exception);
                    new MessageBox(temp, "INVALID SERIAL NUMBER");
                }
                String Query = "DELETE FROM "+ TableName + " WHERE (`S.NO` = ?);";
                try(Connection Connect = DriverManager.getConnection(URL, USER, PASSWORD);
                    PreparedStatement Statemet = Connect.prepareCall(Query)){

                    Statemet.setInt(1, SNO);
                    
                    Statemet.executeUpdate(); 

                    System.out.println("Sucess"+SNO);


                    List = this.AddData(this.TableName);
                    Data = List.toArray(new String[0][0]);
                    Table.setModel(new DefaultTableModel(Data,TableColumnName));

                    CentreRow();

                }catch(SQLException exception){
                    System.err.println(exception);
                }
             
            }

            DataValue.setText("");
        }
    }
}
