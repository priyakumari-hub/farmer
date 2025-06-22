package farmer.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Search extends JFrame implements ActionListener {
    JLabel heading, search;
    JComboBox<String> Type;
    JTextField s_field;
    JButton searchBtn, backBtn;
    JTextArea resultArea;
    JScrollPane scrollPane;

    Search()
    {
        setTitle("Search Crop Details");
        setSize(700, 500);
        setLocation(300, 100);
        setLayout(null);

        heading = new JLabel("Search Crop Details");
        heading.setBounds(220, 20, 300, 30);
        heading.setFont(new Font("Serif", Font.BOLD, 24));
        add(heading);

        search = new JLabel("Search by:");
        search.setBounds(50, 80, 100, 30);
        add(search);

        Type = new JComboBox<>(new String[]{"Crop Name", "Season"});
        Type.setBounds(150, 80, 150, 30);
        add(Type);

        s_field = new JTextField();
        s_field.setBounds(320, 80, 200, 30);
        add(s_field);
        

        searchBtn = new JButton("Search");
        searchBtn.setBounds(530, 80, 100, 30);
        searchBtn.addActionListener(this);
        add(searchBtn);
        

        resultArea = new JTextArea();
        resultArea.setBounds(50, 130, 580, 250);
        resultArea.setEditable(false);
        resultArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        add(resultArea);
        
        
        scrollPane=new JScrollPane(resultArea);      //to scroll down
        scrollPane.setBounds(50,130,580,250);
        add(scrollPane);

        backBtn = new JButton("Back");
        backBtn.setBounds(300, 400, 100, 30);
        backBtn.addActionListener(e -> {
        setVisible(false);
              new FarmerDashBoard(); // Go back to Crop Dashboard if needed
        });
        add(backBtn);

        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        String searchBy = (String) Type.getSelectedItem();
        String input = s_field.getText().trim();

        if (input.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a search term.");
            return;
        }

        String query = "";
        if (searchBy.equals("Crop Name"))
        {
            query = "SELECT * FROM crop WHERE crop_name LIKE ?";
        } 
        else if (searchBy.equals("Season"))
        {
            query = "SELECT * FROM crop WHERE season LIKE ?";
        }

        try {
            conn c = new conn();
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, "%" + input + "%");
            ResultSet rs = ps.executeQuery();

            StringBuilder sb = new StringBuilder();
            while (rs.next()) {
                sb.append("Crop ID: ").append(rs.getString("c_id")).append("\n");
                sb.append("Farmer ID: ").append(rs.getInt("f_id")).append("\n");
                sb.append("Crop Name: ").append(rs.getString("crop_name")).append("\n");
                sb.append("Season: ").append(rs.getString("season")).append("\n");
                sb.append("Sown Month: ").append(rs.getString("sown_month")).append("\n");
                sb.append("Harvest Month: ").append(rs.getString("harvest_month")).append("\n");
                sb.append("Variety: ").append(rs.getString("variety")).append("\n");
                sb.append("Amount Produced: ").append(rs.getDouble("amount_produced")).append(" quintals\n");
                sb.append("Area Grown: ").append(rs.getDouble("area_grown")).append(" acres\n");
                sb.append("----------------------------------------------------\n");
            }

            if (sb.length() == 0) {
                resultArea.setText("No records found.");
            } else {
                resultArea.setText(sb.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching records.");
        }
    }

    public static void main(String[] args) {
        new Search();
    }
}