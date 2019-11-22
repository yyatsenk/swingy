package Swingy.src.main.java.com.unit.view;
import javax.swing.*;
import java.util.*;
import java.io.*;
import Swingy.src.main.java.com.unit.model.*;
import Swingy.src.main.java.com.unit.controller.*;

public abstract class SwingView
{
    public UserInputHandeler input = new UserInputMySQL();
    public Logger logger;
    public Listener listener;
    protected int[][] map;
    private List<Hero> villainList;
    protected abstract void printDatabase();

    public abstract void initView();
    public abstract Hero getUserInput();
    public abstract void startGame(int width, int height, Hero hero);
    public abstract void printMap(int width, int height);
    public abstract void deinitView();
    public abstract void resultMessage(String result);
    public void spreadWarriors(int mapSize)
    {
        Random rand =  new Random();
        int level = (mapSize - 4) / 5;
        if (((mapSize - 5) % 5) == 0)
            level = (mapSize - 5) / 5;
        level++;
        int exp = level * 1000 + (level - 1) * (level - 1) * 450;
        villainList = new ArrayList<Hero> ();
        for (int i = 0; i < 5 * level; i++)
        {
            villainList.add(new Hero.HeroBuilder().setName("Devil").setLevel(4).setExperience(rand.nextInt(exp * 2)).setPosX(rand.nextInt(mapSize)).setPosY(rand.nextInt(mapSize)).build());
        }
        for (Hero h : villainList) {
            if (map[h.getPosY()][h.getPosX()] == 0)
                map[h.getPosY()][h.getPosX()] = h.getCharLevel();
        }
    }
    public Logger getLogger()
    {
        return logger;
    }
    public Listener getListener()
    {
        return listener;
    }
    public int[][] getMap()
    {
        return map;
    }
    public void setMap(int[][] map)
    {
        this.map = map;
    }
    public List<Hero> getVillainList()
    {
        return villainList;
    }
};