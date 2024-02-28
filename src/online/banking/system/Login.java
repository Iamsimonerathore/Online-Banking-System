package online.banking.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

/**
 *
 * @author simone
 */


public class Login extends JFrame implements ActionListener{

   JButton login, signup, clear; 
   JTextField cardTextField;
   JPasswordField pinTextField;
    
    Login(){
        
        setTitle("ONLINE BANKING SYSTEM");
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(150, 180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);
        
        JLabel text = new JLabel("ONLINE BANKING SYSTEM");
        text.setFont(new Font("Osward", Font.BOLD, 30));
        text.setBounds(220, 40, 400, 40);
        add(text);
        
        JLabel cardno = new JLabel("Card No.:");
        cardno.setFont(new Font("Raleway", Font.BOLD, 28));
        cardno.setBounds(120, 140, 150, 40);
        add(cardno);
        
        cardTextField = new JTextField();
        cardTextField.setBounds(300, 150, 250, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardTextField);

        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        pin.setBounds(120, 210, 250, 40);
        add(pin);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(300, 220, 250, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinTextField);
        
        login = new JButton("SIGN IN");
        login.setBounds(310, 300, 100, 30);
        login.addActionListener(this);
        add(login);
        
        clear = new JButton("CLEAR");
        clear.setBounds(440, 300, 100, 30);
        clear.addActionListener(this);
        add(clear);
        
        signup = new JButton("SIGN UP");
        signup.setBounds(310, 350, 230, 30);
        signup.addActionListener(this);
        add(signup);
        
         getContentPane().setBackground(Color.WHITE);
        
        
        setSize(800, 480);
        setVisible(true);
        setLocation(350, 200);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
        
            
       if (ae.getSource() == clear){
           cardTextField.setText("");
           pinTextField.setText("");
           
       }else if (ae.getSource() == login){
          Conn conn = new Conn();
          String cardnumber = cardTextField.getText();
          String pinnumber = pinTextField.getText();
           
           String query = "select * from login where cardnumber = '"+cardnumber+"'and pin = '"+pinnumber+"'";
       
           try{
             ResultSet rs = conn.s.executeQuery(query); 
             if(rs.next()){
                 setVisible(false);
                 new Transactions(pinnumber).setVisible(true);
                 
                 }else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                    

                 
             
             }
           }catch(Exception e){
               System.out.println(e);
               
           }
       }else if (ae.getSource()== signup){
           setVisible(false);
          new SignupOne().setVisible(true);
       }
        
    }

    public static void main(String args[]){
         new Login().setVisible(true);
    }
    
}