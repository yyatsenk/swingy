package Swingy.src.main.java.com.unit.view;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.io.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import Swingy.src.main.java.com.unit.model.*;
import Swingy.src.main.java.com.unit.controller.*;

public class GuiView extends SwingView
{
    public Hero hero;
    private JFrame f;
    private JFrame gameArea;
    private JPanel panel;
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
    BufferedImage background;
    BufferedImage herotexture;
    Image backgroundSized;
    Image herotextureSized;
    BufferedImage devil;
    Image devilSized;
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
        listener = new ListenerGui();
    }
    private void setHero(Hero h)
    {
        this.hero = h;
    }
    public void initView()
    {
        if (input.establishConnection() == 0)
		{
			System.out.println("Database connection failed\n");
			return ;
		}
        f = new JFrame("Swingy");

        lbl = new JLabel("You need the warrior for game!"); 
        lbl.setBounds(0, 5, 500, 30);
        lbl.setForeground(Color.white);
        lbl.setHorizontalAlignment(JLabel.CENTER);

        buttCreate = new JButton("Create");
        buttCreate.setBounds(145,100,100, 40);
        buttCreate.setBackground(new Color(22, 22, 22));
        buttCreate.setForeground(Color.white);
        buttCreate.setFocusPainted(false);

        buttChoose = new JButton("Choose");
        buttChoose.setBounds(245,100,100, 40);
        buttChoose.setBackground(new Color(22, 22, 22));
        buttChoose.setForeground(Color.white);
        buttChoose.setFocusPainted(false);
        
              
        f.add(buttCreate);
        f.add(buttChoose);
        f.add(lbl);
        f.getContentPane().setBackground(new Color(0x2F, 0x35, 0x38));
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
        Validate.setBounds(205,250,100, 45);
        Validate.setBackground(new Color(22, 22, 22));
        Validate.setForeground(Color.white);
        Validate.setFocusPainted(false);
        
        name = new JTextField("Name");
        name.setBounds(145, 145, 100, 20);
        name.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                name.setText("");
            }
        });

        cls = new JTextField("Class");
        cls.setBounds(145, 170, 100, 20);
        cls.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                cls.setText("");
            }
        });

        level = new JTextField("Level");
        level.setBounds(145, 195, 100, 20);
        level.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                level.setText("");
            }
        });

        experience = new JTextField("Experience");
        experience.setBounds(245, 145, 100, 20);
        experience.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                experience.setText("");
            }
        });

        defence = new JTextField("Defence");
        defence.setBounds(245, 170, 100, 20);
        defence.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                defence.setText("");
            }
        });

        attack = new JTextField("Attack");
        attack.setBounds(245, 195, 100, 20);
        attack.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                attack.setText("");
            }
        });

        hit = new JTextField("Hit");
        hit.setBounds(245, 220, 100, 20);
        hit.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                hit.setText("");
            }
        });

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
                try {
                    Hero hero = new Hero.HeroBuilder().setName(name.getText()).setHeroClass(cls.getText())
                    .setLevel(Integer.parseInt(level.getText())).setExperience(Integer.parseInt(experience.getText()))
                    .setAttack(Integer.parseInt(attack.getText())).setDefense(Integer.parseInt(defence.getText()))
                    .setHit(Integer.parseInt(hit.getText())).setMovement(new MovementGui()).build();
                    if (input.validate(hero) == 1)
                    {
                        input.addChar(hero);
                        setHero(hero);
                        // game starts
                    }
                }
                catch (NumberFormatException exp) {
                    level.setText       ("Must be integer");
                    experience.setText  ("Must be integer");
                    attack.setText      ("Must be integer");
                    defence.setText     ("Must be integer");
                    hit.setText         ("Must be integer");
                }
                }
            });
            buttChoose.addActionListener(new ActionListener(){  
                public void actionPerformed(ActionEvent e){
                        buttCreate.setEnabled( false );
                        String[][] data = input.getResQuery();
                  
                        final JTable j = new JTable(data, columnNames); 
                        j.setBounds(0, 200, 500, 200);
                        j.setBackground(new Color(0x78, 0xBB, 0xD6));
                        j.getTableHeader().setBackground(new Color(0x78, 0xBB, 0xD6));
                        j.getTableHeader().setFont(new Font("Serif", Font.BOLD, 12));

                        JScrollPane sp = new JScrollPane(j);
                        sp.getViewport().setBackground(new Color(0x2F, 0x35, 0x38));
                        sp.setBorder(BorderFactory.createEmptyBorder());
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
            map = new int[(hero.getCharLevel() - 1) * 5 + 10 - (hero.getCharLevel() % 2)][(hero.getCharLevel() - 1) * 5 + 10 - (hero.getCharLevel() % 2)];
            map[((hero.getCharLevel() - 1) * 5 + 10 - (hero.getCharLevel() % 2))/2][((hero.getCharLevel() - 1) * 5 + 10 - (hero.getCharLevel() % 2))/2] = 1;
            hero.setPosX(((hero.getCharLevel() - 1) * 5 + 10 - (hero.getCharLevel() % 2))/2);
            hero.setPosY(((hero.getCharLevel() - 1) * 5 + 10 - (hero.getCharLevel() % 2))/2);
            return this.hero;
    }
    public void deinitView()
    {
        f.dispose();
    }

    public void refresh()
    {
        panel.removeAll();
        for (int[] m: map)
        {
            for (int numb: m)
            {
                if (numb == 0)
                    panel.add(new JLabel(new ImageIcon(backgroundSized)));
                else if (numb == 1)
                    panel.add(new JLabel(new ImageIcon(herotextureSized)));
                else
                    panel.add(new JLabel(new ImageIcon(devilSized)));
            }
        }
        panel.revalidate();
        gameArea.show();
    }

    public void startGame(int width, int height, Hero hero)
    {
        if (f.isVisible())
            f.setVisible(false);
        gameArea = new JFrame("Swingy");
        gameArea.getContentPane().setBackground(new Color(0x2F, 0x35, 0x38));
        panel = new JPanel();
        ((LoggerGui)logger).getTextArea().setEditable(false);
        JScrollPane scrolll = new JScrollPane(((LoggerGui)logger).getTextArea());
        scrolll.setBounds(255, 0, 250, 250);
        panel.setLayout(new GridLayout(map.length, map[0].length));

        try {
            herotexture = ImageIO.read(GuiView.class.getResourceAsStream("/images/pacman.png"));
            background = ImageIO.read(GuiView.class.getResourceAsStream("/images/solid-green-background.jpg"));
            devil = ImageIO.read(GuiView.class.getResourceAsStream("/images/dragon.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        herotextureSized = herotexture.getScaledInstance(width / map.length / 2, height / map.length / 2, Image.SCALE_DEFAULT);
        backgroundSized = background.getScaledInstance(width / map.length / 2, height / map.length / 2, Image.SCALE_DEFAULT);
        devilSized = devil.getScaledInstance(width / map.length / 2, height / map.length / 2, Image.SCALE_DEFAULT);

        
        GuiStatusBar statusBar = GuiStatusBar.getGuiStatusBar(hero);
        statusBar.getLevelBar().setForeground(new Color(0x78, 0xBB, 0xD6));
        gameArea.setSize(width, height);
        panel.setBounds(0,0,250,250);
        panel.setBackground(Color.gray);
        gameArea.add(panel);  
        gameArea.add(scrolll);
        gameArea.add(statusBar.getStatusBarTable());
        gameArea.add(statusBar.getLevelBar());
        spreadWarriors(map.length - 1);
        gameArea.setLayout(null);
        gameArea.setVisible(true);
        statusBar.updateProgressBar(hero.getCharExperience(), hero.getCharLevel());
        refresh();
        gameArea.show();
        gameArea.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        logger.printMessage("Game starts!!!\n");
    }
    public void resultMessage(String result)
    {
        gameArea.setEnabled(false);
        logger.printMessage("YOU " + result + "!\n");
    }
}