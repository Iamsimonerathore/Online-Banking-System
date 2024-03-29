package online.banking.system;

/**
 *
 * @author simone
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener{
    
    JTextField amount;
    JButton deposit, back;
    String pinnumber;
    Deposit(String pinnumber) {
        this.pinnumber = pinnumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/ui.jpg"));
        Image i2 = i1.getImage().getScaledInstance(780, 780, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 780, 780);
        add(image);
        
        JLabel text = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 14));
        text.setBounds(149,250,400,35);
        image.add(text);
        
        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(145,300,300,25);
        image.add(amount);
        
        deposit = new JButton("DEPOSIT");
        deposit.setBounds(300,420,150,25);
        deposit.addActionListener(this);
        image.add(deposit);

        back = new JButton("BACK");
        back.setBounds(300,450,150,25);
        back.addActionListener(this);
        image.add(back);
        
        setSize(780,780);
        setLocation(300,0);
        setVisible(true);
        
    }
     public void actionPerformed(ActionEvent ae){
         
         if(ae.getSource() == deposit){
             String number = amount.getText();
             Date date = new Date();
             if(number.equals("")){
             JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Deposit");
             
              }else{
                try{ 
                Conn conn = new Conn();
                String query =("insert into bank values('"+pinnumber+"', '"+date+"', 'Deposit', '"+number+"')");
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs. "+number+" Deposited Successfully");
   
               setVisible(false);
               new Transactions(pinnumber).setVisible(true);
                }catch (Exception e){ 
                    System.out.println(e);
                }    
             }       
                    
         } else if(ae.getSource() == back){
             setVisible(false);
             new Transactions(pinnumber).setVisible(true);
             
         }
     }
         
    
   
    public static void main (String args []){
        new Deposit("");
        
        
    }
}
