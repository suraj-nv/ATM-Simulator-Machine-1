import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends JFrame implements ActionListener {
    private Container container;
    private JLabel label1, label2, label3, label4;
    private JTextField jt1;
    private JPasswordField passwordField;
    private Button signIn, SignUp, clear;

    public Login() throws HeadlessException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("AUTOMATED TELLER MACHINE");
        container = this.getContentPane();
        container.setLayout(null);
        ImageIcon icon = new ImageIcon("D:\\atmmm.png");
        label1 = new JLabel(icon);
        label1.setBounds(60, 60, icon.getIconWidth(), icon.getIconHeight());
        container.add(label1);
        Font f = new Font("Osward", Font.BOLD, 38);
        label2 = new JLabel("Welcome to ATM");
        label2.setBounds(130, 60, 350, 40);
        label2.setFont(f);
        container.add(label2);
        Font f1 = new Font("Raleway", Font.BOLD, 20);
        label3 = new JLabel("Card No:");
        label3.setBounds(90, 150, 100, 60);
        label3.setFont(f1);
        container.add(label3);
        jt1 = new JTextField();
        jt1.setBounds(200, 165, 200, 30);
        jt1.setFont(new Font("Osward", Font.BOLD, 17));
        container.add(jt1);
        label4 = new JLabel("PIN:");
        label4.setBounds(90, 200, 100, 60);
        label4.setFont(f1);
        container.add(label4);
        passwordField = new JPasswordField();
        passwordField.setEchoChar('*');
        passwordField.setFont(new Font("Osward", Font.BOLD, 17));
        passwordField.setBounds(200, 215, 200, 30);
        container.add(passwordField);
        signIn = new Button("SIGN IN");
        signIn.setBackground(Color.BLACK);
        signIn.setForeground(Color.WHITE);
        signIn.setBounds(200, 270, 90, 30);
        container.add(signIn);
        clear = new Button("CLEAR");
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.setBounds(310, 270, 90, 30);
        container.add(clear);
        SignUp = new Button("SIGN UP");
        SignUp.setBackground(Color.BLACK);
        SignUp.setForeground(Color.WHITE);
        SignUp.setBounds(200, 330, 200, 30);
        container.add(SignUp);
        signIn.addActionListener(this);
        clear.addActionListener(this);
        SignUp.addActionListener(this);
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clear) {
            jt1.setText("");
            passwordField.setText("");
        } else if (e.getSource() == SignUp) {
            new Signup().setVisible(true);
            dispose();
        } else if (e.getSource() == signIn) {
            Database database = new Database();
            String cardNumber = jt1.getText();
            String pin = passwordField.getText();
            String query = "select * from login where Card_No = '" + cardNumber + "' and Pin = '" + pin + "';";
            if (cardNumber.isEmpty() || pin.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Invalid Card_No or Password");
            } else {
                try {
                    ResultSet resultSet = database.statement.executeQuery(query);
                    if (resultSet.next()) {
                        setVisible(false);
                        new HomeFrame(pin).setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid Card_No or Password");
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            }
        }
    }
}