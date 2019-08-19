package Swingy.src.main.java.com.unit.controller;

import java.util.*;
import java.io.*;
import java.util.Scanner; 
import Swingy.src.main.java.com.unit.view.*;
import Swingy.src.main.java.com.unit.model.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.Valid;


    public class SwingTest { 
	
	@Pattern(regexp=".+@.+\\..+", message="Wrong email!")
	private static String testValidation;
	public static void setTestValifation(String test)
	{
		testValidation = test;
	}
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
			System.out.println("After SwingView");
		UserInputFile input;
		setTestValifation("0");
		cView.initView();
		Thread.sleep(10000);
		cView.deinitView();
    }  
}  
