import java.awt.BorderLayout;
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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class HistoryPanel extends JPanel{

    private static final String URL = "jdbc:mysql://localhost:3306/cashbook";
    private static final String USER = "root";
    private static final String PASSWORD = "7418022289";

    JTable HistoryTable;
    List<String[]> HistoryList;
    String[][] HistoryData;
    
    public HistoryPanel() {

        // Defining Cash In
        setBounds(30, 460, 1440, 505);
        setBackground(Color.decode("#979a9a"));//  new Color(206 , 230, 243) 
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        setVisible(false);

        JPanel ButtonPanel = new JPanel();

        String[] Headings = {""};
        JComboBox TabelHeading = new JComboBox<>();

        ButtonPanel.setPreferredSize(new Dimension(1420, 66));
        ButtonPanel.setBackground(Color.decode("#0779E4"));
        ButtonPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));


        String[] HistoryTableColumnName = {"S.NO","CASH TYPE","AMOUNT","CATEGORY","DATE"};
        HistoryList = this.HistoryAddData();
        HistoryData = HistoryList.toArray(new String[0][0]);
        HistoryTable = new JTable(HistoryData,HistoryTableColumnName);
        JTableHeader HistoryHeader = HistoryTable.getTableHeader();
        HistoryHeader.setDefaultRenderer(new TableCellRenderer() {
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
        TableColumn column = HistoryTable.getColumnModel().getColumn(0);
        column.setPreferredWidth(100);
        column.setMaxWidth(100);

        // Create a cell renderer to center text
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        // Apply the cell renderer to each column
        for (int i = 0; i < HistoryTable.getColumnCount(); i++) {
            HistoryTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        JScrollPane HistoryTableScrollPanel = new JScrollPane(HistoryTable);


        HistoryTable.setFont(new Font("Roboto", Font.BOLD, 28));
        HistoryTable.setRowHeight(45);
        HistoryTable.setBackground(Color.decode("#f2f3f4"));
        HistoryTable.setPreferredScrollableViewportSize(new Dimension(1400, 500));
        HistoryTable.getTableHeader().setReorderingAllowed(false);
        HistoryTable.setEnabled(false);

        HistoryTableScrollPanel.setPreferredSize(new Dimension(1420, 413));
        HistoryTableScrollPanel.setBorder(BorderFactory.createEmptyBorder());
        
        add(ButtonPanel,BorderLayout.NORTH);
        add(HistoryTableScrollPanel,BorderLayout.SOUTH);
        
    }


    public List<String[]> HistoryAddData(){
        List<String[]> Data = new ArrayList<>();

        String Query = "SELECT * FROM history;";
        try(Connection Connect = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement St = Connect.createStatement()){

            ResultSet Rs = St.executeQuery(Query);
    
            while(Rs.next()){
                String[] Row = {Rs.getString("S.NO"),Rs.getString("CashType"),Rs.getString("Amount"),Rs.getString("Category"),Rs.getString("Date")};
                
                Data.add(Row);  
            }
            
            
        }catch(SQLException exception){
            System.err.println(exception);
        }

        return Data;
    }


}
