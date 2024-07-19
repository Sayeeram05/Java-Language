import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class LoginPage implements ActionListener{
    
    JFrame frame;
    JLabel close ;
    JLabel min ;
    JPanel left_panel;
    JLabel passwordicon;
    JPasswordField password_passwordfield;
    JTextField username_textfield;
    JButton login_button;

    JFrame message_frame = new JFrame();
    GradientButton messagebox_ok = new GradientButton(Color.decode("#004FF9"),Color.decode("#56CCF2"));

    // Database connection details
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/cashbook";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "7418022289";

    LoginPage()
    {

        // Initialize frame
        frame = new JFrame();
        ImageIcon AppIcon = new ImageIcon("lib\\images\\App_Icon.png");

        //---------------------------------------------------F R A M E--------------------------------------------------//
        // Defining frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // 
        frame.setSize(new Dimension(850,500));  // frame size
        frame.setLocationRelativeTo(null);  // display frame in center of screen
        frame.setIconImage(AppIcon.getImage());
        frame.setLayout(new BorderLayout());
        frame.setUndecorated(true); // removes the title bar


        //----------------------------------------------R I G H T P A N E L---------------------------------------------//
        // Initilize rightpanel
        JPanel right_Panel = new JPanel();

        // Initilize components used in rightpanel
        close = new JLabel(" X ");
        min = new JLabel("-");
        JLabel mainlogo = new JLabel();
        JLabel loginimage_label = new JLabel();
        ImageIcon loginicon = new ImageIcon("lib\\images\\LoginPic.jpg");   
        JLabel WelcomeLabel = new JLabel("WELCOME");

        // Defining right_Panel
        right_Panel.setPreferredSize(new Dimension(400, 500));
        right_Panel.setBackground(Color.WHITE);
        right_Panel.setLayout(null);

        // Defining close
        close.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
        close.setBounds(370, 5, 25, 25);
        close.setOpaque(true);
        close.setBackground(Color.WHITE);
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
        
        // Defining min
        min.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 40));
        min.setBounds(345, 6, 15, 15);
        min.addMouseListener(new java.awt.event.MouseAdapter() 
        {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e)
            {
                minclicked(e);
            }
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e)
            {
                minentered(e);
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent e)
            {
                minexited(e);
            }
            
        });

        // Defining loginimage_label
        loginimage_label.setSize(400,450); // Size of label
        // Different label and image size
        // fit the image int the label
        Image img = loginicon.getImage();  // get the image from the Imageicon
        // Resisizing image to the size of label
        Image resizeimage = img.getScaledInstance(loginimage_label.getWidth(), loginimage_label.getHeight(),Image.SCALE_SMOOTH);
        // store resized image to Imageicon
        ImageIcon finalimage = new ImageIcon(resizeimage);
        loginimage_label.setIcon(finalimage);
        loginimage_label.setBounds(0, 80, 350 , 450);

        // Defining WelcomeLabel
        WelcomeLabel.setFont(new Font("Roboto", Font.BOLD, 40));
        WelcomeLabel.setForeground(new Color(6, 143, 255));
        WelcomeLabel.setBounds(95,50, 220, 30);


        // Adding defined components to the right_Panel
        right_Panel.add(close);
        right_Panel.add(min);
        right_Panel.add(mainlogo);
        right_Panel.add(loginimage_label);
        right_Panel.add(WelcomeLabel);

        //-----------------------------------------------L E F T P A N E L----------------------------------------------//

        // Initilize leftpanel
        left_panel = new JPanel();

        // Initilize components used in leftpanel
        JLabel login_label = new JLabel("LOGIN");
        JLabel usernamelabel = new JLabel("Username");
        username_textfield = new JTextField();
        JLabel userline = new JLabel("________________________");
        JLabel usernameicon = new JLabel();
        JLabel passwordlabel = new JLabel("Password");
        password_passwordfield = new JPasswordField();
        JLabel passwordline = new JLabel("________________________");
        passwordicon = new JLabel();
        login_button = new JButton();


        // Defining leftpanel
        left_panel.setPreferredSize(new Dimension(450, 500));  // use preferdsize for panel
        left_panel.setBackground(new Color(6, 143, 255));
        left_panel.setLayout(null); // no layout

        // Defining label
        login_label.setFont(new Font("Roboto", Font.PLAIN, 40)); // Modify fonts
        login_label.setForeground(Color.WHITE); // Font color
        login_label.setBounds(160, 50, 150, 40); // position of label(null Layout)

        // Defining usernamelabel
        usernamelabel.setFont(new Font("Roboto", Font.PLAIN, 18)); 
        usernamelabel.setForeground(Color.WHITE);
        usernamelabel.setBounds(50, 155, 150, 18); 

        // Defining username_textfield
        username_textfield.setFont(new Font("Roboto", Font.PLAIN, 20));
        username_textfield.setBounds(50, 177, 300, 35);
        username_textfield.setBorder(null);
        username_textfield.setFont(new Font("Roboto", Font.PLAIN, 20));
        username_textfield.setBackground(new Color(6, 143, 255));
        username_textfield.setForeground(Color.BLACK);
        userline.setFont(new Font("Roboto", Font.PLAIN, 25));
        userline.setBounds(50, 190, 360, 30);

        // Defining usernameicon
        usernameicon.setIcon(new ImageIcon("lib\\images\\user.png")); 
        usernameicon.setBounds(360, 175, 35, 35);

        // Defining passwordlabel
        passwordlabel.setFont(new Font("Roboto", Font.PLAIN, 18));
        passwordlabel.setForeground(Color.WHITE);
        passwordlabel.setBounds(50, 245, 100, 18);

        // Defining password_passwordfield
        password_passwordfield.setFont(new Font("Roboto", Font.PLAIN, 20));
        password_passwordfield.setBounds(50, 267, 300, 35);
        password_passwordfield.setBorder(null);
        password_passwordfield.setBackground(new Color(6, 143, 255));
        password_passwordfield.setForeground(Color.BLACK);
        passwordline.setFont(new Font("Roboto", Font.PLAIN, 25));
        passwordline.setBounds(50, 280, 360, 30);

        // Defining username_textfield
        passwordicon.setIcon(new ImageIcon("lib\\images\\invisible.png"));
        passwordicon.setBounds(360, 265, 35, 35);
        passwordicon.addMouseListener(new java.awt.event.MouseAdapter() // react to the mouse pointer
        {
            @Override
            public void mousePressed(java.awt.event.MouseEvent e)  
            {
                passwordiconPressed(e);
            }
            @Override
            public void mouseReleased(java.awt.event.MouseEvent e)
            {
                passwordiconReleased(e);
            }
        });

        // Defining login_button
        login_button.setText("NEXT");
        login_button.setFont(new Font("Roboto", Font.BOLD, 25));
        login_button.setForeground(new Color(6, 143, 255));
        login_button.setBounds(50, 400, 340, 35);
        login_button.setBorder(null);
        login_button.setFocusable(false); // Inside button, box around the text
        login_button.addActionListener(this);



        // Adding defined component to the left_panel
        left_panel.add(login_label);
        left_panel.add(usernamelabel);
        left_panel.add(username_textfield);
        left_panel.add(userline);
        left_panel.add(usernameicon);
        left_panel.add(passwordlabel);
        left_panel.add(password_passwordfield);
        left_panel.add(passwordline);
        left_panel.add(passwordicon);
        left_panel.add(login_button);



        //---------------------------------------------------F R A M E--------------------------------------------------//
        // Adding defined panels in the frame
        frame.add(right_Panel,BorderLayout.EAST);
        frame.add(left_panel,BorderLayout.WEST);

        frame.setVisible(true);
    }



    //---------------------------------------------M O U S E L I S T E N E R--------------------------------------------//
    public void closeclicked(java.awt.event.MouseEvent e)
    {
        System.exit(0);
    }
    public void closeentered(java.awt.event.MouseEvent e)
    {
        close.setForeground(Color.RED);
    }
    public void closeexited(java.awt.event.MouseEvent e)
    {
        close.setForeground(Color.BLACK);
    }


    public void minclicked(java.awt.event.MouseEvent e)
    {
        frame.setExtendedState(1);
    }
    public void minentered(java.awt.event.MouseEvent e)
    {
        min.setForeground(Color.RED);
    }
    public void minexited(java.awt.event.MouseEvent e)
    {
        min.setForeground(Color.BLACK);
    }

    public void passwordiconPressed(java.awt.event.MouseEvent e)
    {
        passwordicon.setIcon(new ImageIcon("lib\\images\\visible.png"));
        password_passwordfield.setEchoChar((char)0);
    }
    public void passwordiconReleased(java.awt.event.MouseEvent e)
    {
        passwordicon.setIcon(new ImageIcon("lib\\images\\invisible.png"));
        password_passwordfield.setEchoChar('•'); //alt+7
    }
    //--------------------------------------------M E S S A G E B O X-------------------------------------------//
    public void messagebox(String h,String c1)
    {
        GradientPanel message_panel = new GradientPanel(new Color(245,245,245),new Color(245,245,245),30);
        
        //GradientButton cancel = new GradientButton(Color.decode("#004FF9"),Color.decode("#56CCF2"));

        JLabel heading = new JLabel();
        JLabel content = new JLabel();
        

        message_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // 
        message_frame.setSize(1920,1080); // message_frame size
        message_frame.setLocationRelativeTo(null);  // display message_frame in center of screen
        message_frame.setUndecorated(true);
        message_frame.setLayout(null);
        //getContentPane().setBackground(new Color(0,0,0));
        message_frame.setIconImage(new ImageIcon("lib\\images\\companylogo.png").getImage());
        message_frame.setBackground(new Color(0.f,0.0f,0.0f,0.6f));

        message_panel.setBounds(750,450, 500, 200);
        message_panel.setOpaque(true);
        message_panel.setLayout(null);
        //message_panel.setBackground(Color.BLACK);//(new Color(1.0f,1.0f,1.0f,0.0f));
        

        messagebox_ok.setBounds(320 ,140, 150, 40);
        messagebox_ok.setBorder(BorderFactory.createEmptyBorder());
        messagebox_ok.setText("OK");
        messagebox_ok.setFont(new Font("Roboto", Font.BOLD, 25));
        messagebox_ok.setForeground(new Color(240,240, 240));
        messagebox_ok.setFocusable(false);
        messagebox_ok.addActionListener(this);

        heading.setBounds(50 , 30, 400, 40);
        heading.setText(h);
        heading.setFont(new Font("Roboto", Font.BOLD, 30));
        heading.setForeground(Color.decode("#004FF9"));

        content.setBounds(50 , 85, 400, 30);
        content.setText(c1);
        content.setFont(new Font("Roboto", Font.PLAIN, 20));
        content.setForeground(Color.BLACK);

        message_panel.add(messagebox_ok);
        message_panel.add(heading);
        message_panel.add(content);

        message_frame.add(message_panel);
        message_frame.setVisible(true);

    }
    //--------------------------------------------D A T A B A S E F U N C T I O N -------------------------------------------//
    public static boolean isValidUser(String UserName,String password){

        String query = "SELECT * FROM login WHERE username = ? AND password = ?";

        try(Connection con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            PreparedStatement statement = con.prepareStatement(query)){

                statement.setString(1, UserName);
                statement.setString(2, password);

                ResultSet result = statement.executeQuery();

                // System.out.println(result.next());

                return result.next();
        }catch(SQLException exp){
            System.out.println(exp);
            return false;
        }
    }

    //--------------------------------------------A C T I O N L I S T E N E R-------------------------------------------//
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == login_button){
            String UserName = username_textfield.getText();
            String password = String.valueOf(password_passwordfield.getPassword());

            if(isValidUser(UserName, password)){
                // open the message box
                messagebox("LOGIN", "You are Logined as Admin");
            }
            else{
                messagebox("LOGIN", "Invalid Username or password");
            }

        }

        if(e.getSource()==messagebox_ok)
        {
            this.frame.dispose();
            message_frame.dispose();
        }
    }
    
    public static void main(String[] args) {
        new LoginPage();
    }
}
