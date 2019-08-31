package Swingy.src.main.java.com.unit.model;
import java.awt.*;
import java.util.*;
import java.io.*;
import javax.swing.*;

public class LoggerGui extends Logger
{
    static  LoggerGui loggerGui;
    private JTextArea textArea;

    private LoggerGui()
    {
        textArea = new JTextArea();
        textArea.setBounds(250,0, 250,400);
    }
    public void printMessage(String str)
    {
        textArea.append(str);
    }
    public static Logger getLogger()
    {
        logger = new LoggerGui();
        return logger;
    }
    public JTextArea getTextArea()
    {
        return textArea;
    }
}