package restaurantfinder;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class login2 extends Frame implements ActionListener
{
    Button b1, b2, b3;
    TextField t1, t2;
    Label l1,l2,l3,l4;
    Connection con=null;
    PreparedStatement stat;
    Statement st;
    ResultSet rs;
    login2()
    {
        setBackground(Color.CYAN);
        Font myFont = new Font("Courier", Font.PLAIN,18);
        Font myFont1 = new Font("Courier", Font.BOLD,24);
        b1 = new Button("Login");
        b1.setBounds(212,350,75,30);
        b1.setFont(myFont);
        b2 = new Button("Back");
        b2.setBounds(212,400,75,30);
        b2.setFont(myFont);
        b3 = new Button("Exit");
        b3.setBounds(212,450,75,30);
        b3.setFont(myFont);
        t1 = new TextField();
        t1.setBounds(150,150,200,30);
        t1.setFont(myFont);
        t2 = new TextField();
        t2.setEchoChar('*');
        t2.setBounds(150,250,200,30);
        t2.setFont(myFont);
        l1 = new Label("WELCOME TO RESTAURANT FINDER!");
        l1.setBounds(25,50,450,50);
        l1.setFont(myFont1);
        l2 = new Label("Enter email id");
        l2.setBounds(195,100,200,30);
        l2.setFont(myFont);
        l3 = new Label("Enter password");
        l3.setBounds(185,200,200,30);
        l3.setFont(myFont);
        l4 = new Label ("                               ");
        l4.setBounds(165,300,200,30);
        l4.setFont(myFont);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        
        add(l1);
        add(l2);
        add(t1);
        add(l3);
        add(t2);
        add(b1);
        add(b2);
        add(l4);
        add(b3);
        
        setLayout(null);
        setSize(500,500);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {
            try
            {
                String temp=t1.getText();
                Class.forName("com.mysql.cj.jdbc.Driver");  
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant","root","tiger");
                String SQL = "select * from owner1 where email = '"+temp+"'";  
                st = con.createStatement();  
                rs = st.executeQuery(SQL);
                String a = "";
                String n = "";
                while(rs.next())
                {
                a = rs.getString(4);
                n = rs.getString(2);
                }        
                if(a.equals(""))
                {
                    l4.setText("Enter correct details!!");
                }
                else
                {
                    if(t2.getText().equals(a))
                    {
                        setVisible(false);
                        restaurant ob2 =new restaurant(n);
                    }
                }
            }
            catch(Exception e)
            {
                System.out.println("error "+e.getMessage());
            }
        }
        if(ae.getSource()==b2)
        {
            setVisible(false);
            hotel a = new hotel();
        }
        if(ae.getSource()==b3)
        {
            System.exit(0);
        }
    }
}
public class OwnerLogin
{
    public static void main(String args[])
    {
        login2 abc = new login2();
    }
}
