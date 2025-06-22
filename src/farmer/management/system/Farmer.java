package farmer.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;


public class Farmer extends JFrame implements ActionListener
{
        JButton fmodify,fview,flogout;
        Farmer()
        {
            
            setSize(1000,600);                                 //frame size in height,width
            setLocation(150,90);
            setVisible(true);
            getContentPane().setBackground(Color.WHITE);                       //background color of frame
            setLayout(null);
            
            setTitle("Farmer DASH BOARD");   
            
            JLabel heading=new JLabel("     FARMER DETAILS   ");
            add(heading);
            heading.setBounds(70,20,700,60);
            heading.setFont(new Font("serif",Font.BOLD,40));
            heading.setForeground(Color.BLACK);
            
            ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("images/farmer.jpg"));    //for image we use image icon class in this object is created i1.in image loader for oading image and address of image is passed in it
            Image i2=i1.getImage().getScaledInstance(1000,600,Image.SCALE_DEFAULT);                    //for scaling image and stored in i2.for this image class is used
            ImageIcon i3=new ImageIcon(i2);      // image converted back to imageicon
            JLabel image=new JLabel(i3);         // can't directly add so jlabel is created and then it is added
            image.setBounds(0,10,990,590);
            add(image);
             
               
            
            fmodify=new JButton("Modify Farmer Details ");                      //LOGIN Button
            fmodify.setBounds(300,150,160,50);                              
            fmodify.setBackground(Color.BLACK);
            fmodify.setForeground(Color.WHITE);
            fmodify.addActionListener(this);
             add(fmodify); 
               
            fview=new JButton("View Details");                //register button
            fview.setBounds(500,150,150,50);
            fview.setBackground(Color.BLACK);
            fview.setForeground(Color.WHITE);
            fview.addActionListener(this);
            add(fview);
            
            flogout=new JButton("Back");                //register button
            flogout.setBounds(700,150,150,50);
            flogout.setBackground(Color.BLACK);
            flogout.setForeground(Color.WHITE);
            flogout.addActionListener(this);
            add(flogout);
        }
         public void actionPerformed(ActionEvent ae)
         {
                   
              
               if(ae.getSource()==fmodify)
               {
                    new updatefarmer ();
               }
               else if(ae.getSource()==fview)
               {
                    new viewfarmer ();
               }
               
               else 
               {
                    new FarmerDashBoard();
               }
           }
}


class viewfarmer extends JFrame 
{
      JTable table;
      DefaultTableModel model;
      JTextField farmer_id;
      JButton fetch;
    
    viewfarmer()
    {
            setSize(900,600);                                 //frame size in height,width
            setLocation(300,50);
            setVisible(true);
            getContentPane().setBackground(Color.WHITE); //background color of frame
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setLayout(new BorderLayout());
            
            
            JPanel input=new JPanel();
            input.add(new JLabel("Enter Farmer ID"));
            farmer_id=new JTextField(10);
            input.add(farmer_id);
            
            fetch=new JButton("view");
            input.add(fetch,BorderLayout.NORTH);
            add(input,BorderLayout.NORTH);
           
        
          model=new DefaultTableModel(new String[]{"Farmer Id","Name","Address","Age","Date of birth","user ID"},0);
        
          table=new JTable(model);
          JScrollPane scrollPane=new JScrollPane(table);
          add(scrollPane,BorderLayout.CENTER);
          
           fetch.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    int farmerid;
                    
                    try
                    {
                        farmerid=Integer.parseInt(farmer_id.getText().trim());
                        fetchcrop(farmerid);
                    }
                    catch(NumberFormatException g)
                    {
                        JOptionPane.showMessageDialog(null,"Please enter valid farmer id");
                    }
                }
            });
       }
    
       void fetchcrop(int farmerid)
       {
           model.setRowCount(0);
          try
          {
              conn c=new conn();
              PreparedStatement check=c.prepareStatement("Select * from farmer_details where f_id=?");
              check.setInt(1,farmerid);
              ResultSet rs1=check.executeQuery();
              if(!rs1.next())
              {
                  JOptionPane.showMessageDialog(this,"Invalid Farmer ID");
                  rs1.close();
                  return;
              }
             
              
            PreparedStatement ps=c.prepareStatement("Select * from farmer_details where f_id=?"); 
            ps.setInt(1,farmerid);
            ResultSet rs=ps.executeQuery();
            boolean found=false;
              
              while(rs.next())
              {
                  found=true;
                  model.addRow(new Object[]{
                      rs.getInt("f_id"),
                      rs.getString("Name"),
                      rs.getString("Address"),
                      rs.getInt("Age"),
                      rs.getDate("dob"),
                      rs.getString("phone_no"),
                      rs.getInt("user_id"),  
                  });
                  
              }
              rs.close();
             }
          catch(Exception e)
          {
              e.printStackTrace();
          }
    }
}





class updatefarmer extends JFrame implements ActionListener
{
     JLabel f_id,f_name,addr,f_age,f_dob,phone,u_id;
     JTextField tff_id,tff_name,tfaddr,tff_age,tff_dob,tfphone,tfu_id;
     JComboBox<String> farmerdrop;
     JButton update,back,fetch;
 
