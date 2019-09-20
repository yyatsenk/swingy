package Swingy.src.main.java.com.unit.controller;
import java.util.*;
import java.io.*;
import java.awt.event.*;
import java.awt.*;
import Swingy.src.main.java.com.unit.view.*;
import Swingy.src.main.java.com.unit.model.*;

public class MovementGui implements Movement
{
    public int [][] up(final SwingView view, final Hero player)
    {
        final int var = view.getMap()[player.getPosY() - 1][player.getPosX()];
        //System.out.println("In UP");
        if (player.getPosY() - 1 < 0)
            System.out.println("You won!");
        else
        {
            if (view.getMap()[player.getPosY() - 1][player.getPosX()] != 0)
            {
                view.getMap()[player.getPosY()][player.getPosX()] = 0;
                player.setPosY(player.getPosY() - 1);
                view.getMap()[player.getPosY()][player.getPosX()] = 1;
                Hero villian = null;
                view.getLogger().printMessage("You should choose run or fight!\nYour opponent is");
                for (Hero h : view.getVillainList()) {
                    if (h.getPosY() == (player.getPosY()) && h.getPosX() == player.getPosX())
                    {
                        villian = h;
                        break ;
                    }
                    view.getLogger().printMessage(Integer.toString(h.getPosY()) + " " + Integer.toString(h.getPosX()) + "\n");
                }
                final int villianExp = villian.getCharExperience();
                view.getLogger().printMessage("\nName :" + villian.getCharName() + "\n");
                view.getLogger().printMessage("Class :" + villian.getCharClass() + "\n");
                view.getLogger().printMessage("Experience :" + Integer.toString(villian.getCharExperience()) + "\n");
                view.getLogger().printMessage("Enter r to run and f to fight\n");
                //KeyEventDispatcher keyEventDispatcherPrevious = KeyboardFocusManager.getCurrentKeyboardFocusManager().get
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
                            }
                            else
                            {
                                player.setExperience(player.getCharExperience() + villianExp);
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
            System.out.println("You won!");
        else
        {
            view.getMap()[player.getPosY()][player.getPosX()] = 0;
            player.setPosY(player.getPosY() + 1);
            view.getMap()[player.getPosY()][player.getPosX()] = 1;
        }
        return view.getMap();
    }
    public int [][] left(SwingView view, Hero player)
    {
        if (player.getPosX() - 1 < 0)
            System.out.println("You won!");
        else
        {
            view.getMap()[player.getPosY()][player.getPosX()] = 0;
            player.setPosX(player.getPosX() - 1);
            view.getMap()[player.getPosY()][player.getPosX()] = 1;
        }
        return view.getMap();
    }
    public int [][] right(SwingView view, Hero player)
    {
        if (player.getPosX() + 1 > view.getMap()[0].length -  1)
            System.out.println("You won!");
        else
        {
            view.getMap()[player.getPosY()][player.getPosX()] = 0;
            player.setPosX(player.getPosX() + 1);
            view.getMap()[player.getPosY()][player.getPosX()] = 1;
        }
        return view.getMap();
    }
}