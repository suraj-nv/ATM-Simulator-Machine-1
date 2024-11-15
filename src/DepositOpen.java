import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DepositOpen extends JFrame implements ActionListener {
    private Container container;
    private JLabel label,l3,l4;
    private JTextField t1;
    private JButton b1,b2;
    String pin="";
    String formno="";
    String Card ="";
    String atype ="";
    String facility="";
    public DepositOpen(String pin,String Card ,String formno,String atype,String facility) {
        this.pin=pin;
        this.Card=Card;
        this.formno=formno;
        this.atype=atype;
        this.facility=facility;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,700);
        setResizable(false);
        setLocationRelativeTo(null);
        setUndecorated(true);
        container=this.getContentPane();
        container.setLayout(null);
        ImageIcon imageIcon = new ImageIcon("D:\\fornt.jpg");
        Image image = imageIcon.getImage().getScaledInstance(700,700,Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(image);
        label = new JLabel(imageIcon);
        label.setBounds(0,0,imageIcon.getIconWidth(),imageIcon.getIconHeight());
        add(label);
        Font f=new Font("Arial",Font.BOLD,12);
        l3 = new JLabel("Enter the amount you want to Deposit for");
        l3.setFont(f);
        l3.setBounds(150,250,240,20);
        l3.setForeground(Color.WHITE);
        label.add(l3);
        l4 = new JLabel(" Account Opening ");
        l4.setFont(f);
        l4.setBounds(200,280,220,20);
        l4.setForeground(Color.WHITE);
        label.add(l4);
        t1 = new JTextField();
        t1.setFont(new Font("Relway",Font.BOLD,15));
        t1.setBounds(160,310,180,20);
        label.add(t1);
        b1 = new JButton("Deposit");
        b1.setFont(f);
        b1.setBounds(260,360,135,20);
        label.add(b1);
        b2 = new JButton("Cancel");
        b2.setFont(f);
        b2.setBounds(260,390,135,20);
        label.add(b2);
        b2.addActionListener(this);
        b1.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String amount = t1.getText();
        if(e.getSource() == b1) {

            LocalDateTime myDateObj = LocalDateTime.now();

            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

            String formattedDate = myDateObj.format(myFormatObj);
            if (amount.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter " +
                        "the amount you want to Deposit!");
            } else if (Integer.parseInt(amount) < 1000) {
                JOptionPane.showMessageDialog(null, "Please enter " +
                        "minimum RS: 1000  amount you want to Deposit!");
            } else {
                try {
                    Database database = new Database();
                    String sql = "insert into bank(pin,date,type,amount) values('" + pin + "', '"
                            + formattedDate + "','Deposit', '" + amount + "');";
                    String q1 = "insert into signup3(fromno,Account_Type,Card_No,Pin,Facility) values('" + formno + "','" + atype + "','" + Card + "','" + pin + "','" + facility + "')";
                    String q2 = "insert into login(fromno,Card_No,Pin) values('" + formno + "','" + Card + "','" + pin + "')";

                    database.statement.executeUpdate(q1);
                    database.statement.executeUpdate(q2);
                    database.statement.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Rs " + amount + " Deposited Successfully");
                    JOptionPane.showMessageDialog(null, "Card Number: " + Card + "\n Pin:" + pin);
                    setVisible(false);
                    new Login().setVisible(true);

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            }
        }else if (e.getSource() == b2) {
           int choice= JOptionPane.showConfirmDialog(null,"Do you want to cancel the account opening?","Cancel",JOptionPane.YES_NO_OPTION);
            if(choice == JOptionPane.YES_OPTION){
                setVisible(false);
                new Login().setVisible(true);
            }else {

            }
        }
    }
}
