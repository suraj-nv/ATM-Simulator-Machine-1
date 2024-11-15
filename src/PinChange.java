import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PinChange extends JFrame implements ActionListener {

    private Container container;
    private JLabel label, l3, l1, l2;
    private JPasswordField t1, t2;
    private JButton  b1,b2, b3;
    String pin = "";

    public PinChange(String pin) {
        this.pin = pin;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 700);
        setResizable(false);
        setLocationRelativeTo(null);
        setUndecorated(true);
        container = this.getContentPane();
        container.setLayout(null);
        ImageIcon imageIcon = new ImageIcon("D:\\fornt.jpg");
        Image image = imageIcon.getImage().getScaledInstance(700, 700, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(image);
        label = new JLabel(imageIcon);
        label.setBounds(0, 0, imageIcon.getIconWidth(), imageIcon.getIconHeight());
        add(label);
        Font f = new Font("Arial", Font.BOLD, 12);
        l1 = new JLabel("CHANGE YOUR PIN ");
        l1.setFont(f);
        l1.setBounds(200, 250, 250, 20);
        l1.setForeground(Color.WHITE);
        label.add(l1);
        l3 = new JLabel("Enter New Pin ");
        l3.setFont(f);
        l3.setBounds(130, 280, 250, 20);
        l3.setForeground(Color.WHITE);
        label.add(l3);
        l2 = new JLabel("Re-Enter New Pin ");
        l2.setFont(f);
        l2.setBounds(130, 330, 250, 20);
        l2.setForeground(Color.WHITE);
        label.add(l2);
        t1 = new JPasswordField();
        t1.setFont(new Font("Relway", Font.BOLD, 15));
        t1.setBounds(273, 280, 105, 20);
        t1.setEchoChar('*');
        label.add(t1);
        t2 = new JPasswordField();
        t2.setFont(new Font("Relway", Font.BOLD, 15));
        t2.setBounds(273, 330, 105, 20);
        t2.setEchoChar('*');
        label.add(t2);
        b1 = new JButton("Change");
        b1.setFont(f);
        b1.setBounds(280, 400, 100, 20);
        label.add(b1);
        b2 = new JButton("Clear");
        b2.setFont(f);
        b2.setBounds(280, 430, 100, 20);
        label.add(b2);
        b3 = new JButton("Back");
        b3.setFont(f);
        b3.setBounds(130, 430, 100, 20);
        label.add(b3);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b2) {
            t1.setText("");
            t2.setText("");
        } else if (e.getSource() == b3) {
            setVisible(false);
            new HomeFrame(pin).setVisible(true);
        } else if (e.getSource() == b1) {
            String npin = t1.getText();
            String rpin = t2.getText();
            if (npin.equals(rpin) && npin.length() == 4) {
                try {
                    Database database = new Database();
                    String q1 = "update login set Pin = '" + rpin + "' where Pin = '" + pin + "'";
                    String q2 = "update bank set pin = '" + rpin + "' where Pin = '" + pin + "'";
                    String q3 = "update signup3 set Pin = '" + rpin + "' where Pin = '" + pin + "'";
                    database.statement.executeUpdate(q1);
                    database.statement.executeUpdate(q2);
                    database.statement.executeUpdate(q3);
                    JOptionPane.showMessageDialog(null, "PIN changed Successfully ");
                    setVisible(false);
                    new Login().setVisible(true);

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            } else {
                JOptionPane.showMessageDialog(null, "New Pin and Re-Enter Pin does not match! or You have  entered more than " +
                        " 4 digits Pin or less than 4 digits Pin");
            }
        }
    }
}
