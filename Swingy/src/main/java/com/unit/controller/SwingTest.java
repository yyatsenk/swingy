package Swingy.src.main.java.com.unit.controller;

import java.util.*;
import java.io.*;
import java.util.Scanner; 
import Swingy.src.main.java.com.unit.view.*;
import Swingy.src.main.java.com.unit.model.*;

    public class SwingTest { 
	
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
		// input char stat
		// if (view.input.validate(character) == 1)
		// 	view.input.addChar(character);
		view.initView();
		view.getUserInput();
		//view.printMap(30,15);
		Thread.sleep(50000);
		view.deinitView();
		view.input.destroyConnection();
    }  
}  
