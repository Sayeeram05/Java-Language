import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Category extends JPanel implements ActionListener, Runnable{

    //-----------------------------------------------G L O B A L----------------------------------------------//

    JPanel Button_Panel = new JPanel();
    JPanel Content_Panel = new JPanel();
    JLabel Context_Heading = new JLabel("CATEGORY"); 
    JLabel CashInTitle = new JLabel(" CASH IN ");
    JLabel CashOutTitle = new JLabel(" CASH OUT ");

    JTextField DataValue = new JTextField();
    GradientButton DataButton = new GradientButton(Color.decode("#283048"), Color.decode("#859398"));

    JPanel CategoryDataPanel = new JPanel();

    Animation WhiteScreen = new Animation();

    public void run(){  // It Will run when thread starts
        WhiteScreen.StartAnimation(600);
    }

    
    public Category(){

        
        setBackground(new Color(206, 230, 243));//new Color(206, 230, 243) 
        setBounds(30,80,1440,890);
        setLayout(null);
        setVisible(false);

        // Initilize components
        JPanel CashInPanel = new JPanel(); 
        JPanel CashOutPanel = new JPanel();
        

        //----------------------------------------------B U T T O N P A N E L---------------------------------------------//

        // Button Panel
        Button_Panel.setBounds(0, 50, 1442, 250);
        Button_Panel.setBackground(new Color(206, 230, 243));//   new Color(206, 230, 243) new Color(206, 230, 243)
        Button_Panel.setLayout(null);
        Button_Panel.setVisible(false);

        // Initilize components
        GradientPanel CashInAddPanel = new GradientPanel(Color.decode("#000000"), Color.decode("#004ff9"), 50);
        JLabel CashInAddIcon = new JLabel();
        JLabel CashInAddLabel = new JLabel("ADD");
        GradientPanel CashInRemovePanel = new GradientPanel(Color.decode("#000000"), Color.decode("#26D0CE"), 50);
        JLabel CashInRemoveIcon = new JLabel();
        JLabel CashInRemoveLabel = new JLabel("REMOVE");

        GradientPanel CashOutAddPanel = new GradientPanel(Color.decode("#000000"), Color.decode("#004ff9"), 50);
        JLabel CashOutAddIcon = new JLabel();
        JLabel CashOutAddLabel = new JLabel("ADD");
        GradientPanel CashOutRemovePanel = new GradientPanel(Color.decode("#000000"), Color.decode("#26D0CE"), 50);
        JLabel CashOutRemoveIcon = new JLabel();
        JLabel CashOutRemoveLabel = new JLabel("REMOVE");
        

        //----------------------------------------------C A S H I N P A N E L---------------------------------------------//

        // Cash In Title
        CashInTitle.setFont(new Font("Roboto", Font.BOLD, 35));
        CashInTitle.setForeground(new Color(6, 143, 255));
        CashInTitle.setBounds(0, 0, 200, 65);
        CashInTitle.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        
        // Cash In Panel
        CashInPanel.setBounds(0,10,700,230);
        CashInPanel.setBackground(new Color(206, 230, 243));
        CashInPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        CashInPanel.setLayout(null);

        // Cash In Add
        CashInAddPanel.setBounds(25, 25, 310, 180);
        CashInAddPanel.setLayout(null);
        CashInAddIcon.setIcon(new ImageIcon("lib\\images\\PlusIcon.png"));
        CashInAddIcon.setBounds(170, 40, 100, 100);

        CashInAddLabel.setFont(new Font("Roboto", Font.BOLD, 30));
        CashInAddLabel.setForeground(new Color(240, 240, 240));
        CashInAddLabel.setBounds(25, 40, 200, 30);

        // After Clicked Cash In Add
        CashInAddPanel.addMouseListener(new java.awt.event.MouseAdapter() 
        {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e)
            {
                CashInAddclicked(e);
            }
        });

        // Adding Components in the CashInAddPanel
        CashInAddPanel.add(CashInAddLabel);
        CashInAddPanel.add(CashInAddIcon);

        // Cash In Remove
        CashInRemovePanel.setBounds(360, 25, 310, 180);
        CashInRemovePanel.setLayout(null);
        CashInRemoveIcon.setIcon(new ImageIcon("lib\\images\\MinusIcon.png"));
        CashInRemoveIcon.setBounds(170, 40, 100, 100);

        CashInRemoveLabel.setFont(new Font("Roboto", Font.BOLD, 30));
        CashInRemoveLabel.setForeground(new Color(240, 240, 240));
        CashInRemoveLabel.setBounds(25, 40, 200, 30);

        // After Clicked Cash In Remove
        CashInRemovePanel.addMouseListener(new java.awt.event.MouseAdapter() 
        {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e)
            {
                CashInRemoveclicked(e);
            }
        });


        // Adding Components in the CashInRemovePanel
        CashInRemovePanel.add(CashInRemoveLabel);
        CashInRemovePanel.add(CashInRemoveIcon);


        // Addind components in CashIn Panel
        CashInPanel.add(CashInAddPanel);
        CashInPanel.add(CashInRemovePanel);

        //----------------------------------------------C A S H O U T P A N E L---------------------------------------------//

        // Cash Out Title
        CashOutTitle.setFont(new Font("Roboto", Font.BOLD, 35));
        CashOutTitle.setForeground(new Color(6, 143, 255));
        CashOutTitle.setBounds(740, 0, 210, 65);
        CashOutTitle.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));

        // Cash Out Panel
        CashOutPanel.setBounds(740,10,700,230);
        CashOutPanel.setBackground(new Color(206, 230, 243));
        CashOutPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        CashOutPanel.setLayout(null);

        // Cash Out Add
        CashOutAddPanel.setBounds(25, 25, 310, 180);
        CashOutAddPanel.setLayout(null);
        CashOutAddIcon.setIcon(new ImageIcon("lib\\images\\PlusIcon.png"));
        CashOutAddIcon.setBounds(170, 40, 100, 100);

        CashOutAddLabel.setFont(new Font("Roboto", Font.BOLD, 30));
        CashOutAddLabel.setForeground(new Color(240, 240, 240));
        CashOutAddLabel.setBounds(25, 40, 200, 30);

        // After Clicked Cash Out Add
        CashOutAddPanel.addMouseListener(new java.awt.event.MouseAdapter() 
        {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e)
            {
                CashOutAddclicked(e);
            }
        });

        // Adding components in the CashOut Add
        CashOutAddPanel.add(CashOutAddIcon);
        CashOutAddPanel.add(CashOutAddLabel);


        // Cash Out Remove
        CashOutRemovePanel.setBounds(360, 25, 310, 180);
        CashOutRemovePanel.setLayout(null);
        CashOutRemoveIcon.setIcon(new ImageIcon("lib\\images\\MinusIcon.png"));
        CashOutRemoveIcon.setBounds(170, 40, 100, 100);

        CashOutRemoveLabel.setFont(new Font("Roboto", Font.BOLD, 30));
        CashOutRemoveLabel.setForeground(new Color(240, 240, 240));
        CashOutRemoveLabel.setBounds(25, 40, 200, 30);

        // After Clicked Cash Out Remove
        CashOutRemovePanel.addMouseListener(new java.awt.event.MouseAdapter() 
        {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e)
            {
                CashOutRemoveclicked(e);
            }
        });

        // Adding components in the CashOut Remove
        CashOutRemovePanel.add(CashOutRemoveIcon);
        CashOutRemovePanel.add(CashOutRemoveLabel);


        // Addind components in CashOut Panel
        CashOutPanel.add(CashOutAddPanel);
        CashOutPanel.add(CashOutRemovePanel);


        // Addind Cash In & Out in Button Panel
        Button_Panel.add(CashInPanel);
        Button_Panel.add(CashOutPanel);
        


        //----------------------------------------------C O N T E N T P A N E L---------------------------------------------//
        // Initilizing Components
        JLabel DataLabel = new JLabel("CATEGORY");


        // Content Panel Heading
        Context_Heading.setFont(new Font("Roboto", Font.BOLD, 35));
        Context_Heading.setForeground(new Color(6, 143, 255));
        Context_Heading.setBounds(0, 320, 500, 40);

        // Content Panel
        Content_Panel.setBounds(0, 380, 1440, 505);
        Content_Panel.setBackground(new Color(240, 240, 240));//  new Color(206, 230, 243)
        Content_Panel.setLayout(null);
        Content_Panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        Content_Panel.setVisible(false);

        //----------------------------------------------C A S H I N---------------------------------------------//

        // Defining Category Data Panel
        CategoryDataPanel.setBounds(0,0,1440, 75);
        CategoryDataPanel.setBackground(Color.decode("#0779E4"));// new Color(240, 240, 240) new Color(206 , 230, 243)
        CategoryDataPanel.setLayout(null);
        CategoryDataPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        CategoryDataPanel.setVisible(false);

        // Data Label
        DataLabel.setFont(new Font("Roboto", Font.BOLD, 30));
        DataLabel.setBounds(250, 12, 220,50);
        DataLabel.setForeground(Color.BLACK);

        // Data Value
        DataValue.setBounds(450, 15, 500, 45);
        DataValue.setBorder(BorderFactory.createLoweredBevelBorder());
        DataValue.setFont(new Font("Roboto", Font.BOLD, 30));
        DataValue.setForeground(Color.decode("#004FF9"));

        // Data Button
        DataButton.setBounds(1000, 15, 250, 45);
        DataButton.setBorder(BorderFactory.createEmptyBorder());
        DataButton.setText("CATEGORY");
        DataButton.setFont(new Font("Roboto", Font.BOLD, 30));
        DataButton.setForeground(new Color(240, 240, 240));
        DataButton.setFocusable(false);
        DataButton.addActionListener(this);
        

        // Adding Components in Category Data Panel
        CategoryDataPanel.add(DataLabel);
        CategoryDataPanel.add(DataValue);
        CategoryDataPanel.add(DataButton);

        // Adding Compnents in Content Panel
        Content_Panel.add(CategoryDataPanel);

        // Adding Defined Components to the Category Panel
        add(CashInTitle);
        add(CashOutTitle);
        add(Button_Panel);
        add(Content_Panel);
        add(Context_Heading);


    }


    //--------------------------------------------M O U S E L I S T E N E R-------------------------------------------//

    // Cash In Add
    public void CashInAddclicked(java.awt.event.MouseEvent e)
    {
        new Thread(this).start();
        
        Context_Heading.setText("CASH IN - ADD");
        DataButton.setText("ADD");

        CategoryDataPanel.setVisible(true);

    }
    // Cash In Remove
    public void CashInRemoveclicked(java.awt.event.MouseEvent e)
    {
        new Thread(this).start();

        Context_Heading.setText("CASH IN - REMOVE");
        DataButton.setText("REMOVE");

        CategoryDataPanel.setVisible(true);


    }

    // Cash Out Add
    public void CashOutAddclicked(java.awt.event.MouseEvent e)
    {
        new Thread(this).start();

        Context_Heading.setText("CASH OUT - ADD");
        DataButton.setText("ADD");

        CategoryDataPanel.setVisible(true);
    }
    // Cash Out Remove
    public void CashOutRemoveclicked(java.awt.event.MouseEvent e)
    {
        new Thread(this).start();

        Context_Heading.setText("CASH OUT - REMOVE");
        DataButton.setText("REMOVE");

        CategoryDataPanel.setVisible(true);
    }

    //--------------------------------------------A C T I O N L I S T E N E R-------------------------------------------//
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == DataButton){
            String ButtonName = Context_Heading.getText();
            if(ButtonName.equals("CASH IN - ADD")){
                System.out.println("CASH IN - ADD");
            }
            else if (ButtonName.equals("CASH IN - REMOVE")) {
                System.out.println("CASH IN - REMOVE");
            }
            else if (ButtonName.equals("CASH OUT - ADD")) {
                System.out.println("CASH OUT - ADD");
            }else if (ButtonName.equals("CASH OUT - REMOVE")) {
                System.out.println("CASH OUT - REMOVE");
            }
        }
    }




    //--------------------------------------------F U  N C T I O N S-------------------------------------------//

    public void VisibilityCategoty(boolean Visibile){

        // Visibility
        Button_Panel.setVisible(Visibile);
        Context_Heading.setVisible(Visibile);
        Content_Panel.setVisible(Visibile);
        CashInTitle.setVisible(Visibile);
        CashOutTitle.setVisible(Visibile);

    }


    public void VisibilityDataPanel(boolean Visibile){
    
    }
}
