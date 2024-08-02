import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class HomePage extends Thread {

    //-----------------------------------------------G L O B A L----------------------------------------------//

    JLabel close = new JLabel(" X ");
    JFrame frame = new JFrame();
    JLabel logout = new JLabel("LOGOUT");
    JPanel rightpanel = new JPanel();
    GradientPanel leftPanel = new GradientPanel(Color.decode("#004FF9"),Color.decode("#56CCF2"),0);
    CashInPanel Cash_In = new CashInPanel();
    CashOutPanel Cash_Out = new CashOutPanel();
    HistoryPanel History = new HistoryPanel();
    JLabel Context_Heading = new JLabel("HOME TABEL"); 
    HomePageTabel HomeTable = new HomePageTabel();
    JLabel home = new JLabel("HOME");
    JLabel Category = new JLabel("CATEGORY");
    JPanel Button_Panel = new JPanel();
    GradientPanel Cash_In_Panel = new GradientPanel(Color.decode("#000000"), Color.decode("#004ff9"), 75);
    GradientPanel Cash_Out_Panel = new GradientPanel(Color.decode("#0c0014"), Color.decode("#0779E4"), 75);
    GradientPanel Transaction_Panel = new GradientPanel(Color.decode("#1A2980"), Color.decode("#26D0CE"), 75);
    JLabel Button_Panel_Title = new JLabel();
    Category CategoryPanel = new Category();
    Animation WhiteScreen = new Animation();
    JLabel DeleteLable = new JLabel("DELETE");
    DeletePanel Delete = new DeletePanel();

    JLabel Print = new JLabel(new ImageIcon("lib\\images\\Print.png"));


    

    //-----------------------------------------------T H R E A D----------------------------------------------//

    public void run(){  // It Will run when thread starts
        WhiteScreen.StartAnimation(600);
    }


    //-----------------------------------------------C O N S T R U C T O R----------------------------------------------//

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

        JLabel Cash_In_icon = new JLabel();
        JLabel Cash_In_label = new JLabel("CASH IN ");

        JLabel Cash_Out_icon = new JLabel();
        JLabel Cash_Out_label = new JLabel("CASH OUT ");

        JLabel Transaction_icon = new JLabel();
        JLabel Transaction_label = new JLabel("HISTORY ");

        

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

        // Button Panel Title
        Button_Panel_Title.setText("HOME");
        Button_Panel_Title.setFont(new Font("Roboto", Font.BOLD, 35));
        Button_Panel_Title.setForeground(new Color(6, 143, 255));
        Button_Panel_Title.setBounds(30, 70, 200, 60);

        // Button Panel
        Button_Panel.setBounds(20, 110, 1462, 250);
        // Button_Panel.setBackground(new Color(206, 230, 243));// new Color(240, 240, 240)
        Button_Panel.setLayout(null);
        Button_Panel.setOpaque(false);

        // Cash In
        Cash_In_Panel.setBounds(10, 30, 400, 200);;//
        Cash_In_Panel.setLayout(null);
        Cash_In_icon.setIcon(new ImageIcon("lib\\images\\PlusIcon.png"));
        Cash_In_icon.setBounds(245, 50, 100, 100);

        Cash_In_label.setFont(new Font("Roboto", Font.BOLD, 30));
        Cash_In_label.setForeground(new Color(240, 240, 240));
        Cash_In_label.setBounds(25, 50, 200, 30);

        // After Clicked Cash  In
        Cash_In_Panel.addMouseListener(new java.awt.event.MouseAdapter() 
        {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e)
            {
                CashInclicked(e);
            }         
            
        });


        Cash_In_Panel.add(Cash_In_icon);
        Cash_In_Panel.add(Cash_In_label);

        Cash_Out_Panel.setBounds(530, 30, 400, 200);
        Cash_Out_Panel.setLayout(null);
        Cash_Out_icon.setIcon(new ImageIcon("lib\\images\\MinusIcon.png"));
        Cash_Out_icon.setBounds(245, 50, 100, 100);

        Cash_Out_label.setFont(new Font("Roboto", Font.BOLD, 30));
        Cash_Out_label.setForeground(new Color(240, 240, 240));
        Cash_Out_label.setBounds(25, 50, 200, 30);
        
        // After Clicked Cash Out
        Cash_Out_Panel.addMouseListener(new java.awt.event.MouseAdapter() 
        {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e)
            {
                CashOutclicked(e);
            }

        });

        Cash_Out_Panel.add(Cash_Out_icon);
        Cash_Out_Panel.add(Cash_Out_label);

        // Transaction
        Transaction_Panel.setBounds(1050, 30, 400, 200);
        Transaction_Panel.setLayout(null);
        Transaction_icon.setIcon(new ImageIcon("lib\\images\\HistoryIcon.png"));
        Transaction_icon.setBounds(245, 50, 100, 100);

        Transaction_label.setFont(new Font("Roboto", Font.BOLD, 30));
        Transaction_label.setForeground(new Color(240, 240, 240));
        Transaction_label.setBounds(25, 50, 225, 30);

        // After Clicked History
        Transaction_Panel.addMouseListener(new java.awt.event.MouseAdapter() 
        {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e)
            {
                Historyclicked(e);
            }

        });


        Transaction_Panel.add(Transaction_icon);
        Transaction_Panel.add(Transaction_label);

        // Adding defined components to the Button Panel
        Button_Panel.add(Cash_In_Panel);
        Button_Panel.add(Cash_Out_Panel);
        Button_Panel.add(Transaction_Panel);

        // Content Panel Heading
        Context_Heading.setFont(new Font("Roboto", Font.BOLD, 35));
        Context_Heading.setForeground(new Color(6, 143, 255));
        Context_Heading.setBounds(30, 400, 500, 40);


        
        
        Print.setBounds(1415,390,55,65);
        Print.setBorder(BorderFactory.createRaisedBevelBorder());
        Print.setBackground(Color.decode("#909497"));
        Print.setOpaque(true);
        Print.addMouseListener(new java.awt.event.MouseAdapter() 
        {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e)
            {
                Printclicked(e);
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent e)
            {
                Printentered(e);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e)
            {
                Printexited(e);
            }
        });


        // Adding defined components to the RightPanel
        rightpanel.add(TitleBar);
        rightpanel.add(Button_Panel_Title);
        rightpanel.add(Button_Panel);
        rightpanel.add(Context_Heading);
        // 
        
        rightpanel.add(CategoryPanel);
        rightpanel.add(HomeTable);
        rightpanel.add(Cash_In);
        rightpanel.add(Cash_Out);
        rightpanel.add(History);
        rightpanel.add(Delete);

        rightpanel.add(Print);


        
        


        //----------------------------------------------L E F T P A N E L---------------------------------------------//

        // Initilize components used in Left Panel
        // User Icon And Name
        ImageAvatar AdminIcon = new ImageAvatar();
        JLabel username = new JLabel("UserName");
        JLabel admin = new JLabel("Rahul",JLabel.CENTER);
        

        // Defining Left Panel
        leftPanel.setPreferredSize(new Dimension(300, 1000));
        leftPanel.setBounds(0, 0, 300, 1000);
        leftPanel.setLayout(null);


        // Defining logout
        logout.setIcon(new ImageIcon("lib\\images\\logout.png"));
        logout.setFont(new Font("Roboto", Font.BOLD, 25));
        logout.setBounds(10, 933, 280,50);
        logout.setForeground(new Color(240, 240, 240));
        logout.setHorizontalTextPosition(JLabel.RIGHT);
        logout.setVerticalTextPosition(JLabel.CENTER);
        logout.setIconTextGap(15);
        
        logout.addMouseListener(new java.awt.event.MouseAdapter() 
        {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e)
            {
                logoutclicked(e);
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent e)
            {
                logoutentered(e);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e)
            {
                logoutexited(e);
            }
        });

        // Defining AdminIcon
        AdminIcon.setBounds(5, 5, 65, 65);
        AdminIcon.setIcon(new ImageIcon("lib\\images\\Rahul.jpg"));

        // Defining UserName
        username.setFont(new Font("Roboto", Font.BOLD, 20)); // Modify fonts
        username.setForeground(Color.BLACK); // Font color
        username.setBounds(85, 15, 100 , 15);

        // Defining Admin
        admin.setFont(new Font("Roboto", Font.BOLD, 25)); // Modify fonts
        admin.setForeground(Color.WHITE); // Font color
        admin.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3, false));
        admin.setBounds(85, 35, 180 , 32);
        admin.setVerticalTextPosition(1);

        // Defining Home
        home.setIcon(new ImageIcon("lib\\images\\Home.png"));
        home.setFont(new Font("Roboto", Font.BOLD, 25));
        home.setBounds(10, 117, 280,50);
        home.setHorizontalTextPosition(JLabel.RIGHT);
        home.setVerticalTextPosition(JLabel.CENTER);
        home.setIconTextGap(19);
        home.setForeground(Color.BLACK);
        home.addMouseListener(new java.awt.event.MouseAdapter() 
        {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e)
            {
                homeclicked(e);
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent e)
            {
                homeentered(e);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e)
            {
                homeexited(e);
            }
        });

        // Defining Category
        Category.setIcon(new ImageIcon("lib\\images\\Category.png"));
        Category.setFont(new Font("Roboto", Font.BOLD, 25));
        Category.setBounds(10, 187, 280,50);
        Category.setForeground(new Color(240, 240, 240));
        Category.setHorizontalTextPosition(JLabel.RIGHT);
        Category.setVerticalTextPosition(JLabel.CENTER);
        Category.setIconTextGap(15);
        Category.addMouseListener(new java.awt.event.MouseAdapter() 
        {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e)
            {
                Categoryclicked(e);
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent e)
            {
                Categoryentered(e);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e)
            {
                Categoryexited(e);
            }
        });


        // Defining Delete
        DeleteLable.setIcon(new ImageIcon("lib\\images\\Remove.png"));
        DeleteLable.setFont(new Font("Roboto", Font.BOLD, 25));
        DeleteLable.setBounds(10, 257, 280,50);
        DeleteLable.setForeground(new Color(240, 240, 240));
        DeleteLable.setHorizontalTextPosition(JLabel.RIGHT);
        DeleteLable.setVerticalTextPosition(JLabel.CENTER);
        DeleteLable.setIconTextGap(15);
        DeleteLable.addMouseListener(new java.awt.event.MouseAdapter() 
        {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e)
            {
                Deleteclicked(e);
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent e)
            {
                Deleteentered(e);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e)
            {
                Deleteexited(e);
            }
        });

        
        // Adding defined components to the Left Panel
        leftPanel.add(logout);
        leftPanel.add(AdminIcon);
        leftPanel.add(username);
        leftPanel.add(admin);
        leftPanel.add(home);
        leftPanel.add(Category);
        leftPanel.add(DeleteLable);

        // Adding defined components to the Frame
        frame.add(rightpanel);
        frame.add(leftPanel);

        frame.setVisible(true);

    }



    //--------------------------------------------M O U S E L I S T E N E R-------------------------------------------//

    // Close
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


    // Logout
    public void logoutclicked(java.awt.event.MouseEvent e)
    {
        home.setForeground(new Color(240, 240, 240));
        Category.setForeground(new Color(240, 240, 240));
        logout.setForeground(Color.BLACK);
        
        this.frame.dispose();
        new LoginPage();
    }
    public void logoutentered(java.awt.event.MouseEvent e)
    {
        
        logout.setBorder(BorderFactory.createRaisedBevelBorder());
    }
    public void logoutexited(java.awt.event.MouseEvent e)
    {
        logout.setForeground(new Color(240,240,240));
        logout.setBorder(null);
    }


    // Cash In
    public void CashInclicked(java.awt.event.MouseEvent e)
    {
        new Thread(this).start();
        Context_Heading.setText("CASH IN");

        rightpanel.remove(this.Cash_In);
        this.Cash_In = new CashInPanel();
        rightpanel.add(this.Cash_In);

        // rightpanel.remove(Cash_Out);
        // rightpanel.remove(History);
        // rightpanel.remove(HomeTable);

        Cash_In.setVisible(true);
        Cash_Out.setVisible(false);
        History.setVisible(false);
        HomeTable.setVisible(false);
        Delete.setVisible(false);

        Cash_In.CashInCombobox();

        

    }



    // Cash Out
    public void CashOutclicked(java.awt.event.MouseEvent e)
    {
        new Thread(this).start();

        Context_Heading.setText("CASH OUT");

        rightpanel.remove(this.Cash_Out);
        this.Cash_Out = new CashOutPanel();
        rightpanel.add(this.Cash_Out);

        // rightpanel.remove(Cash_In);
        // rightpanel.remove(History);
        // rightpanel.remove(HomeTable);

        Cash_In.setVisible(false);
        Cash_Out.setVisible(true);
        History.setVisible(false);
        HomeTable.setVisible(false);
        Delete.setVisible(false);

        Cash_Out.CashOutCombobox();
    }


    


    // History
    public void Historyclicked(java.awt.event.MouseEvent e)
    {
        new Thread(this).start();
        
        Context_Heading.setText("HISTORY");

        rightpanel.remove(History);
        this.History = new HistoryPanel();
        rightpanel.add(this.History);

        // rightpanel.remove(Cash_In);
        // rightpanel.remove(Cash_Out);
        // rightpanel.remove(HomeTable);


        Cash_In.setVisible(false);
        Cash_Out.setVisible(false);
        History.setVisible(true);
        HomeTable.setVisible(false);
        Delete.setVisible(false);
    }




    // Home
    public void homeclicked(java.awt.event.MouseEvent e)
    {
        new Thread(this).start();

        Context_Heading.setText("HOME TABLE");

        home.setForeground(Color.BLACK);
        Category.setForeground(new Color(240, 240, 240));
        logout.setForeground(new Color(240, 240, 240));
        DeleteLable.setForeground(new Color(240, 240, 240));

        VisibilityHome(true);

        rightpanel.remove(CategoryPanel);

        rightpanel.remove(HomeTable);
        HomeTable = new HomePageTabel();
        rightpanel.add(HomeTable);

        // rightpanel.remove(Cash_In);
        // rightpanel.remove(Cash_Out);
        // rightpanel.remove(History);

        Cash_In.setVisible(false);
        Cash_Out.setVisible(false);
        History.setVisible(false);
        HomeTable.setVisible(true);
        Delete.setVisible(false);

        HomeTable.setBounds(30, 460, 1440, 510);

        CategoryPanel.setVisible(false);
        CategoryPanel.VisibilityCategoty(false);

        // UpdateCashInTable();
    }
    public void homeentered(java.awt.event.MouseEvent e)
    {
        home.setBorder(BorderFactory.createRaisedBevelBorder());
    }
    public void homeexited(java.awt.event.MouseEvent e)
    {
        home.setBorder(null);
    }

    // Category
    public void Categoryclicked(java.awt.event.MouseEvent e)
    {
        new Thread(this).start();
        
        home.setForeground(new Color(240, 240, 240));
        Category.setForeground(Color.BLACK);
        logout.setForeground(new Color(240, 240, 240));
        DeleteLable.setForeground(new Color(240, 240, 240));

        VisibilityHome(false);
        Cash_In.setVisible(false);
        Cash_Out.setVisible(false);
        History.setVisible(false);
        HomeTable.setVisible(false);
        Delete.setVisible(false);

        rightpanel.remove(CategoryPanel);
        CategoryPanel = new Category();
        rightpanel.add(CategoryPanel);

        CategoryPanel.setVisible(true);
        CategoryPanel.VisibilityCategoty(true);

        // CategoryPanel.CategoryDataPanel.setVisible(false);
        CategoryPanel.Context_Heading.setText("CASH IN - ADD");

    }
    public void Categoryentered(java.awt.event.MouseEvent e)
    {
        Category.setBorder(BorderFactory.createRaisedBevelBorder());
    }
    public void Categoryexited(java.awt.event.MouseEvent e)
    {
       Category.setBorder(null);
    }

    // Category
    public void Deleteclicked(java.awt.event.MouseEvent e)
    {
        new Thread(this).start();
        
        home.setForeground(new Color(240, 240, 240));
        Category.setForeground(new Color(240, 240, 240));
        logout.setForeground(new Color(240, 240, 240));
        DeleteLable.setForeground(Color.BLACK);

        VisibilityHome(false);
        Cash_In.setVisible(false);
        Cash_Out.setVisible(false);
        History.setVisible(false);
        HomeTable.setVisible(false);
        Delete.setVisible(true);

        // rightpanel.remove(CategoryPanel);
        // CategoryPanel = new Category();
        // rightpanel.add(CategoryPanel);

        CategoryPanel.setVisible(false);
        CategoryPanel.VisibilityCategoty(false);

        // CategoryPanel.CategoryDataPanel.setVisible(false);
        Delete.Table.DataValue.setText("");

    }
    public void Deleteentered(java.awt.event.MouseEvent e)
    {
        DeleteLable.setBorder(BorderFactory.createRaisedBevelBorder());
    }
    public void Deleteexited(java.awt.event.MouseEvent e)
    {
        DeleteLable.setBorder(null);
    }


    // Home
    public void Printclicked(java.awt.event.MouseEvent e)
    {

        // UpdateCashInTable();
    }
    public void Printentered(java.awt.event.MouseEvent e)
    {
        Print.setBorder(BorderFactory.createLoweredBevelBorder());
        Print.setBackground(Color.decode("#d7dbdd"));
    }
    public void Printexited(java.awt.event.MouseEvent e)
    {
        Print.setBorder(BorderFactory.createRaisedBevelBorder());
        Print.setBackground(Color.decode("#909497"));
    }



    //--------------------------------------------F U  N C T I O N S-------------------------------------------//

    public void VisibilityHome(boolean Visibile){

        // Visibility
        Button_Panel.setVisible(Visibile);
        Context_Heading.setVisible(Visibile);
        Cash_In_Panel.setVisible(Visibile);
        Cash_Out_Panel.setVisible(Visibile);
        Transaction_Panel.setVisible(Visibile);
        Button_Panel_Title.setVisible(Visibile);

    }

    

    // public void UpdateCashInTable(){

    //     CashInList.clear();
    //     CashInList = this.CashInAddData();
    //     CashInData = CashInList.toArray(new String[0][0]);

    //     for(String[] Rows : CashInData){
    //         for(String Row : Rows)
    //         System.out.println(Row);
    //     }

    //     CashInTable.
        
    // }

    public static void main(String[] args) {
        new HomePage();
    }

}
