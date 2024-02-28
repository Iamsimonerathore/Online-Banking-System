package online.banking.system;

/**
 *
 * @author simone
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{

     JLabel text;
    JButton deposit,withdrawl,cash,ministatement,pinchange,balance,exit;
    
    String pinnumber;
    FastCash(String pinnumber){
        this.pinnumber = pinnumber;
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/ui.jpg"));
        Image i2 = i1.getImage().getScaledInstance(780, 780, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 780, 780);
        add(image);
        
        text = new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        
       
        deposit = new JButton("100");
        withdrawl = new JButton("500");
        cash = new JButton("1000");
        ministatement = new JButton("2000");
        pinchange = new JButton("5000");
        balance = new JButton("10000");
        exit = new JButton("BACK");
        
        setLayout(null);
        
        text.setBounds(170,250,700,35);
        image.add(text);
        
        deposit.setBounds(135,360,105,25);
        image.add(deposit);
        
        withdrawl.setBounds(300,360,145,25);
        image.add(withdrawl);
        
        cash.setBounds(135,390,105,25);
        image.add(cash);
        
        ministatement.setBounds(300,390,145,25);
        image.add(ministatement);
        
        pinchange.setBounds(135,420,105,25);
        image.add(pinchange);
        
        balance.setBounds(300,420,145,25);
        image.add(balance);
        
        exit.setBounds(300,450,145,25);
        image.add(exit);
        
        
        deposit.addActionListener(this);
        withdrawl.addActionListener(this);
        cash.addActionListener(this);
        ministatement.addActionListener(this);
        pinchange.addActionListener(this);
        balance.addActionListener(this);
        exit.addActionListener(this);
        
        
        setSize(780,780);
        setLocation(300,0);
        setVisible(true);
        
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== exit){ 
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
          
        }else { 
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn c =new Conn();
            
            try{
              ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
              int bal = 0;
              while (rs.next()) {
                  if (rs.getString("type").equals("Deposit")){
                      bal += Integer.parseInt(rs.getString("amount"));
                } else {
                    bal -= Integer.parseInt(rs.getString("amount"));

                  }
              }
              if (ae.getSource() != exit && bal < Integer.parseInt(amount)) {
                JOptionPane.showMessageDialog(null, "Insuffient Balance");
                return;
              }
               Date date = new Date();
                String query = ("insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrawl', '"+amount+"')");
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");
                
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
               
                
            }catch(Exception e){
                System.out.println(e);
            }
            
          
        }
    }
    
    public static void main(String[] args){
        new FastCash("").setVisible(true);
    }
}