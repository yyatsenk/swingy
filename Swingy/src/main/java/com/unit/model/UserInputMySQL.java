package Swingy.src.main.java.com.unit.model;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.sql.*;

public class UserInputMySQL implements UserInputHandeler
{

    private Connection  connection;
    private Statement   statement;
    private String      query;
    private ResultSet   res;

    public int     establishConnection()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");  
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Characters?useSSL=false","root","root"); 
            statement=connection.createStatement();
        }
        catch(Exception e)
        { 
            System.out.println(e);
            return (0);
        }
        System.out.println("Database connection established.\n");
        return (1);
    }

    public int     validate(Hero hero)
    {
        return val.validateChar(hero);
    }

    public void    addChar(Hero hero)
    {
        try
        {
            query = " insert into char_table (char_id, name, char_class, level, experience, attack, defense, hit, Weapon, Armor, Helm)"
            + " SELECT * FROM (SELECT ? as col1, ? as col2, ? as col3, ? as col4, ? as col5, ? as col6, ? as col7, ? as col8, ? as col9, ? as col10, ? as col11) AS tmp" +
            " WHERE NOT EXISTS (SELECT name FROM char_table WHERE name = ?) LIMIT 1";
    
          // create the mysql insert preparedstatement
          PreparedStatement preparedStmt = connection.prepareStatement(query);
          preparedStmt.setInt    (1, 0);
          preparedStmt.setString (2, hero.getCharName());
          preparedStmt.setString (3, hero.getCharClass());
          preparedStmt.setInt    (4, hero.getCharLevel());
          preparedStmt.setInt    (5, hero.getCharExperience());
          preparedStmt.setInt    (6, hero.getCharAttack());
          preparedStmt.setInt    (7, hero.getCharDefense());
          preparedStmt.setInt    (8, hero.getCharHit());
          preparedStmt.setInt    (9, 0);
          preparedStmt.setInt    (10, 0);
          preparedStmt.setInt    (11, 0);
          preparedStmt.setString    (12, hero.getCharName());
          preparedStmt.execute();
        }
          catch(Exception e)
        { 
            System.out.println(e);
        }
    }
    public Object  getResQuery()
    {
        try
        {
            res = statement.executeQuery("select * from char_table");
            System.out.println("Name\tClass\tLevel\tExperience\tAttack\tDefense\tHit\tWeapon\tArmor\tHelm");
            while(res.next())  
                System.out.println(res.getString(2)+"\t" + res.getString(3)+"\t" + res.getString(4)
                + "\t"+ res.getString(5) + "\t\t"+res.getString(6) + "\t"+res.getString(7) + "\t"
                + res.getString(8) + "\t"+res.getString(9)+"\t"+res.getString(10) +"\t" + res.getString(11));  

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return res;
    }
    public void    destroyConnection()
    {
        try
        {
            connection.close();
        }
        catch(Exception e)
        { 
            System.out.println(e);
        }
    }
}