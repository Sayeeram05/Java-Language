import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class HistoryPanel extends JPanel implements ActionListener{

    private static final String URL = "jdbc:mysql://localhost:3306/cashbook";
    private static final String USER = "root";
    private static final String PASSWORD = "7418022289";

    JTable HistoryTable;
    List<String[]> HistoryList;
    String[][] HistoryData;

    String[] Headings = {"S.NO","CashType","Amount","Category","Date"};
    JComboBox<String> TabelHeading = new JComboBox<>(Headings);
    JTextField Value;
    GradientButton SearchButton;

    JScrollPane HistoryTableScrollPanel;
    String[] HistoryTableColumnName = {"S.NO","CASH TYPE","AMOUNT","CATEGORY","DATE"};
    
    public HistoryPanel() {

        // Defining Cash In
        setBounds(30, 460, 1440, 505);
        setBackground(Color.decode("#979a9a"));//  new Color(206 , 230, 243) 
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        setVisible(false);

        JPanel ButtonPanel = new JPanel();
        JLabel HeadingLabel = new JLabel("SEARCH BY");
        JLabel ValueLabel = new JLabel("Value");
        Value = new JTextField();
        SearchButton = new GradientButton(Color.decode("#283048"), Color.decode("#859398"));


        ButtonPanel.setPreferredSize(new Dimension(1420, 66));
        ButtonPanel.setBackground(Color.decode("#0779E4"));
        ButtonPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        ButtonPanel.setLayout(null);


        HeadingLabel.setFont(new Font("Roboto", Font.BOLD, 30));
        HeadingLabel.setBounds(50, 7, 220,50);
        HeadingLabel.setForeground(Color.BLACK);

        // Tabel Heading
        TabelHeading.setBounds(240, 10, 300, 45);
        TabelHeading.setBorder(BorderFactory.createLoweredBevelBorder());
        TabelHeading.setFont(new Font("Roboto", Font.BOLD, 28));
        TabelHeading.setForeground(Color.BLUE);
        TabelHeading.setBackground(Color.WHITE);
        TabelHeading.setFocusable(false); 

        ValueLabel.setFont(new Font("Roboto", Font.BOLD, 30));
        ValueLabel.setBounds(600, 7, 220,50);
        ValueLabel.setForeground(Color.BLACK);

        // Value
        Value.setBounds(695, 10, 300, 45);
        Value.setBorder(BorderFactory.createLoweredBevelBorder());
        Value.setFont(new Font("Roboto", Font.BOLD, 30));
        Value.setForeground(Color.decode("#004FF9"));

        // Category Button
        SearchButton.setBounds(1110, 10, 250, 45);
        SearchButton.setBorder(BorderFactory.createEmptyBorder());
        SearchButton.setText("Search");
        SearchButton.setFont(new Font("Roboto", Font.BOLD, 30));
        SearchButton.setForeground(new Color(240, 240, 240));
        SearchButton.setFocusable(false);
        SearchButton.addActionListener(this);


        ButtonPanel.add(HeadingLabel);
        ButtonPanel.add(TabelHeading);
        ButtonPanel.add(ValueLabel);
        ButtonPanel.add(Value);
        ButtonPanel.add(SearchButton);


        
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
        
        ApplyHistoryTable();

        HistoryTableScrollPanel = new JScrollPane(HistoryTable);

        HistoryTableScrollPanel.setPreferredSize(new Dimension(1420, 413));
        HistoryTableScrollPanel.setBorder(BorderFactory.createEmptyBorder());
        
        add(ButtonPanel,BorderLayout.NORTH);
        add(HistoryTableScrollPanel,BorderLayout.SOUTH);
        
    }

    //--------------------------------------------A C T I O N L I S T E N E R-------------------------------------------//
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == SearchButton){
            String SortBy = (String)TabelHeading.getSelectedItem();
            String ValueText = Value.getText();

            if(ValueText.isEmpty()){
                new MessageBox("Search", "Invalid Or Empty Searh Value");
            }
            else{
                // Fetch new data based on the search criteria
                HistoryList = fetchFilteredData(SortBy, ValueText);
                HistoryData = HistoryList.toArray(new String[0][0]);

                // Update the table model with the new data
                HistoryTable.setModel(new DefaultTableModel( // modify the table data (like searching, filtering, or editing)
                    HistoryData,
                    HistoryTableColumnName
                ));
                // HistoryTable = new JTable(
                //     HistoryData,
                //     HistoryTableColumnName
                // );

                ApplyHistoryTable();
            }

            TabelHeading.setSelectedIndex(0);
            Value.setText("");
        }

    }

    public void ApplyHistoryTable(){
        TableColumn column = HistoryTable.getColumnModel().getColumn(0);
        column.setPreferredWidth(200);
        column.setMaxWidth(200);

        // Create a cell renderer to center text
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        // Apply the cell renderer to each column
        for (int i = 0; i < HistoryTable.getColumnCount(); i++) {
            HistoryTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }


        HistoryTable.setFont(new Font("Roboto", Font.BOLD, 28));
        HistoryTable.setRowHeight(45);
        HistoryTable.setBackground(Color.decode("#f2f3f4"));
        HistoryTable.setPreferredScrollableViewportSize(new Dimension(1400, 500));
        HistoryTable.getTableHeader().setReorderingAllowed(false);
        HistoryTable.setEnabled(false);
        HistoryTable.getTableHeader().setEnabled(false);
    }

    public List<String[]> fetchFilteredData(String column, String value) {
        List<String[]> data = new ArrayList<>();
        String query = "SELECT * FROM history WHERE `" + column + "` = '" + value + "';";
        
        try (Connection connect = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement st = connect.createStatement()) {
    
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                String[] row = {
                    rs.getString("S.NO"),
                    rs.getString("CashType"),
                    rs.getString("Amount"),
                    rs.getString("Category"),
                    rs.getString("Date")
                };
                data.add(row);
            }
        } catch (SQLException exception) {
            System.err.println(exception);
        }

        return data;
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
