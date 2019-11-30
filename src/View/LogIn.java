package View;

import Controller.Stem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogIn extends JFrame{
    private JPanel panel1;
    private JComboBox LogComboBox1;
    private JButton continueButton;
    private Stem stem;

    public LogIn() throws HeadlessException {
        this.stem = stem;
        JFrame frame= new JFrame();
        frame.setTitle("LogIn to STEM");
        frame.add(panel1);
        frame.pack();
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(LogComboBox1.getSelectedIndex()==0) {
                    EmployeeLogIn eL = new EmployeeLogIn();
                    eL.setVisible(true);
                    frame.setVisible(false);

                }
                else{
                    CustomerLogIn cL = new CustomerLogIn();
                    cL.setVisible(true);
                    frame.setVisible(false);
                }
            }
        });
    }

    /*public static void main(String[] args) {
        JFrame frame = new JFrame("LogIn");
        frame.setContentPane(new LogIn().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogIn().setVisible(true);
            }
        });
    }*/
}
