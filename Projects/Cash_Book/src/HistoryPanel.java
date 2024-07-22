import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class HistoryPanel extends JPanel{

    
    public HistoryPanel() {

        // Defining Cash In
        setBounds(30, 460, 1440, 505);
        setBackground(Color.BLACK);//   new Color(206 , 230, 243) new Color(240, 240, 240)
        setLayout(null);
        setBorder(BorderFactory.createLineBorder(Color.CYAN, 5));
        setVisible(false);
        
    }


}
