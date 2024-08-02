import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class MessageBox implements ActionListener{
    JFrame message_frame = new JFrame();
    GradientButton messagebox_ok = new GradientButton(Color.decode("#004FF9"),Color.decode("#56CCF2"));

    public MessageBox(String h,String c1){
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



    //--------------------------------------------A C T I O N L I S T E N E R-------------------------------------------//
    @Override
    public void actionPerformed(ActionEvent e)
    {
        
        if(e.getSource()==messagebox_ok)
        {
            message_frame.dispose();
        }
    }
}
