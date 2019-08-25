package Swingy.src.main.java.com.unit.controller;

import java.util.*;
import java.io.*;
import java.util.Scanner; 
import Swingy.src.main.java.com.unit.view.*;
import Swingy.src.main.java.com.unit.model.*;

    public class SwingTest { 
	
    public static void main(String[] args) throws InterruptedException
    {   
		Scanner in = new Scanner(System.in);
		SwingView cView;
		if (args.length != 1)
        {
            System.out.println("Usage: java swingy [console, gui]");
            System.exit(0);
        }

		System.out.println(args[0]);
		if ("console".equals(args[0]))
			cView = new ConsoleView();
		else if ("gui".equals(args[0]))
			cView = new GuiView();
		else
		{
			System.out.println("return");
			return ;
		}
		Hero character = new Hero.HeroBuilder().setAttack(10).setDefense(50).setName("Kevin").setLevel(1).setHeroClass("Goblin").build();
		UserInputHandeler input = new UserInputMySQL();
		if (input.establishConnection() == 0)
		{
			System.out.println("establishConnection failed\n");
			return ;
		}
		input.addChar(character);
		input.getResQuery();
		cView.initView();
		cView.printMap(30,15);
		Thread.sleep(10000);
		cView.deinitView();
		input.destroyConnection();
    }  
}  
