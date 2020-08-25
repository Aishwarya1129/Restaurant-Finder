/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantfinder;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class restaurant extends Frame implements ActionListener
{
    Font myFont = new Font("Courier", Font.PLAIN,18);
    Font myFont1 = new Font("Courier", Font.BOLD,24);
    Button b1,b2,b3;
    Label l3;
    Connection con=null;
    Statement stat;
    ResultSet rs;
    String name1="";
    restaurant(String temp1)
    {
        setBackground(Color.CYAN);
        System.out.print(temp1);
        name1=temp1;
        try
        {
            l3=new Label("WELCOME TO RESTAURANT FINDER!");
            l3.setBounds(25,50,450,50);
            l3.setFont(myFont1);
         String n3="";
         int flag=0;
         String n1 = "select count(*) from restaurant1 where oname= "+"'"+temp1+"'";
         Class.forName("com.mysql.cj.jdbc.Driver");  
         con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant","root","tiger");
         stat = con.createStatement();
         rs=stat.executeQuery(n1);
         while(rs.next())
             n3 = rs.getString(1);
         flag=Integer.parseInt(n3);
        if(flag>0)
        {
            b1=new Button("ADD RESTAURANT");
            b1.setBounds(125,150,250,30);
            b1.setFont(myFont);
            b2=new Button("ADD MENU");
            b2.setBounds(175,250,150,30);
            b2.setFont(myFont);
            b3=new Button("Back");
            b3.setBounds(200,450,100,30);
            b3.setFont(myFont);
            setVisible(true);
            setSize(500,500);
            setLayout(null);
        
            b1.addActionListener(this);
            b2.addActionListener(this);
            b3.addActionListener(this);
        
            add(b1);
            add(b2);
            add(b3);
            add(l3);
          
        }
        else
        {
            b1=new Button("ADD RESTAURANT");
            b1.setBounds(125,250,250,30);
            b1.setFont(myFont);
            b3=new Button("Back");
            b3.setBounds(212,450,75,30);
            b3.setFont(myFont);
            setVisible(true);
            setSize(500,500);
            setLayout(null);
        
            b1.addActionListener(this);
            b3.addActionListener(this);
        
            add(b1);
            add(b3);
        }
        }
         catch(Exception m)
        {
            System.out.println(m.getMessage());
        }
        
       
    }
                                       
    public void actionPerformed(ActionEvent ae2)
    {
    if(ae2.getSource()== b1)
    {
        
            first ob3;
            ob3 = new first(name1);
            setVisible(false);      
    }
    
    if(ae2.getSource()==b2)
    {    
        second ob4 = new second(name1);
        setVisible(false);
    }
    else if(ae2.getSource()==b3)
    {
        setVisible(false);
    hotel s = new hotel();
    }
    
}
}


