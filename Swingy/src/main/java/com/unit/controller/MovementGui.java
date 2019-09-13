package Swingy.src.main.java.com.unit.controller;
import java.util.*;
import java.io.*; 
import Swingy.src.main.java.com.unit.view.*;
import Swingy.src.main.java.com.unit.model.*;

public class MovementGui implements Movement
{
    public int [][] up(int [][] map, Hero player)
    {
        //System.out.println("In UP");
        if (player.getPosY() - 1 < 0)
            System.out.println("You won!");
        else
        {
            map[player.getPosY()][player.getPosX()] = 0;
            player.setPosY(player.getPosY() - 1);
            map[player.getPosY()][player.getPosX()] = 1;
        }
        return map;
    }
    public int [][] down(int [][] map, Hero player)
    {
        if (player.getPosY() + 1 > map.length - 1)
            System.out.println("You won!");
        else
        {
            map[player.getPosY()][player.getPosX()] = 0;
            player.setPosY(player.getPosY() + 1);
            map[player.getPosY()][player.getPosX()] = 1;
        }
        return map;
    }
    public int [][] left(int [][] map, Hero player)
    {
        if (player.getPosX() - 1 < 0)
            System.out.println("You won!");
        else
        {
            map[player.getPosY()][player.getPosX()] = 0;
            player.setPosX(player.getPosX() - 1);
            map[player.getPosY()][player.getPosX()] = 1;
        }
        return map;
    }
    public int [][] right(int [][] map, Hero player)
    {
        if (player.getPosX() + 1 > map[0].length -  1)
            System.out.println("You won!");
        else
        {
            map[player.getPosY()][player.getPosX()] = 0;
            player.setPosX(player.getPosX() + 1);
            map[player.getPosY()][player.getPosX()] = 1;
        }
        return map;
    }
}