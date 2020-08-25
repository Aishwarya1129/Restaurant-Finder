/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantfinder;
import java.awt.*;
import static java.awt.PageAttributes.ColorType.COLOR;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class second extends Frame implements ItemListener, ActionListener
{
    Font myFont = new Font("Courier", Font.PLAIN,18);
    Font myFont1 = new Font("Courier", Font.BOLD,24);
    List list1;
    Button b1,b2;
    TextField t1,t2;
    Label l1,l2,l3;
    Connection con=null;
    Statement stmt;
    PreparedStatement stat;
    Statement st;
    ResultSet rs;
    String temp4="";
    
    second(String n3)
    {       
        try
            {
                setBackground(Color.CYAN);
                l3=new Label("WELCOME TO RESTAURANT FINDER!");
                l3.setBounds(25,50,450,50);
                l3.setFont(myFont1);
                list1 = new List();
                String temp3 = "select *from restaurant1 where oname='"+n3+"';";
                Class.forName("com.mysql.cj.jdbc.Driver");  
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant","root","tiger");
                stmt = con.createStatement();
                rs=stmt.executeQuery(temp3);
                while(rs.next())
                    {
                         list1.add(rs.getString(2));
                    }
                
                list1.setBounds(25,150,200,200);
                list1.setFont(myFont);
                list1.addItemListener(this);
                add(l3);
                add(list1);
                setVisible(true);
                setSize(500,500);
                setLayout(new FlowLayout());
            }
        catch(Exception m)
            {
                System.out.println(m.getMessage());
            }
    }
    
    public void itemStateChanged(ItemEvent e)
    {
            temp4 =list1.getSelectedItem();
            remove(list1);
            list1.setBounds(25,150,200,200);
            list1.setFont(myFont);
            b1=new Button("Add");
            b1.setBounds(200,400,100,30);
            b1.setFont(myFont);
            b2=new Button("Exit");
            b2.setBounds(200,450,100,30);
            b2.setFont(myFont);
            t1=new TextField();
            t1.setBounds(250,200,200,30);
            t1.setFont(myFont);
            t2=new TextField();
            t2.setBounds(250,300,200,30);
            t2.setFont(myFont);
            l1=new Label("Enter Dishes: ");
            l1.setBounds(250,150,200,30);
            l1.setFont(myFont);
            l2=new Label("Enter Prices: ");
            l2.setBounds(250,250,200,30);
            l2.setFont(myFont);
            b1.addActionListener(this);
            b2.addActionListener(this);
            setVisible(true);
            setSize(500,500);
            setLayout(null);
            add(l1);
            add(t1);
            add(l2);
            add(t2);
            add(b1);
            add(b2);
            add(list1);
    }

    
    public void actionPerformed(ActionEvent ae)
    {
       
        if(ae.getSource()==b1)
            {
                //System.out.println("");
                //System.out.print(temp4);
                try
                    {
                        String d="", p="";
                        Class.forName("com.mysql.cj.jdbc.Driver");  
                        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant","root","tiger");
                        //stat = con.prepareStatement("select * from restaurant1 where name = "+"'"+temp4+"'");
                        String SQL = "select * from restaurant1 where name = "+"'"+temp4+"'";  
                        st = con.createStatement();  
                        rs = st.executeQuery(SQL);
                        while(rs.next())
                        {
                            d = rs.getString(5);
                            p = rs.getString(6);
                        }
                        stat = con.prepareStatement("update restaurant1 set dishes = ?, price = ? where name = "+"'"+temp4+"'");
                        String dishes = d + t1.getText() + ",";
                        String price = p + t2.getText() + ",";
            
          
                        stat.setString(1, dishes);
                        stat.setString(2, price);
                        stat.executeUpdate();  
                        //System.out.print("done");
                        con.close();
                        //setVisible(false);
                    }
                catch(Exception m)
                    {
                        System.out.println(m.getMessage());
                    }
            }
        if(ae.getSource()==b2)
        {
            System.exit(0);
        }    
    }
}

