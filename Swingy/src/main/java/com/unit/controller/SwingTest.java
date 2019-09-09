package Swingy.src.main.java.com.unit.controller;

import java.util.*;
import java.io.*;
import java.util.Scanner; 
import Swingy.src.main.java.com.unit.view.*;
import Swingy.src.main.java.com.unit.model.*;

    public class SwingTest { 
	static Hero player;
	static SwingView view;
    public static void main(String[] args) throws InterruptedException
    {
		if (args.length != 1)
        {
            System.out.println("Usage: java swingy [console, gui]");
            System.exit(0);
        }

		if ("console".equals(args[0]))
			view = new ConsoleView();
		else if ("gui".equals(args[0]))
			view = new GuiView();
		else
		{
			System.out.println("Usage: java swingy [console, gui]");
			return ;
		}
		if (view.input.establishConnection() == 0)
		{
			System.out.println("Database connection failed\n");
			return ;
		}
			view.initView();
				player = view.getUserInput();
				if (player != null)
					view.startGame(500, 500, player);
				System.out.println("Player name = " + player.getCharName());
				//player.getMovement().up(view.getMap(), player.getPosX(), player.getPosY());
				view.printMap(20,30);
				for (int j = 0; ; j++)
				{
					try
					{
						char keyChar = (char)System.in.read();
						if (keyChar == 'w')
							player.getMovement().up(view.getMap(), player);
						if (keyChar == 's')
							player.getMovement().down(view.getMap(), player);
						if (keyChar == 'a')
							player.getMovement().left(view.getMap(), player);
						if (keyChar == 'd')
							player.getMovement().right(view.getMap(), player);
						if (keyChar == 'q')
							break;
					}
					catch(Exception e)
					{}
					view.printMap(20,30);
					// System.out.print("\033[H\033[2J");  
					// System.out.flush();
				}
				/*
				view.spreadWarriors();
				if (KEY_UP pressed)
					player.move.up();
				...
				...
				if (meets warrior)
				{
					if (fight pressed)
						fight
					else
						run
				}
				if (border encountered)
					you won
				if (health == 0)
					you lose
				*/
			view.deinitView();

		view.input.destroyConnection();
    }  
}  
