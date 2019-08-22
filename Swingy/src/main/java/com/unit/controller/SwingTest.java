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
		//UserInputFile input = new UserInputFile();
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
			System.out.println("After SwingView");
		UserInputHandeler input = new UserInputFile();
		UserInputHandeler input2 = new UserInputConsole();
		input.readFile();
		input2.readFile();
		cView.initView();
		Thread.sleep(10000);
		cView.deinitView();
    }  
}  
