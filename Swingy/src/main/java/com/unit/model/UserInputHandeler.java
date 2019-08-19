package Swingy.src.main.java.com.unit.model;
import javax.swing.*;
import java.util.*;
import java.io.*;

class Character
{
    private String name;
    private int age;
    private String heroClass;
    private int experience;
    private int attack;
    private int defense;
    private int hit;
    public Character()
    {
        name = "Noname";
        age = 20;
        experience = 100;
        attack = 200;
        defense = 100;
        hit = 50;

    }
    Character(String name, int age, int power, int ammo)
    {
        ;
    }
    public String getCharName()
    {
        return name;
    }
    public int getCharAge()
    {
        return age;
    }
    public String getCharClass()
    {
        return heroClass;
    }
    public int getCharExperience()
    {
        return experience;
    }
    public int getCharAttack()
    {
        return attack;
    }
    public int getCharDefense()
    {
        return defense;
    }
    public int getCharHit()
    {
        return hit;
    }
    
}

public interface UserInputHandeler
{
    public String filename=null;
    public Character char_list[]=null;
    public String getFilename();
    public abstract int readFile(); 
}