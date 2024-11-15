import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BalanceEnq extends JFrame implements ActionListener {

    private Container container ;
    String pin = "";
    private JLabel label,label2;
    private JButton b2,b3;
    public BalanceEnq(String pin) {
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

        b2 = new JButton("Exit");
        b2.setFont(f);
        b2.setBounds(280, 430, 100, 20);
        label.add(b2);
        b3 = new JButton("Back");
        b3.setFont(f);
        b3.setBounds(280, 400, 100, 20);
        label.add(b3);
        b2.addActionListener(this);
        b3.addActionListener(this);
        double balance =0;
        Database database = new Database();
        try{
            ResultSet rs = database.statement.executeQuery("select * from bank where pin = '" +pin+"'");

            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance +=Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -=  Integer.parseInt(rs.getString("amount"));
                }
            }
            label2 = new JLabel("AVAILABLE BALANCE "+balance);
            label2.setFont(f);
            label2.setBounds(130, 280, 250, 20);
            label2.setForeground(Color.WHITE);
            label.add(label2);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b2){
            setVisible(false);
            new Login().setVisible(true);
        } else if (e.getSource() == b3) {
            setVisible(false);
            new HomeFrame(pin).setVisible(true);
        }
    }
}
