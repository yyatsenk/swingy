package Swingy.src.main.java.com.unit.controller;
import javax.swing.*;
import java.util.*;
import java.io.*;
import Swingy.src.main.java.com.unit.view.*;
import Swingy.src.main.java.com.unit.model.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

    public class SwingTest { 
	
	@Pattern(regexp=".+@.+\\..+", message="Wrong email!")
	private String testValidation;
    public static void main(String[] args) 
    {   
		if (args.length != 1)
        {
            System.out.println("Usage: java swingy [console, gui]");
            System.exit(0);
        }

		if (args[0] == "console")
		{
			ConsoleView cView = new ConsoleView();
		}
		UserInputFile input;
    	JFrame f=new JFrame();//creating instance of JFrame  
              
    	JButton b=new JButton("click");//creating instance of JButton  
    	b.setBounds(130,100,100, 40);//x axis, y axis, width, height  
              
    	f.add(b);//adding button in JFrame  
              
    	f.setSize(400,500);//400 width and 500 height  
    	f.setLayout(null);//using no layout managers  
    	f.setVisible(true);//making the frame visible  
    }  
}  
