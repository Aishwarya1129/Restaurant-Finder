package restaurantfinder;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class finder1 extends Frame implements ActionListener,ItemListener
{
 TextField t1;
 Label l1,l2,l3,l4,l5,l6,l10,l11,l12;
 Button b1,b2,b3, b4;
 List list1,list2,list3;
 Connection con=null;
 Statement stmt=null;
 ResultSet rs = null;
 PreparedStatement stat;
 Font myFont = new Font("Courier", Font.PLAIN,18);
 Font myFont1 = new Font("Courier", Font.BOLD,24);
 finder1()
 {
    setBackground(Color.CYAN);
  t1=new TextField();
  t1.setBounds(25,200,200,30);
    t1.setFont(myFont);
  l1=new Label("WELCOME TO RESTAURANT FINDER!");
  l1.setBounds(25,50,450,50);
    l1.setFont(myFont1);
  l2=new Label("Enter City ");
  l2.setBounds(25,150,200,50);
    l2.setFont(myFont);
  l3=new Label(" ");
  l3.setBounds(225,150,250,50);
    l3.setFont(myFont);
  l4=new Label(" ");
  l4.setBounds(25,200,100,50);
    l4.setFont(myFont);
  l5=new Label(" ");
  l5.setBounds(150,200,250,50);
    l5.setFont(myFont);
  l10=new Label(" ");
  l10.setBounds(25,250,200,50);
    l10.setFont(myFont);
  l11=new Label(" ");
  l11.setBounds(250,250,50,50);
    l11.setFont(myFont);
  l6=new Label(" ");
  l6.setBounds(100,300,150,50);
    l6.setFont(myFont);
  l12=new Label(" ");
  l12.setBounds(325,300,150,30);
l12.setFont(myFont);
  b1=new Button("Search");
  b1.setBounds(25,250,100,30);
    b1.setFont(myFont);
  b2=new Button("Back");
  b2.setBounds(380,450,100,30);
    b2.setFont(myFont);
  list1=new List();
  list1.setBounds(250,125,200,150);
list1.setFont(myFont);
  list2=new List();
  list2.setBounds(25,350,125,125);
list2.setFont(myFont);
  list3=new List();
  list3.setBounds(175,350,125,125);
list3.setFont(myFont);
  //setLayout(new FlowLayout());
  setLayout(null);
  
  add(l1);
  add(l2);

  add(t1);
  add(b1);
  add(b2);
  
  
  b1.addActionListener(this);
  b2.addActionListener(this);
  list1.addItemListener(this);
  
  setSize(500,500);
  setVisible(true);
 } 
 

 public void actionPerformed(ActionEvent a)
 {
  if (a.getSource()==b1)
  {
    
  //System.out.println("Searching");
  try
  {
  
    
    //System.out.println("Trying");
    Class.forName("com.mysql.cj.jdbc.Driver");  
    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant","root","tiger");
    stat = con.prepareStatement("select name from restaurant1 where city = ? ");
    String city = t1.getText();
    stat.setString(1,city);
    rs=stat.executeQuery();  
    //System.out.print("done");
    add(list1);
    while (rs.next())      
    {
     list1.add(rs.getString(1));
    }
  }
  catch(Exception m)
  {
      System.out.println(m.getMessage());
  }
  }
  if (a.getSource()==b3)
  {
   //System.out.println("Booking");
   try
   {
    //System.out.println("Trying");
    Class.forName("com.mysql.cj.jdbc.Driver");  
    stmt=con.createStatement();  
    rs=stmt.executeQuery("select id,avail_tables from restaurant1");  
    
    while(rs.next()) 
    {
        
     int id=Integer.parseInt(rs.getString(1));
     int table=Integer.parseInt(rs.getString(2));
     //System.out.print(table);
     if (table>0)
      {
       //System.out.println("Entered");
          l12.setText("Table booked");
       table= table-1;
       l11.setText(String.valueOf(table));
       //System.out.print(table);
       stat = con.prepareStatement("update restaurant1 set avail_tables = ? where id = ? ");
       stat.setInt(1,table);
       stat.setInt(2,id);
       stat.executeUpdate();
      }     
     else
      {   
       l12.setText("Restaurant full");
      }
    }
   } 
   catch(Exception m)
   {
      System.out.println(m.getMessage());
   }
  }
  else if(a.getSource()==b2)
  {
  setVisible(false);
    hotel s = new hotel();
  }
 } 
public void itemStateChanged(ItemEvent e)
{
 String temp=list1.getSelectedItem();
 remove(t1);
 remove(list1);
 list1.setBounds(0,0,1,1);
list1.setFont(myFont);
 remove(b1);
 b3=new Button("Book Table");
  b3.setBounds(375,250,100,30);
  b3.setFont(myFont);
 add(b3);
 b3.addActionListener(this);
 try
  {
    Class.forName("com.mysql.cj.jdbc.Driver");  
    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant","root","tiger");
    stmt=con.createStatement();  
    rs=stmt.executeQuery("select * from restaurant1 where name= "+"'"+temp+"'");  
    while(rs.next()) 
    {   
       l2.setText("Name of the Restaurant:");
       l3.setText(rs.getString(2));
       l4.setText("Address:");
       l5.setText(rs.getString(3)+" "+rs.getString(4));
       l10.setText("Available Tables:");
       l11.setText(rs.getString(7));
       l6.setText("Menu:");
        add(l3);
        add(l4);
        add(l5);
        add(l10);
        add(l11);

        add(l12);
        add(l6);
       String m=rs.getString(5);
       String[] menu= m.split(",");
       String p=rs.getString(6);
       String[] price= p.split(",");
       add(list2);
       add(list3);
       
       for (int j = 0; j <= menu.length; j++) 
       {
        list2.add(menu[j]);
        list3.add(price[j]);
       }
    }
    con.close();
  }
  catch(Exception m)
  {
      System.out.println(m.getMessage());
  }
}
}

public class Userview {
    public static void main(String[] args) {
        finder1 ob=new finder1();
    }
}
