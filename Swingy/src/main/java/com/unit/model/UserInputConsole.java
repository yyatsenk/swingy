package Swingy.src.main.java.com.unit.model;
import javax.swing.*;
import java.util.*;
import java.io.*;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;


public class UserInputConsole implements UserInputHandeler
{
     private static Validator validator;
     private Hero character;
     public int readFile()
    {
        character = new Hero.HeroBuilder().setAttack(0).setDefense(0).setName("Greek").build();
        System.out.println("Reading from console\n");
        //ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        //validator = factory.getValidator();
        // ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
         
        // //It validates bean instances
        // validator = factory.getValidator();
        // Set<ConstraintViolation<Hero>> constraintViolations = validator.validate(character);
 
        //Show errors
    //     if (constraintViolations.size() > 0) {
    //         for (ConstraintViolation<Hero> violation : constraintViolations) {
    //             System.out.println(violation.getMessage());
    //         }
    //     } else {
    //         System.out.println("Valid Object");
    //     }
         return (0);
     }
    public String getFilename()
    {
        return new String("hello");
    }
    
}