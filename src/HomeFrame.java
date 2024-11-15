import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.jar.JarEntry;

public class HomeFrame extends JFrame implements ActionListener {
    private Container container;
    private JLabel label,l3;
    private  JButton b1,b2,b3,b4,b5,b6,b7;
    String pin="";

    public HomeFrame(String pin) throws HeadlessException {
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
        l3 = new JLabel("Please select your Transaction ");
        l3.setFont(f);
        l3.setBounds(170,250,200,20);
        l3.setForeground(Color.WHITE);
        label.add(l3);
        b1 = new JButton("Deposit");
        b1.setFont(f);
        b1.setBounds(130,320,100,20);
        label.add(b1);
        b3 = new JButton("Fast Cash");
        b3.setFont(f);
        b3.setBounds(130,350,100,20);
        label.add(b3);
        b5 = new JButton("Pin Change");
        b5.setFont(f);
        b5.setBounds(130,380,100,20);
        label.add(b5);
        b2 = new JButton("Cash Withdrawal");
        b2.setFont(f);
        b2.setBounds(250,320,135,20);
        label.add(b2);
        b4 = new JButton("Mini Statement");
        b4.setFont(f);
        b4.setBounds(250,350,135,20);
        label.add(b4);
        b6 = new JButton("Balance Enquiry");
        b6.setFont(f);
        b6.setBounds(250,380,135,20);
        label.add(b6);
        b7 = new JButton("Exit");
        b7.setFont(f);
        b7.setBounds(250,410,135,20);
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
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            setVisible(false);
            new Deposit(pin).setVisible(true);
        } else if (ae.getSource() == b2) {
            setVisible(false);
            new Withdrawal(pin).setVisible(true);
        }else if (ae.getSource() == b7) {
            System.exit(0);
        }
        else if(ae.getSource()==b3){
            setVisible(false);
            new FastCash(pin).setVisible(true);
        }
        else if(ae.getSource()==b4){
            new MiniStatement(pin).setVisible(true);
        }
        else if(ae.getSource()==b5){
            setVisible(false);
            new PinChange(pin).setVisible(true);
        }
        else if(ae.getSource()==b6){
            this.setVisible(false);
            new BalanceEnq(pin).setVisible(true);
        }
            if (ae.getSource() == b7) {
                System.exit(0);
            }
        }
    }
//}
