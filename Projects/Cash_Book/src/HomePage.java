import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HomePage {

    //-----------------------------------------------G L O B A L----------------------------------------------//

    JLabel close = new JLabel(" X ");
    JFrame frame = new JFrame();
    JLabel logout = new JLabel("Logout");
    JPanel rightpanel = new JPanel();
    GradientPanel leftPanel = new GradientPanel(Color.decode("#004FF9"),Color.decode("#56CCF2"),0);

    //-----------------------------------------------C  O   N   S   T   R   U   C   T   O   R----------------------------------------------//

    public HomePage() {

        //---------------------------------------------------F R A M E--------------------------------------------------//

        // Defining frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // 
        frame.setSize(1800,1000); // frame size
        frame.setLocationRelativeTo(null);  // display frame in center of screen
        frame.setUndecorated(true);
        frame.setIconImage(new ImageIcon("lib\\images\\App_Icon.png").getImage());
        frame.setLayout(null);

        //----------------------------------------------R I G H T P A N E L---------------------------------------------//

        // Initilize components used in rightpanel
        JPanel TitleBar = new JPanel();
        close = new JLabel("X",JLabel.CENTER);
        JLabel CashBookHeading = new JLabel();

        JPanel Button_Panel = new JPanel();
        JLabel Button_Panel_Title = new JLabel("Home");

        GradientPanel Cash_In_Panel = new GradientPanel(Color.decode("#000000"), Color.decode("#004ff9"), 50);
        JLabel Cash_In_icon = new JLabel();
        JLabel Cash_In_label = new JLabel("CASH IN ");

        GradientPanel Cash_Out_Panel = new GradientPanel(Color.decode("#0c0014"), Color.decode("#0779E4"), 50);
        JLabel Cash_Out_icon = new JLabel();
        JLabel Cash_Out_label = new JLabel("CASH OUT ");

        GradientPanel Transaction_Panel = new GradientPanel(Color.decode("#1A2980"), Color.decode("#26D0CE"), 50);
        JLabel Transaction_icon = new JLabel();
        JLabel Transaction_label = new JLabel("HISTORY ");



        JPanel Content_Panel = new JPanel();

        // Defining right_Panel
        rightpanel.setPreferredSize(new Dimension(1500, 1000));
        rightpanel.setBackground(new Color(206, 230, 243));
        rightpanel.setBounds(300,0,1500,1000);
        rightpanel.setLayout(null);

        // Defining TitleBar
        TitleBar.setPreferredSize(new Dimension(149, 40));
        TitleBar.setBounds(0, 0, 1500, 40);
        TitleBar.setBackground(Color.WHITE);
        TitleBar.setLayout(null);

        // Defining close
        close.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
        close.setBounds(1460, 0, 40, 40);
        close.setOpaque(true);
        close.setBackground(Color.WHITE);
        close.setForeground(Color.RED);
        close.addMouseListener(new java.awt.event.MouseAdapter() 
        {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e)
            {
                closeclicked(e);
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent e)
            {
                closeentered(e);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e)
            {
                closeexited(e);
            }
        });

        // Defining CashBookHeading
        CashBookHeading.setText("CASH BOOK");
        CashBookHeading.setFont(new Font("Arial Black", Font.BOLD,30));
        CashBookHeading.setForeground(new Color(0, 121, 255));
        CashBookHeading.setBounds(650, 0, 250, 40);
        CashBookHeading.addMouseListener(new java.awt.event.MouseAdapter() 
        {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e)
            {
                   //homeclicked(e);
            }
        });

        // Adding defined components to the TitleBar
        TitleBar.add(close);
        TitleBar.add(CashBookHeading);

        //----------------------------------------------B U T T O N P A N E L---------------------------------------------//

        Button_Panel.setBounds(20, 75, 1462, 280);
        Button_Panel.setBackground(new Color(206, 230, 243));// new Color(240, 240, 240)
        Button_Panel.setLayout(null);

        // Button Panel Title
        Button_Panel_Title.setFont(new Font("Roboto", Font.BOLD, 35));
        Button_Panel_Title.setForeground(new Color(6, 143, 255));
        Button_Panel_Title.setBounds(10, 0, 200, 40);

        // Cash In
        Cash_In_Panel.setBounds(10, 60, 400, 200);
        Cash_In_Panel.setLayout(null);
        Cash_In_icon.setIcon(new ImageIcon("lib\\images\\PlusIcon.png"));
        Cash_In_icon.setBounds(245, 50, 100, 100);

        Cash_In_label.setFont(new Font("Roboto", Font.BOLD, 30));
        Cash_In_label.setForeground(new Color(240, 240, 240));
        Cash_In_label.setBounds(25, 50, 200, 30);


        Cash_In_Panel.add(Cash_In_icon);
        Cash_In_Panel.add(Cash_In_label);

        Cash_Out_Panel.setBounds(525, 60, 400, 200);
        Cash_Out_Panel.setLayout(null);
        Cash_Out_icon.setIcon(new ImageIcon("lib\\images\\MinusIcon.png"));
        Cash_Out_icon.setBounds(245, 50, 100, 100);

        Cash_Out_label.setFont(new Font("Roboto", Font.BOLD, 30));
        Cash_Out_label.setForeground(new Color(240, 240, 240));
        Cash_Out_label.setBounds(25, 50, 200, 30);


        Cash_Out_Panel.add(Cash_Out_icon);
        Cash_Out_Panel.add(Cash_Out_label);

        // Transaction
        Transaction_Panel.setBounds(1050, 60, 400, 200);
        Transaction_Panel.setLayout(null);
        Transaction_icon.setIcon(new ImageIcon("lib\\images\\HistoryIcon.png"));
        Transaction_icon.setBounds(245, 50, 100, 100);

        Transaction_label.setFont(new Font("Roboto", Font.BOLD, 30));
        Transaction_label.setForeground(new Color(240, 240, 240));
        Transaction_label.setBounds(25, 50, 225, 30);


        Transaction_Panel.add(Transaction_icon);
        Transaction_Panel.add(Transaction_label);

        // Adding defined components to the Button Panel
        Button_Panel.add(Button_Panel_Title);
        Button_Panel.add(Cash_In_Panel);
        Button_Panel.add(Cash_Out_Panel);
        Button_Panel.add(Transaction_Panel);
        

        //----------------------------------------------C O N T E N T P A N E L---------------------------------------------//

        Content_Panel.setBounds(20, 400, 1462, 550);
        Content_Panel.setBackground(new Color(240, 240, 240));//  new Color(206, 230, 243)
        Content_Panel.setLayout(null);

        // Adding defined components to the RightPanel
        rightpanel.add(TitleBar);
        rightpanel.add(Button_Panel);
        rightpanel.add(Content_Panel);


        //----------------------------------------------L E F T P A N E L---------------------------------------------//

        
        leftPanel.setPreferredSize(new Dimension(300, 1000));
        leftPanel.setBounds(0, 0, 300, 1000);
        leftPanel.setLayout(null);

        


        // Adding defined components to the Frame
        frame.add(rightpanel);
        frame.add(leftPanel);

        frame.setVisible(true);

    }



    //--------------------------------------------A C T I O N L I S T E N E R-------------------------------------------//

    public void closeclicked(java.awt.event.MouseEvent e)
    {
        frame.dispose();
    }
    public void closeentered(java.awt.event.MouseEvent e)
    {
        close.setForeground(Color.BLACK);
        close.setBackground(Color.RED);
    }
    public void closeexited(java.awt.event.MouseEvent e)
    {
        close.setForeground(Color.RED);
        close.setBackground(Color.WHITE);
    }



    public static void main(String[] args) {
        new HomePage();
    }

}
