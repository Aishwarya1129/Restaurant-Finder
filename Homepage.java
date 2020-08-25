package restaurantfinder;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

class hotel extends Frame implements ActionListener
{
Label l1,l2,l3;
Button b1,b2,b3,b4,b5,b6;
Connection con=null;
hotel()
{
    setBackground(Color.CYAN);
    Font myFont = new Font("Courier", Font.PLAIN,18);
    Font myFont1 = new Font("Courier", Font.BOLD,24);
    l1=new Label("Are you an owner?");
    l1.setBounds(50,150,175,60);
    l1.setFont(myFont);
    b1=new Button("Log In");
    b1.setBounds(90,250,75,30);
    b1.setFont(myFont);
    b2=new Button("Sign Up");
    b2.setBounds(90,300,75,30);
    b2.setFont(myFont);
    l2=new Label("Are you a user?");
    l2.setBounds(300,150,175,60);
    l2.setFont(myFont);
    b3=new Button("Log In");
    b3.setBounds(330,250,75,30);
    b3.setFont(myFont);
    b4=new Button("Sign Up");
    b4.setBounds(330,300,75,30);
    b4.setFont(myFont);
    l3=new Label("WELCOME TO RESTAURANT FINDER!");
    l3.setBounds(25,50,450,50);
    l3.setFont(myFont1);
    b5=new Button("Exit");
    b5.setBounds(212,450,75,30);
    b5.setFont(myFont);
    b6=new Button("Admin");
    b6.setBounds(212,400,75,30);
    b6.setFont(myFont);
    
    add(l3);
    add(l1);
    add(l2);
    add(b1);
    add(b2);
    add(b3);
    add(b4);
    add(b5);
    add(b6);
    b1.addActionListener(this);
    b2.addActionListener(this);
    b3.addActionListener(this);
    b4.addActionListener(this);
    b5.addActionListener(this);
    b6.addActionListener(this);
    
    setSize(500,500);
    setLayout(null);
    setVisible(true);

}

public void actionPerformed(ActionEvent ae)
{
    if(ae.getSource()==b6)
    {
        setVisible(false);
        login3 l= new login3();
        //System.out.println("water");
           
    }
    if(ae.getSource()==b5)
    {
        System.exit(0);           
    }
    if(ae.getSource()==b4)
    {
        setVisible(false);
        signup sign=new signup();
        //System.out.println("water");
           
    }
    if(ae.getSource()==b3)
    {
        setVisible(false);
        login1 log=new login1();
        //System.out.println("water");
           
    }

    if(ae.getSource()==b2)
    {
        setVisible(false);
        osignup sign=new osignup();
        //System.out.println("water");
           
    }
    if(ae.getSource()==b1)
    {
        setVisible(false);
        login2 log=new login2();
        //System.out.println("water");
    }
}
}
public class Homepage {
    public static void main(String[] args)
    {
        hotel roti = new hotel();
    }
    
}