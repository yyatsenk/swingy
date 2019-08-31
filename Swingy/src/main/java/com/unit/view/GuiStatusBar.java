package Swingy.src.main.java.com.unit.view;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.io.*;
import javax.swing.*;
import javax.swing.table.*;
import Swingy.src.main.java.com.unit.model.*;

public class GuiStatusBar
{
    static GuiStatusBar bar;
    private JTable statusBarTable;
    private JProgressBar levelBar;

    private GuiStatusBar(Hero hero)
    {
        String[][] data = {{"Name", "Class", "Level",
        "Experience","Defence", "Attack", "Hit"},
        {hero.getCharName(), hero.getCharClass(), Integer.toString(hero.getCharLevel()),
            Integer.toString(hero.getCharExperience()), Integer.toString(hero.getCharAttack()),
            Integer.toString(hero.getCharDefense()), Integer.toString(hero.getCharHit())}};
        String[] columnNames = {"Name", "Class", "Level",
        "Experience","Defence", "Attack", "Hit"};
        statusBarTable = new JTable(data, columnNames)
        {
            public Component prepareRenderer(
                TableCellRenderer renderer, int row, int column)
            {
                System.out.println(row);
                Component cellInTable = super.prepareRenderer(renderer, row, column);
                if (row == 0)
                {
                    //cellInTable.setFont(this.getFont().deriveFont(Font.BOLD));
                    cellInTable.setFont(new Font("Serif", Font.BOLD, 12));
                    cellInTable.setBackground(Color.WHITE);
                }
                else if (row == 1)
                {
                    cellInTable.setFont(new Font("Serif", Font.BOLD, 14));
                    cellInTable.setBackground(new Color(174,226,237));
                }
                //  add custom rendering here
        
                return cellInTable;
            }
        };
        statusBarTable.setBounds(0, 400, 500, 100);
        statusBarTable.setShowGrid(false);

        levelBar = new JProgressBar(); 
        levelBar.setBounds(50, 380, 200, 20);
        levelBar.setValue(30);
        levelBar.setStringPainted(true); 
        levelBar.setString(Integer.toString(hero.getCharLevel() * 1000) + " XP");
    }
    static GuiStatusBar getGuiStatusBar(Hero Hero)
    {
        return new GuiStatusBar(Hero);
    }
    public JTable getStatusBarTable()
    {
        return statusBarTable;
    }
    public JProgressBar getLevelBar()
    {
        return levelBar;
    }
}