package farmer.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Random;



public class login extends JFrame implements ActionListener
{
          JLabel lusername,lpassword,lrole;                                            //Label name declaration
          JTextField tusername,tpassword,trole;    //Text fields name
          JButton login,register;
             
        login()
        {

              setSize(600,500);                                 //frame size in height,width
              setLocation(450,200);
              setVisible(true);
              setTitle("      FARMER MANAGEMENT SYSTEM     ");
   
              getContentPane().setBackground(Color.WHITE);                       //background color of frame
              setLayout(null);
           
             lusername=new JLabel("Username");                          //label for username
             lusername.setBounds(40,20,100,30);                                      // coordinates for username display
             add(lusername);
      
            tusername=new JTextField();                                             //for writing space
            tusername.setBounds(150,20,150,30); 
            add(tusername);
            
             lpassword=new JLabel("Password");
             lpassword.setBounds(40,90,100,30) ;                            //parameters x,y,height,width
             add(lpassword);

             tpassword=new JTextField();
             tpassword.setBounds(150,90,150,30);
             add(tpassword);

             lrole=new JLabel("Role");                                     // label for role
             lrole.setBounds(40,160,100,30);
             add(lrole);

             trole=new JTextField();                                         //textbox for role
             trole.setBounds(150,160,150,30);
             add(trole);
              
             login=new JButton("LOGIN");                      //LOGIN Button
             login.setBounds(100,270,150,30);                              
             login.setBackground(Color.BLACK);
             login.setForeground(Color.WHITE);
             login.addActionListener(this);
             add(login); 
               
            register=new JButton("Register?");                //register button
            register.setBounds(300,270,150,30);
            register.setBackground(Color.BLACK);
            register.setForeground(Color.WHITE);
            register.addActionListener(this);
            add(register);
             
             
        }
        public void actionPerformed(ActionEvent ae)
           {
              if(ae.getSource()==login)
              {

                 try
                 {
                      
                       String name=tusername.getText();                    // getText fetch username from tusername
                  
                      String passd = new String(tpassword.getText());
                       String  roles=trole.getText();

                       conn c=new conn();                                          // object of connection class
                      String query="Select * from users where username='"+name+"'and password='"+passd+"'and roles ='"+roles+"'";

                         
                        ResultSet rs= c.s.executeQuery(query);                   // conn class se statement calling then value is stored inside resultset object this will execute query
                        
                        if(rs.next())                                           // next() to check value inside rs 
                        {
                            
                            String roleLower = roles.toLowerCase();

                             if(roleLower.equals("farmer"))
                             {
                                    JOptionPane.showMessageDialog(this, "WELCOME");
                                    setVisible(false);
                                    new FarmerDashBoard();
                              }
                             else if(roleLower.equals("government"))
                             {
                                   // setVisible(false);
                                    // new admin();
                              }
                                dispose();
                        }
                       else
                        {
                                JOptionPane.showMessageDialog(null,"Invalid username or password");                     // a pop message box in swing,1st parameter can be null too,2nd is for message
                                setVisible(false);
                         }
                                                
                        }
                        catch(Exception e)
                        {
                            e.printStackTrace();                   // print details of error    
                        }
              }
              else
              {
 
                       new Registration();
                }

             }//action closed 

                 
             
 public static void main(String[] args)
 {
                    new login();
                  //  new UserRegistration();
  }
}



