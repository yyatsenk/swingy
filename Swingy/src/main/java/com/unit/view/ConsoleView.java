package Swingy.src.main.java.com.unit.view;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class ConsoleView implements SwingView
{

    public void initView()
    {
        System.out.println("To create warrior enter: 1\nTo choose warrior enter: 2\n");
    }
    public void deinitView()
    {
        System.out.println("Here we encounter the end\n");
    }
}