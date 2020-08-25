package restaurantfinder;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

class osignup extends Frame implements ActionListener
{
Label l1,l2,l3,l4,l5;
Button b1,b2,b3,b4;
TextField t1,t2,t3;
Connection con=null;
PreparedStatement stat;
Statement st;
ResultSet rs;
osignup()
{
    setBackground(Color.CYAN);
    Font myFont = new Font("Courier", Font.PLAIN,18);
    Font myFont1 = new Font("Courier", Font.BOLD,24);
    l1=new Label("Enter your name:");
    l1.setBounds(30,150,200,50);
    l1.setFont(myFont);
    t1=new TextField(10);
    t1.setBounds(300,150,100,30);
    t1.setFont(myFont);
    l2=new Label("Enter your email id:");
    l2.setBounds(30,200,200,50);
    l2.setFont(myFont);
    t2=new TextField(10);
    t2.setBounds(300,200,100,30);
    t2.setFont(myFont);
    l4=new Label("Enter your password:");
    l4.setBounds(30,250,200,50);
    l4.setFont(myFont);
    t3=new TextField(10);
    t3.setEchoChar('*');
    t3.setBounds(300,250,100,30);
    t3.setFont(myFont);
    b1=new Button("Submit");
    b1.setBounds(200,350,100,30);
    b1.setFont(myFont);
    l3=new Label("WELCOME TO RESTAURANT FINDER!");
    l3.setBounds(25,50,450,50);
    l3.setFont(myFont1);
    b2=new Button("Exit");
    b2.setBounds(212,450,75,30);
    b2.setFont(myFont);
    b3=new Button("Back");
    b3.setBounds(212,400,75,30);
    b3.setFont(myFont);
    l5=new Label("                     ");
    l5.setBounds(125,300,300,30);
    
    add(l3);
    add(l1);
    add(l2);
    add(b1);
    add(t1);
    add(t2);
    add(t3);
    add(l4);
    add(b2);
    add(b3);
    add(l5);
    b1.addActionListener(this);
    b2.addActionListener(this);
    b3.addActionListener(this);
    
    setSize(500,500);
    setLayout(null);
    setVisible(true);

}

public void actionPerformed(ActionEvent a)
{
  if(a.getSource()==b3)
 {
     setVisible(false);
     hotel b = new hotel();
 }  
 if(a.getSource()==b2)
 {
     System.exit(0);
 }
 if(a.getSource()==b1)
 {
     try
     {
         //System.out.println("Wait, in process");
     Class.forName("com.mysql.jdbc.Driver");  
     con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant","root","tiger");
     stat = con.prepareStatement("insert into owner1 values(?,?,?,?) ");
     stat.setString(1,Integer.toString(3));
     //System.out.println("Wait");
    String name= t1.getText();
    stat.setString(2,name);
    String mail= t2.getText();
    stat.setString(3,mail);
    String pass= t3.getText();
    stat.setString(4,pass);
    //System.out.println("Wait, in process");
    
    stat.executeUpdate();  
    //System.out.print("done");
    l5.setText("Submitted");
    con.close();
     }
     catch (Exception m)
     {
         l5.setText(m.getMessage());
         //System.out.println(m.getMessage());
     }
     
 }
}
}

public class OwnerSignup {
    public static void main(String args[])
    {
        osignup o1 = new osignup();
    }
    
}