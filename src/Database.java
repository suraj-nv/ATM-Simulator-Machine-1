import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class Database {
   private static final String url = "jdbc:mysql://localhost:3306/BankManagementSystem";
   private static final String username = "root";
   private static  final String password = "suraj@123";
   protected Connection connection;
   protected Statement statement;

    public Database() {

            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
            }catch (ClassNotFoundException e){
                System.out.println(e.getMessage());
            }
        try {
             connection = DriverManager.getConnection(url, username, password);
             statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}