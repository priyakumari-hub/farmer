package farmer.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;



public class Land extends JFrame implements ActionListener
{
        JButton ladd,ldelete,lmodify,lview,llogout;
        Land()
        {
            
            setSize(1000,600);                                 //frame size in height,width
            setLocation(150,90);
            setVisible(true);
            getContentPane().setBackground(Color.WHITE);                       //background color of frame
            setLayout(null);
            
            setTitle("LAND DASH BOARD");   
            
            JLabel heading=new JLabel("     LAND DETAILS   ");
            add(heading);
            heading.setBounds(70,20,700,60);
            heading.setFont(new Font("serif",Font.BOLD,40));
            heading.setForeground(Color.BLACK);
            
            ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("images/land2.jpg"));    //for image we use image icon class in this object is created i1.in image loader for oading image and address of image is passed in it
            Image i2=i1.getImage().getScaledInstance(1000,600,Image.SCALE_DEFAULT);                    //for scaling image and stored in i2.for this image class is used
            ImageIcon i3=new ImageIcon(i2);      // image converted back to imageicon
            JLabel image=new JLabel(i3);         // can't directly add so jlabel is created and then it is added
            image.setBounds(0,10,990,590);
            add(image);
             
            ladd=new JButton("Add Lands");                      //LOGIN Button
            ladd.setBounds(100,150,150,50);                              
            ladd.setBackground(Color.BLACK);
            ladd.setForeground(Color.WHITE);
            ladd.addActionListener(this);
             add(ladd);
             
            ldelete=new JButton("Delete Lands");                //register button
            ldelete.setBounds(300,150,150,50);
            ldelete.setBackground(Color.BLACK);
            ldelete.setForeground(Color.WHITE);
            ldelete.addActionListener(this);
            add(ldelete);
            
            lmodify=new JButton("Modify Lands ");                      //LOGIN Button
            lmodify.setBounds(500,150,150,50);                              
            lmodify.setBackground(Color.BLACK);
            lmodify.setForeground(Color.WHITE);
            lmodify.addActionListener(this);
             add(lmodify); 
               
            lview=new JButton("View Land Details");                //register button
            lview.setBounds(700,150,150,50);
            lview.setBackground(Color.BLACK);
            lview.setForeground(Color.WHITE);
            lview.addActionListener(this);
            add(lview);
            
            llogout=new JButton("Back");                //register button
            llogout.setBounds(100,250,150,50);
            llogout.setBackground(Color.BLACK);
            llogout.setForeground(Color.WHITE);
            llogout.addActionListener(this);
            add(llogout);
        }
         public void actionPerformed(ActionEvent ae)
         {
                   
               if(ae.getSource()==ladd)
               {
                   new ladd();
               }
                else if(ae.getSource()==ldelete)
               {
                   new  DeleteLand ();
               }
               else if(ae.getSource()==lview)
               {
                    new viewland();
               }
                else if(ae.getSource()==lmodify)
               {
                     new updateland();
               } 
               else 
               {
                    setVisible(false);
                    new FarmerDashBoard();
               }
           }
}

class ladd extends JFrame implements ActionListener
{
     JLabel land_id,farmer_id,sarea,address,soil,l_area;
     JTextField tffarmer_id,tfland_id,tfaddress,tfsoil,tfsarea,tfl_area;
     Random ran=new Random();                 // inside util package
     int number=ran.nextInt(999999);
     JButton add,back;
 
