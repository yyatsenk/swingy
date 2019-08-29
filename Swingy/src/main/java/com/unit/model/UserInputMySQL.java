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
    public String[][]  getResQuery()
    {
        //String[][] data = {};
        try
        {
            int i = 0;
            int j = -1;
            res = statement.executeQuery("select * from char_table");
            res.last();
            int size = res.getRow();
            res.first();
            String[][] data = new String[size][10];
            do
            {
                while (++j < 9)
                    data[i][j] = res.getString(j+2);
                i++;
                j = -1;
            } while(res.next());
            return data;
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return null;
    }

    //get final hero 
    public Hero setFinalHero(String name)
    {
        try
        {
            res = statement.executeQuery("select * from char_table where name=\'"+ name +"\'");
            if (!res.next())
                return null;
            
            Hero hero = new Hero.HeroBuilder().setName(res.getString(2)).setHeroClass(res.getString(3))
            .setLevel(Integer.parseInt(res.getString(4))).setExperience(Integer.parseInt(res.getString(5)))
            .setAttack(Integer.parseInt(res.getString(6))).setDefense(Integer.parseInt(res.getString(7)))
            .setHit(Integer.parseInt(res.getString(8))).build();
            return hero;
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return null;
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