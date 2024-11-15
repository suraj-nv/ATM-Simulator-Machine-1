import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Signup3 extends JFrame implements ActionListener { private Container container;
   private JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
   Random random = new Random();
   int last = +random.nextInt(1000,9999);
   String card = "XXXX-XXXX-XXXX-" +last;
   private JRadioButton r2,r3,r4,r5;
   private JCheckBox r6,r7,r8,r9,r10,r11,r1;
   private JButton submit,cancel;
   private ButtonGroup bg1;
   String formno = "";
    public Signup3(String from) throws HeadlessException {
        this.formno=from;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,750);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("NEW ACCOUNT OPENING APPLICATION FORM - PAGE 3");

        container=this.getContentPane();
        container.setLayout(null);
        Font f = new Font("Relway",Font.BOLD,17);
        Font f1 = new Font("Relway",Font.BOLD,9);
        l1 = new JLabel("Page 3: Additional Details");
        l1.setFont(f);
        l1.setBounds(170,70,300,20);
        container.add(l1);
        l2 = new JLabel("Account Type_");
       // l2.setForeground(Color.blue);
        l2.setFont(f);
        l2.setBounds(60,140,150,30);
        container.add(l2);
        l9 = new JLabel("From No: "+formno);
        // l2.setForeground(Color.blue);
        l9.setFont(f);
        l9.setBounds(450,20,150,30);
        container.add(l9);
        l3 = new JLabel("Card Number ");
        l3.setFont(f);
        l3.setBounds(60,270,200,20);
        container.add(l3);
        l4 = new JLabel("Your 16 Digit Card Number");
        l4.setFont(f1);
        l4.setBounds(62,290,200,20);
        container.add(l4);
        l4 = new JLabel("PIN:");
        l4.setFont(f);
        l4.setBounds(60,330,200,20);
        container.add(l4);
        l5 = new JLabel("Your 4 Digit Password");
        l5.setFont(f1);
        l5.setBounds(62,350,200,20);
        container.add(l5);
        l6 = new JLabel("Services Required:");
        l6.setFont(f);
        l6.setBounds(60,420,200,20);
        container.add(l6);
        l7 = new JLabel("XXXX");
        l7.setFont(f);
        l7.setBounds(260,330,300,20);
        container.add(l7);
        l8 = new JLabel(card);
        l8.setFont(f);
        l8.setBounds(260,270,300,20);
        container.add(l8);
        bg1 = new ButtonGroup();
        r1 = new JCheckBox("I hereby declares that the above entered details are correct to the best Acknowledge");
        r1.setFont(f1);
        r1.setBounds(90,600,450,20);
        container.add(r1);
        r2 = new JRadioButton("Savings Account");
        r2.setFont(new Font("Relway",Font.BOLD,12));
        r2.setBounds(70,170,140,40);
        container.add(r2);
        r3 = new JRadioButton("Fixed Deposit Account");
        r3.setFont(new Font("Relway",Font.BOLD,12));
        r3.setBounds(250,170,140,40);
        container.add(r3);
        r4 = new JRadioButton("Current Account");
        r4.setFont(new Font("Relway",Font.BOLD,12));
        r4.setBounds(70,220,140,50);
        container.add(r4);
        r5 = new JRadioButton("Salaried Account");
        r5.setFont(new Font("Relway",Font.BOLD,12));
        r5.setBounds(250,220,1300,50);
        container.add(r5);
        bg1.add(r2);
        bg1.add(r3);
        bg1.add(r4);
        bg1.add(r5);
        r6= new JCheckBox("ATM CARD");
        r6.setFont(new Font("Relway",Font.BOLD,12));
        r6.setBounds(80,470,100,50);
        container.add(r6);
        r7= new JCheckBox("Internet Banking");
        r7.setFont(new Font("Relway",Font.BOLD,12));
        r7.setBounds(250,470,200,50);
        container.add(r7);
        r8= new JCheckBox("Mobile Banking");
        r8.setFont(new Font("Relway",Font.BOLD,14));
        r8.setBounds(80,510,170,50);
        container.add(r8);
        r9= new JCheckBox("EMAIL & SMS Alerts");
        r9.setFont(new Font("Relway",Font.BOLD,12));
        r9.setBounds(250,510,280,50);
        container.add(r9);
        r10= new JCheckBox("Cheque Book");
        r10.setFont(new Font("Relway",Font.BOLD,12));
        r10.setBounds(80,550,110,50);
        container.add(r10);
        r11= new JCheckBox("E-Statement");
        r11.setFont(new Font("Relway",Font.BOLD,12));
        r11.setBounds(250,550,100,50);
        container.add(r11);
        submit = new JButton("SUBMIT");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(170,630,90,30);
        container.add(submit);
        cancel = new JButton("CANCEL");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(340,630,90,30);
        container.add(cancel);
        submit.addActionListener(this);
        cancel.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        String atype = "";
        if(r2.isSelected()){
            atype = "Saving Account";
        }
        else if(r3.isSelected()){
            atype = "Fixed Deposit Account";
        }
        else if(r4.isSelected()){
            atype = "Current Account";
        }else if(r5.isSelected()){
            atype = "Salaried Account";
        }

       String Card = "" + random.nextInt(1000,9999) + ""
               + random.nextInt(1000,9999) + ""
               + random.nextInt(1000,9999) + ""+last;
        String pin = ""+random.nextInt(1000,9999);

        String facility = "";
        if(r6.isSelected()){
            facility = facility + " ATM Card";
        }
        if(r7.isSelected()){
            facility = facility + " Internet Banking";
        }
        if(r8.isSelected()){
            facility = facility + " Mobile Banking";
        }
        if(r9.isSelected()){
            facility = facility + " EMAIL Alerts";
        }
        if(r10.isSelected()){
            facility = facility + " Cheque Book";
        }
        if(r11.isSelected()){
            facility = facility + " E-Statement";
        }
        String check ="";
        if(r1.isSelected()){
            check="Yes";
        }
        try{
            if(e.getSource()==submit){

                if(atype.equals("")){
                    JOptionPane.showMessageDialog(null, "Fill all the required fields");
                } else if (facility.equals("")) {
                    JOptionPane.showMessageDialog(null, "Fill the Services");
                } else if (check.equals("")) {
                    JOptionPane.showMessageDialog(null, "Click I hereby declares that the above entered details are correct to the best Acknowledge ");
                } else {
                    int choice = JOptionPane.showConfirmDialog(null, "Is your Given details is correct ?,", "Cheacked", JOptionPane.YES_NO_OPTION);
                    if (choice == JOptionPane.NO_OPTION) {

                    } else {
                        Database c1 = new Database();
                        setVisible(false);
                        new DepositOpen(pin, Card, formno, atype, facility).setVisible(true);
                    }
                }

            }else if(e.getSource()==cancel){
               setVisible(false);
               new Login().setVisible(true);
            }

        }catch(Exception ex){
            ex.printStackTrace();
        }
    }


}
