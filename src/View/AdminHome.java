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
                UserAccounts userAccounts = new UserAccounts();
                userAccounts.setVisible(true);
                frame.setVisible(false);
            }
        });
        VIEWLOANSButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Loans loans = new Loans();
                loans.setVisible(true);
                frame.setVisible(false);
            }
        });
        CUSTOMERACCOUNTSButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CustomerAccounts customerAccounts = new CustomerAccounts();
                customerAccounts.setVisible(true);
                frame.setVisible(false);
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
