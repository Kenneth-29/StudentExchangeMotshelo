package View;

import javax.swing.*;
import java.awt.*;

public class CustomerHome extends JFrame {
    private JPanel panel1;

    public CustomerHome() throws HeadlessException {
        JFrame frame= new JFrame();
        frame.setTitle("CustomerHome");
        frame.add(panel1);
        frame.pack();
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
