import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class MiniStatement extends JFrame {
    private Container container;
    private String pin = "";

    private JLabel Bank,line,card,l4,l1,date,type,amount;

    public MiniStatement(String pin) {
        this.pin = pin;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(150,50,400,600);
        setResizable(false);
        setLocationRelativeTo(null);

        setTitle("Account mini Statement");
        container = this.getContentPane();
        container.setLayout(null);

        Font f = new Font("Relway",Font.BOLD,17);
        Font f1 = new Font("Relway",Font.BOLD,14);
        Bank = new JLabel("Indian Bank");
        Bank.setFont(f);
        Bank.setBounds(150,50,300,20);
        container.add(Bank);
        line=new JLabel("------------------------------------------");
        line.setFont(new Font("Relway",Font.PLAIN,14));
        line.setBounds(90,60,250,20);
        container.add(line);
        card=new JLabel();
        card.setFont(f1);
        card.setBounds(50,100,300,20);
        container.add(card);
        l1 = new JLabel();
        l1.setBounds(40,200,200,150);

        container.add(l1);
        l4 = new JLabel();
        l4.setBounds(40,420,210,100);
        container.add(l4);
        container.add(l1);


        try {
            Database database = new Database();
            String sql = "select * from login where Pin = '"+pin+"'";
            ResultSet resultSet = database.statement.executeQuery(sql);
            String cardNo="";
            while(resultSet.next()){
                card.setText("Card No:    "+resultSet.getString("Card_No").substring(0,4) +
                        "XXXXXXXXXXXX"+resultSet.getString("Card_No").substring(11));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try{

            Database database1 = new Database();
            ResultSet rs = database1.statement.executeQuery("select * from bank where pin ='" +pin+"'");
            int balance = 0;


            while (rs.next()){

                l1.setText(l1.getText() + "<html>"+rs.getString("date")+
                        "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type")
                        + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                        + rs.getString("amount") + "<br><br><html>");

                if(rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            date = new JLabel("");


           l4.setText("Your total Balance is Rs "+balance);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        new MiniStatement("1234").setVisible(true);
    }

}
