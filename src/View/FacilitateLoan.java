package View;

import Controller.Stem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;

public class FacilitateLoan extends JFrame{
    private JButton ADDButton;
    private JTextField cusNum;
    private JTextField fname;
    private JTextField sName;
    private JTextField loanAmt;
    private JTextField dat;
    private JTextField daysdue;
    private JTextField cellNum;
    private JTextField stat;
    private JPanel panel1;
    private JButton VIEWLOANSButton;
    private JButton BACKButton;

    public FacilitateLoan() throws HeadlessException {
        JFrame frame= new JFrame();
        frame.setTitle("Facilitating A Loan");
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
        ADDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int customerNumber = Integer.parseInt(cusNum.getText());
                    String firstName = fname.getText();
                    String lastName = sName.getText();
                    Double loanAmount = Double.valueOf(loanAmt.getText());
                    Date date = Date.valueOf(dat.getText());
                    int daysDue = Integer.parseInt(daysdue.getText());
                    int cellNumber = Integer.parseInt(cellNum.getText());
                    String status = stat.getText();
                    Stem.faciliateLoan(customerNumber, firstName, lastName, loanAmount, date, daysDue, cellNumber, status);
                    JOptionPane.showMessageDialog(frame, "Loan Administered!!");
                    cusNum.setText("");
                    fname.setText("");
                    sName.setText("");
                    loanAmt.setText("");
                    dat.setText("yyyy-mm-dd");
                    daysdue.setText("");
                    cellNum.setText("");
                    stat.setText("");
                    cusNum.requestFocus();



                }catch (SQLException ex){
                    ex.printStackTrace();
                }
            }
        });

        VIEWLOANSButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoansEmp loansEmp = new LoansEmp();
                loansEmp.setVisible(true);
                frame.setVisible(false);
            }
        });
    }
}
