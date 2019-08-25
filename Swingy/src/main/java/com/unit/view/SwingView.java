package Swingy.src.main.java.com.unit.view;
import javax.swing.*;
import java.util.*;
import java.io.*;


public interface SwingView{

    public abstract void initView();
    //public abstract void printCharTable();
    public abstract void printMap(int width, int height);
    public abstract void deinitView();

};