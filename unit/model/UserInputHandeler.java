package unit.model;
import javax.swing.*;
import java.util.*;
import java.io.*;

class Character
{
    private String name;
    private int age;
    private int power;
    private int ammo;
    public Character()
    {
        name = "Noname";
        age = 20;
        power = 100;
        ammo = 200;

    }
    Character(String name, int age, int power, int ammo);
    public String getCharName()
    {
        return name;
    }
    public int getCharAge()
    {
        return age;
    }
    public int getCharPower()
    {
        return power;
    }
    public int getCharAmmo()
    {
        return ammo;
    }
    public void setCharName(String name)
    {
        this.name = name;
    }
    public void setCharAge(int age)
    {
        this.age = age;
    }
    public void setCharPower(int power)
    {
        this.power = power;
    }
    public void setCharAmmo(int ammo)
    {
        this.ammo = ammo;
    }
}

public interface UserInputHandeler
{
    public String filename=null;
    public Character char_list[]=null;
    public String getFilename();
    public abstract int readFile(); 
}