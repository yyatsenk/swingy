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
    public void printMap(int width, int height)
    {
        int i = -1;
        int j = -1;

        while (++i != height)
        {
            if (i == 0 || i == height - 1)
            {
                while (++j != width)
                    System.out.print("#");
                System.out.println("");
            }
            else
            {
                while (++j != width)
                {
                    if (j == 0 || j == width - 1)
                        System.out.print("#");
                    else
                        System.out.print(" ");
                }
                System.out.println("");
            }
            j = -1;
        }
    }
    public void deinitView()
    {
        System.out.println("Here we encounter the end\n");
    }
}