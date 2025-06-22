package farmer.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;


public class Loan extends JFrame implements ActionListener
{
        JButton ladd,ldelete,lmodify,lview,llogout;
        Loan()
        {
            
            setSize(1000,600);                                 //frame size in height,width
            setLocation(150,90);
            setVisible(true);
            getContentPane().setBackground(Color.WHITE);                       //background color of frame
            setLayout(null);
            
            setTitle("Loan DASH BOARD");   
            
            JLabel heading=new JLabel("     LOAN DETAILS   ");
            add(heading);
            heading.setBounds(70,20,700,60);
            heading.setFont(new Font("serif",Font.BOLD,40));
            heading.setForeground(Color.BLACK);
            
            ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("images/loan4.jpg"));    //for image we use image icon class in this object is created i1.in image loader for oading image and address of image is passed in it
            Image i2=i1.getImage().getScaledInstance(900,600,Image.SCALE_DEFAULT);                    //for scaling image and stored in i2.for this image class is used
            ImageIcon i3=new ImageIcon(i2);      // image converted back to imageicon
            JLabel image=new JLabel(i3);         // can't directly add so jlabel is created and then it is added
            image.setBounds(0,10,990,590);
            add(image);
             
            ladd=new JButton("Add Loans");                      //LOGIN Button
            ladd.setBounds(100,150,150,50);                              
            ladd.setBackground(Color.BLACK);
            ladd.setForeground(Color.WHITE);
            ladd.addActionListener(this);
             add(ladd);
             
            ldelete=new JButton("Delete Loans");                //register button
            ldelete.setBounds(300,150,150,50);
            ldelete.setBackground(Color.BLACK);
            ldelete.setForeground(Color.WHITE);
            ldelete.addActionListener(this);
            add(ldelete);
            
            lmodify=new JButton("Modify Loans ");                      //LOGIN Button
            lmodify.setBounds(500,150,150,50);                              
            lmodify.setBackground(Color.BLACK);
            lmodify.setForeground(Color.WHITE);
            lmodify.addActionListener(this);
             add(lmodify); 
               
            lview=new JButton("View Loans Details");                //register button
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
                  new loadd();
               }
                else if(ae.getSource()==ldelete)
               {
                    new DeleteLoan();
               }
                else if(ae.getSource()==lmodify)
               {
                    new updateloan();
               } 
               else if(ae.getSource()==lview)
               {
                    new viewloan();
               }
               else 
               {
                    setVisible(false);
                    new FarmerDashBoard();
               }
           }
}


class loadd extends JFrame implements ActionListener
{
     JLabel lo_id,farmer_id,lo_date,a_paid,time,rate,lo_amount;
     JTextField tffarmer_id,tflo_id,tflo_date,tfa_paid,tftime,tfrate,tflo_amount;
     Random ran=new Random();                 // inside util package
     int number=ran.nextInt(999999);
     JButton add,back;
 
