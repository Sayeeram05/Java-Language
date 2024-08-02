import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PrintMessage implements ActionListener {
    JFrame message_frame = new JFrame();
    GradientButton PrintButton = new GradientButton(Color.decode("#004FF9"),Color.decode("#56CCF2"));
    GradientButton CancelButton = new GradientButton(Color.decode("#283048"), Color.decode("#859398"));

    JLabel FilePathLabel = new JLabel();


    public PrintMessage(){
        GradientPanel message_panel = new GradientPanel(Color.decode("#d6dbdf"),Color.decode("#d6dbdf"),30);
        
        //GradientButton cancel = new GradientButton(Color.decode("#004FF9"),Color.decode("#56CCF2"));

        JLabel heading = new JLabel();
        JLabel content = new JLabel();
        

        message_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // 
        message_frame.setSize(1920,1080); // message_frame size
        message_frame.setLocationRelativeTo(null);  // display message_frame in center of screen
        message_frame.setUndecorated(true);
        message_frame.setLayout(null);
        //getContentPane().setBackground(new Color(0,0,0));
        message_frame.setIconImage(new ImageIcon("lib\\images\\App_Icon.png").getImage());
        message_frame.setBackground(new Color(0.f,0.0f,0.0f,0.6f));

        message_panel.setBounds(620,450, 700, 200);
        message_panel.setOpaque(false);
        message_panel.setLayout(null);
        

        PrintButton.setBounds(492 ,140, 150, 40);
        PrintButton.setBorder(BorderFactory.createEmptyBorder());
        PrintButton.setText("PRINT");
        PrintButton.setFont(new Font("Roboto", Font.BOLD, 25));
        PrintButton.setForeground(new Color(240,240, 240));
        PrintButton.setFocusable(false);
        PrintButton.addActionListener(this);

        // Data Button
        CancelButton.setBounds(300, 140, 150, 40);
        CancelButton.setBorder(BorderFactory.createEmptyBorder());
        CancelButton.setText("CANCEL");
        CancelButton.setFont(new Font("Roboto", Font.BOLD, 25));
        CancelButton.setForeground(new Color(240, 240, 240));
        CancelButton.setFocusable(false);
        CancelButton.addActionListener(this);

        heading.setBounds(50 , 20, 400, 40);
        heading.setText("REPORT");
        heading.setFont(new Font("Roboto", Font.BOLD, 30));
        heading.setForeground(Color.decode("#004FF9"));

        content.setBounds(50 , 80, 200, 30);
        content.setText("FILE PATH");
        content.setFont(new Font("Roboto", Font.BOLD, 20));
        content.setForeground(Color.BLACK);

        FilePathLabel.setBounds(170 , 80, 470, 30);
        FilePathLabel.setText("");
        FilePathLabel.setFont(new Font("Roboto", Font.BOLD, 16));
        FilePathLabel.setForeground(Color.BLUE);
        FilePathLabel.setOpaque(true);
        FilePathLabel.setBorder(BorderFactory.createLoweredBevelBorder());
        FilePathLabel.setBackground(Color.decode("#fdfefe"));
        FilePathLabel.addMouseListener(new java.awt.event.MouseAdapter() 
        {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e)
            {
                FilePathLabelclicked(e);
            }
        });

        message_panel.add(PrintButton);
        message_panel.add(CancelButton);
        message_panel.add(heading);
        message_panel.add(content);
        message_panel.add(FilePathLabel);

        message_frame.add(message_panel);
        message_frame.setVisible(true);
    }



    //--------------------------------------------A C T I O N L I S T E N E R-------------------------------------------//
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==PrintButton)
        {
            String Path = FilePathLabel.getText();
            if(Path.isEmpty()){
                message_frame.dispose();
                new MessageBox("REPORT", "PLEASE SELECT THE FOLDER");
            }
        }
        if(e.getSource() == CancelButton){
            message_frame.dispose();
        }
    }

    public static void main(String[] args) {
        new PrintMessage();
    }


    public void FilePathLabelclicked(java.awt.event.MouseEvent e)
    {
        JFileChooser folderChooser = new JFileChooser();
        folderChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnValue = folderChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFolder = folderChooser.getSelectedFile();
            FilePathLabel.setText(selectedFolder.getAbsolutePath());
        } else {
            FilePathLabel.setText("");
        }
    }

    
}
