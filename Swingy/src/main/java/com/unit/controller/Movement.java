package Swingy.src.main.java.com.unit.controller;
import Swingy.src.main.java.com.unit.view.*;

public interface  Movement {
    public void up(SwingView view, Hero player);
    public void down(SwingView view, Hero player);
    public void left(SwingView view, Hero player);
    public void right(SwingView view, Hero player);
}