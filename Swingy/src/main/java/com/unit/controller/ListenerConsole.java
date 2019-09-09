package Swingy.src.main.java.com.unit.controller;

import java.util.*;
import java.io.*;
import Swingy.src.main.java.com.unit.view.*;
import Swingy.src.main.java.com.unit.model.*;

public class ListenerConsole extends Listener
{
    public int listen(Hero player, SwingView view)
    {
        try
		{
			char keyChar = (char)System.in.read();
		    if (keyChar == 'w')
			    player.getMovement().up(view.getMap(), player);
			if (keyChar == 's')
				player.getMovement().down(view.getMap(), player);
			if (keyChar == 'a')
				player.getMovement().left(view.getMap(), player);
			if (keyChar == 'd')
				player.getMovement().right(view.getMap(), player);
			if (keyChar == 'q')
					return 1;
			}
		catch(Exception e)
		{}
        return (0);
    }
}