package View;

import Controller.Stem;
import Model.Customer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;

public class RegisterCustomer extends JFrame {
    private JTextField cusNum;
    private JTextField fName;
    private JTextField lName;
    private JTextField regDate;
    private JPasswordField pass;
    private JButton ADDCUSTOMERButton;
    private JPanel panel1;
    private JButton UPDATEButton;
    private JButton DELETEButton;
    private JButton LISTCUSTOMERSButton;
    private JButton BACKButton;

    public RegisterCustomer() {
        JFrame frame= new JFrame();
        frame.setTitle("EmpLogin");
        frame.add(panel1);
        frame.pack();
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        BACKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EmployeeHome employeeHome = new EmployeeHome();
                employeeHome.setVisible(true);
                frame.setVisible(false);
            }
        });
        ADDCUSTOMERButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               try{
                   int customerNumber = Integer.parseInt(cusNum.getText());
                   String firstname = fName.getText();
                   String lastname = lName.getText();
                   Date date = Date.valueOf(regDate.getText());
                   String password = pass.getText();
                   Customer customer = new Customer(firstname, lastname, customerNumber, date);
                   Stem.addCustomerDetails(customer);

                   JOptionPane.showMessageDialog(frame, "Customer Registered!!");

                   cusNum.setText("");
                   fName.setText("");
                   lName.setText("");
                   regDate.setText("yyyy-mm-dd");
                   pass.setText("");
                   cusNum.requestFocus();


               }catch (SQLException ex){
                   ex.printStackTrace();
               }
            }
        });
        UPDATEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int customerNumber = Integer.parseInt(cusNum.getText());
                    String firstname = fName.getText();
                    String lastname = lName.getText();
                    Date date = Date.valueOf(regDate.getText());
                    String password = pass.getText();
                    Stem.updateCustomerDetails(customerNumber,firstname,lastname,date);
                    JOptionPane.showMessageDialog(frame, "Record Updated Successfully!");

                    cusNum.setText("");
                    fName.setText("");
                    lName.setText("");
                    regDate.setText("yyyy-mm-dd");
                    pass.setText("");
                    cusNum.requestFocus();

                }catch (SQLException ex){
                    ex.printStackTrace();
                }
            }
        });
        DELETEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int customerNumber = Integer.parseInt(cusNum.getText());

                    Stem.deleteCustomerDetails(customerNumber);
                }catch (SQLException ex){
                    ex.printStackTrace();
                }
            }
        });
        LISTCUSTOMERSButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Customers cus = new Customers();
                cus.setVisible(true);

            }
        });
    }
}
