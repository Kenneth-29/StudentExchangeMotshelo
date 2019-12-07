package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Loans extends JFrame{
    private JPanel panel1;
    private JTable table1;
    private JButton BACKButton;

    public Loans() throws HeadlessException {
        JFrame frame= new JFrame();
        frame.setTitle("Loans");
        frame.add(panel1);
        frame.pack();
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        BACKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminHome adminHome = new AdminHome();
                adminHome.setVisible(true);
                frame.setVisible(false);
            }
        });
    }
}
