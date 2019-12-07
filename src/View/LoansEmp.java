package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoansEmp extends JFrame{
    private JTable table1;
    private JButton BACKButton;
    private JPanel panel1;

    public LoansEmp() throws HeadlessException {
        JFrame frame= new JFrame();
        frame.setTitle("Loans");
        frame.add(panel1);
        frame.pack();
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        BACKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FacilitateLoan fL = new FacilitateLoan();
                fL.setVisible(true);
                frame.setVisible(false);
            }
        });
    }
}
