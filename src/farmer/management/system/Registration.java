package farmer.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Random;


public class Registration extends JFrame
{
     JTextField txtUsername, txtRole;
     JPasswordField txtPassword;
     JLabel lblUserId;
     JButton btnNext;

    public Registration()
    {
        setTitle("User Registration");
        setSize(400, 350);
        setLayout(new GridLayout(5, 2));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        lblUserId = new JLabel("User ID: " + generateUserId());
        txtUsername = new JTextField();
        txtPassword = new JPasswordField();
        txtRole = new JTextField();
        btnNext = new JButton("Next");

       // add(new JLabel("User ID:"));
        //add(lblUserId);
        add(new JLabel("Username:"));
        add(txtUsername);
        add(new JLabel("Password:"));
        add(txtPassword);
        add(new JLabel("Role:"));
        add(txtRole);
        add(new JLabel(""));
        add(btnNext);

        btnNext.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                registerUser();
            }
        });

        setVisible(true);
    }

    private String generateUserId()
    {
        Random rand = new Random();
        return String.valueOf(1000 + rand.nextInt(9000));
    }

    private void registerUser()
    {
        String userId = lblUserId.getText().split(": ")[1];
        String username = txtUsername.getText();
        String password = new String(txtPassword.getPassword());
        String role = txtRole.getText();

        if (username.isEmpty() || password.isEmpty() || role.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "All fields are required.");
            return;
        }

        try
        {
            conn c = new conn(); 
            String sql = "INSERT INTO users (u_id, username, roles, password) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setString(1, userId);
            stmt.setString(2, username);
            stmt.setString(3, role);
            stmt.setString(4, password);
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(this, "User registered successfully!");
            dispose(); 
            String roleLower = role.toLowerCase();
            if(roleLower.equals("farmer"))
            {
                    JOptionPane.showMessageDialog(this, "WELCOME");
                    setVisible(false);
                    new FarmerRegistration(userId);
             }
             else if(roleLower.equals("admin"))
             {
                     //
             }
        }
        catch (Exception ex) 
        {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error registering user.");
        }
    }

     public static void main(String[] args)
     {
                    new Registration();
      }
}



class FarmerRegistration extends JFrame 
{
    private JTextField txtName, txtAddress, txtAge, txtDob, txtPhone;
    private JLabel lblUserId, lblFarmerId;
    private JButton btnSubmit;

    public FarmerRegistration(String userId)
    {
        setTitle("Farmer Registration");
        setSize(400, 350);
        setLayout(new GridLayout(8, 2));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        String farmerId = generateFarmerId();

        lblUserId = new JLabel("User ID: " + userId);
        add(lblUserId);
        
        lblFarmerId = new JLabel("Farmer ID: " + farmerId);
        add(lblFarmerId);

        txtName = new JTextField();
        add(new JLabel("Name:"));
        add(txtName);

        txtAddress = new JTextField();
        add(new JLabel("Address:"));
        add(txtAddress);
        
        txtAge = new JTextField();
        add(new JLabel("Age:"));
        add(txtAge);
        
        txtDob = new JTextField();
        add(new JLabel("DOB (YYYY-MM-DD):"));
        add(txtDob);
        
        
        txtPhone = new JTextField();
        add(new JLabel("Phone:"));
        add(txtPhone);
        
        btnSubmit = new JButton("Submit");
        add(new JLabel(""));
        add(btnSubmit);

 
        btnSubmit.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) 
            {
                registerFarmer(userId, farmerId);
            }
        });

        setVisible(true);
    }

    private String generateFarmerId() 
    {
        Random rand = new Random();
        return String.valueOf(1 + rand.nextInt(999));
    }

    private void registerFarmer(String userId, String farmerId) 
    {
        String name = txtName.getText();
        String address = txtAddress.getText();
        String age = txtAge.getText();
        String dob = txtDob.getText();
        String phone = txtPhone.getText();

        if (name.isEmpty() || address.isEmpty() || age.isEmpty() || dob.isEmpty() || phone.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "All fields must be filled!");
            return;
        }

        try
        {
            conn c=new conn();
            String sql = "INSERT INTO farmer_details (f_id, user_id, name, address, age, dob, phone_no) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setString(1, farmerId);
            stmt.setString(2, userId);
            stmt.setString(3, name);
            stmt.setString(4, address);
            stmt.setInt(5, Integer.parseInt(age));
            stmt.setString(6, dob);
            stmt.setString(7, phone);

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(this, "Farmer registered successfully!");
            dispose();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error registering farmer.");
        }
    }
}
    

