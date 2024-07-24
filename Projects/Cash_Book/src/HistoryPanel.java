import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class HistoryPanel extends JPanel{

    
    public HistoryPanel() {

        // Defining Cash In
        setBounds(0, 0, 1440, 505);
        setBackground(new Color(240, 240, 240));//  new Color(206 , 230, 243) 
        setLayout(null);
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        setVisible(false);
        
    }


}
