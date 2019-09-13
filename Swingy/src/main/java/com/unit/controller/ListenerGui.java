package Swingy.src.main.java.com.unit.controller;

import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import Swingy.src.main.java.com.unit.view.*;
import Swingy.src.main.java.com.unit.model.*;

public class ListenerGui extends Listener
{
    public int listen(final Hero player, final SwingView view)
    {
        KeyEventDispatcher keyEventDispatcher = new KeyEventDispatcher() {
            @Override
            public boolean dispatchKeyEvent(KeyEvent e) {
              if (e.getKeyCode() == KeyEvent.VK_W) {
                player.getMovement().up(view.getMap(), player);
                view.logger.printMessage("Go up\n");
              }
              if (e.getKeyCode() == KeyEvent.VK_A) {
                player.getMovement().left(view.getMap(), player);
                view.logger.printMessage("Go left\n");
              }
              if (e.getKeyCode() == KeyEvent.VK_D) {
                player.getMovement().right(view.getMap(), player);
                view.logger.printMessage("Go right\n");
              }
              if (e.getKeyCode() == KeyEvent.VK_S) {
                player.getMovement().down(view.getMap(), player);
                view.logger.printMessage("Go down\n");
              }
              GuiView guiView = (GuiView)view;
              guiView.refresh();
              // Pass the KeyEvent to the next KeyEventDispatcher in the chain
              return false;
            }
          };
          KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(keyEventDispatcher);
        // GuiView guiView = (GuiView)view;
        // guiView.panel.addContainerListener(new ContainerAdapter() {
        //     public void windowOpened(WindowEvent e) {
        //         System.out.println("Window Opened Event");
        //       }
        
        // });
        return 0;
    }
}