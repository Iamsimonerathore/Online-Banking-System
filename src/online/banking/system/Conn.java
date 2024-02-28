package online.banking.system;

import java.sql.*;

/**
 *
 * @author simone
 */

public class Conn{
    Connection c;
    Statement s;
    public Conn(){
       
         try {
             
             Class.forName("com.mysql.cj.jdbc.Driver");
             c = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinebankingsystem", "root", "simone2582");
             s = c.createStatement();
             
         }  catch(Exception e){
             System.out.println(e);
             
         }
       
    }
    
}