package Swingy.src.main.java.com.unit.model;
import java.util.*;
import java.io.*;
import java.sql.*;


public interface UserInputHandeler
{
    public abstract int     establishConnection();
    public abstract void    addChar(Hero hero);
    public abstract Object  getResQuery();
    public abstract void    destroyConnection();
}