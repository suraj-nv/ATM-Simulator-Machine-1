import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class SignUpTwo extends JFrame {
    private Container container;
    private JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
    private JButton next;
    private JComboBox jc1,jc2,jc3,jc4,jc5;
    private JTextField jt1,jt2;
    private JRadioButton bt1,bt2,b3,b4;
    private ButtonGroup bg1,bg2;
    private String[] religion = {"Hindu","Muslim","Sikh","Other"};
    private String[] C = {"General","OBC","SC","ST","Other"};
    private String[] Inc = {"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000","Above 10,00,000"};
    private String[] Edu = {"Non-Graduate","Graduate","Post-Graduate","Doctrate","Others"};
    private String[] Occu = {"Salaried","Self-Employed","Business","Student","Retired","Others"};
    String Fromno = null;
    public SignUpTwo(String fromno) throws HeadlessException {
        this.Fromno = (fromno);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,750);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("NEW ACCOUNT OPENING APPLICATION FORM - PAGE 2");

        container=this.getContentPane();
        container.setLayout(null);
        Font f = new Font("Relway",Font.BOLD,17);
        Font f1 = new Font("Relway",Font.BOLD,14);
        l1 = new JLabel("Page 2: Additional Details");
        l1.setFont(f);
        l1.setBounds(170,70,300,20);
        container.add(l1);
        l9 = new JLabel("From No: "+Fromno);
        // l2.setForeground(Color.blue);
        l9.setFont(f);
        l9.setBounds(450,20,150,30);
        container.add(l9);
        l2 = new JLabel("Religion:");
        l2.setFont(f);
        l2.setBounds(60,110,150,30);
        container.add(l2);
        l3 = new JLabel("Category:");
        l3.setBounds(60,160,150,30);
        l3.setFont(f);
        add(l3);

        l4 = new JLabel("Income:");
        l4.setBounds(60,220,150,30);
        l4.setFont(f);
        container.add(l4);

        l5 = new JLabel("Educational");
        l5.setBounds(60,280,150,30);
        l5.setFont(f);
        container.add(l5);
        l11 = new JLabel("Qualification:");
        l11.setFont(f);
        l11.setBounds(60,303,150,20);
        container.add(l11);

        l6 = new JLabel("Occupation:");
        l6.setBounds(60,370,150,30);
        l6.setFont(f);
        container.add(l6);

        l7 = new JLabel("PAN Number:");
        l7.setBounds(60,430,150,30);
        l7.setFont(f);
        container.add(l7);
        l8 = new JLabel("Aadhar Number:");
        l8.setBounds(60,480,150,30);
        l8.setFont(f);

        add(l8);
        l9 = new JLabel("Senior Citizen:");
        l9.setBounds(60,530,150,30);
        l9.setFont(f);

        container.add(l9);

        l10 = new JLabel("Existing Account:");
        l10.setBounds(60,580,150,30);
        l10.setFont(f);
        container.add(l10);
        jc1 = new JComboBox<>(religion);
        jc1.setBounds(210,120,300,25);
        container.add(jc1);
        jc2 = new JComboBox<>(C);
        jc2.setBounds(210,165,300,25);
        container.add(jc2);
        jc3 = new JComboBox<>(Inc);
        jc3.setBounds(210,222,300,25);
        container.add(jc3);
        jc4 = new JComboBox<>(Edu);
        jc4.setBounds(210,292,300,25);
        container.add(jc4);
        jc5 = new JComboBox<>(Occu);
        jc5.setBounds(210,380,300,25);
        container.add(jc5);
        jt1=new JTextField();
        jt1.setBounds(210,435,300,25);
        jt1.setFont(f1);
        container.add(jt1);
        jt2=new JTextField();
        jt2.setBounds(210,485,300,25);
        jt2.setFont(f1);
        jt2.setColumns(12);
        container.add(jt2);
        bg1 = new ButtonGroup();
        bt1 = new JRadioButton("Yes");
        bt1.setFont(new Font("Relway",Font.BOLD,14));
        bt1.setBounds(210,530,80,30);
        container.add(bt1);
        bt2 = new JRadioButton("No");
        bt2.setFont(new Font("Relway",Font.BOLD,14));
        bt2.setBounds(300,530,100,30);
        container.add(bt2);
        bg1.add(bt1);
        bg1.add(bt2);
        bg2 = new ButtonGroup();
        b3 = new JRadioButton("Yes");
        b3.setFont(new Font("Relway",Font.BOLD,14));
        b3.setBounds(210,580,80,30);
        container.add(b3);
        b4 = new JRadioButton("No");
        b4.setFont(new Font("Relway",Font.BOLD,14));
        b4.setBounds(300,580,100,30);
        container.add(b4);
        bg2.add(b3);
        bg2.add(b4);



        next = new JButton("NEXT");
        next.setBackground(Color.black);
        next.setForeground(Color.WHITE);
        next.setBounds(400,620,100,30);
        container.add(next);
        //setVisible(true);
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //String fromnoo = "" + Fromno;
                String Religion =jc1.getSelectedItem().toString();
                String category = jc2.getSelectedItem().toString();
                String Income = jc3.getSelectedItem().toString();
                String Education = jc4.getSelectedItem().toString();
                String occupation = jc5.getSelectedItem().toString();
                String pan = jt1.getText();
                String adh = jt2.getText();
                String citezen = "";
                if(bt1.isSelected()){
                    citezen = "YES";
                } else if (bt2.isSelected()) {
                    citezen = "NO";
                }
                String Existing = "";
                if(b3.isSelected()){
                    Existing = "YES";
                } else if (b4.isSelected()) {
                    Existing = "NO";
                }
                try {
                    if(pan.isEmpty()){
                        JOptionPane.showMessageDialog(null,"Please Enter You Pan Number");
                    } else if (adh.isEmpty()) {
                        JOptionPane.showMessageDialog(null,"Please Enter You Aadhar Number");
                    } else if (citezen.isEmpty()) {
                        JOptionPane.showMessageDialog(null,"Please Select Citizenship");
                    } else if (Existing.isEmpty()) {
                        JOptionPane.showMessageDialog(null,"Please select Existing account status");
                    }else {
                        int choice = JOptionPane.showConfirmDialog(null, "Is your Given details is correct ?,", "Cheacked", JOptionPane.YES_NO_OPTION);
                        if (choice == JOptionPane.NO_OPTION) {

                        } else {
                            Database database = new Database();
                            String query = "INSERT INTO signup2(From_no,Religion , Category , Income ,Qualification , Occupation , Pan_No , Aadhar_No , Citigenship ,Account_Status) " +
                                    "VALUES ('" + Fromno + "', '" + Religion + "', '" + category + "', '" + Income + "', '" + Education + "', '" + occupation +
                                    "', '" + pan + "', '" + adh + "', '" + citezen + "', '" + Existing + "')";
                            if (pan.length() != 10 ) {
                                JOptionPane.showMessageDialog(null, "Please input 10 digits pan no");
                            } else if (adh.length()!=12) {
                                JOptionPane.showMessageDialog(null, "Please input 12 digit aadhar no");
                            } else {
                                database.statement.executeUpdate(query);
                                new Signup3(fromno).setVisible(true);
                                dispose();
                            }
                        }
                    }

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

    }
}


