import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Deposit extends JFrame implements ActionListener {
    private Container container;
    private JLabel label,l3;
    private JTextField t1;
    private JButton b1,b2;
    String pin="";
    public Deposit(String pin) {
        this.pin=pin;
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
        l3 = new JLabel("Enter the amount you want to deposit ");
        l3.setFont(f);
        l3.setBounds(130,250,220,20);
        l3.setForeground(Color.WHITE);
        label.add(l3);
        t1 = new JTextField();
        t1.setFont(new Font("Relway",Font.BOLD,15));
        t1.setBounds(130,280,200,20);
        label.add(t1);
        b1 = new JButton("Deposit");
        b1.setFont(f);
        b1.setBounds(260,400,135,20);
        label.add(b1);
        b2 = new JButton("Back");
        b2.setFont(f);
        b2.setBounds(260,430,135,20);
        label.add(b2);
        b1.addActionListener(this);
        b2.addActionListener(this);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1){
            String amount = t1.getText();
            LocalDateTime myDateObj = LocalDateTime.now();

            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

            String formattedDate = myDateObj.format(myFormatObj);
            if(amount.isEmpty()){
                JOptionPane.showMessageDialog(null,"Please enter the amount you want to Deposit!");
            }else{
                try {
                Database database = new Database();
                String sql = "insert into bank(pin,date,type,amount) values('"+pin+"', '"
                        + formattedDate+"','Deposit   ', '"+amount+"');";
                System.out.println(sql);

                    database.statement.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null,"Rs "+amount+" Deposited Successfully");
                    setVisible(false);
                    new HomeFrame(pin).setVisible(true);

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }

        } else if (e.getSource() == b2) {
            setVisible(false);
            new HomeFrame("").setVisible(true);
        }
    }
}
