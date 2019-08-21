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
        // String query = " insert into char_table (char_id, name, char_class, level, experience, attack, defense, hit, Weapon, Armor, Helm)"
        // + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String query = " insert into char_table (char_id, name, char_class, level, experience, attack, defense, hit, Weapon, Armor, Helm)"
        + " SELECT * FROM (SELECT ? as col1, ? as col2, ? as col3, ? as col4, ? as col5, ? as col6, ? as col7, ? as col8, ? as col9, ? as col10, ? as col11) AS tmp" +
        " WHERE NOT EXISTS (SELECT name FROM char_table WHERE name = ?) LIMIT 1";

      // create the mysql insert preparedstatement
      PreparedStatement preparedStmt = con.prepareStatement(query);
      preparedStmt.setInt    (1, 0);
      preparedStmt.setString (2, "Peter");
      preparedStmt.setString (3, "Golden");
      preparedStmt.setInt    (4, 3);
      preparedStmt.setInt    (5, 100);
      preparedStmt.setInt    (6, 200);
      preparedStmt.setInt    (7, 300);
      preparedStmt.setInt    (8, 400);
      preparedStmt.setInt    (9, 2);;
      preparedStmt.setInt    (10, 4);
      preparedStmt.setInt    (11, 5);
      preparedStmt.setString    (12, "Peter");
      preparedStmt.execute();
        ResultSet rs=stmt.executeQuery("select * from char_table");  
        while(rs.next())  
            System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
        con.close();  
    }catch(Exception e)
    { 
        System.out.println(e);
    } 
    }
    public String getFilename()
    {
        return new String("Hello");
    }
    public int readFile()
    {
        System.out.println("Reading from file\n");
        return (0);
    }
}