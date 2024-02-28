package online.banking.system;

/**
 *
 * @author simone
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class PinChange extends JFrame implements ActionListener{
    
    JLabel text, pintext, repintext;
    JPasswordField newpin, repin;
    JButton back, change;
    String pinnumber;
    PinChange (String pinchange){
        this.pinnumber = pinnumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/ui.jpg"));
        Image i2 = i1.getImage().getScaledInstance(780, 780, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 780, 780);
        add(image);
        
        text = new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(210,250,700,35);
        image.add(text);
        
        pintext = new JLabel("NEW PIN:");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System", Font.BOLD, 16));
        pintext.setBounds(140,290,500,35);
        image.add(pintext);
        
        repintext = new JLabel("Re-ENTER NEW PIN:");
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System", Font.BOLD, 14));
        repintext.setBounds(140,330,500,35);
        image.add(repintext);
        
        newpin = new JPasswordField();
        newpin.setFont(new Font("Raleway", Font.BOLD, 14));
        newpin.setBounds(290, 290, 160,25 );
        add(newpin);
        
        repin = new JPasswordField();
        repin.setFont(new Font("Raleway", Font.BOLD, 14));
        repin.setBounds(290, 330, 160,25 );
        add(repin);
        
        change = new JButton("CHANGE");
        change.setFont(new Font("Raleway", Font.BOLD, 16));
        change.setBounds(300, 420, 150, 25);
        change.addActionListener(this);
        image.add(change);
        
        back = new JButton("BACK");
        back.setFont(new Font("Raleway", Font.BOLD, 16));
        back.setBounds(300,450,150,25);
        back.addActionListener(this);
        image.add(back);

        
        setSize(780,780);
        setLocation(300,0);
        setVisible(true);
    }
       
    public void actionPerformed (ActionEvent ae){
        
        if (ae.getSource() == change){
       try{
           String npin = newpin.getText();
           String rpin = repin.getText();
           
            if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                return;
            }
            if(npin.equals("")){
                JOptionPane.showMessageDialog(null, "Please Enter New PIN");
                
            }
           if (rpin.equals("")) {
               JOptionPane.showMessageDialog(null, "Please Re-Enter PIN");
                
           }
           Conn conn = new Conn();
                String q1 = "update bank set pin = '"+rpin+"' where pin = '"+pinnumber+"' ";
                String q2 = "update login set pin = '"+rpin+"' where pin = '"+pinnumber+"' ";
                String q3 = "update signupthree set pin = '"+rpin+"' where pin = '"+pinnumber+"' ";

                conn.s.executeUpdate(q1);
                conn.s.executeUpdate(q2);
                conn.s.executeUpdate(q3);
                
                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                setVisible(false);
                new Transactions(rpin).setVisible(true);
                
       } catch (Exception e){
           System.out.println(e);
       }
    } else{
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
        
       
    
    public static void main(String[] args){
        new PinChange("").setVisible(true);
        
      }
    }
