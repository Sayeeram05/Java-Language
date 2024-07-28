import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class CashOutPanel extends JPanel implements ActionListener{

    //-----------------------------------------------G L O B A L----------------------------------------------//

    private static final String URL = "jdbc:mysql://localhost:3306/cashbook";
    private static final String USER = "root";
    private static final String PASSWORD = "7418022289";

    GradientButton SaveButton = new GradientButton(Color.decode("#004FF9"), Color.decode("#56CCF2"));
    GradientButton CategoryButton = new GradientButton(Color.decode("#283048"), Color.decode("#859398"));

    JPanel HeadingPanel = new JPanel();

    JTextField OutAmountValue = new JTextField();
    LocalDate Today = LocalDate.now();
    JLabel TodaysDateValue = new JLabel(Today.toString());
    JTextField RemarkValue = new JTextField();

    JComboBox<String> OutCategoryValue = new JComboBox<>();

    JLabel OutAmountHeadingValue ;
    JLabel BalanceHeadingValue;

    public CashOutPanel() {

        DataForHomeTable function = new DataForHomeTable();

        // Defining Cash In
        setBounds(30, 460, 1440, 505);
        setBackground(new Color(240, 240, 240));//  new Color(206 , 230, 243) 
        setLayout(null);
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        setVisible(false);

        // Save Button
        SaveButton.setBounds(1155, 430, 250, 45);
        SaveButton.setBorder(BorderFactory.createEmptyBorder());
        SaveButton.setText("SAVE");
        SaveButton.setFont(new Font("Roboto", Font.BOLD, 30));
        SaveButton.setForeground(new Color(240, 240, 240));
        SaveButton.setFocusable(false);
        SaveButton.addActionListener(this);

        // Category Button
        CategoryButton.setBounds(855, 430, 250, 45);
        CategoryButton.setBorder(BorderFactory.createEmptyBorder());
        CategoryButton.setText("CATEGORY");
        CategoryButton.setFont(new Font("Roboto", Font.BOLD, 30));
        CategoryButton.setForeground(new Color(240, 240, 240));
        CategoryButton.setFocusable(false);
        CategoryButton.addActionListener(this);


        //----------------------------------------------H E A D I N G P A N E L---------------------------------------------//

        // Initilize components used in Heading Panel
        JLabel OutAmountHeading = new JLabel("EXPENSE - ");
        OutAmountHeadingValue = new JLabel(String.valueOf(function.Expense));
        JLabel BalanceHeading = new JLabel("BALANCE - ");
        BalanceHeadingValue = new JLabel(String.valueOf(function.Balance));


        // Defining Heading Panel
        HeadingPanel.setBounds(0,0,1440, 75);
        HeadingPanel.setBackground(Color.decode("#0779E4"));// new Color(240, 240, 240) new Color(206 , 230, 243)
        HeadingPanel.setLayout(null);
        HeadingPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));

        // In Amount Heading
        OutAmountHeading.setFont(new Font("Roboto", Font.BOLD, 30));
        OutAmountHeading.setBounds(366, 10, 220,50);
        OutAmountHeading.setForeground(Color.BLACK);

        // In Amount Heading Value
        OutAmountHeadingValue.setFont(new Font("Roboto", Font.BOLD, 30));
        OutAmountHeadingValue.setBounds(540, 10, 220,50);
        OutAmountHeadingValue.setForeground(new Color(240, 240, 240));

        // Balance Heading
        BalanceHeading.setFont(new Font("Roboto", Font.BOLD, 30));
        BalanceHeading.setBounds(760, 10, 220,50);
        BalanceHeading.setForeground(Color.BLACK);

        // Balance Heading Value
        BalanceHeadingValue.setFont(new Font("Roboto", Font.BOLD, 30));
        BalanceHeadingValue.setBounds(940, 10, 220,50);
        BalanceHeadingValue.setForeground(new Color(240, 240, 240));
    

        // Adding Elements In The Heading Panel
        HeadingPanel.add(OutAmountHeading);
        HeadingPanel.add(OutAmountHeadingValue);
        HeadingPanel.add(BalanceHeading);
        HeadingPanel.add(BalanceHeadingValue);

        //----------------------------------------------D E T A I L S---------------------------------------------//

        JLabel OutAmountLabel = new JLabel("CASH OUT"); 
        JLabel OutCategoryLabel = new JLabel("OUT CATEGORY");
        JLabel TodaysDateLabel = new JLabel("TODAY");
        JLabel RemarkLabel = new JLabel("Remark");
        


        // In Amount Label
        OutAmountLabel.setFont(new Font("Roboto", Font.BOLD, 30)); 
        OutAmountLabel.setForeground(Color.BLACK);
        OutAmountLabel.setBounds(150, 120, 200, 30); 

        // In Amount Value
        OutAmountValue.setBounds(150, 150, 450, 45);
        OutAmountValue.setBorder(BorderFactory.createLoweredBevelBorder());
        OutAmountValue.setFont(new Font("Roboto", Font.BOLD, 30));
        OutAmountValue.setForeground(Color.decode("#004FF9"));

        // In Category Label
        OutCategoryLabel.setFont(new Font("Roboto", Font.BOLD, 30)); 
        OutCategoryLabel.setForeground(Color.BLACK);
        OutCategoryLabel.setBounds(800, 120, 250, 30); 

        // In Category Value
        OutCategoryValue.setBounds(800, 150, 450, 45);
        OutCategoryValue.setBorder(BorderFactory.createLoweredBevelBorder());
        OutCategoryValue.setFont(new Font("Roboto", Font.BOLD, 30));
        OutCategoryValue.setForeground(Color.BLUE);
        OutCategoryValue.setBackground(Color.WHITE);
        OutCategoryValue.setFocusable(false); 
        CashOutCombobox();


        // Today's Date Label
        TodaysDateLabel.setFont(new Font("Roboto", Font.BOLD, 30)); 
        TodaysDateLabel.setForeground(Color.BLACK);
        TodaysDateLabel.setBounds(150, 230, 250, 30); 

        // Today's Date Value
        TodaysDateValue.setBounds(150, 260, 450, 45);
        TodaysDateValue.setBorder(BorderFactory.createLoweredBevelBorder());
        TodaysDateValue.setFont(new Font("Roboto", Font.BOLD, 30));
        TodaysDateValue.setForeground(Color.decode("#004FF9"));
        TodaysDateValue.setOpaque(true);
        TodaysDateValue.setBackground(Color.WHITE);

        // Remark Label
        RemarkLabel.setFont(new Font("Roboto", Font.BOLD, 30)); 
        RemarkLabel.setForeground(Color.BLACK);
        RemarkLabel.setBounds(800, 230, 250, 30); 

        // Remark Value
        RemarkValue.setBounds(800, 260, 450, 45);
        RemarkValue.setBorder(BorderFactory.createLoweredBevelBorder());
        RemarkValue.setFont(new Font("Roboto", Font.BOLD, 30));
        RemarkValue.setForeground(Color.decode("#004FF9"));

        


        // Adding Elemets In The Panel
        add(SaveButton);
        add(CategoryButton);
        add(HeadingPanel);
        add(OutAmountLabel);
        add(OutAmountValue);
        add(OutCategoryLabel);
        add(OutCategoryValue);
        add(TodaysDateLabel);
        add(TodaysDateValue);
        add(RemarkLabel);
        add(RemarkValue);

    }

    //--------------------------------------------A C T I O N L I S T E N E R-------------------------------------------//
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == SaveButton){
            try {
                int OutAmount = Integer.parseInt(OutAmountValue.getText());
                String OutCategory = (String)OutCategoryValue.getSelectedItem();
                String Date = TodaysDateValue.getText();
                String Remark =  RemarkValue.getText();
                System.out.println(OutAmount + OutCategory + Date +Remark);

                String Query = "INSERT INTO cashout (Expense, OutCategory, Date, Remark) VALUES (?,?,?,?);";
                if(OutAmount > 1){
                    try(Connection Connect = DriverManager.getConnection(URL, USER, PASSWORD);
                        PreparedStatement Statemet = Connect.prepareCall(Query)){

                            Statemet.setInt(1, OutAmount);
                            Statemet.setString(2, OutCategory);
                            Statemet.setString(3, Date);
                            Statemet.setString(4, Remark);

                        Statemet.executeUpdate();  
                    }catch(SQLException exception){
                        System.err.println(exception);
                    }
                    Query = "INSERT INTO history (CashType, Amount, Category, Date) VALUES ('Expense', ?,?,?)";
                    try(Connection Connect = DriverManager.getConnection(URL, USER, PASSWORD);
                        PreparedStatement Statemet = Connect.prepareCall(Query)){

                            Statemet.setInt(1, OutAmount);
                            Statemet.setString(2, OutCategory);
                            Statemet.setString(3, Date);

                        Statemet.executeUpdate();  
                    }catch(SQLException exception){
                        System.err.println(exception);
                    }

                    DataForHomeTable function = new DataForHomeTable();
                    
                    OutAmountHeadingValue.setText(String.valueOf(function.Expense));
                    BalanceHeadingValue.setText(String.valueOf(function.Balance));
                }
                else{
                    new MessageBox("CASH OUT", "INVALID AMOUNT(MIN - RS.1)");
                }

            }catch(NumberFormatException ex) {
                System.out.println(ex);
                new MessageBox("CASH OUT", "PLEASE ENTER CORRECT AMOUNT");
            }

            OutAmountValue.setText("");
            OutCategoryValue.setSelectedIndex(0);
            RemarkValue.setText("");
            
        }
        if(e.getSource() == CategoryButton){

        }
    }


    public void CashOutCombobox(){
        OutCategoryValue.removeAllItems();

        String Query = "SELECT category FROM outcategory";
        try(Connection Connect = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement st = Connect.createStatement()){

            ResultSet rs = st.executeQuery(Query);
            
            while(rs.next()){
                OutCategoryValue.addItem(rs.getString("category"));
            }

        }catch(SQLException exception){
            System.err.println(exception);
        }
    }

}


 