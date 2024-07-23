import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Animation {
    JFrame AnimationFrame = new JFrame();
    
    public Animation(){

        AnimationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // 
        AnimationFrame.setSize(1800,1000); // AnimationFrame size
        AnimationFrame.setLocationRelativeTo(null);  // display AnimationFrame in center of screen
        AnimationFrame.setUndecorated(true);
        AnimationFrame.setLayout(null);
        AnimationFrame.setIconImage(new ImageIcon("lib\\images\\companylogo.png").getImage());
        AnimationFrame.setBackground(new Color(0.0f,0.0f,0.0f,0.5f));

    }

    public void StartAnimation(int Max){
        int Time = 0;
        while(Time < Max){
            AnimationFrame.setVisible(true);
            Time += 1;
        }
        AnimationFrame.dispose();
    }
    
}
