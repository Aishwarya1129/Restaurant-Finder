/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantfinder;
import java.util.*;
import java.awt.*;
import java.awt.List;
import java.awt.event.*;
import java.sql.*;

public class first extends Frame implements ActionListener
{
    Font myFont = new Font("Courier", Font.PLAIN,18);
    Font myFont1 = new Font("Courier", Font.BOLD,24);
    String n1;
    Button b1,b2;
    TextField t1,t2,t3,t4,t5,t6;
    Label l1,l2,l3,l4,l5,l6;
    Connection con=null;
    PreparedStatement stat;
first(String n)
{
    setBackground(Color.CYAN);
    n1=n;
    b1=new Button("Submit");
    b1.setBounds(200,400,100,30);
    b1.setFont(myFont);
    b2=new Button("Exit");
    b2.setBounds(200,450,100,30);
    b2.setFont(myFont);
    t1=new TextField();
    t1.setBounds(250,150,225,30);
    t1.setFont(myFont);
    t2=new TextField();
    t2.setBounds(250,200,225,30);
    t2.setFont(myFont);
    t3=new TextField();
    t3.setBounds(250,250,225,30);
    t3.setFont(myFont);
    t4=new TextField();
    t4.setBounds(250,300,225,30);
    t4.setFont(myFont);
    
    l1=new Label("Enter Restaurant name");
    l1.setBounds(25,150,200,30);
    l1.setFont(myFont);
    l2=new Label("Enter Address");
    l2.setBounds(25,200,200,30);
    l2.setFont(myFont);
    l3=new Label("Enter City");
    l3.setBounds(25,250,200,30);
    l3.setFont(myFont);
    l4=new Label("Enter no. of tables");
    l4.setBounds(25,300,200,30);
    l4.setFont(myFont);
    l5=new Label("WELCOME TO RESTAURANT FINDER!");
    l5.setBounds(25,50,450,50);
    l5.setFont(myFont1);
    //l6=new Label("Enter id");
    //t6=new TextField();
    
   
    
    b1.addActionListener(this);
    b2.addActionListener(this);
    setVisible(true);
    setSize(500,500);
    setLayout(null);
    //add(l6);
    //add(t6);
    add(l1);
    add(t1);
    add(l2);
    add(t2);
    add(l3);
    add(t3);
    add(l4);
    add(t4);
    add(b1);
    add(b2);
    add(l5);
    
}
public void actionPerformed(ActionEvent ae)
{
    if(ae.getSource()==b1)
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");  
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant","root","tiger");
            stat = con.prepareStatement("insert into restaurant1 values (?, ?, ?, ?, ?, ?, ?, ?)");
            //String id = t6.getText();
            String name = t1.getText();
            String address = t2.getText();
            String city = t3.getText();
            String avail_tables = t4.getText();
            String dishes = "";
            String price = "";
            
            
           
            stat.setInt(1, '1');
            stat.setString(2, name);
            stat.setString(3, address);
            stat.setString(4, city);
            stat.setInt(7, Integer.parseInt(avail_tables));
            stat.setString(5, dishes);
            stat.setString(6, price);
            stat.setString(8, n1);
            stat.executeUpdate();  
            //System.out.print("Restaurant Added");
            restaurant ob2 = new restaurant(n1);
            setVisible(false);
            con.close();
        }
        catch(Exception m)
        {
            System.out.println(m.getMessage());
        }

    }
    else if(ae.getSource()==b2)
    System.exit(0);
}
}
