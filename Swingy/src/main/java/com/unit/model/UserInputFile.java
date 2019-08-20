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
        Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/sonoo","root","root");  
        //here sonoo is database name, root is username and password  
        Statement stmt=con.createStatement();  
        ResultSet rs=stmt.executeQuery("select * from emp");  
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