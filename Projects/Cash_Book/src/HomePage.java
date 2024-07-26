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
import java.util.Arrays;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;


public class HomePage extends Thread {

    //-----------------------------------------------G L O B A L----------------------------------------------//

    JLabel close = new JLabel(" X ");
    JFrame frame = new JFrame();
    JLabel logout = new JLabel("Logout");
    JPanel rightpanel = new JPanel();
    GradientPanel leftPanel = new GradientPanel(Color.decode("#004FF9"),Color.decode("#56CCF2"),0);
    CashInPanel Cash_In = new CashInPanel();
    CashOutPanel Cash_Out = new CashOutPanel();
    HistoryPanel History = new HistoryPanel();
    JLabel Context_Heading = new JLabel("Home Table"); 
    JPanel Content_Panel = new JPanel();
    JLabel home = new JLabel("Home");
    JLabel Category = new JLabel("Category");
    JPanel Button_Panel = new JPanel();
    GradientPanel Cash_In_Panel = new GradientPanel(Color.decode("#000000"), Color.decode("#004ff9"), 75);
    GradientPanel Cash_Out_Panel = new GradientPanel(Color.decode("#0c0014"), Color.decode("#0779E4"), 75);
    GradientPanel Transaction_Panel = new GradientPanel(Color.decode("#1A2980"), Color.decode("#26D0CE"), 75);
    JLabel Button_Panel_Title = new JLabel();

    Category CategoryPanel = new Category();

    Animation WhiteScreen = new Animation();

    private static final String URL = "jdbc:mysql://localhost:3306/cashbook";
    private static final String USER = "root";
    private static final String PASSWORD = "7418022289";

    JTable CashInTable;
    List<String[]> CashInList;
    String[][] CashInData;

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
        Button_Panel_Title.setText("Home");
        Button_Panel_Title.setFont(new Font("Roboto", Font.BOLD, 35));
        Button_Panel_Title.setForeground(new Color(6, 143, 255));
        Button_Panel_Title.setBounds(30, 70, 200, 60);

        // Button Panel
        Button_Panel.setBounds(20, 110, 1462, 250);
        Button_Panel.setBackground(new Color(206, 230, 243));// new Color(240, 240, 240)
        Button_Panel.setLayout(null);

        // Cash In
        Cash_In_Panel.setBounds(10, 30, 400, 200);
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
        

        //----------------------------------------------C O N T E N T P A N E L---------------------------------------------//
        JPanel HeadingPanel = new JPanel();

        JPanel TotalCashInPanel = new JPanel();
        JLabel TotalCashInTitle = new JLabel("INCOME");
        JLabel TotalCashInValue = new JLabel("0000");
        
        JPanel TotalCashOutPanel = new JPanel();
        JLabel TotalCashOutTitle = new JLabel("EXPENSE");
        JLabel TotalCashOutValue = new JLabel("0000");

        JPanel BalancePanel = new JPanel();
        JLabel BalanceTitle = new JLabel("BALANCE");
        JLabel BalanceValue = new JLabel("0000");


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
        JScrollPane CashInTableScrollPanel = new JScrollPane(CashInTable);

        JPanel CashOutTabelHeadingPanel = new JPanel();
        JLabel CashOutTableHeading = new JLabel("CASH OUT");

        JPanel CashOutTableBasePanel = new JPanel();

        String[] CashOutColumnName = {"EXPENSE","CATEGORY","DATE"};
        
        String[][] CashOutData = {{"1000","Income 1","2024-07-23"},
            {"200","Income 1","2024-07-23"},
            {"500","In5","2024-07-23"},
            {"1000","Income 1","2024-07-23"},
            {"200","Income 1","2024-07-23"},
            {"500","In5","2024-07-23"},
            {"1000","Income 1","2024-07-23"},
            {"200","Income 1","2024-07-23"},
            {"500","In5","2024-07-23"},
            {"200","Income 1","2024-07-23"},
            {"500","In5","2024-07-23"},
            {"1000","Income 1","2024-07-23"},
            {"200","Income 1","2024-07-23"},
            {"500","In5","2024-07-23"},
            {"1000","Income 1","2024-07-23"},
            {"200","Income 1","2024-07-23"},
            {"500","In5","2024-07-23"}};

        JTable CashOutTable = new JTable(CashOutData,CashOutColumnName);
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
        JScrollPane CashOutTableScrollPanel = new JScrollPane(CashOutTable);

        // Content Panel Heading
        Context_Heading.setFont(new Font("Roboto", Font.BOLD, 35));
        Context_Heading.setForeground(new Color(6, 143, 255));
        Context_Heading.setBounds(30, 400, 200, 40);
        

