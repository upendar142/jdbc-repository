package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertOperation {

    public static void main(String[] args) {
        Connection connection=null;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/my_first_db", "root", "root");
            if(connection!=null)
            {
                System.out.println("Conneted!!");
            }
            else
            {
                System.out.println("Problem in database connection!!");
            }
         
            PreparedStatement preparedStatement=connection.prepareStatement("insert into customer values(?,?,?,?,?)"); //? -placeholders
            preparedStatement.setInt(1, 2525);
            preparedStatement.setString(2, "Lavanya");
            preparedStatement.setString(3, "Hyderabad");
            preparedStatement.setString(4, "upendar@abc.com");
            preparedStatement.setLong(5, 9347370767L);
            
            if(preparedStatement.executeUpdate()>0)
            {
                System.out.println("Record inserted!!");
            }
            else
            {
                System.out.println("Problem in insert operation!!");
            }
            
        }
        catch (ClassNotFoundException e) {
            
            e.printStackTrace();
        }
        catch (SQLException e) {
            
            e.printStackTrace();
        }

    }

}
