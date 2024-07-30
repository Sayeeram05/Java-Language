package src;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



class LoginPage implements ActionListener
{

    // Database connection details
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/employee_payroll_system";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "7418022289";

    //use this objects in other function
    JFrame frame;
    JButton login_button;
    JButton clearButton;
    JTextField username_textfield;
    JPasswordField password_passwordfield;
    JComboBox<String> privilege_ComboBox;
    JLabel message;

    // Variable stores the data
    String username ;
    String password;
    String privilege;
    // constructor
    LoginPage()
    {
        // Ojects
        frame = new JFrame();
        JLabel login_label  = new JLabel("LOGIN");
        JLabel username_label = new JLabel("Username");
        JLabel password_label = new JLabel("Password");
        JLabel privilege_label = new JLabel("Privilege");
        username_textfield = new JTextField();
        password_passwordfield = new JPasswordField();
        login_button = new JButton();
        clearButton = new JButton();
        ImageIcon logo = new ImageIcon("lib\\images\\Logo.png");
        JPanel rightPanel = new JPanel();
        message = new JLabel();


        // panel components
        rightPanel.setBackground(Color.WHITE);
        rightPanel.setBounds(400,0,386,450);
        
        
        // login lable components
        login_label.setBounds(140, 55,150,30);
        login_label.setForeground(new Color(0,12,123));
        login_label.setFont(new Font("CENTURY",Font.BOLD,30));


        // username lable components
        username_label.setBounds(35, 130,90,15);
        username_label.setFont(new Font("CENTURY",Font.BOLD,15));


        // username textfield components
        username_textfield.setBounds(150, 125,200,25);
        username_textfield.setFont(new Font("CENTURY",Font.BOLD,15));
        username_textfield.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));


        // password lable components
        password_label.setBounds(35, 180,90,15);
        password_label.setFont(new Font("CENTURY",Font.BOLD,15));


        // password passwordfield components
        password_passwordfield.setBounds(150, 175,200,25);
        password_passwordfield.setFont(new Font("CENTURY",Font.BOLD,15));
        password_passwordfield.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));


        // privilage label
        privilege_label.setBounds(35, 230,90,15);
        privilege_label.setFont(new Font("CENTURY",Font.BOLD,15));


        //privilage combobox 
        String list[] = {"Admin","Employee"};
        privilege_ComboBox = new JComboBox<>(list);
        privilege_ComboBox.setSelectedIndex(0);
        privilege_ComboBox.setBounds(150, 225,200,25);
        

        // login button
        login_button.setText("Login");
        login_button.setBounds(275, 280,75,20);
        login_button.setFocusable(false);
        login_button.setFont(new Font("CENTURY",Font.BOLD,13));
        login_button.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        login_button.addActionListener(this);


        // clear button
        clearButton.setText("Clear");
        clearButton.setBounds(150, 280,75,20);
        clearButton.setFocusable(false);
        clearButton.setFont(new Font("CENTURY",Font.BOLD,13));
        clearButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        clearButton.addActionListener(this);


        // message to show user
        message.setFont(new Font("CENTURY",Font.CENTER_BASELINE,25));
        message.setBounds(120, 330 , 200, 35);
        message.setForeground(Color.BLUE);


        // Logo label in Right palek
        JLabel MainLogo = new JLabel();
        rightPanel.setLayout(null); // to set position using bounds
        MainLogo.setText("GT PRINTS");
        MainLogo.setFont(new Font("CENTURY",Font.BOLD,30));
        MainLogo.setForeground(new Color(0,12,123));
        MainLogo.setIcon(logo);
        MainLogo.setHorizontalTextPosition(JLabel.CENTER);  
        MainLogo.setVerticalTextPosition(JLabel.BOTTOM);
        MainLogo.setIconTextGap(15);
        MainLogo.setBounds(90, 60, 200, 245);

        
        // add Mainlogo lobel in right panel
        rightPanel.add(MainLogo);


        // add other components to the frame
        frame.add(rightPanel);
        frame.add(login_label);
        frame.add(username_label);
        frame.add(username_textfield);
        frame.add(password_label);
        frame.add(password_passwordfield);
        frame.add(privilege_label);
        frame.add(privilege_ComboBox);
        frame.add(login_button);
        frame.add(clearButton);
        frame.add(message);


        // difining frame
        frame.setTitle("Login Page");
        frame.getContentPane().setBackground(new Color(238, 238, 238));
        frame.setIconImage(new ImageIcon("lib\\images\\mainlogo.png").getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,450);
        frame.setResizable(false);;
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.getRootPane().setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY,7));
        frame.setVisible(true);

    }


    // Implemented function in ActionListener
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clearButton) {
            username_textfield.setText("");
            password_passwordfield.setText("");
            privilege_ComboBox.setSelectedIndex(0);
        }

        if (e.getSource() == login_button) {
            username = username_textfield.getText();
            password = String.valueOf(password_passwordfield.getPassword());
            privilege = String.valueOf(privilege_ComboBox.getSelectedItem());

            if (authenticateUser(username, password, privilege)) {
                if (privilege.equals("Admin")) 
                {
                    // lable for icon
                    JLabel sucessicon = new JLabel();
                    // icon location
                    sucessicon.setIcon(new ImageIcon("lib\\images\\sucess.png"));

                    // labele for message
                    JLabel sucessmessage = new JLabel("Admin Login Sucessful");
                    sucessmessage.setFont(new Font("CENTURY",Font.BOLD,15));

                    // panel to place icon and message
                    JPanel panel = new JPanel();
                    panel.setLayout(new FlowLayout());
                    panel.add(sucessicon);
                    panel.add(sucessmessage);
                    
                    // open the message box
                    JOptionPane.showMessageDialog(null,panel,"ADMIN LOGIN",JOptionPane.PLAIN_MESSAGE);

                    frame.dispose(); // Close the login page
                    //new AdminPage(); // Open the admin page
                } 

                else if (privilege.equals("Employee")) 
                {
                    // lable for icon
                    JLabel sucessicon = new JLabel();
                    // icon location
                    sucessicon.setIcon(new ImageIcon("lib\\images\\sucess.png"));

                    // labele for message
                    JLabel sucessmessage = new JLabel("Employee Login Sucessful");
                    sucessmessage.setFont(new Font("CENTURY",Font.BOLD,15));

                    // panel to place icon and message
                    JPanel panel = new JPanel();
                    panel.setLayout(new FlowLayout());
                    panel.add(sucessicon);
                    panel.add(sucessmessage);
                    
                    // open the message box
                    JOptionPane.showMessageDialog(null,panel,"EMPLOYEE LOGIN",JOptionPane.PLAIN_MESSAGE);
                    
                    frame.dispose(); // Close the login page
                    //new EmployeePage(); // Open the user dashboard with the given username
                }
            } 
            else 
            {
                // lable for icon
                JLabel wrongicon = new JLabel();
                // icon location
                wrongicon.setIcon(new ImageIcon("lib\\images\\wrong.png"));

                // labele for message
                JLabel wrongmessage = new JLabel("Login Failed. Invalid username, password, or privilege.");
                wrongmessage.setFont(new Font("CENTURY",Font.BOLD,15));

                // panel to place icon and message
                JPanel panel = new JPanel();
                panel.setLayout(new FlowLayout());
                panel.add(wrongicon);
                panel.add(wrongmessage);
                
                // open the message box
                JOptionPane.showMessageDialog(null,panel,"LOGIN FAILED",JOptionPane.DEFAULT_OPTION);
                username_textfield.setText("");
                password_passwordfield.setText("");
            }
        }
    }

    private boolean authenticateUser(String username, String password, String privilege) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            String query = "SELECT * FROM login WHERE username = ? AND password = ? AND privilege = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, privilege);

            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet.next();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}