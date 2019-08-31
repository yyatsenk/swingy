package Swingy.src.main.java.com.unit.view;
import javax.swing.*;
import java.util.*;
import java.io.*;
import Swingy.src.main.java.com.unit.model.*;

public abstract class SwingView
{
    public UserInputHandeler input = new UserInputMySQL();
    public Logger logger;

    protected abstract void printDatabase();

    public abstract void initView();
    public abstract Hero getUserInput();
    public abstract void startGame(int width, int height);
    public abstract void printMap(int width, int height);
    public abstract void deinitView();

};