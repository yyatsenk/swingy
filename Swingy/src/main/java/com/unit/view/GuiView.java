package Swingy.src.main.java.com.unit.view;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import javax.swing.*;
import Swingy.src.main.java.com.unit.model.*;

public class GuiView implements SwingView
{
    private JFrame f;
    private JButton buttCreate;
    private JButton buttChoose;
    private JButton Validate;
    private JTextField name;
    private JTextField cls;
    private JTextField level;
    private JTextField experience;
    private JTextField defence;
    private JTextField attack;
    private JTextField hit;
    JLabel lbl;
    public void initView()
    {
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


        Validate = new JButton("Validate");
        Validate.setBounds(190,250,100, 45);
        name = new JTextField("Enter name");
        name.setBounds(130, 145, 100, 20);
        cls = new JTextField("Enter class");
        cls.setBounds(130, 170, 100, 20);
        level = new JTextField("2");
        level.setBounds(130, 195, 100, 20);

        experience = new JTextField("3");
        experience.setBounds(230, 145, 100, 20);
        defence = new JTextField("4");
        defence.setBounds(230, 170, 100, 20);
        attack = new JTextField("5");
        attack.setBounds(230, 195, 100, 20);
        hit = new JTextField("6");
        hit.setBounds(230, 220, 100, 20);
        // f.add(name);
        // f.add(cls);
        // f.add(level);
        // f.add(Validate);
        buttCreate.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                    f.setVisible(false);
                    f.add(name);
                    f.add(cls);
                    f.add(level);
                    f.add(experience);
                    f.add(defence);
                    f.add(attack);
                    f.add(hit);
                    f.add(Validate);
                    f.show();
                    }  
                });
            Validate.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){
                    Hero hero = new Hero.HeroBuilder().setName(name.getText()).setHeroClass(cls.getText())
                    .setLevel(Integer.parseInt(level.getText())).setExperience(Integer.parseInt(experience.getText())).setAttack(Integer.parseInt(attack.getText()))
                    .setDefense(Integer.parseInt(defence.getText())).setHit(Integer.parseInt(hit.getText())).build();
                    if (input.validate(hero) == 1)
                    {
                        input.addChar(hero);
                        // game starts
                    }
                     System.out.println(name.getText());
                    // System.out.println(name.getText());
                    // System.out.println(name.getText());
                            }  
                        });
    	f.setSize(500,400);
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