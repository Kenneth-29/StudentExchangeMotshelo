package View;

import Controller.Stem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeLogIn extends JFrame {
    private JTextField usernameTextField;
    private JButton logInButton;
    private JComboBox comboBox1;
    private JPanel panel1;
    private JPasswordField passwordField;
    ResultSet rs = null;

    public EmployeeLogIn() {
        JFrame frame= new JFrame();
        frame.setTitle("EmpLogin");
        frame.add(panel1);
        frame.pack();
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameTextField.getText();
                String password = passwordField.getText();
                String type = String.valueOf(comboBox1.getSelectedItem());

                try {
                    rs = Stem.loginUser(username, password, type);

                    if(rs.next()){
                       if(comboBox1.getSelectedIndex()==0){
                          AdminHome aH = new AdminHome();
                          aH.setVisible(true);
                          frame.setVisible(false);
                       }else{
                          EmployeeHome eH = new EmployeeHome();
                          eH.setVisible(true);
                          frame.setVisible(false);
                       }
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
