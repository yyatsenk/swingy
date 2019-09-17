package Swingy.src.main.java.com.unit.view;
import javax.swing.*;
import java.util.*;
import java.io.*;
import Swingy.src.main.java.com.unit.controller.*;
import Swingy.src.main.java.com.unit.model.*;
import java.sql.*;


public class ConsoleView extends SwingView
{
    private Scanner in = new Scanner(System.in);
    int choise;
    private String finalHero;
    private String name;
    private String heroClass;
    private int level;
    private int experience;
    private int attack;
    private int defense;
    private int hit;
    public ConsoleView()
    {
        logger = LoggerConsole.getLogger();
        listener = new ListenerConsole();
    }
    public void initView()
    {
    }


    public void printMap(int width, int height)
    {
        int i = -1;
        int j = -1;
        while (++i < map.length)
        {
            while (++j < map[i].length)
            {
                System.out.print(map[i][j]);
            }
            j = -1;
            System.out.print("\n");
        }
    }
    public Hero  getUserInput()
    {
        System.out.println("Enter \"1\" to create or \"2\" to choose warrior :\n");
        try
        {
            choise = in.nextInt();
        }
        catch(Exception e)
        { 
            System.out.println(e);
            return null;
        }
        if (choise == 1)
        {
            try
            {
                
                System.out.println("Enter name:");
                name = in.next();
                System.out.println("Enter class: ");
                heroClass = in.next();
                System.out.println("Enter level: ");
                level = in.nextInt();
                System.out.println("Enter experience: ");
                experience = in.nextInt();
                System.out.println("Enter attack: ");
                attack = in.nextInt();
                System.out.println("Enter defense: ");
                defense = in.nextInt();
                System.out.println("Enter hit: ");
                hit = in.nextInt();
            }
            catch (Exception e)
            {
                System.out.println(e);
                return null;
            }
            Hero hero = new Hero.HeroBuilder().setName(name).setHeroClass(heroClass)
                    .setLevel(level).setExperience(experience).setAttack(attack)
                    .setDefense(defense).setHit(hit).setMovement(new MovementConsole())
                    .build();
            if (input.validate(hero) == 1)
            {
                //input.addChar(hero);
                // game starts
                return hero;
            }
        }
        else
        {
            Hero hero;
            System.out.println("Enter name of warrior you want to play as:");
            this.printDatabase();
            finalHero = in.next();
            hero = input.setFinalHero(finalHero);
            hero.setMovement(new MovementConsole());
            map = new int[(hero.getCharLevel() - 1) * 5 + 10 - (hero.getCharLevel() % 2)][(hero.getCharLevel() - 1) * 5 + 10 - (hero.getCharLevel() % 2)];
            map[((hero.getCharLevel() - 1) * 5 + 10 - (hero.getCharLevel() % 2))/2][((hero.getCharLevel() - 1) * 5 + 10 - (hero.getCharLevel() % 2))/2] = 1;
            hero.setPosX(((hero.getCharLevel() - 1) * 5 + 10 - (hero.getCharLevel() % 2))/2);
            hero.setPosY(((hero.getCharLevel() - 1) * 5 + 10 - (hero.getCharLevel() % 2))/2);
            return hero;

        }
        return null;
    }
    protected void printDatabase()
    {
        String[][] data = input.getResQuery();
        int i = -1;
        int j = -1;
        System.out.println("\tName\tClass\tLevel\tExperience\tAttack\tDefense\tHit\tWeapon\tArmor\tHelm");
        while (++i < data.length)
        {
            while (++j < data[i].length)
            {
                System.out.print("\t" + data[i][j] + " ");
            }
            System.out.println("");
            j = -1;
        }


    }
    public void deinitView()
    {
        System.out.println("Here we encounter the end\n");
    }
    public void startGame(int width, int height, Hero hero)
    {

    }
}