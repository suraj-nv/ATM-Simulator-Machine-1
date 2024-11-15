
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.nio.file.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Signup extends JFrame implements ActionListener {
    private Container container;
    private JLabel label1,label2;
    private JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
    private  JTextField t1,t2,t3,t4,t5,t6;
    private JTextArea textArea;
    private JScrollPane js;
    private JRadioButton male,female,married,unmarried,other;
    private  JButton next;
    private Random random = new Random();
    private JDateChooser jDateChooser;
    private int a =random.nextInt(1000,9999);

    public Signup() throws HeadlessException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,800);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("NEW ACCOUNT OPENING APPLICATION FORM");

        container=this.getContentPane();
        container.setLayout(null);
        ImageIcon icon = new ImageIcon("D:\\logo.png");
        label1 = new JLabel(icon);
        label1.setBounds(10,10,icon.getIconWidth(),icon.getIconHeight());
        add(label1);
  ;

        Font f = new Font("Osward",Font.BOLD,30);
        label2 = new JLabel("APPLICATION FORM NO. "+a);
        label2.setBounds(80,20,500,40);
        label2.setFont(f);
        container.add(label2);
        Font f1 = new Font("Relway",Font.BOLD,17);
        l1 = new JLabel("Page 1: Personal Details");
        l1.setBounds(170,70,200,20);
        l1.setFont(f1);

        container.add(l1);
        l2 = new JLabel("Name:");
        l2.setBounds(60,110,150,30);
        l2.setFont(f1);
        container.add(l2);


        l3 = new JLabel("Father's Name:");
        l3.setBounds(60,160,150,30);
        l3.setFont(f1);
        add(l3);

        l4 = new JLabel("Date of Birth:");
        l4.setBounds(60,220,150,30);
        l4.setFont(f1);
        container.add(l4);

        l5 = new JLabel("Gender:");
        l5.setBounds(60,280,150,30);
        l5.setFont(f1);
        container.add(l5);

        l6 = new JLabel("Email Address:");
        l6.setBounds(60,330,150,30);
        l6.setFont(f1);
        container.add(l6);
        l11 = new JLabel("Marital Status");
        l11.setBounds(60,370,150,30);
        l11.setFont(f1);
        container.add(l11);
        l7 = new JLabel("Address:");
        l7.setBounds(60,430,150,30);
        l7.setFont(f1);
        container.add(l7);
        l8 = new JLabel("City:");
        l8.setBounds(60,530,150,30);
        l8.setFont(f1);

        add(l8);
        l9 = new JLabel("Pin Code");
        l9.setBounds(60,590,150,30);
        l9.setFont(f1);

        container.add(l9);

        l10 = new JLabel("State:");
        l10.setBounds(60,630,150,30);
        l10.setFont(f1);
        container.add(l10);


        t1=new JTextField();
        t1.setBounds(200,120,250,30);
        t1.setFont(f1);
        container.add(t1);
        t2 = new JTextField();
        t2.setBounds(200,170,250,30);
        t2.setFont(f1);
        container.add(t2);
        t3 = new JTextField();
        t3.setBounds(200,337,250,30);
        t3.setFont(f1);
        container.add(t3);
        t4 = new JTextField();
        t4.setBounds(200,537,250,30);
        t4.setFont(f1);
        container.add(t4);
        t5 = new JTextField();
        t5.setBounds(200,597,250,30);
        t5.setFont(f1);
        container.add(t5);
        t6 = new JTextField();
        t6.setFont(f1);
        t6.setBounds(200,637,250,30);
        container.add(t6);
         textArea = new JTextArea("");
        textArea.setFont(f1);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(200,430,250,60);
        container.add(scrollPane);
        ButtonGroup buttonGroup = new ButtonGroup();
        male = new JRadioButton("Male");
        male.setFont(new Font("Relway",Font.BOLD,17));
        male.setBounds(200,270,100,50);
        container.add(male);
        female = new JRadioButton("Female");
        female.setFont(new Font("Relway",Font.BOLD,17));
        female.setBounds(300,270,100,50);
        container.add(female);
        buttonGroup.add(male);
        buttonGroup.add(female);
        married = new JRadioButton("Married");
        married.setFont(new Font("Relway",Font.BOLD,12));
        married.setBounds(200,370,80,50);
        container.add(married);
        unmarried = new JRadioButton("Unmarried");
        unmarried.setFont(new Font("Relway",Font.BOLD,12));
        unmarried.setBounds(280,370,100,50);
        container.add(unmarried);
        other = new JRadioButton("Other");
        other.setFont(new Font("Relway",Font.BOLD,12));
        other.setBounds(380,370,80,50);
        container.add(other);
        ButtonGroup bt = new ButtonGroup();
        bt.add(married);;
        bt.add(unmarried);
        bt.add(other);

        jDateChooser = new JDateChooser();
        jDateChooser.setBounds(200,220,250,30);
        container.add(jDateChooser);


        next=new JButton("NEXT");
        next.setBackground(Color.black);
        next.setForeground(Color.WHITE);
        next.setBounds(350,680,100,30);
        container.add(next);
        next.addActionListener(this);

    }




      @Override
      public void actionPerformed(ActionEvent e) {
            String fromNo = ""+a;
            String name = t1.getText();
            String fName = t2.getText();
            String formattedDate = "";
            try{
            Date selectedDate = jDateChooser.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            formattedDate = dateFormat.format(selectedDate);
            }catch (NullPointerException ex){

            }
          String email = t3.getText();
          String Gender ="";
          if(male.isSelected()){
                Gender = "Male";
          } else if (female.isSelected()) {
                Gender = "Female";
          }
          String Marital = "";
          if(married.isSelected()){
                Marital = "Married";
          } else if (unmarried.isSelected()) {
                Marital = "Unmarried";
          } else if (other.isSelected()) {
                Marital = "Others";
          }
            String addrs =textArea.getText();
          String city = t4.getText();
          String pinCode = t5.getText();
          String state = t6.getText();
          try {
              if (name.isEmpty()) {
                  JOptionPane.showMessageDialog(null, "Name is empty!");
              } else if (formattedDate.isEmpty()) {
                  JOptionPane.showMessageDialog(null, "Enter Your Dob");
              } else if (fName.isEmpty()) {
                  JOptionPane.showMessageDialog(null, "Enter Father' Name");
              } else if (email.isEmpty()) {
                  JOptionPane.showMessageDialog(null, "Enter Email");
              } else if (Gender.isEmpty()) {
                  JOptionPane.showMessageDialog(null, "Select Your Gender");
              } else if (Marital.isEmpty()) {
                  JOptionPane.showMessageDialog(null, "Select Your Marital Status");
              } else if (addrs.isEmpty()) {
                  JOptionPane.showMessageDialog(null, "Enter your Address");
              } else if (city.isEmpty()) {
                  JOptionPane.showMessageDialog(null, "Enter You City");
              } else if (state.isEmpty()) {
                  JOptionPane.showMessageDialog(null, "Enter Your State");
              } else if (pinCode.isEmpty()) {
                  JOptionPane.showMessageDialog(null, "Enter Your PIN CODE");
              } else {
                  int choice = JOptionPane.showConfirmDialog(null, "Is your Given details is correct ?,", "Cheacked", JOptionPane.YES_NO_OPTION);
                  if (choice == JOptionPane.NO_OPTION) {

                  } else {
                      Database database = new Database();
                      String query = "INSERT INTO signup(From_No,Name,FName,Dob,Gender,Email,Marital,Address,City,Pin_Code,State) " +
                              "VALUES ('" + fromNo + "', '" + name + "', '" + fName + "', '" + formattedDate + "', '" + Gender +
                              "', '" + email + "', '" + Marital + "', '" + addrs + "', '" + city + "', '" + pinCode + "', '" + state + "')";
                      database.statement.executeUpdate(query);
                      new SignUpTwo(fromNo).setVisible(true);
                      dispose();
                  }
              }
              } catch(Exception ex){
                  ex.printStackTrace();
              }
          }
}

