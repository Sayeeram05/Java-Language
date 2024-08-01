import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class DeletePanel extends JPanel implements Runnable{

    GradientPanel Cash_In_Panel = new GradientPanel(Color.decode("#000000"), Color.decode("#004ff9"), 75);
    GradientPanel Cash_Out_Panel = new GradientPanel(Color.decode("#0c0014"), Color.decode("#0779E4"), 75);
    GradientPanel Transaction_Panel = new GradientPanel(Color.decode("#1A2980"), Color.decode("#26D0CE"), 75);

    Animation WhiteScreen = new Animation();

    JLabel Context_Heading = new JLabel("HOME TABEL");

    DeleteTable Table = new DeleteTable("cashin");
    
    //-----------------------------------------------T H R E A D----------------------------------------------//

    public void run(){  // It Will run when thread starts
        WhiteScreen.StartAnimation(600);
    }

    public DeletePanel() {

        setBackground(new Color(206, 230, 243));//new Color(206, 230, 243) new Color(206, 230, 243)
        setBounds(30,80,1440,890);
        setLayout(null);
        setVisible(false);

        JLabel Button_Panel_Title = new JLabel();
        JPanel Button_Panel = new JPanel();

        JLabel Cash_In_icon = new JLabel();
        JLabel Cash_In_label = new JLabel("CASH IN ");

        JLabel Cash_Out_icon = new JLabel();
        JLabel Cash_Out_label = new JLabel("CASH OUT ");

        JLabel Transaction_icon = new JLabel();
        JLabel Transaction_label = new JLabel("HISTORY ");



        //----------------------------------------------B U T T O N P A N E L---------------------------------------------//

        // Button Panel Title
        Button_Panel_Title.setText("DELETE");
        Button_Panel_Title.setFont(new Font("Roboto", Font.BOLD, 35));
        Button_Panel_Title.setForeground(new Color(6, 143, 255));
        Button_Panel_Title.setBounds(0, 0, 200, 40);

        // Button Panel
        Button_Panel.setBounds(0, 50, 1440, 220);
        Button_Panel.setBackground(new Color(206, 230, 243));// new Color(240, 240, 240)
        Button_Panel.setLayout(null);

        // Cash In
        Cash_In_Panel.setBounds(0, 10, 400, 200);
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

        Cash_Out_Panel.setBounds(520, 10, 400, 200);
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
        Transaction_Panel.setBounds(1040, 10, 400, 200);
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
        Context_Heading.setBounds(0, 320, 500, 40);






        add(Button_Panel_Title);
        add(Button_Panel);
        add(Context_Heading);
        add(Table);
    }


    // Cash In
    public void CashInclicked(java.awt.event.MouseEvent e)
    {
        new Thread(this).start();
        Context_Heading.setText("CASH IN");

        remove(Table);
        Table = new DeleteTable("cashin");
        add(Table);

    }


    // Cash Out
    public void CashOutclicked(java.awt.event.MouseEvent e)
    {
        new Thread(this).start();

        Context_Heading.setText("CASH OUT");

        remove(Table);
        Table = new DeleteTable("cashout");
        add(Table);

    }


    // History
    public void Historyclicked(java.awt.event.MouseEvent e)
    {
        new Thread(this).start();
        
        Context_Heading.setText("HISTORY");

        remove(Table);
        Table = new DeleteTable("history");
        add(Table);

    }
    

    
}
