package Swingy.src.main.java.com.unit.controller;
import java.util.*;
import java.io.*; 
import Swingy.src.main.java.com.unit.view.*;
import Swingy.src.main.java.com.unit.model.*;

public class MovementGui implements Movement
{
    public int [][] up(int [][] map, Hero player)
    {
        System.out.println("MovementGui: go UP");
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
        return null;
    }
    public int [][] left(int [][] map, Hero player)
    {
        return null;
    }
    public int [][] right(int [][] map, Hero player)
    {
        return null;
    }
}