   ladd()
   {
            setSize(900,600);                                 //frame size in height,width
            setLocation(300,50);
            setVisible(true);
            getContentPane().setBackground(Color.PINK);                       //background color of frame
            setLayout(null);
            
            JLabel heading1=new JLabel("ADD LAND DETAILS   ");
            heading1.setBounds(320,20,500,50);
            heading1.setFont(new Font("serif",Font.BOLD,40));
            heading1.setForeground(Color.BLACK);
            add(heading1);
            
            
             land_id=new JLabel("Land ID");
             land_id.setBounds(50,150,150,30) ;
             add(land_id);

             tfland_id=new JTextField(""+number);
             tfland_id.setBounds(240,150,150,30);
             add(tfland_id);
             
             farmer_id=new JLabel("Farmer ID");
             farmer_id.setBounds(440,150,150,30) ;
             add(farmer_id);

             tffarmer_id=new JTextField();
             tffarmer_id.setBounds(640,150,150,30);
             add(tffarmer_id);
            
             
             address=new JLabel("Land Location");
             address.setBounds(50,200,150,30) ;
             add(address);

             tfaddress=new JTextField();
             tfaddress.setBounds(240,200,150,30);
             add(tfaddress);
            
             
             soil=new JLabel("Soil Type");
             soil.setBounds(440,200,150,30) ;
             add(soil);

             tfsoil=new JTextField();
             tfsoil.setBounds(640,200,150,30);
             add(tfsoil);
 
             sarea=new JLabel("Total Area sowned in (hectares)");
             sarea.setBounds(50,250,220,30) ;
             add(sarea);

             tfsarea=new JTextField();
             tfsarea.setBounds(240,250,150,30);
             add(tfsarea);
            
             l_area=new JLabel("Total Area of land in (hectares)");
             l_area.setBounds(440,250,180,30) ;
             add(l_area);

             tfl_area=new JTextField();
             tfl_area.setBounds(640,250,150,30);
             add(tfl_area);
            
            add=new JButton("Add Land Details");                //register button
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
                    int l_id=Integer.parseInt(tfland_id.getText());
                    int f_id=Integer.parseInt(tffarmer_id.getText());
                    String l_addr=tfaddress.getText();
                    String s_type=tfsoil.getText();
                    double land=Double.parseDouble(tfl_area.getText());
                    double sown=Double.parseDouble(tfsarea.getText());
                    try
                    {
                        conn conn=new conn();
                        String query="insert into land(L_id,F_id,land_area,land_addr,sown_area,soil_type) values(?,?,?,?,?,?)";
                        PreparedStatement ps=conn.prepareStatement(query);   // prepare and execute sql statements
                        ps.setInt(1,l_id);   // use to set value in place of placeholder ?
                        ps.setInt(2,f_id);
                        ps.setDouble(3,land);
                        ps.setString(4,l_addr);
                        ps.setDouble(5,sown);
                        ps.setString(6,s_type);
                        
                        // executeQuery used when executing sql select statements
                        
                        int rows=ps.executeUpdate();     //executing  sql statements that modify data like insert,update,delete. int represents no. of rows affected
                        if(rows>0)
                        {
                            System.out.println("Land added successfully");
                            JOptionPane.showMessageDialog(this, "LAND ADDED SUCCESSFULLY");
                            setVisible(false);
                            new Land();
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
                    new Land();
               }
         }

}


class viewland extends JFrame 
{
      JTable table;
      DefaultTableModel model;
      JTextField farmer_id;
      JButton fetch;
    
