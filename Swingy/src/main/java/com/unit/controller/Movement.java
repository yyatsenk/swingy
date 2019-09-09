package Swingy.src.main.java.com.unit.controller;

public interface  Movement {
    public int [][] up(int [][] map, Hero player);
    public int [][] down(int [][] map, Hero player);
    public int [][] left(int [][] map, Hero player);
    public int [][] right(int [][] map, Hero player);
}