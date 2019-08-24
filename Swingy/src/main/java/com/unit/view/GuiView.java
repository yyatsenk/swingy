package Swingy.src.main.java.com.unit.view;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import javax.swing.*;

public class GuiView implements SwingView
{
    private JFrame f;
    private JButton buttCreate;
    private JButton buttChoose;
    JLabel lbl;
    public void initView()
    {
        System.out.println("Inside GuiView");
        f = new JFrame("Swingy");


        lbl = new JLabel("You need the warrior for game!"); 
        lbl.setBounds(110,5, 350,30);

        buttCreate = new JButton("Create");
        buttCreate.setBounds(130,100,100, 40); 
        
        buttChoose = new JButton("Choose");
    	buttChoose.setBounds(230,100,100, 40);
              
        f.add(buttCreate);//adding button in JFrame 
        f.add(buttChoose);
        f.add(lbl);
        buttCreate.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                    f.setVisible(false); 
                    }  
                });  
    	f.setSize(500,300);
    	f.setLayout(null);  
        f.setVisible(true);
        f.show();
    }
    public void printMap(int width, int height)
    {
        
    }
    public void deinitView()
    {
        if (f.isVisible())
            f.setVisible(false);
        f.dispose();
        System.out.println("Here we encounter the end\n");
    }
}