   updatefarmer()
   {
            setSize(900,600);                                 //frame size in height,width
            setLocation(300,50);
            setVisible(true);
            getContentPane().setBackground(Color.CYAN);                       //background color of frame
            setLayout(null);
            
            JLabel heading1=new JLabel("UPDATE FARMER ");
            heading1.setBounds(150,20,500,50);
            heading1.setFont(new Font("serif",Font.BOLD,40));
            heading1.setForeground(Color.BLACK);
            add(heading1);
            
            
            f_id=new JLabel("Farmer ID");                       // inpuut for farmmer id
             f_id.setBounds(50,100,150,30) ;
             add(f_id);

             tff_id=new JTextField();
             tff_id.setBounds(200,100,150,30);
             add(tff_id);
             
             
             fetch=new JButton("Fetch Farmer");
             fetch.setBounds(380,100,150,30);
             fetch.addActionListener(new ActionListener()
             {
                   public void actionPerformed(ActionEvent e)
                   {
               
                    try
                    {
                        int farmerid=Integer.parseInt(tff_id.getText().trim());
                        fetchfarmer(farmerid);
                    }
                    catch(NumberFormatException g)
                    {
                        JOptionPane.showMessageDialog(null,"Please enter valid farmer id");
                    }
                }  
              });
             add(fetch);
             
             
         
             
           JLabel farmerlabel=new JLabel("Select Farmer");
             farmerlabel.setBounds(50,150,150,30);
             add(farmerlabel);
             
             farmerdrop=new JComboBox<>();
             farmerdrop.setBounds(200,150,150,30);
             farmerdrop.setVisible(false);        // hidden initially
             add(farmerdrop);
             
             
                
             
             f_name=new JLabel("Farmer name");            //crop name will be uneditable
             f_name.setBounds(50,200,150,30) ;
             add(f_name);

             tff_name=new JTextField();
             tff_name.setBounds(200,200,150,30);
             tff_name.setEditable(true);
             add(tff_name);
             
                    
             
             addr=new JLabel("Farmer Address");
             addr.setBounds(400,200,150,30) ;
             add(addr);

             tfaddr=new JTextField();
             tfaddr.setBounds(600,200,150,30);
             tfaddr.setEditable(true);
             add(tfaddr);
             
             f_age=new JLabel(" Age");
             f_age.setBounds(50,250,155,30) ;
             add(f_age);

             tff_age=new JTextField();
             tff_age.setBounds(200,250,150,30);
             tff_age.setEditable(true);
             add(tff_age);
            
             f_dob=new JLabel("Date Of Birth");
             f_dob.setBounds(400,250,150,30);
             add(f_dob);

             tff_dob=new JTextField();
             tff_dob.setBounds(600,250,150,30);
             tff_dob.setEditable(true);
             add(tff_dob);
            
            
             phone=new JLabel("Phone number");
             phone.setBounds(50,300,150,30);
             add(phone);

             tfphone=new JTextField();
             tfphone.setBounds(200,300,150,30);
             tfphone.setEditable(true);
             add(tfphone);

      
            update=new JButton("Update Farmer Details");                //register button
            update.setBounds(600,450,170,50);
            update.setBackground(Color.BLACK);
            update.setForeground(Color.WHITE);
            update.addActionListener(this);
            add(update);
            
            back=new JButton("Back");                //register button
            back.setBounds(200,450,150,50);
            back.setBackground(Color.BLACK);
            back.setForeground(Color.WHITE);
            back.addActionListener(this);
            add(back);

   } 
   
   private void fetchfarmer(int farmerid)
   {
       farmerdrop.setVisible(true);
       try
       {
              conn c=new conn();
              String query="Select * from farmer_details where f_id=?";
              PreparedStatement ps=c.prepareStatement(query);
              ps.setInt(1,farmerid);
              ResultSet rs=ps.executeQuery();
              
              // fill value in dropdown
              
              farmerdrop.removeAllItems();    // clear previous item
              while(rs.next())
              {
                   String farmer=rs.getString("f_id");
                   farmerdrop.addItem(farmer);
              }
              rs.close();
          }
          catch(Exception e)
          {
              e.printStackTrace();
          }    
   }
   
   public void actionPerformed(ActionEvent ae)
   {
                   
              if(ae.getSource()==update)
              {
                    String selectedfarmer=(String)farmerdrop.getSelectedItem();    //selected crop id and updated values
                    String name=tff_name.getText();
                    String f_addr=tfaddr.getText();
                    String p_no=tfphone.getText();
                    int age =Integer.parseInt(tff_age.getText());
                    java.sql.Date dob=java.sql.Date.valueOf(tff_dob.getText());
      
                    try
                    {
                        conn conn=new conn();
                        String u_query="update farmer_details set name=?,address=?,age=?,dob=?,phone_no=? where f_id=?";
                        PreparedStatement ps=conn.prepareStatement(u_query);   // prepare and execute sql statements
                                                                               // use to set value in place of placeholder ?
                        ps.setString(1,name);
                        ps.setString(2,f_addr);
                        ps.setInt(3,age);
                        ps.setDate(4,dob);
                        ps.setString(5,p_no);
                        ps.setString(6,selectedfarmer);

                        
                        int rows=ps.executeUpdate();     //executing  sql statements that modify data like insert,update,delete. int represents no. of rows affected
                        if(rows>0)
                        {
                            System.out.println("Farmer updated successfully");
                            JOptionPane.showMessageDialog(this, "Farmer UPDATED SUCCESSFULLY");
                            setVisible(false);
                            new Farmer();
                        }
                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                     
              }
               else 
               {
                    setVisible(false);
                    new Farmer();
               }
         }

}








