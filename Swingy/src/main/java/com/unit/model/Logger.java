package Swingy.src.main.java.com.unit.model;
import java.util.*;
import java.io.*;

public abstract class Logger
{
    static Logger logger;
    
    protected Logger()
    {
        System.out.println("Logger has been created!");
    }

    public abstract void printMessage(String str);
    
    public void outputToFile(String filemame)
    {
        // will implement it if i have good mood
    }
    public static Logger getLogger()
    {
        return null;
    }
}