package online.banking.system;

/**
 *
 * @author simone
 */
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;
import java.util.*;


public class BalanceEnquiry extends JFrame implements ActionListener{
    
    JButton back;
    String pinnumber;
     BalanceEnquiry(String pinnumber) {
     this.pinnumber = pinnumber;    
         
         
          setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/ui.jpg"));
        Image i2 = i1.getImage().getScaledInstance(780, 780, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 780, 780);
        add(image);
        
        back = new JButton("BACK");
        back.setFont(new Font("Raleway", Font.BOLD, 16));
        back.setBounds(300,450,150,25);
        back.addActionListener(this);
        image.add(back);
        
        Conn c =new Conn();
         int balance = 0;   
        try{
            
        ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
        while (rs.next()) {
        if (rs.getString("type").equals("Deposit")){
         balance += Integer.parseInt(rs.getString("amount"));
                
        } else {
            
            balance -= Integer.parseInt(rs.getString("amount"));

                  }
              }
            }catch (Exception e){
                System.out.println(e);
            }
         
        JLabel text = new JLabel("Your Current Account Balance is Rs: "+balance);
        text.setForeground(Color.WHITE);
        text.setBounds(135, 250, 400, 30);
        image.add(text);
        
        setSize(780,780);
        setLocation(300,0);
        setVisible(true);  
     }
     public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
     }


public static void main(String[] args){
        new BalanceEnquiry("").setVisible(true);
 }
}