package Swingy.src.main.java.com.unit.controller;

import java.util.*;
import java.io.*;
import Swingy.src.main.java.com.unit.view.*;
import Swingy.src.main.java.com.unit.model.*;

public class ListenerConsole extends Listener
{
    public int listen(Hero player, SwingView view)
    {
		while (true)
		{
        	try
			{
				char keyChar = (char)System.in.read();
		    	if (keyChar == 'w')
			    	player.getMovement().up(view, player);
				if (keyChar == 's')
					player.getMovement().down(view, player);
				if (keyChar == 'a')
					player.getMovement().left(view, player);
				if (keyChar == 'd')
					player.getMovement().right(view, player);
				if (keyChar == 'q')
					break ;
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			view.printMap(0,0);
		}
        return (0);
    }
}