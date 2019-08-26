package Swingy.src.main.java.com.unit.view;
import javax.swing.*;
import java.util.*;
import java.io.*;
import Swingy.src.main.java.com.unit.model.*;

public interface SwingView
{
    public UserInputHandeler input = new UserInputMySQL();

    public abstract void initView();
    public abstract void printMap(int width, int height);
    public abstract void deinitView();

};