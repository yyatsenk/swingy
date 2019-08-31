package Swingy.src.main.java.com.unit.model;
import java.util.*;
import java.io.*;

public class LoggerConsole extends Logger
{
    public void printMessage(String str)
    {
        System.out.print(str);
    }
    public static Logger getLogger()
    {
        logger = new LoggerConsole();
        return logger;
    }
}