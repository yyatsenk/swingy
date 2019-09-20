package Swingy.src.main.java.com.unit.view;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.io.*;
import javax.swing.*;
import javax.swing.table.*;
import Swingy.src.main.java.com.unit.controller.*;
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
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        statusBarTable = new JTable(model)
        {
            public Component prepareRenderer(
                TableCellRenderer renderer, int row, int column)
            {
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
        statusBarTable.setBounds(0, 370, 500, 50);
        statusBarTable.setShowGrid(false);

        levelBar = new JProgressBar(); 
        levelBar.setBounds(10, 300, 480, 40);
        levelBar.setStringPainted(true); 
    }
    public static GuiStatusBar getGuiStatusBar(Hero Hero)
    {
        if (bar == null)
            bar = new GuiStatusBar(Hero);
        return bar;
    }
    public void updateBarTable(int row, int col, String val)
    {
        GuiStatusBar statusBar = GuiStatusBar.getGuiStatusBar(null);
        JTable table = statusBar.getStatusBarTable();
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        model.setValueAt(val, row, col);
    }
    public void updateProgressBar(int experience, int level)
    {
        int xp = level * 1000 + (level - 1) * (level - 1) * 450;
        levelBar.setValue(experience * 100 / xp);
        levelBar.setString(Integer.toString(experience) + " XP");
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