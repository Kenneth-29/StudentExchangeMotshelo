package View;

import javax.swing.*;

public class RegisterCustomer extends JFrame {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JPasswordField passwordField1;
    private JButton ADDCUSTOMERButton;
    private JPanel panel1;

    public RegisterCustomer() {
        JFrame frame= new JFrame();
        frame.setTitle("EmpLogin");
        frame.add(panel1);
        frame.pack();
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
