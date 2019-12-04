package View;

import javax.swing.*;
import java.awt.*;

public class AdminHome extends JFrame{
    private JButton USERACCOUNTSButton;
    private JButton VIEWLOANSButton;
    private JButton CUSTOMERACCOUNTSButton;
    private JPanel panel1;

    public AdminHome() throws HeadlessException {
        JFrame frame= new JFrame();
        frame.setTitle("ADMIN PANEL");
        frame.add(panel1);
        frame.pack();
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
