
package online.banking.system;

/**
 *
 * @author simone
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Transactions extends JFrame implements ActionListener{

     JLabel text;
    JButton deposit,withdrawl,fastcash,ministatement,pinchange,exit, balanceenquiry;
    
    String pinnumber;
    Transactions(String pinnumber){
        this.pinnumber = pinnumber;
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/ui.jpg"));
        Image i2 = i1.getImage().getScaledInstance(780, 780, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 780, 780);
        add(image);
        
        text = new JLabel("Please Select Your Transaction");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        
       
        deposit = new JButton("DEPOSIT");
        withdrawl = new JButton("CASH WITHDRAWL");
        fastcash = new JButton("FAST CASH");
        ministatement = new JButton("MINI STATEMENT");
        pinchange = new JButton("PIN CHANGE");
        balanceenquiry = new JButton("BALANCE ENQUIRY");
        exit = new JButton("EXIT");
        
        setLayout(null);
        
        text.setBounds(170,250,700,35);
        image.add(text);
        
        deposit.setBounds(135,360,105,25);
        image.add(deposit);
        
        withdrawl.setBounds(300,360,145,25);
        image.add(withdrawl);
        
        fastcash.setBounds(135,390,105,25);
        image.add(fastcash);
        
        ministatement.setBounds(300,390,145,25);
        image.add(ministatement);
        
        pinchange.setBounds(135,420,105,25);
        image.add(pinchange);
        
        balanceenquiry.setBounds(300,420,145,25);
        image.add(balanceenquiry);
        
        exit.setBounds(300,450,145,25);
        image.add(exit);
        
        
        deposit.addActionListener(this);
        withdrawl.addActionListener(this);
        fastcash.addActionListener(this);
        ministatement.addActionListener(this);
        pinchange.addActionListener(this);
        balanceenquiry.addActionListener(this);
        exit.addActionListener(this);
        
        
        setSize(780,780);
        setLocation(300,0);
        setVisible(true);
        
        
        
    }

    Transactions(int pinnumber) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== exit){ 
            System.exit(0);
          
        }else if(ae.getSource() == deposit){ 
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
          
        }else if (ae.getSource() == withdrawl){
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        
        }else if (ae.getSource() == fastcash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
            
        }else if (ae.getSource() == balanceenquiry){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
       
        }else if (ae.getSource()== ministatement ) {
            setVisible(false);
            new MiniStatement(pinnumber).setVisible(true);
        
        }else if (ae.getSource()== pinchange ) {
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        
        }
    }
    
    public static void main(String[] args){
        new Transactions("").setVisible(true);
    }
}