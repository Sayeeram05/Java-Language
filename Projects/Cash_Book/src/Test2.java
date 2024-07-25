import java.awt.*;
import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

public class Test2 {
    public static void main(String[] args) {
        // Sample data and column names
        String[][] data = {
            
        };
        String[] columnNames = {"ID", "Name", "Age"};

        // Creating the JTable
        JTable table = new JTable(data, columnNames);

        // Custom header renderer to change font and color
        JTableHeader header = table.getTableHeader();
        header.setDefaultRenderer(new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JLabel label = new JLabel(value.toString());
                label.setFont(new Font("Arial", Font.BOLD, 14)); // Set your desired font
                label.setForeground(Color.decode("#ecf0f1")); // Set your desired font color
                label.setHorizontalAlignment(SwingConstants.CENTER); // Center align the header text
                label.setBackground(Color.decode("#2e86c1")); // Set your desired background color
                label.setOpaque(true); // Necessary for background color to display
                label.setBorder(BorderFactory.createRaisedBevelBorder());
                return label;
            }
        });

        // Setting up the frame
        JFrame frame = new JFrame("Table Header Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JScrollPane(table));
        frame.setSize(400, 200);
        frame.setVisible(true);
    }
}