   loadd()
   {
            setSize(900,600);                                 //frame size in height,width
            setLocation(300,50);
            setVisible(true);
            getContentPane().setBackground(Color.PINK);                       //background color of frame
            setLayout(null);
            
            JLabel heading1=new JLabel("ADD LOAN DETAILS   ");
            heading1.setBounds(320,20,500,50);
            heading1.setFont(new Font("serif",Font.BOLD,40));
            heading1.setForeground(Color.BLACK);
            add(heading1);
            
            
             lo_id=new JLabel("Loan ID");
             lo_id.setBounds(50,150,150,30) ;
             add(lo_id);

             tflo_id=new JTextField(""+number);
             tflo_id.setBounds(240,150,150,30);
             add(tflo_id);
             
             farmer_id=new JLabel("Farmer ID");
             farmer_id.setBounds(440,150,150,30) ;
             add(farmer_id);

             tffarmer_id=new JTextField();
             tffarmer_id.setBounds(600,150,150,30);
             add(tffarmer_id);
            
             
             lo_date=new JLabel("Loan Date(yyyy-mm-dd)");
             lo_date.setBounds(50,200,150,30) ;
             add(lo_date);

             tflo_date=new JTextField();
             tflo_date.setBounds(240,200,150,30);
             add(tflo_date);
            
             
             a_paid=new JLabel("Amount Paid");
             a_paid.setBounds(440,200,150,30) ;
             add(a_paid);

             tfa_paid=new JTextField();
             tfa_paid.setBounds(600,200,150,30);
             add(tfa_paid);
 
             time=new JLabel("Duration Of Loan");
             time.setBounds(50,250,220,30) ;
             add(time);

             tftime=new JTextField();
             tftime.setBounds(240,250,150,30);
             add(tftime);
            
             rate=new JLabel("Loan Rate");
             rate.setBounds(440,250,180,30) ;
             add(rate);

             tfrate=new JTextField();
             tfrate.setBounds(600,250,150,30);
             add(tfrate);
             
             
             lo_amount=new JLabel("Loan Amount");
             lo_amount.setBounds(50,300,150,30) ;
             add(lo_amount);

             tflo_amount=new JTextField();
             tflo_amount.setBounds(240,300,150,30);
             add(tflo_amount);
            
            add=new JButton("Add LOAN Details");                //register button
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
                
                    int loan_id=Integer.parseInt(tflo_id.getText());
                    int f_id=Integer.parseInt(tffarmer_id.getText());
                    
                    String loan_date=tflo_date.getText();
                    java.sql.Date lo_date=java.sql.Date.valueOf(loan_date);
                    
                    double paid=Double.parseDouble(tfa_paid.getText());
                    int time=Integer.parseInt(tftime.getText());
                    double rate=Double.parseDouble(tfrate.getText());
                    double lo_amount=Double.parseDouble(tflo_amount.getText());
                    try
                    {
                        conn conn=new conn();
                        String query="insert into loan(Loan_id,F_id,loan_date,amount_paid,time_left,loan_rate,loan_amount) values(?,?,?,?,?,?,?)";
                        PreparedStatement ps=conn.prepareStatement(query);   // prepare and execute sql statements
                        ps.setInt(1,loan_id);   // use to set value in place of placeholder ?
                        ps.setInt(2,f_id);
                        ps.setDate(3, lo_date);
                        ps.setDouble(4,paid);
                        ps.setInt(5,time);
                        ps.setDouble(6,rate);
                        ps.setDouble(7,lo_amount);
                        
                        // executeQuery used when executing sql select statements
                        
                        int rows=ps.executeUpdate();     //executing  sql statements that modify data like insert,update,delete. int represents no. of rows affected
                        if(rows>0)
                        {
                            System.out.println("Loan added successfully");
                            JOptionPane.showMessageDialog(this, "LOAN ADDED SUCCESSFULLY");
                            setVisible(false);
                            new Loan();
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
                    new Loan();
               }
         }

}


class viewloan extends JFrame 
{
      JTable table;
      DefaultTableModel model;
      JTextField farmer_id;
      JButton fetch;
    
    viewloan()
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
           
            
          
