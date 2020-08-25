package restaurantfinder;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class insert1 extends Frame implements ActionListener
{
Button b1,b2,b3,b4;
List list7;
Label l1;
Connection cont=null;
//PreparedStatement stat;
ResultSet res=null; 
insert1()
{
    setBackground(Color.CYAN);
Font myFont = new Font("Courier", Font.PLAIN,18);
Font myFont1 = new Font("Courier", Font.BOLD,24);
b1=new Button("View User");
b1.setBounds(30,150,200,30);
b1.setFont(myFont);
b2=new Button("View Owner");
b2.setBounds(30,250,200,30);
b2.setFont(myFont);
b3=new Button("View Restaurants");
b3.setBounds(30,350,200,30);
b3.setFont(myFont);
b4=new Button("Back");
b4.setBounds(212,450,75,30);
b4.setFont(myFont);
list7=new List();
list7.setBounds(250,125,200,275);
list7.setFont(myFont);
l1 = new Label("WELCOME TO RESTAURANT FINDER!");
l1.setBounds(25,50,450,50);
l1.setFont(myFont1);
setLayout(null);

add(b1);
add(b2);
add(b3);
add(l1);
add(b4);
b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);

b4.addActionListener(this);

setSize(500,500);

setVisible(true);
}
public void actionPerformed(ActionEvent a)
{
if (a.getSource()==b1)
{list7.clear();
  try
  {//list7=new List();
      add(list7);
      //list7.setSize(500,600);
  Class.forName("com.mysql.cj.jdbc.Driver");  
         cont = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant","root","tiger");
         Statement stmt = cont.createStatement();  
         res = stmt.executeQuery("select * from user1"); 
         while (res.next()) {  
           list7.add(res.getString(2)+" "+res.getString(3)+" "+res.getString(4));
         } 
  }
  catch(Exception m)
  {
      System.out.println(m.getMessage());
  }
  }
else if(a.getSource()==b2)
{list7.clear();
  try
  {//list7=new List();
      add(list7);
       //list7.setSize(500,600);
  Class.forName("com.mysql.cj.jdbc.Driver");  
         cont = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant","root","tiger");
         Statement stmt = cont.createStatement();  
         res = stmt.executeQuery("select * from owner1"); 
         while (res.next()) {  
           list7.add(res.getString(2)+" "+res.getString(3)+" "+res.getString(4));
         } 
  }
  catch(Exception m)
  {
      System.out.println(m.getMessage());
  } 
  }
else if(a.getSource()==b3)
{list7.clear();
  try
  {//list7=new List();
      add(list7);
       //list7.setSize(500,600);
       
  Class.forName("com.mysql.cj.jdbc.Driver");  
         cont = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant","root","tiger");
         Statement stmt = cont.createStatement();  
         res = stmt.executeQuery("select * from restaurant1"); 
         while (res.next()) {  
           list7.add(res.getInt(1)+"  "+res.getString(2)+" "+res.getString(3)+" "+res.getString(4)+" "+res.getString(5)+" "+res.getString(6));
         } 
  }
  catch(Exception m)
  {
      System.out.println(m.getMessage());
  }
  }
else if(a.getSource()==b4)
{
    setVisible(false);
    hotel q = new hotel();}
}
}

public class Adminview {
    public static void main(String[] args) {
        insert1 ob=new insert1();// TODO code application logic here
    }
}
