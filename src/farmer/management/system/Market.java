package farmer.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;


public class Market extends JFrame implements ActionListener
{
        JButton g_view,lview,llogout;
        Market()
        {
            
            setSize(1000,600);                                 //frame size in height,width
            setLocation(150,90);
            setVisible(true);
            getContentPane().setBackground(Color.WHITE);                       //background color of frame
            setLayout(null);
            
            setTitle("MARKET DASH BOARD");   
            
            JLabel heading=new JLabel("              MARKET DETAILS   ");
            add(heading);
            heading.setBounds(70,20,700,60);
            heading.setFont(new Font("serif",Font.BOLD,40));
            heading.setForeground(Color.WHITE);
            
            ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("images/f4.jpg"));    //for image we use image icon class in this object is created i1.in image loader for oading image and address of image is passed in it
            Image i2=i1.getImage().getScaledInstance(950,600,Image.SCALE_DEFAULT);                    //for scaling image and stored in i2.for this image class is used
            ImageIcon i3=new ImageIcon(i2);      // image converted back to imageicon
            JLabel image=new JLabel(i3);         // can't directly add so jlabel is created and then it is added
            image.setBounds(0,10,990,590);
            add(image);
             
   
            
            g_view=new JButton("Government Schemes");                      //LOGIN Button
            g_view.setBounds(100,150,200,50);                              
            g_view.setBackground(Color.BLACK);
            g_view.setForeground(Color.WHITE);
            g_view.addActionListener(this);
             add(g_view); 
               
            lview=new JButton("View Market Details");                //register button
            lview.setBounds(370,150,200,50);
            lview.setBackground(Color.BLACK);
            lview.setForeground(Color.WHITE);
            lview.addActionListener(this);
            add(lview);
            
            llogout=new JButton("Back");                //register button
            llogout.setBounds(650,150,150,50);
            llogout.setBackground(Color.BLACK);
            llogout.setForeground(Color.WHITE);
            llogout.addActionListener(this);
            add(llogout);
        }
         public void actionPerformed(ActionEvent ae)
         {
                   
               if(ae.getSource()==g_view)
               {
                    new ViewGovernment();
               }
               else if(ae.getSource()==lview)
               {
                    new ViewMarket();
               }
               else 
               {
                     new FarmerDashBoard();
               }
           }
}


 class ViewMarket extends JFrame 
 {

    // Constructor for ViewMarket class
    public ViewMarket() {
        setTitle("Nearby Market Details");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Column names for the JTable
        String[] columnNames = {
            "Market ID", "Market Name", "Location",
            "Contact Person", "Contact No",
            "Crop Variety", "Crop Name"
        };

        // Create DefaultTableModel and JTable
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Panel to hold the location input and search button
        JPanel panel = new JPanel();
        JLabel locationLabel = new JLabel("Enter Location:");
        JTextField locationField = new JTextField(20);
        JButton searchButton = new JButton("Search");
        panel.add(locationLabel);
        panel.add(locationField);
        panel.add(searchButton);
        add(panel, BorderLayout.NORTH);

        // Search button action to search nearby markets based on entered location
        searchButton.addActionListener(e -> {
            String location = locationField.getText().trim();
            if (!location.isEmpty()) {
                searchmarkets(location, model);
            } else {
                JOptionPane.showMessageDialog(this, "Please enter a location.");
            }
        });

        setVisible(true);
    }

   
       private void searchmarkets(String location, DefaultTableModel model) {
      
        model.setRowCount(0);


        try
        {
            conn c=new conn();
            
            // SQL query to find markets near the entered location
            String query = "SELECT * FROM market WHERE M_location LIKE ?";
             PreparedStatement stmt = c.prepareStatement(query);
            stmt.setString(1, "%" + location + "%");  // Using LIKE to find nearby locations
             ResultSet rs = stmt.executeQuery();

             
            // Iterate through the result set and add rows to the model
            while (rs.next()) {
                int id = rs.getInt("M_Id");
                String name = rs.getString("market_name");
                String marketLocation = rs.getString("M_location");
                String contactName = rs.getString("Contact_pname");
                String contactPhone = rs.getString("Contact_pno");
                String cropVariety = rs.getString("Crop_variety");
                String cropName = rs.getString("Crop_name");
                

                // Add row to the table model
                model.addRow(new Object[] {
                    id, name, marketLocation, contactName, contactPhone, cropVariety, cropName
                });
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading market data");
        } 
    }

    // Main method to run the program
    public static void main(String[] args) {
        new ViewMarket();  // Create and display the market view window
    }
}



class ViewGovernment extends JFrame
{

    public ViewGovernment()
    {
        setTitle("Government Schemes");
        setSize(900, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

       
        String[] columnNames = {
            "Scheme Id","Scheme Name", "Deadline", "Description", "Eligibility", "Benefits"
        };

       
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);

        // Create a JTable with the model
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        try 
        {
            conn c=new conn();
            PreparedStatement stmt = c.prepareStatement("SELECT * FROM government_schemas");
            ResultSet rs = stmt.executeQuery();

            
            while (rs.next())
            {
                int schemeid=rs.getInt("s_id");
                String schemeName = rs.getString("scheme_name");
                String deadline = rs.getString("deadline");
                String description = rs.getString("description");
                String eligibility = rs.getString("eligibility");
                String benefits = rs.getString("benefits");

                // Add row to the table model
                model.addRow(new Object[] {
                    schemeid,schemeName, deadline, description, eligibility, benefits
                });
            }

          
            
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading government schemes data");
        }

        setVisible(true);
    }

    public static void main(String[] args) {
        // Create the JFrame to view the government schemes data
        new ViewGovernment();
    }
}
