package farmer.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class FarmerDashBoard extends JFrame implements ActionListener
{
        JButton Crop,Land,Farmer,Market,Search,Loan,Logout;
        FarmerDashBoard()
        {
            setSize(1000,600);                                 //frame size in height,width
            setLocation(150,90);
            setVisible(true);
            getContentPane().setBackground(Color.WHITE);                       //background color of frame
            setLayout(null);
            
            setTitle("FARMER DASH BOARD");   
            
            JLabel heading=new JLabel("WELCOME FARMER !! WORLD HOPES ON YOU!!");
            add(heading);
            heading.setBounds(60,20,700,60);
            heading.setFont(new Font("serif",Font.BOLD,28));
            heading.setForeground(Color.BLACK);
            
            ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("images/FARMER1.jpg"));    //for image we use image icon class in this object is created i1.in image loader for oading image and address of image is passed in it
            Image i2=i1.getImage().getScaledInstance(1000,600,Image.SCALE_DEFAULT);                    //for scaling image and stored in i2.for this image class is used
            ImageIcon i3=new ImageIcon(i2);      // image converted back to imageicon
            JLabel image=new JLabel(i3);         // can't directly add so jlabel is created and then it is added
            image.setBounds(0,10,990,590);
            add(image);
            
            
            Crop=new JButton("Crop Details");                      //LOGIN Button
            Crop.setBounds(100,150,150,50);                              
            Crop.setBackground(Color.BLACK);
            Crop.setForeground(Color.WHITE);
            Crop.addActionListener(this);
             add(Crop); 
               
            Farmer=new JButton("Farmer Details");                //register button
            Farmer.setBounds(300,150,150,50);
            Farmer.setBackground(Color.BLACK);
            Farmer.setForeground(Color.WHITE);
            Farmer.addActionListener(this);
            add(Farmer);
            
            Land=new JButton("Land Details");                      //LOGIN Button
            Land.setBounds(500,150,150,50);                              
            Land.setBackground(Color.BLACK);
            Land.setForeground(Color.WHITE);
            Land.addActionListener(this);
             add(Land); 
            
            Market=new JButton("Market Linkage Details");                      //LOGIN Button
            Market.setBounds(100,250,160,50);                              
            Market.setBackground(Color.BLACK);
            Market.setForeground(Color.WHITE);
            Market.addActionListener(this);
             add(Market); 
               
            Search=new JButton("Search");                //register button
            Search.setBounds(300,250,150,50);
            Search.setBackground(Color.BLACK);
            Search.setForeground(Color.WHITE);
            Search.addActionListener(this);
            add(Search);
            
            Loan=new JButton("Loan Details");                      //LOGIN Button
            Loan.setBounds(500,250,150,50);                              
            Loan.setBackground(Color.BLACK);
            Loan.setForeground(Color.WHITE);
            Loan.addActionListener(this);
             add(Loan); 
               
            
                          
            Logout=new JButton("Logout");                //register button
            Logout.setBounds(300,350,150,50);
            Logout.setBackground(Color.BLACK);
            Logout.setForeground(Color.WHITE);
            Logout.addActionListener(this);
            add(Logout);
            
        }
        
         public void actionPerformed(ActionEvent ae)
           {
                   
               if(ae.getSource()==Crop)
              {
                    new Crop();
              }
               else if(ae.getSource()==Farmer)
               {
                   new Farmer();
               }
                else if(ae.getSource()==Land)
               {
                    new Land();
               }
                else if(ae.getSource()==Market)
               {
                    new Market();
               }
                else if(ae.getSource()==Search)
               {
                   new Search();
               }
               else if(ae.getSource()==Loan)
               {
                   new Loan();
               }
               else 
               {
                    System.exit(0);

               }
               
           }
 public static void main(String[] args)
 {
                    new FarmerDashBoard();
  }
}


