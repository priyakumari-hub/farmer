package farmer.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;

public class Crop extends JFrame implements ActionListener
{
        JButton Add,delete,modify,view,logout;
        Crop()
        {
            
            setSize(1000,600);                                 //frame size in height,width
            setLocation(150,90);
            setVisible(true);
            getContentPane().setBackground(Color.WHITE);                       //background color of frame
            setLayout(null);
            
            setTitle("CROPS DASH BOARD");   
            
            JLabel heading=new JLabel("     CROP DETAILS   ");
            add(heading);
            heading.setBounds(70,20,700,60);
            heading.setFont(new Font("serif",Font.BOLD,40));
            heading.setForeground(Color.BLACK);
            
            ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("images/crop1.jpg"));    //for image we use image icon class in this object is created i1.in image loader for oading image and address of image is passed in it
            Image i2=i1.getImage().getScaledInstance(1000,600,Image.SCALE_DEFAULT);                    //for scaling image and stored in i2.for this image class is used
            ImageIcon i3=new ImageIcon(i2);      // image converted back to imageicon
            JLabel image=new JLabel(i3);         // can't directly add so jlabel is created and then it is added
            image.setBounds(0,10,990,590);
            add(image);
            
            Add=new JButton("Add Crops");                      //LOGIN Button
            Add.setBounds(100,150,150,50);                              
            Add.setBackground(Color.BLACK);
            Add.setForeground(Color.WHITE);
            Add.addActionListener(this);
             add(Add); 
               
            delete=new JButton("Delete Crops");                //register button
            delete.setBounds(300,150,150,50);
            delete.setBackground(Color.BLACK);
            delete.setForeground(Color.WHITE);
            delete.addActionListener(this);
            add(delete);
            
            modify=new JButton("Modify Crops ");                      //LOGIN Button
            modify.setBounds(500,150,150,50);                              
            modify.setBackground(Color.BLACK);
            modify.setForeground(Color.WHITE);
            modify.addActionListener(this);
             add(modify); 
               
            view=new JButton("View Details");                //register button
            view.setBounds(700,150,150,50);
            view.setBackground(Color.BLACK);
            view.setForeground(Color.WHITE);
            view.addActionListener(this);
            add(view);
            
            logout=new JButton("Back");                //register button
            logout.setBounds(100,250,150,50);
            logout.setBackground(Color.BLACK);
            logout.setForeground(Color.WHITE);
            logout.addActionListener(this);
            add(logout);
        }
         public void actionPerformed(ActionEvent ae)
         {
                   
               if(ae.getSource()==Add)
              {
                    new Add();
              }
               else if(ae.getSource()==delete)
               {
                  new DeleteCrop();
               }
                else if(ae.getSource()==modify)
               {
                   new update();
               }
                else if(ae.getSource()==view)
               {
                    new view();
               }
                else 
               {
                    setVisible(false);
                    new FarmerDashBoard();
               }
           }
         
  public static void main(String[] args)
  {
                    new login();
  }
}


class Add extends JFrame implements ActionListener
{
     JLabel labelname,c_id,harvest,sown,amount,season,area,variety,f_id;
     JTextField tfname,tfc_id,tfharvest,tfsown,tfamount,tfseason,tfarea,tfvariety,tff_id;
     Random ran=new Random();                 // inside util package
     int number=ran.nextInt(999999);
     JButton add,back;
 
