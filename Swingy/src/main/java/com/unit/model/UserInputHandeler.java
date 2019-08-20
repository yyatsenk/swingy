package Swingy.src.main.java.com.unit.model;
import java.util.*;
import java.io.*;

public interface UserInputHandeler
{
    public String filename=null;
    public Character char_list[]=null;
    public String getFilename();
    public abstract int readFile(); 
}