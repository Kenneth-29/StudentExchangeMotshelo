package View;

import Controller.Stem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerLogIn extends JFrame {
    private JPanel panel1;
    private javax.swing.JTextField CustomerNumTextField;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JButton logInButton;
    private JButton backButton;
    ResultSet rs = null;



    public CustomerLogIn() throws HeadlessException {
        JFrame frame= new JFrame();
        frame.setTitle("CustomerLogin");
        frame.add(panel1);
        frame.pack();
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int customerNumber = Integer.parseInt(CustomerNumTextField.getText());
                String password = passwordField.getText();

                try{
                    rs= Stem.loginCustomers(customerNumber, password);
                    if(rs.next()){
                        JOptionPane.showMessageDialog(frame, "Login Successful");
                        CustomerHome cH = new CustomerHome();
                        cH.setVisible(true);
                        frame.setVisible(false);
                    }else{
                        JOptionPane.showMessageDialog(frame, "Login Failed, please check your Customer Number and Password then try again" +
                                " or contact admin");
                    }
                }catch(SQLException ex)
                {
                    ex.printStackTrace();
                }
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LogIn logIn = new LogIn();
                logIn.setVisible(true);
                frame.setVisible(false);
            }
        });
    }
    /*public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerLogIn().setVisible(true);
            }
        });
    }*/
}
