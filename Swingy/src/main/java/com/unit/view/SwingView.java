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
    protected int[][] map;
    protected abstract void printDatabase();

    public abstract void initView();
    public abstract Hero getUserInput();
    public abstract void startGame(int width, int height, Hero hero);
    public abstract void printMap(int width, int height);
    public abstract void deinitView();
    public int[][] getMap()
    {
        return map;
    }
    public void setMap(int[][] map)
    {
        this.map = map;
    }

};