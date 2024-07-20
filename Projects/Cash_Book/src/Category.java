import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Category extends JPanel {

    //-----------------------------------------------G L O B A L----------------------------------------------//

    JPanel Button_Panel = new JPanel();
    JPanel Content_Panel = new JPanel();
    JLabel Context_Heading = new JLabel("Cash IN"); 
    
    public Category(){

        
        setBackground(new Color(206, 230, 243));//new Color(206, 230, 243)
        setBounds(30,130,1440,840);
        setLayout(null);
        setVisible(false);

        // Initilize components 
        

        //----------------------------------------------B U T T O N P A N E L---------------------------------------------//

        // Button Panel
        Button_Panel.setBounds(0, 10, 1442, 250);
        Button_Panel.setBackground(new Color(206, 230, 243));//   new Color(206, 230, 243)
        Button_Panel.setLayout(null);
        Button_Panel.setVisible(false);

        // Initilize components
        GradientPanel Cash_In_Panel = new GradientPanel(Color.decode("#000000"), Color.decode("#004ff9"), 100);
        GradientPanel Cash_Out_Panel = new GradientPanel(Color.decode("#000000"), Color.decode("#26D0CE"), 100);

        JLabel Cash_In_icon = new JLabel();
        JLabel Cash_In_label = new JLabel("CASH IN ");

        JLabel Cash_Out_icon = new JLabel();
        JLabel Cash_Out_label = new JLabel("CASH OUT ");


        // Cash In
        Cash_In_Panel.setBounds(60, 0, 600, 250);
        Cash_In_Panel.setLayout(null);
        Cash_In_icon.setIcon(new ImageIcon("lib\\images\\CategoryPlus.png"));
        Cash_In_icon.setBounds(345, 25, 230, 200);

        Cash_In_label.setFont(new Font("Roboto", Font.BOLD, 50));
        Cash_In_label.setForeground(new Color(240, 240, 240));
        Cash_In_label.setBounds(85, 85, 300, 60);

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

        Cash_Out_Panel.setBounds(775, 0, 600, 250);
        Cash_Out_Panel.setLayout(null);
        Cash_Out_icon.setIcon(new ImageIcon("lib\\images\\CategoryMinus.png"));
        Cash_Out_icon.setBounds(345, 25, 230, 200);

        Cash_Out_label.setFont(new Font("Roboto", Font.BOLD, 50));
        Cash_Out_label.setForeground(new Color(240, 240, 240));
        Cash_Out_label.setBounds(85,85,300, 60);
        
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


        // Addind Cash In & Out in Button Panel
        Button_Panel.add(Cash_In_Panel);
        Button_Panel.add(Cash_Out_Panel);

    

        //----------------------------------------------C O N T E N T P A N E L---------------------------------------------//

        // Content Panel Heading
        Context_Heading.setFont(new Font("Roboto", Font.BOLD, 35));
        Context_Heading.setForeground(new Color(6, 143, 255));
        Context_Heading.setBounds(0, 270, 200, 40);

        // Content Panel
        Content_Panel.setBounds(0, 330, 1440, 505);
        Content_Panel.setBackground(new Color(240, 240, 240));//  new Color(206, 230, 243)
        Content_Panel.setLayout(null);
        Content_Panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        Content_Panel.setVisible(false);


        // Adding Defined Components to the Category Panel
        add(Button_Panel);
        add(Content_Panel);
        add(Context_Heading);


    }


    //--------------------------------------------M O U S E L I S T E N E R-------------------------------------------//


    // Cash In
    public void CashInclicked(java.awt.event.MouseEvent e)
    {
        
    }

    // Cash Out
    public void CashOutclicked(java.awt.event.MouseEvent e)
    {
        
    }



    //--------------------------------------------F U  N C T I O N S-------------------------------------------//

    public void VisibilityCategoty(boolean Visibile){

        // Visibility
        Button_Panel.setVisible(Visibile);
        Context_Heading.setVisible(Visibile);
        Content_Panel.setVisible(Visibile);

    }
}
