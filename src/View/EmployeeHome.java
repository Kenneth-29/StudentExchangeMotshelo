package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeHome extends JFrame{
    private JButton registerCustomerButton;
    private JButton facilitateLoanButton;
    private JButton logOffButton;
    private JPanel panel1;

    public EmployeeHome() {
        JFrame frame= new JFrame();
        frame.setTitle("EmpHome");
        frame.add(panel1);
        frame.pack();
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        registerCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegisterCustomer registerCustomer = new RegisterCustomer();
                registerCustomer.setVisible(true);
                frame.setVisible(false);
            }
        });
        facilitateLoanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FacilitateLoan facilitateLoan = new FacilitateLoan();
                facilitateLoan.setVisible(true);
                frame.setVisible(false);
            }
        });
    }
}
