package Swingy.src.main.java.com.unit.controller;

import java.util.*;
import java.io.*;
import java.util.Scanner; 
import Swingy.src.main.java.com.unit.view.*;
import Swingy.src.main.java.com.unit.model.*;

    public class SwingTest { 
	static Hero player;
    public static void main(String[] args) throws InterruptedException
    {
		SwingView view;
		//viewUserInputHandeler input = new UserInputMySQL();
		Hero character = new Hero.HeroBuilder().setAttack(10).setDefense(50).setName(null).setLevel(1).setHeroClass("Goblin").build();
		
		if (args.length != 1)
        {
            System.out.println("Usage: java swingy [console, gui]");
            System.exit(0);
        }

		System.out.println(args[0]);
		if ("console".equals(args[0]))
			view = new ConsoleView();
		else if ("gui".equals(args[0]))
			view = new GuiView();
		else
		{
			System.out.println("return");
			return ;
		}
		if (view.input.establishConnection() == 0)
		{
			System.out.println("establishConnection failed\n");
			return ;
		}
		view.initView();
		player = view.getUserInput();
		if (player != null)
			view.startGame(500, 500, player);
		System.out.println("Player name = " + player.getCharName());
		view.deinitView();
		view.input.destroyConnection();
    }  
}  