        Content_Panel.setBounds(30, 460, 1440, 505);
        Content_Panel.setBackground(Color.decode("#616a6b"));//  new Color(206, 230, 243)
        Content_Panel.setLayout(null);
        Content_Panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));

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
        // CashInTable.
        CashInTable.setEnabled(false);



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
        
        CashOutTable.setFont(new Font("Roboto", Font.BOLD, 30));
        CashOutTable.setRowHeight(40);
        CashOutTable.setBackground(Color.decode("#f2f3f4"));
        CashOutTable.setPreferredScrollableViewportSize(new Dimension(300,200));

        CashOutTableBasePanel.add(CashOutTableScrollPanel);
        




        // Adding defined components to the ContentPanel
        Content_Panel.add(Cash_In);
        Content_Panel.add(Cash_Out);
        Content_Panel.add(History);
        Content_Panel.add(HeadingPanel);

        Content_Panel.add(CashInTableHeadingPanel);
        Content_Panel.add(CashOutTabelHeadingPanel);
        Content_Panel.add(CashInTableBasePanel);
        Content_Panel.add(CashOutTableBasePanel);

        



        // Adding defined components to the RightPanel
        rightpanel.add(TitleBar);
        rightpanel.add(Button_Panel_Title);
        rightpanel.add(Button_Panel);
        rightpanel.add(Context_Heading);
        rightpanel.add(Content_Panel);
        rightpanel.add(CategoryPanel);


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
        AdminIcon.setBounds(5, 5, 55, 55);
        AdminIcon.setIcon(new ImageIcon("lib\\images\\Rahul.jpg"));

        // Defining UserName
        username.setFont(new Font("Roboto", Font.BOLD, 17)); // Modify fonts
        username.setForeground(Color.BLACK); // Font color
        username.setBounds(80, 12, 100 , 15);

        // Defining Admin
        admin.setFont(new Font("Roboto", Font.BOLD, 20)); // Modify fonts
        admin.setForeground(Color.WHITE); // Font color
        admin.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3, false));
        admin.setBounds(80, 29, 180 , 28);
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

        
        // Adding defined components to the Left Panel
        leftPanel.add(logout);
        leftPanel.add(AdminIcon);
        leftPanel.add(username);
        leftPanel.add(admin);
        leftPanel.add(home);
        leftPanel.add(Category);


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

        Cash_In.setVisible(true);
        Cash_Out.setVisible(false);
        History.setVisible(false);

        Cash_In.CashInCombobox();
    }


    // Cash Out
    public void CashOutclicked(java.awt.event.MouseEvent e)
    {
        new Thread(this).start();

        Context_Heading.setText("CASH OUT");

        Cash_In.setVisible(false);
        Cash_Out.setVisible(true);
        History.setVisible(false);

        Cash_Out.CashOutCombobox();
    }


    // History
    public void Historyclicked(java.awt.event.MouseEvent e)
    {
        new Thread(this).start();
        
        Context_Heading.setText("HISTORY");

        Cash_In.setVisible(false);
        Cash_Out.setVisible(false);
        History.setVisible(true);
    }


    // Home
    public void homeclicked(java.awt.event.MouseEvent e)
    {
        new Thread(this).start();

        Context_Heading.setText("Home Table");

        home.setForeground(Color.BLACK);
        Category.setForeground(new Color(240, 240, 240));
        logout.setForeground(new Color(240, 240, 240));

        VisibilityHome(true);

        Cash_In.setVisible(false);
        Cash_Out.setVisible(false);

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

        VisibilityHome(false);

        CategoryPanel.setVisible(true);
        CategoryPanel.VisibilityCategoty(true);

        CategoryPanel.CategoryDataPanel.setVisible(false);
        CategoryPanel.Context_Heading.setText("CATEGORY");

    }
    public void Categoryentered(java.awt.event.MouseEvent e)
    {
        Category.setBorder(BorderFactory.createRaisedBevelBorder());
    }
    public void Categoryexited(java.awt.event.MouseEvent e)
    {
       Category.setBorder(null);
    }


    //--------------------------------------------F U  N C T I O N S-------------------------------------------//

    public void VisibilityHome(boolean Visibile){

        // Visibility
        Button_Panel.setVisible(Visibile);
        Context_Heading.setVisible(Visibile);
        Content_Panel.setVisible(Visibile);
        Cash_In.setVisible(Visibile);
        Cash_Out.setVisible(Visibile);
        Cash_In_Panel.setVisible(Visibile);
        Cash_Out_Panel.setVisible(Visibile);
        Transaction_Panel.setVisible(Visibile);
        Button_Panel_Title.setVisible(Visibile);

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
