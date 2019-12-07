package View;

import Controller.Stem;
import Model.Employee;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class UserAccounts extends JFrame{
    private JPanel panel1;
    private JTextField uname;
    private JTextField fname;
    private JTextField lname;
    private JTextField email;
    private JTextField padd;
    private JComboBox comboBox1;
    private JButton ADDButton;
    private JButton DELETEButton;
    private JButton UPDATEButton;
    private JButton LISTEMPLOYEESButton;
    private JButton BACKButton;

    public UserAccounts() {
        JFrame frame= new JFrame();
        frame.setTitle("Employees");
        frame.add(panel1);
        frame.pack();
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        ADDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String username = uname.getText();
                    String firstname = fname.getText();
                    String lastname = lname.getText();
                    String eMail = email.getText();
                    String physicalAdd = padd.getText();
                    String type = String.valueOf(comboBox1.getSelectedItem());
                    Employee emp = new Employee(firstname, lastname, username, eMail, physicalAdd);
                    Stem.addEmployeeDetails(emp, type);
                    JOptionPane.showMessageDialog(frame, "Employee Registred!!");

                    uname.setText("");
                    fname.setText("");
                    lname.setText("");
                    email.setText("");
                    padd.setText("");
                    uname.requestFocus();


                }catch (SQLException ex){
                    ex.printStackTrace();
                }
            }
        });
        DELETEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String username = uname.getText();
                    String firstname = fname.getText();
                    String lastname = lname.getText();
                    String eMail = email.getText();
                    String physicalAdd = padd.getText();
                    String type = String.valueOf(comboBox1.getSelectedItem());
                    Stem.deleteEmpDetails(username);

                    JOptionPane.showMessageDialog(frame, "Employee Deleted from records");

                    uname.setText("");
                    fname.setText("");
                    lname.setText("");
                    email.setText("");
                    padd.setText("");
                    uname.requestFocus();

                }catch (SQLException ex){
                    ex.printStackTrace();
                }
            }
        });
        UPDATEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String username = uname.getText();
                    String firstname = fname.getText();
                    String lastname = lname.getText();
                    String eMail = email.getText();
                    String physicalAdd = padd.getText();
                    String type = String.valueOf(comboBox1.getSelectedItem());

                    Stem.updateEmpDetails(username,firstname,lastname,eMail,physicalAdd,type);
                    JOptionPane.showMessageDialog(frame, "Record updated successfully!!");

                    uname.setText("");
                    fname.setText("");
                    lname.setText("");
                    email.setText("");
                    padd.setText("");
                    uname.requestFocus();


                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        LISTEMPLOYEESButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EmployeeAccounts employeeAccounts = new EmployeeAccounts();
                employeeAccounts.setVisible(true);
                frame.setVisible(false);
            }
        });
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
