package Swingy.src.main.java.com.unit.view;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import javax.swing.*;

public class GuiView implements SwingView
{
    private JFrame f;
    private JButton b;
    public void initView()
    {
        System.out.println("Inside GuiView");
        f=new JFrame();//creating instance of JFrame  
              
    	b=new JButton("Close");//creating instance of JButton  
    	b.setBounds(130,100,100, 40);//x axis, y axis, width, height  
              
    	f.add(b);//adding button in JFrame  
        b.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                    f.setVisible(false); 
                    }  
                });  
    	f.setSize(1000,1000);
    	f.setLayout(null);  
    	f.setVisible(true);
    }
    public void deinitView()
    {
        if (f.isVisible())
            f.setVisible(false);
        f.dispose();
        System.out.println("Here we encounter the end\n");
    }
}