package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminHome extends JFrame{
    private JButton USERACCOUNTSButton;
    private JButton VIEWLOANSButton;
    private JButton CUSTOMERACCOUNTSButton;
    private JPanel panel1;
    private JButton LOGOFFButton;

    public AdminHome() throws HeadlessException {
        JFrame frame= new JFrame();
        frame.setTitle("ADMIN PANEL");
        frame.add(panel1);
        frame.pack();
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        USERACCOUNTSButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        VIEWLOANSButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        CUSTOMERACCOUNTSButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        LOGOFFButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Logged out!! Enter Username and password to log in again");
                EmployeeLogIn employeeLogIn = new EmployeeLogIn();
                employeeLogIn.setVisible(true);
                frame.setVisible(false);
            }
        });
    }
}
