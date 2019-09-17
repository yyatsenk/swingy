package Swingy.src.main.java.com.unit.controller;
import Swingy.src.main.java.com.unit.view.*;

public interface  Movement {
    public int [][] up(SwingView view, Hero player);
    public int [][] down(SwingView view, Hero player);
    public int [][] left(SwingView view, Hero player);
    public int [][] right(SwingView view, Hero player);
}