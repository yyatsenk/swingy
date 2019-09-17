package Swingy.src.main.java.com.unit.controller;
import java.util.*;
import java.io.*; 
import Swingy.src.main.java.com.unit.view.*;
import Swingy.src.main.java.com.unit.model.*;

public class MovementConsole implements Movement
{
    public int [][] up(SwingView view, Hero player)
    {
        if (player.getPosY() - 1 < 0)
            System.out.println("You won!");
        else
        {
            view.getMap()[player.getPosY()][player.getPosX()] = 0;
            player.setPosY(player.getPosY() - 1);
            view.getMap()[player.getPosY()][player.getPosX()] = 1;
        }
        return view.getMap();
    }
    public int [][] down(SwingView view, Hero player)
    {
        if (player.getPosY() + 1 > view.getMap().length - 1)
            System.out.println("You won!");
        else
        {
            view.getMap()[player.getPosY()][player.getPosX()] = 0;
            player.setPosY(player.getPosY() + 1);
            view.getMap()[player.getPosY()][player.getPosX()] = 1;
        }
        return view.getMap();
    }
    public int [][] left(SwingView view, Hero player)
    {
        if (player.getPosX() - 1 < 0)
            System.out.println("You won!");
        else
        {
            view.getMap()[player.getPosY()][player.getPosX()] = 0;
            player.setPosX(player.getPosX() - 1);
            view.getMap()[player.getPosY()][player.getPosX()] = 1;
        }
        return view.getMap();
    }
    public int [][] right(SwingView view, Hero player)
    {
        if (player.getPosX() + 1 > view.getMap()[0].length -  1)
            System.out.println("You won!");
        else
        {
            view.getMap()[player.getPosY()][player.getPosX()] = 0;
            player.setPosX(player.getPosX() + 1);
            view.getMap()[player.getPosY()][player.getPosX()] = 1;
        }
        return view.getMap();
    }
}