package View;

import javax.swing.*;
import java.awt.*;

public class FacilitateLoan extends JFrame{
    private JButton proceedButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JPanel panel1;

    public FacilitateLoan() throws HeadlessException {
        JFrame frame= new JFrame();
        frame.setTitle("Facilitating A Loan");
        frame.add(panel1);
        frame.pack();
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