    viewland()
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
           
        
          model=new DefaultTableModel(new String[]{"Land Id","Land Address","Land Area","Sown Area","Soil Type","Farmer ID"},0);
        
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
                        fetchland(farmerid);
                    }
                    catch(NumberFormatException g)
                    {
                        JOptionPane.showMessageDialog(null,"Please enter valid farmer id");
                    }
                }
            });
       }
    
       void fetchland(int farmerid)
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
             
              
            PreparedStatement ps=c.prepareStatement("Select * from land where f_id=?"); 
            ps.setInt(1,farmerid);
            ResultSet rs=ps.executeQuery();
            boolean found=false;
              
              while(rs.next())
              {
                  found=true;
                  model.addRow(new Object[]{
                      rs.getInt("l_id"),
                      rs.getString("land_addr"),
                      rs.getDouble("land_area"),
                      rs.getDouble("Sown_area"),
                      rs.getString("soil_type"),
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





class updateland extends JFrame implements ActionListener
{
     JLabel l_id,l_addr,l_area,sown,soil,f_id;
     JTextField tfl_id,tfl_addr,tfl_area,tfsown,tfsoil,tff_id;
     JComboBox<String> landdrop;
     JButton update,back,fetch;
 
   updateland()
   {
            setSize(900,600);                                 //frame size in height,width
            setLocation(300,50);
            setVisible(true);
            getContentPane().setBackground(Color.CYAN);                       //background color of frame
            setLayout(null);
            
            JLabel heading1=new JLabel("Update Land DETAILS   ");
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
             
             
             fetch=new JButton("Fetch Land");
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
             
             JLabel landlabel=new JLabel("Select Land");
             landlabel.setBounds(50,150,150,30);
             add(landlabel);
             
             landdrop=new JComboBox<>();
             landdrop.setBounds(200,150,150,30);
             landdrop.setVisible(false);        // hidden initially
             add(landdrop);
             
             
            // crop detail          
             
             l_area=new JLabel("Land area (hectare)");            //crop name will be uneditable
             l_area.setBounds(50,200,150,30) ;
             add(l_area);

             tfl_area=new JTextField();
             tfl_area.setBounds(200,200,150,30);
             tfl_area.setEditable(true);
             add(tfl_area);
             
                    
             
             l_addr=new JLabel("Land Address");
             l_addr.setBounds(400,200,150,30) ;
             add(l_addr);

             tfl_addr=new JTextField();
             tfl_addr.setBounds(600,200,150,30);
             tfl_addr.setEditable(true);
             add(tfl_addr);
             
             soil=new JLabel("Soil Type");
             soil.setBounds(50,250,155,30) ;
             add(soil);

             tfsoil=new JTextField();
             tfsoil.setBounds(200,250,150,30);
             tfsoil.setEditable(true);
             add(tfsoil);
            
             sown=new JLabel("Sown Area");
             sown.setBounds(400,250,150,30);
             add(sown);

             tfsown=new JTextField();
             tfsown.setBounds(600,250,150,30);
             tfsown.setEditable(true);
             add(tfsown);
            
              
      
            update=new JButton("Update Land Details");                //register button
            update.setBounds(600,350,150,50);
            update.setBackground(Color.BLACK);
            update.setForeground(Color.WHITE);
            update.addActionListener(this);
            add(update);
            
            back=new JButton("Back");                //register button
            back.setBounds(200,350,150,50);
            back.setBackground(Color.BLACK);
            back.setForeground(Color.WHITE);
            back.addActionListener(this);
            add(back);

   } 
   
   private void fetchcrop(int farmerid)
   {
       landdrop.setVisible(true);
       try
       {
              conn c=new conn();
              String query="Select * from land where f_id=?";
              PreparedStatement ps=c.prepareStatement(query);
              ps.setInt(1,farmerid);
              ResultSet rs=ps.executeQuery();
              
              // fill value in dropdown
              
              landdrop.removeAllItems();    // clear previous item
              while(rs.next())
              {
                   String landid=rs.getString("l_id");
                   landdrop.addItem(landid);
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
                    String selectedland=(String)landdrop.getSelectedItem();    //selected crop id and updated values
                    String landid=selectedland.split(" - ")[0];
                    String addr=tfl_addr.getText();
                    String s_type=tfsoil.getText();
                    double area =Double.parseDouble(tfl_area.getText());
                    double s_area=Double.parseDouble(tfsown.getText());
                    int ff_id=Integer.parseInt(tff_id.getText());
                    try
                    {
                        conn conn=new conn();
                        String u_query="update land set land_area=?,land_Addr=?,sown_area=?,soil_type=? where l_id=? and f_id=?";
                        PreparedStatement ps=conn.prepareStatement(u_query);   // prepare and execute sql statements
                                                                               // use to set value in place of placeholder ?
                        ps.setDouble(1,area);
                        ps.setString(2,addr);
                        ps.setDouble(3,s_area);
                        ps.setString(4,s_type);
                        ps.setString(5,landid);
                        ps.setInt(6,ff_id);
                      
                        
                        int rows=ps.executeUpdate();     //executing  sql statements that modify data like insert,update,delete. int represents no. of rows affected
                        if(rows>0)
                        {
                            System.out.println("Land updated successfully");
                            JOptionPane.showMessageDialog(this, "Land UPDATED SUCCESSFULLY");
                            setVisible(false);
                            new Land();
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
                    new Land();
               }
         }

}


class DeleteLand extends JFrame implements ActionListener
{
    JLabel heading, l_id, f_id;
    JTextField tfl_id, tff_id;
    JButton deleteBtn, backBtn;

    DeleteLand() {
        setTitle("Delete Land Record");
        setSize(400, 300);
        setLocation(450, 200);
        setLayout(null);

        heading = new JLabel("Delete Land Record");
        heading.setFont(new Font("Serif", Font.BOLD, 22));
        heading.setBounds(100, 20, 250, 30);
        add(heading);

        l_id = new JLabel("Land ID:");
        l_id.setBounds(50, 80, 100, 30);
        add(l_id);

        tfl_id = new JTextField();
        tfl_id.setBounds(150, 80, 180, 30);
        add(tfl_id);

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
           new Land(); // Uncomment if going back to land dashboard
        });
        add(backBtn);

        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String l_text = tfl_id.getText().trim();
        String f_text = tff_id.getText().trim();

        if (l_text.isEmpty() || f_text.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill both Land ID and Farmer ID.");
            return;
        }

        try {
            int landId = Integer.parseInt(l_text);
            int farmerId = Integer.parseInt(f_text);

            conn c = new conn();
            String query = "DELETE FROM land WHERE l_id = ? AND f_id = ?";
            PreparedStatement ps = c.prepareStatement(query);
            ps.setInt(1, landId);
            ps.setInt(2, farmerId);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Land record deleted successfully.");
                tfl_id.setText("");
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



