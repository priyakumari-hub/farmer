package farmer.management.system;

import java.sql.*;

public class conn               //interface h basically ye 
{
           Connection c;
           Statement s;
          public conn()
          {
                    try
                    {
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/priya","root","root");
                            s=c.createStatement();
                   } catch(Exception e)
                   {
                                  e.printStackTrace();
                  }
        }
          
        public PreparedStatement prepareStatement(String query) throws SQLException
        {
            return c.prepareStatement(query);
        }
}