   Add()
   {
            setSize(900,600);                                 //frame size in height,width
            setLocation(300,50);
            setVisible(true);
            getContentPane().setBackground(new Color(173,216,230));                       //background color of frame
            setLayout(null);
            
            JLabel heading1=new JLabel("Add Crop DETAILS   ");
            heading1.setBounds(320,20,500,50);
            heading1.setFont(new Font("serif",Font.BOLD,40));
            heading1.setForeground(Color.BLACK);
            add(heading1);
            
            
             labelname=new JLabel("Crop Name");
             labelname.setBounds(50,150,150,30) ;
             add(labelname);

             tfname=new JTextField();
             tfname.setBounds(200,150,150,30);
             add(tfname);
             
             c_id=new JLabel("Crop ID");
             c_id.setBounds(400,150,150,30) ;
             add(c_id);

             tfc_id=new JTextField(""+number);
             tfc_id.setBounds(600,150,150,30);
             add(tfc_id);
            
             
             harvest=new JLabel("Harvest Month");
             harvest.setBounds(400,200,150,30) ;
             add(harvest);

             tfharvest=new JTextField();
             tfharvest.setBounds(600,200,150,30);
             add(tfharvest);
            
             
             sown=new JLabel("Sown Month");
             sown.setBounds(50,200,150,30) ;
             add(sown);

             tfsown=new JTextField();
             tfsown.setBounds(200,200,150,30);
             add(tfsown);
            
             amount=new JLabel("Amount produced in quintal");
             amount.setBounds(400,250,155,30) ;
             add(amount);

             tfamount=new JTextField();
             tfamount.setBounds(600,250,150,30);
             add(tfamount);
            
             season=new JLabel("Season");
             season.setBounds(50,250,150,30) ;
             add(season);

             tfseason=new JTextField();
             tfseason.setBounds(200,250,150,30);
             add(tfseason);
             
             area=new JLabel("Area grown in (hectares)");
             area.setBounds(50,300,150,30) ;
             add(area);

             tfarea=new JTextField();
             tfarea.setBounds(200,300,150,30);
             add(tfarea);
             
             variety=new JLabel("Variety");
             variety.setBounds(400,300,150,30) ;
             add(variety);

             tfvariety=new JTextField();
             tfvariety.setBounds(600,300,150,30);
             add(tfvariety);
            
             
             f_id=new JLabel("Farmer Id");
             f_id.setBounds(50,350,150,30) ;
             add(f_id);

             tff_id=new JTextField();
             tff_id.setBounds(200,350,150,30);
             add(tff_id);
            
            add=new JButton("Add Crop Details");                //register button
            add.setBounds(600,400,150,50);
            add.setBackground(Color.BLACK);
            add.setForeground(Color.WHITE);
            add.addActionListener(this);
            add(add);
            
            back=new JButton("Back");                //register button
            back.setBounds(200,400,150,50);
            back.setBackground(Color.BLACK);
            back.setForeground(Color.WHITE);
            back.addActionListener(this);
            add(back);

   } 
   public void actionPerformed(ActionEvent ae)
   {
                   
              if(ae.getSource()==add)
              {
                    int c_id=Integer.parseInt(tfc_id.getText());
                    String name=tfname.getText();
                    String h_month=tfharvest.getText();
                    String s_month=tfsown.getText();
                    double amounts=Double.parseDouble(tfamount.getText());
                    String seasons=tfseason.getText();
                    double area_grown=Double.parseDouble(tfarea.getText());
                    String var=tfvariety.getText();
                    int ff_id=Integer.parseInt(tff_id.getText());
                    try
                    {
                        conn conn=new conn();
                        String query="insert into crop(c_id,crop_name,harvest_month,sown_month,amount_produced,season,area_grown,variety,f_id) values(?,?,?,?,?,?,?,?,?)";
                        PreparedStatement ps=conn.prepareStatement(query);   // prepare and execute sql statements
                        ps.setInt(1,c_id);   // use to set value in place of placeholder ?
                        ps.setString(2,name);
                        ps.setString(3,h_month);
                        ps.setString(4,s_month);
                        ps.setDouble(5,amounts);
                        ps.setString(6,seasons);
                        ps.setDouble(7,area_grown);
                        ps.setString(8,var);
                        ps.setInt(9,ff_id);

                        
                        // executeQuery used when executing sql select statements
                        
                        int rows=ps.executeUpdate();     //executing  sql statements that modify data like insert,update,delete. int represents no. of rows affected
                        if(rows>0)
                        {
                            System.out.println("Crop added successfully");
                            JOptionPane.showMessageDialog(this, "CROP ADDED SUCCESSFULLY");
                            setVisible(false);
                            new Crop();
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
                    new Crop();
               }
         }

}

class view extends JFrame 
{
      JTable table;
      DefaultTableModel model;
      JTextField farmer_id;
      JButton fetch;
    
    view()
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
           
            
          // setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);   //dispose_on_close means only this window will be closed and rest of application will keeprunning 
         //  model=new DefaultTableModel();
          model=new DefaultTableModel(new String[]{"Crop Id","Crop Name","Harvest Month","Sown Month","Amount produced","Season grown","Area grown","Variety","Farmer ID"},0);
        
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
             
              
            PreparedStatement ps=c.prepareStatement("Select * from crop where f_id=?"); 
            ps.setInt(1,farmerid);
            ResultSet rs=ps.executeQuery();
            boolean found=false;
              
              while(rs.next())
              {
                  found=true;
                  model.addRow(new Object[]{
                      rs.getInt("c_id"),
                      rs.getString("crop_name"),
                      rs.getString("Harvest_month"),
                      rs.getString("Sown_month"),
                      rs.getDouble("Amount_produced"),
                      rs.getString("season"),
                      rs.getString("area_grown"),
                      rs.getString("variety"),
                      rs.getInt("f_id"),  
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





class update extends JFrame implements ActionListener
{
     JLabel c_id,c_name,harvest,sown,amount,season,area,variety,f_id;
     JTextField tfc_name,tfc_id,tfharvest,tfsown,tfamount,tfseason,tfarea,tff_id,tfvariety;
     JComboBox<String> cropdrop;
     JButton update,back,fetch;
 
   update()
   {
            setSize(900,600);                                 //frame size in height,width
            setLocation(300,50);
            setVisible(true);
            getContentPane().setBackground(new Color(144,238,144));                       //background color of frame
            setLayout(null);
            
            JLabel heading1=new JLabel("Update Crop DETAILS   ");
            heading1.setBounds(320,20,500,50);
            heading1.setFont(new Font("serif",Font.BOLD,40));
            heading1.setForeground(Color.BLACK);
            add(heading1);
            
            
            f_id=new JLabel("Farmer ID");                       // inpuut for farmmer id
             f_id.setBounds(50,100,150,30) ;
             add(f_id);

             tff_id=new JTextField();
             tff_id.setBounds(200,100,150,30);
             add(tff_id);
             
             
             fetch=new JButton("Fetch Crop");
             fetch.setBounds(380,100,150,30);
             fetch.addActionListener(new ActionListener()
             {
                   public void actionPerformed(ActionEvent e)
                   {
               
                    try
                    {
                        int farmerid=Integer.parseInt(tff_id.getText().trim());
                        fetchcrop(farmerid);
                    }
                    catch(NumberFormatException g)
                    {
                        JOptionPane.showMessageDialog(null,"Please enter valid farmer id");
                    }
                }  
              });
             add(fetch);
             
             
          // dropdown for crop id and crop name
             
             JLabel croplabel=new JLabel("Select Crop");
             croplabel.setBounds(50,150,150,30);
             add(croplabel);
             
             cropdrop=new JComboBox<>();
             cropdrop.setBounds(200,150,150,30);
             cropdrop.setVisible(false);        // hidden initially
             add(cropdrop);
             
             
            // crop detail          
             
             c_name=new JLabel("Crop Name");            //crop name will be uneditable
             c_name.setBounds(50,200,150,30) ;
             add(c_name);

             tfc_name=new JTextField();
             tfc_name.setBounds(200,200,150,30);
             tfc_name.setEditable(true);
             add(tfc_name);
             
                    
             
             area=new JLabel("Area");
             area.setBounds(400,200,150,30) ;
             add(area);

             tfarea=new JTextField();
             tfarea.setBounds(600,200,150,30);
             tfarea.setEditable(true);
             add(tfarea);
             
             
             harvest=new JLabel("Harvest Month");
             harvest.setBounds(50,250,150,30) ;
             add(harvest);

             tfharvest=new JTextField();
             tfharvest.setBounds(200,250,150,30);
             tfharvest.setEditable(true);
             add(tfharvest);
            
             
             sown=new JLabel("Sown Month");
             sown.setBounds(400,250,150,30);
             add(sown);

             tfsown=new JTextField();
             tfsown.setBounds(600,250,150,30);
             tfsown.setEditable(true);
             add(tfsown);
            
             amount=new JLabel("Amount produced in quintal");
             amount.setBounds(50,300,155,30) ;
             add(amount);

             tfamount=new JTextField();
             tfamount.setBounds(200,300,150,30);
             tfamount.setEditable(true);
             add(tfamount);
            
             season=new JLabel("Season");
             season.setBounds(400,300,150,30) ;
             add(season);

             tfseason=new JTextField();
             tfseason.setBounds(600,300,150,30);
             tfseason.setEditable(true);
             add(tfseason);
             
             
             variety=new JLabel("Variety");
             variety.setBounds(50,350,150,30) ;
             add(variety);

             tfvariety=new JTextField();
             tfvariety.setBounds(200,350,150,30);
             tfvariety.setEditable(true);
             add(tfvariety);
             
      
            update=new JButton("Update Crop Details");                //register button
            update.setBounds(600,450,150,50);
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
   
   private void fetchcrop(int farmerid)
   {
       cropdrop.setVisible(true);
       try
       {
              conn c=new conn();
              String query="Select * from crop where f_id=?";
              PreparedStatement ps=c.prepareStatement(query);
              ps.setInt(1,farmerid);
              ResultSet rs=ps.executeQuery();
              
              // fill value in dropdown
              
              cropdrop.removeAllItems();    // clear previous item
              while(rs.next())
              {
                   String cropname=rs.getString("crop_name");   //adding crop id and name
                   String cropid=rs.getString("c_id");
                   cropdrop.addItem(cropid+" - "+cropname);
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
                    String selectedcrop=(String)cropdrop.getSelectedItem();    //selected crop id and updated values
                    String cropid=selectedcrop.split(" - ")[0];
                    
                    String name=tfc_name.getText();
                    String h_month=tfharvest.getText();
                    String s_month=tfsown.getText();
                    double amounts=Double.parseDouble(tfamount.getText());
                    String seasons=tfseason.getText();
                    double area_grown=Double.parseDouble(tfarea.getText());
                    String var=tfvariety.getText();
                    int ff_id=Integer.parseInt(tff_id.getText());
                    try
                    {
                        conn conn=new conn();
                        String u_query="update crop set crop_name=?,harvest_month=?,sown_month=?,amount_produced=?,season=?,area_grown=?,variety=? where c_id=? and f_id=?";
                        PreparedStatement ps=conn.prepareStatement(u_query);   // prepare and execute sql statements
                                                                               // use to set value in place of placeholder ?
                        ps.setString(1,name);
                        ps.setString(2,h_month);
                        ps.setString(3,s_month);
                        ps.setDouble(4,amounts);
                        ps.setString(5,seasons);
                        ps.setDouble(6,area_grown);
                        ps.setString(7,var);
                        ps.setString(8,cropid);
                        ps.setInt(9,ff_id);
                      
                        
                        int rows=ps.executeUpdate();     //executing  sql statements that modify data like insert,update,delete. int represents no. of rows affected
                        if(rows>0)
                        {
                            System.out.println("Crop updated successfully");
                            JOptionPane.showMessageDialog(this, "CROP UPDATED SUCCESSFULLY");
                            setVisible(false);
                            new Crop();
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
                    new Crop();
               }
         }

}


class DeleteCrop extends JFrame implements ActionListener
{
    JLabel heading, c_id, f_id;
    JTextField tfc_id, tff_id;
    JButton deleteBtn, backBtn;

    DeleteCrop() {
        setTitle("Delete Crop Record");
        setSize(400, 300);
        setLocation(450, 200);
        setLayout(null);

        heading = new JLabel("Delete Crop Record");
        heading.setFont(new Font("Serif", Font.BOLD, 22));
        heading.setBounds(100, 20, 250, 30);
        add(heading);

        c_id = new JLabel("Crop ID:");
        c_id.setBounds(50, 80, 100, 30);
        add(c_id);

        tfc_id = new JTextField();
        tfc_id.setBounds(150, 80, 180, 30);
        add(tfc_id);

        f_id = new JLabel("Farmer ID:");
        f_id.setBounds(50, 130, 100, 30);
        add(f_id);

        tff_id = new JTextField();
        tff_id.setBounds(150, 130, 180, 30);
        add(tff_id);

        deleteBtn = new JButton("Delete");
        deleteBtn.setBounds(80, 190, 100, 30);
        deleteBtn.addActionListener(this);
        add(deleteBtn);

        backBtn = new JButton("Back");
        backBtn.setBounds(200, 190, 100, 30);
        backBtn.addActionListener(e -> {
        setVisible(false);
           new Crop(); // Uncomment if going back to crop dashboard
        });
        add(backBtn);

        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String c_text = tfc_id.getText().trim();
        String f_text = tff_id.getText().trim();

        if (c_text.isEmpty() || f_text.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill both Crop ID and Farmer ID.");
            return;
        }

        try {
            int cropId = Integer.parseInt(c_text);
            int farmerId = Integer.parseInt(f_text);

            conn c = new conn();
            String query = "DELETE FROM crop WHERE c_id = ? AND f_id = ?";
            PreparedStatement ps = c.prepareStatement(query);
            ps.setInt(1, cropId);
            ps.setInt(2, farmerId);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Crop record deleted successfully.");
                tfc_id.setText("");
                tff_id.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "No matching record found.");
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input. Enter numeric IDs.");
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error deleting record.");
        }
    }

    public static void main(String[] args) {
        new DeleteCrop();
    }
}


