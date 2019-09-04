package Swingy.src.main.java.com.unit.view;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.io.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import Swingy.src.main.java.com.unit.model.*;
import Swingy.src.main.java.com.unit.controller.*;

public class GuiView extends SwingView
{
    Hero hero;
    private JFrame f;
    private JFrame gameArea;
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
    String[] columnNames = {"Name",
                        "Class",
                        "Level",
                        "Experience",
                        "Defence",
                        "Attack",
                        "Hit"};
    JTable table;
    JLabel lbl;
    public GuiView()
    {
        logger = LoggerGui.getLogger();
    }
    private void setHero(Hero h)
    {
        this.hero = h;
    }
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

    	f.setSize(500,400);
    	f.setLayout(null);  
        f.setVisible(true);
        f.show();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void printMap(int width, int height)
    {

    }
    protected void printDatabase()
    {
    }
    public Hero  getUserInput()
    {
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
        buttCreate.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){
                    buttChoose.setEnabled( false );
                    f.add(name);
                    f.add(cls);
                    f.add(level);
                    f.add(experience);
                    f.add(defence);
                    f.add(attack);
                    f.add(hit);
                    f.add(Validate);
                    f.setVisible(false);
                    f.show();
                    }  
                });
            Validate.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){
                    Hero hero = new Hero.HeroBuilder().setName(name.getText()).setHeroClass(cls.getText())
                    .setLevel(Integer.parseInt(level.getText())).setExperience(Integer.parseInt(experience.getText()))
                    .setAttack(Integer.parseInt(attack.getText())).setDefense(Integer.parseInt(defence.getText()))
                    .setHit(Integer.parseInt(hit.getText())).setMovement(new MovementGui()).build();
                    if (input.validate(hero) == 1)
                    {
                        //input.addChar(hero);
                        // game starts
                    }
                    setHero(hero);
                }
            });
            buttChoose.addActionListener(new ActionListener(){  
                public void actionPerformed(ActionEvent e){
                        buttCreate.setEnabled( false );
                        String[][] data = input.getResQuery();
                  
                        final JTable j = new JTable(data, columnNames); 
                        j.setBounds(0, 200, 500, 200); 
    
                        JScrollPane sp = new JScrollPane(j); 
                        sp.setBounds(0, 200, 500, 200); 
                        f.add(sp);
                        f.show();
                        j.addMouseListener(new java.awt.event.MouseAdapter() {

                            public void mouseClicked(java.awt.event.MouseEvent e)
                            {
                                int row = j.rowAtPoint(e.getPoint());
                                int col = j.columnAtPoint(e.getPoint());
                                setHero(input.setFinalHero(j.getValueAt(row,col).toString()));
                            }
                        });}  
                    });
            try
            {
            while (this.hero == null)
                Thread.sleep(100);
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
            this.hero.setMovement(new MovementGui());
            map = new int[hero.getCharLevel() * 10][hero.getCharLevel() * 10];
            return this.hero;
    }
    public void deinitView()
    {
        f.dispose();
        System.out.println("Here we encounter the end\n");
    }
    public void startGame(int width, int height, Hero hero)
    {
        if (f.isVisible())
            f.setVisible(false);
        gameArea = new JFrame("Swingy");
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(10,10));
        
        BufferedImage img = null;
        BufferedImage img2 = null;
        try {
            img = ImageIO.read(new File("/home/yyatsenk/Downloads/1200px-Pac_Man.svg.png"));
            img2 = ImageIO.read(new File("/home/yyatsenk/Downloads/solid-green-background.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image newImage = img.getScaledInstance(width / 10, height / 10, Image.SCALE_DEFAULT);
        Image newImage2 = img2.getScaledInstance(width / 10, height / 10, Image.SCALE_DEFAULT);
        GuiStatusBar statusBar = GuiStatusBar.getGuiStatusBar(hero);
        gameArea.setSize(width, height);
        panel.setBounds(40,80,200,200);
        panel.setBackground(Color.gray);
        gameArea.add(panel);  
        gameArea.add(((LoggerGui)logger).getTextArea());
        gameArea.add(statusBar.getStatusBarTable());
        gameArea.add(statusBar.getLevelBar());
        gameArea.setLayout(null);  
        gameArea.setVisible(true);
        gameArea.show();
        gameArea.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        for(int i = 0; i < 100; i++)
        {
            if (i != 0)
            {
                try
                {
                    Thread.sleep(100);
                }
                catch (Exception e)
                {}
            }
            panel.removeAll();
            for (int j = 0; j < 100; j++)
            {
                if (j == i)
                    panel.add(new JLabel(new ImageIcon(newImage)));
                else
                    panel.add(new JLabel(new ImageIcon(newImage2)));
            }
            panel.revalidate();
            gameArea.show();
        }
        logger.printMessage("God:Game starts!!!\n");
    }
}