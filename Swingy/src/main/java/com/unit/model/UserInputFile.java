package Swingy.src.main.java.com.unit.model;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.sql.*;

public class UserInputFile implements UserInputHandeler
{
    public UserInputFile()
    {
        try{
        Class.forName("com.mysql.jdbc.Driver");  
        Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/Characters?useSSL=false","root","root");  
        //here sonoo is database name, root is username and password  
        Statement stmt=con.createStatement();
        String query = " insert ignore into char_table (char_id, name, char_class, level, experience, attack, defense, hit, Weapon, Armor, Helm)"
        + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

      // create the mysql insert preparedstatement
      PreparedStatement preparedStmt = con.prepareStatement(query);
      preparedStmt.setInt    (1, 0);
      preparedStmt.setString (2, "Barney");
      preparedStmt.setString (3, "Golden");
      preparedStmt.setInt    (4, 1);
      preparedStmt.setInt    (5, 100);
      preparedStmt.setInt    (6, 200);
      preparedStmt.setInt    (7, 300);
      preparedStmt.setInt    (8, 300);
      preparedStmt.setInt    (9, 0);;
      preparedStmt.setInt    (10, 1);
      preparedStmt.setInt    (11, 1);
      //preparedStmt.execute();
        ResultSet rs=stmt.executeQuery("select * from char_table");  
        while(rs.next())  
            System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
        con.close();  
    }catch(Exception e)
    { 
        System.out.println(e);
    } 
    }
    public String getFilename()
    {
        return filename;
    }
    public int readFile()
    {
        System.out.println("Reading from file\n");
        return (0);
    }
}