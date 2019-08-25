package Swingy.src.main.java.com.unit.model;
import java.util.*;
import java.io.*;
import java.sql.*;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public interface UserInputHandeler
{
    public UserInputValidator val = new UserInputValidator();

    public abstract int     establishConnection();
    public int              validate(Hero hero);
    public abstract void    addChar(Hero hero);
    public abstract Object  getResQuery();
    public abstract void    destroyConnection();
}