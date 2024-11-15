import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class FastCash extends JFrame implements ActionListener {
    private Container container;
    private JLabel label, l3;
    private JButton b1, b2, b3, b4, b5, b6, b7;
    String pin = "";

    public FastCash(String pin) throws HeadlessException {
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
        l3 = new JLabel("Select Withdrawal Amount ");
        l3.setFont(f);
        l3.setBounds(170, 250, 200, 40);
        l3.setForeground(Color.WHITE);
        label.add(l3);
        b1 = new JButton("RS 100");
        b1.setFont(f);
        b1.setBounds(130, 320, 100, 20);
        label.add(b1);
        b3 = new JButton("RS 1000");
        b3.setFont(f);
        b3.setBounds(130, 350, 100, 20);
        label.add(b3);
        b5 = new JButton("Rs 5000");
        b5.setFont(f);
        b5.setBounds(130, 380, 100, 20);
        label.add(b5);
        b2 = new JButton("RS 500");
        b2.setFont(f);
        b2.setBounds(250, 320, 135, 20);
        label.add(b2);
        b4 = new JButton("RS 2000");
        b4.setFont(f);
        b4.setBounds(250, 350, 135, 20);
        label.add(b4);
        b6 = new JButton("RS 10000");
        b6.setFont(f);
        b6.setBounds(250, 380, 135, 20);
        label.add(b6);
        b7 = new JButton("Back");
        b7.setFont(f);
        b7.setBounds(250, 410, 135, 20);
        label.add(b7);


        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if (e.getSource() == b7) {
            setVisible(false);
            new HomeFrame(pin).setVisible(true);
        }else{
           String amount =((JButton) e.getSource()).getText().substring(3);
           Database database = new Database();
           try{
               ResultSet rs = database.statement.executeQuery("select * from bank where pin = '" +pin+"'");
               int balance = 0;
               while (rs.next()) {
                   if (rs.getString("type").equals("Deposit")) {
                       balance += Integer.parseInt(rs.getString("amount"));
                   } else {
                       balance -= Integer.parseInt(rs.getString("amount"));
                   }
               }
               if(e.getSource() !=b7 && balance<Integer.parseInt(amount)){
                   JOptionPane.showMessageDialog(null,"Insufficient Balance");
                   return;
               }
               LocalDateTime myDateObj = LocalDateTime.now();

               DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

               String formattedDate = myDateObj.format(myFormatObj);
               String sql = "insert into bank(pin,date,type,amount) values('"+pin+"', '"
                       + formattedDate+"','Withdrawal', '"+amount+"');";
               // System.out.println(sql);

               database.statement.executeUpdate(sql);
               JOptionPane.showMessageDialog(null,"Rs "+amount+" Withdrawal Successfully");
               setVisible(false);
               new HomeFrame(pin).setVisible(true);

           } catch (SQLException ex) {
               throw new RuntimeException(ex);
           }
       }



    }
}
