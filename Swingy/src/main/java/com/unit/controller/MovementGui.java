package Swingy.src.main.java.com.unit.controller;
import java.util.*;
import java.io.*;
import java.awt.event.*;
import java.awt.*;
// import javax.swing.*;//must be del
// import javax.swing.table.DefaultTableModel;//must be del
import Swingy.src.main.java.com.unit.view.*;
import Swingy.src.main.java.com.unit.model.*;

public class MovementGui implements Movement
{
    private void cross(final SwingView view, final Hero player, final int var, String direction)
    {
        final GuiStatusBar statusBar = GuiStatusBar.getGuiStatusBar(null);
        view.getMap()[player.getPosY()][player.getPosX()] = 0;
        if (direction.equals("UP"))
            player.setPosY(player.getPosY() - 1);
        if (direction.equals("DOWN"))
            player.setPosY(player.getPosY() + 1);
        if (direction.equals("LEFT"))
            player.setPosX(player.getPosX() - 1);
        if (direction.equals("RIGHT"))
            player.setPosX(player.getPosX() + 1);
        view.getMap()[player.getPosY()][player.getPosX()] = 1;
        Hero villian = null;
        view.getLogger().printMessage("You should choose run or fight!\nYour opponent is");
        for (Hero h : view.getVillainList()) {
            if (h.getPosY() == (player.getPosY()) && h.getPosX() == player.getPosX())
            {
                villian = h;
                break ;
            }
        }
        final int villianExp = villian.getCharExperience();
        view.getLogger().printMessage("\nName :" + villian.getCharName() + "\n");
        view.getLogger().printMessage("Class :" + villian.getCharClass() + "\n");
        view.getLogger().printMessage("Experience :" + Integer.toString(villian.getCharExperience()) + "\n");
        view.getLogger().printMessage("Enter r to run and f to fight\n");
        final KeyEventDispatcher keyEventDispatcherPrevious = ((ListenerGui)view.getListener()).getKeyEventDispatcher();
        KeyEventDispatcher keyEventDispatcher = new KeyEventDispatcher() {
            @Override
            public boolean dispatchKeyEvent(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_F && e.getID() == KeyEvent.KEY_PRESSED) {
                    view.getLogger().printMessage("\nFight\n");
                    view.getMap()[player.getPosY()][player.getPosX()] = 1;
                    if (villianExp > player.getCharExperience())
                    {
                        view.getLogger().printMessage("YOU LOSE!\n");
                        view.resultMessage("LOSE");
                        view.input.updateDatabase(player);
                    }
                    else
                    {
                        int currentLevelScores = player.getCharLevel() * 1000 + (player.getCharLevel() - 1) *
                        (player.getCharLevel() - 1) * 450;
                        if (currentLevelScores < player.getCharExperience() + villianExp) {
                            player.setCharLevel(player.getCharLevel() + 1);
                            statusBar.updateBarTable(1, 2, Integer.toString(player.getCharLevel()));
                        }
                        player.setExperience(player.getCharExperience() + villianExp);
                        statusBar.updateProgressBar(player.getCharExperience(), player.getCharLevel());
                        statusBar.updateBarTable(1, 3, Integer.toString(player.getCharExperience()));
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_R && e.getID() == KeyEvent.KEY_PRESSED) {
                    view.getLogger().printMessage("\nRun\n");
                    view.getMap()[player.getPosY()][player.getPosX()] = var;
                }
                if (e.getKeyCode() == KeyEvent.VK_R || e.getKeyCode() == KeyEvent.VK_F)
                {
                    KeyboardFocusManager.getCurrentKeyboardFocusManager().removeKeyEventDispatcher(this);
                    KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(keyEventDispatcherPrevious);
                }
                return false;
            }};
        KeyboardFocusManager.getCurrentKeyboardFocusManager().removeKeyEventDispatcher(keyEventDispatcherPrevious);
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(keyEventDispatcher);
    }
    public int [][] up(final SwingView view, final Hero player)
    {
        if (player.getPosY() - 1 < 0)
        {
            System.out.println("You won!");
            view.resultMessage("WON");
            view.input.updateDatabase(player);
        }
        else
        {
            final int var = view.getMap()[player.getPosY() - 1][player.getPosX()];
            if (view.getMap()[player.getPosY() - 1][player.getPosX()] != 0)
                cross(view, player, var, "UP");
            else
            {
                if (view.getMap()[player.getPosY()][player.getPosX()] == 1)
                    view.getMap()[player.getPosY()][player.getPosX()] = 0;
                player.setPosY(player.getPosY() - 1);
                view.getMap()[player.getPosY()][player.getPosX()] = 1;
            }
        }
        return view.getMap();
    }
    public int [][] down(SwingView view, Hero player)
    {
        if (player.getPosY() + 1 > view.getMap().length - 1)
        {
            System.out.println("You won!");
            view.resultMessage("WON");
            view.input.updateDatabase(player);
        }
        else
        {
            final int var = view.getMap()[player.getPosY() + 1][player.getPosX()];
            if (view.getMap()[player.getPosY() + 1][player.getPosX()] != 0)
                cross(view, player, var, "DOWN");
            else
            {
                if (view.getMap()[player.getPosY()][player.getPosX()] == 1)
                    view.getMap()[player.getPosY()][player.getPosX()] = 0;
                player.setPosY(player.getPosY() + 1);
                view.getMap()[player.getPosY()][player.getPosX()] = 1;
            }
        }
        return view.getMap();
    }
    public int [][] left(SwingView view, Hero player)
    {
        if (player.getPosX() - 1 < 0)
        {
            System.out.println("You won!");
            view.resultMessage("WON");
            view.input.updateDatabase(player);
        }
        else
        {
            final int var = view.getMap()[player.getPosY()][player.getPosX() - 1];
            if (view.getMap()[player.getPosY()][player.getPosX() - 1] != 0)
                cross(view, player, var, "LEFT");
            else
            {
                if (view.getMap()[player.getPosY()][player.getPosX()] == 1)
                    view.getMap()[player.getPosY()][player.getPosX()] = 0;
                player.setPosX(player.getPosX() - 1);
                view.getMap()[player.getPosY()][player.getPosX()] = 1;
            }
        }
        return view.getMap();
    }
    public int [][] right(SwingView view, Hero player)
    {
        if (player.getPosX() + 1 > view.getMap()[0].length -  1)
        {
            System.out.println("You won!");
            view.resultMessage("WON");
            view.input.updateDatabase(player);
        }
        else
        {
            final int var = view.getMap()[player.getPosY()][player.getPosX() + 1];
            if (view.getMap()[player.getPosY()][player.getPosX() + 1] != 0)
                cross(view, player, var, "RIGHT");
            else
            {
                if (view.getMap()[player.getPosY()][player.getPosX()] == 1)
                    view.getMap()[player.getPosY()][player.getPosX()] = 0;
                player.setPosX(player.getPosX() + 1);
                view.getMap()[player.getPosY()][player.getPosX()] = 1;
            }
        }
        return view.getMap();
    }
}