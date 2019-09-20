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
		view.initView();
		player = view.getUserInput();
		if (player != null)
			view.startGame(500, 500, player);
		System.out.println("Player name = " + player.getCharName());
		view.printMap(20,30);
		
		view.listener.listen(player, view);
		
		view.deinitView();
    }  
}  