          model=new DefaultTableModel(new String[]{"Loan Id","Amount Paid","Loan date","time","rate","amount","Farmer ID"},0);
        
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
                        fetchloan(farmerid);
                    }
                    catch(NumberFormatException g)
                    {
                        JOptionPane.showMessageDialog(null,"Please enter valid farmer id");
                    }
                }
            });
       }
    
       void fetchloan(int farmerid)
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
             
              
            PreparedStatement ps=c.prepareStatement("Select * from loan where f_id=?"); 
            ps.setInt(1,farmerid);
            ResultSet rs=ps.executeQuery();
            boolean found=false;
              
              while(rs.next())
              {
                  found=true;
                  model.addRow(new Object[]{
                      rs.getInt("loan_id"),
                      rs.getDate("Loan_date"),
                      rs.getDouble("amount_paid"),
                      rs.getInt("time_left"),
                      rs.getDouble("loan_rate"),
                      rs.getDouble("loan_amount"),
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





class updateloan extends JFrame implements ActionListener
{
     JLabel lo_id,lo_date,paid,time,amount,rate,f_id;
     JTextField tflo_date,tflo_id,tfpaid,tftime,tfamount,tfrate,tff_id;
     JComboBox<String> loandrop;
     JButton update,back,fetch;
 
   updateloan()
   {
            setSize(900,600);                                 //frame size in height,width
            setLocation(300,50);
            setVisible(true);
            getContentPane().setBackground(Color.CYAN);                       //background color of frame
            setLayout(null);
            
            JLabel heading1=new JLabel("Update Loan DETAILS   ");
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
             
             
             fetch=new JButton("Fetch Loan");
             fetch.setBounds(380,100,150,30);
             fetch.addActionListener(new ActionListener()
             {
                   public void actionPerformed(ActionEvent e)
                   {
               
                    try
                    {
                        int farmerid=Integer.parseInt(tff_id.getText().trim());
                        fetchloan(farmerid);
                    }
                    catch(NumberFormatException g)
                    {
                        JOptionPane.showMessageDialog(null,"Please enter valid farmer id");
                    }
                }  
              });
             add(fetch);
             
             
          
             
             JLabel loanlabel=new JLabel("Select Loan");
             loanlabel.setBounds(50,150,150,30);
             add(loanlabel);
             
             loandrop=new JComboBox<>();
             loandrop.setBounds(200,150,150,30);
             loandrop.setVisible(false);        
             add(loandrop);
             
            
                 
             
             lo_date=new JLabel("Loan Date");            
             lo_date.setBounds(50,200,150,30) ;
             add(lo_date);

             tflo_date=new JTextField();
             tflo_date.setBounds(200,200,150,30);
             tflo_date.setEditable(true);
             add(tflo_date);
             
             paid=new JLabel("Amount Paid");
             paid.setBounds(400,200,150,30) ;
             add(paid);

             tfpaid=new JTextField();
             tfpaid.setBounds(600,200,150,30);
             tfpaid.setEditable(true);
             add(tfpaid);
             
             
             time=new JLabel("Duration of loan");
             time.setBounds(50,250,150,30) ;
             add(time);

             tftime=new JTextField();
             tftime.setBounds(200,250,150,30);
             tftime.setEditable(true);
             add(tftime);
            
             
             rate=new JLabel("Loan rate");
             rate.setBounds(400,250,150,30);
             add(rate);

             tfrate=new JTextField();
             tfrate.setBounds(600,250,150,30);
             tfrate.setEditable(true);
             add(tfrate);
            
             amount=new JLabel("Loan Amount");
             amount.setBounds(50,300,155,30) ;
             add(amount);

             tfamount=new JTextField();
             tfamount.setBounds(200,300,150,30);
             tfamount.setEditable(true);
             add(tfamount);
            
            
            update=new JButton("Update Loan Details");                //register button
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
   
   private void fetchloan(int farmerid)
   {
       loandrop.setVisible(true);
       try
       {
              conn c=new conn();
              String query="Select * from loan where f_id=?";
              PreparedStatement ps=c.prepareStatement(query);
              ps.setInt(1,farmerid);
              ResultSet rs=ps.executeQuery();
              
              // fill value in dropdown
              
              loandrop.removeAllItems();    // clear previous item
              while(rs.next())
              {
                   String loanid=rs.getString("loan_id");
                   loandrop.addItem(loanid);
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
                    String loanid=(String)loandrop.getSelectedItem();    //selected crop id and updated values
                    java.sql.Date dated=java.sql.Date.valueOf(tflo_date.getText());
                    double a_paid=Double.parseDouble(tfpaid.getText());
                    double amounts=Double.parseDouble(tfamount.getText());
                    int l_time=Integer.parseInt(tftime.getText());
                    double l_rate=Double.parseDouble(tfrate.getText());
                      
                    try
                    {
                        conn conn=new conn();
                        String u_query="update loan set Loan_date=?,amount_paid=?,time_left=?,loan_rate=?,loan_amount=? where loan_id=? ";
                        PreparedStatement ps=conn.prepareStatement(u_query);   // prepare and execute sql statements
                                                                               // use to set value in place of placeholder ?
                        ps.setDate(1,dated);
                        ps.setDouble(2,a_paid);
                        ps.setInt(3,l_time);
                        ps.setDouble(4,l_rate);
                        ps.setDouble(5,amounts);
                        ps.setString(6,loanid);
                        
                      
                        
                        int rows=ps.executeUpdate();     //executing  sql statements that modify data like insert,update,delete. int represents no. of rows affected
                        if(rows>0)
                        {
                            System.out.println("Loan updated successfully");
                            JOptionPane.showMessageDialog(this, "Loan UPDATED SUCCESSFULLY");
                            setVisible(false);
                            new Loan();
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
                    new Loan();
               }
         }

}


class DeleteLoan extends JFrame implements ActionListener
{
    JLabel heading, lo_id, f_id;
    JTextField tflo_id, tff_id;
    JButton deleteBtn, backBtn;

    DeleteLoan() {
        setTitle("Delete Loan Record");
        setSize(400, 300);
        setLocation(450, 200);
        setLayout(null);

        heading = new JLabel("Delete Loan Record");
        heading.setFont(new Font("Serif", Font.BOLD, 22));
        heading.setBounds(100, 20, 250, 30);
        add(heading);

        lo_id = new JLabel("Loan ID:");
        lo_id.setBounds(50, 80, 100, 30);
        add(lo_id);

        tflo_id = new JTextField();
        tflo_id.setBounds(150, 80, 180, 30);
        add(tflo_id);

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
           new Loan(); // Uncomment if going back to Loan dashboard
        });
        add(backBtn);

        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String lo_text = tflo_id.getText().trim();
        String f_text = tff_id.getText().trim();

        if (lo_text.isEmpty() || f_text.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill both Loan ID and Farmer ID.");
            return;
        }

        try {
            int loanId = Integer.parseInt(lo_text);
            int farmerId = Integer.parseInt(f_text);

            conn c = new conn();
            String query = "DELETE FROM loan WHERE loan_id = ? AND f_id = ?";
            PreparedStatement ps = c.prepareStatement(query);
            ps.setInt(1, loanId);
            ps.setInt(2, farmerId);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0)
            {
                JOptionPane.showMessageDialog(this, "Crop record deleted successfully.");
                tflo_id.setText("");
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
        new DeleteLoan();
    }
}



