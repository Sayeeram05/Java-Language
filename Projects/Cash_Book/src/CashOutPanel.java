import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class CashOutPanel extends JPanel implements ActionListener{

    //-----------------------------------------------G L O B A L----------------------------------------------//

    GradientButton SaveButton = new GradientButton(Color.decode("#004FF9"), Color.decode("#56CCF2"));
    GradientButton CategoryButton = new GradientButton(Color.decode("#283048"), Color.decode("#859398"));

    JPanel HeadingPanel = new JPanel();

    JTextField InAmountValue = new JTextField();
    JTextField InCategoryValue = new JTextField();
    LocalDate Today = LocalDate.now();
    JLabel TodaysDateValue = new JLabel(Today.toString());
    JTextField RemarkValue = new JTextField();
    
    public CashOutPanel() {

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
        JLabel InAmountHeading = new JLabel("ENPENSE - ");
        JLabel InAmountHeadingValue = new JLabel("0000");
        JLabel BalanceHeading = new JLabel("BALANCE - ");
        JLabel BalanceHeadingValue = new JLabel("0000");


        // Defining Heading Panel
        HeadingPanel.setBounds(0,0,1440, 75);
        HeadingPanel.setBackground(Color.decode("#0779E4"));// new Color(240, 240, 240) new Color(206 , 230, 243)
        HeadingPanel.setLayout(null);
        HeadingPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));

        // In Amount Heading
        InAmountHeading.setFont(new Font("Roboto", Font.BOLD, 30));
        InAmountHeading.setBounds(366, 10, 220,50);
        InAmountHeading.setForeground(Color.BLACK);

        // In Amount Heading Value
        InAmountHeadingValue.setFont(new Font("Roboto", Font.BOLD, 30));
        InAmountHeadingValue.setBounds(540, 10, 220,50);
        InAmountHeadingValue.setForeground(new Color(240, 240, 240));

        // Balance Heading
        BalanceHeading.setFont(new Font("Roboto", Font.BOLD, 30));
        BalanceHeading.setBounds(760, 10, 220,50);
        BalanceHeading.setForeground(Color.BLACK);

        // Balance Heading Value
        BalanceHeadingValue.setFont(new Font("Roboto", Font.BOLD, 30));
        BalanceHeadingValue.setBounds(940, 10, 220,50);
        BalanceHeadingValue.setForeground(new Color(240, 240, 240));
    

        // Adding Elements In The Heading Panel
        HeadingPanel.add(InAmountHeading);
        HeadingPanel.add(InAmountHeadingValue);
        HeadingPanel.add(BalanceHeading);
        HeadingPanel.add(BalanceHeadingValue);

        //----------------------------------------------D E T A I L S---------------------------------------------//

        JLabel InAmountLabel = new JLabel("CASH OUT"); 
        JLabel InCategoryLabel = new JLabel("OUT CATEGORY");
        JLabel TodaysDateLabel = new JLabel("TODAY");
        JLabel RemarkLabel = new JLabel("Remark");
        


        // In Amount Label
        InAmountLabel.setFont(new Font("Roboto", Font.BOLD, 30)); 
        InAmountLabel.setForeground(Color.BLACK);
        InAmountLabel.setBounds(150, 120, 200, 30); 

        // In Amount Value
        InAmountValue.setBounds(150, 150, 450, 45);
        InAmountValue.setBorder(BorderFactory.createLoweredBevelBorder());
        InAmountValue.setFont(new Font("Roboto", Font.BOLD, 30));
        InAmountValue.setForeground(Color.decode("#004FF9"));

        // In Category Label
        InCategoryLabel.setFont(new Font("Roboto", Font.BOLD, 30)); 
        InCategoryLabel.setForeground(Color.BLACK);
        InCategoryLabel.setBounds(800, 120, 250, 30); 

        // In Category Value
        InCategoryValue.setBounds(800, 150, 450, 45);
        InCategoryValue.setBorder(BorderFactory.createLoweredBevelBorder());
        InCategoryValue.setFont(new Font("Roboto", Font.BOLD, 30));
        InCategoryValue.setForeground(Color.decode("#004FF9"));

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
        add(InAmountLabel);
        add(InAmountValue);
        add(InCategoryLabel);
        add(InCategoryValue);
        add(TodaysDateLabel);
        add(TodaysDateValue);
        add(RemarkLabel);
        add(RemarkValue);

    }

    //--------------------------------------------A C T I O N L I S T E N E R-------------------------------------------//
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == SaveButton){
            String InAmount = InAmountValue.getText();
            String InCategory = InCategoryValue.getText();
            String Date = TodaysDateValue.getText();
            String Remark =  RemarkValue.getText();
            System.out.println(InAmount + InCategory + Date +Remark);
        }
        if(e.getSource() == CategoryButton){

        }
    }


}


 