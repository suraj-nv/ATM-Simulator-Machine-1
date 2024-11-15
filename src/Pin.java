import javax.swing.*;
import java.awt.*;

public class Pin extends JFrame {
    String pin = "";
    Container container;
    JLabel label,l3;
    JTextField t1;

    public Pin(String pin) throws HeadlessException {
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
        l3 = new JLabel("Enter Your Pin ");
        l3.setFont(f);
        l3.setBounds(130,250,220,20);
        l3.setForeground(Color.WHITE);
        label.add(l3);
        t1 = new JTextField();
        t1.setFont(new Font("Relway",Font.BOLD,15));
        t1.setBounds(130,280,200,20);
        label.add(t1);
    }


}
