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
    private JButton backButton;
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
                        JOptionPane.showMessageDialog(frame, "Login successful, you are logged in as " + rs.getString("type") +" User");
                       if(comboBox1.getSelectedIndex()==0){

                           EmployeeHome eH = new EmployeeHome();
                           eH.setVisible(true);
                           frame.setVisible(false);
                       }else if (comboBox1.getSelectedIndex()==1){
                           AdminHome aH = new AdminHome();
                           aH.setVisible(true);
                           frame.setVisible(false);
                       }
                    }else{
                        JOptionPane.showMessageDialog(frame,"username or password is incorrect, please enter the correct details" );
                    }
                } catch (SQLException ex) {
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
}
