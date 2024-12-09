import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class GUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Super Pet Simulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setBackground(java.awt.Color.WHITE);
        frame.add(panel, BorderLayout.CENTER);
        frame.setSize(1920, 1080);
        frame.setVisible(true);
    }
}
