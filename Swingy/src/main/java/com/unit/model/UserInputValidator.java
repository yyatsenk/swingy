package Swingy.src.main.java.com.unit.model;
import javax.swing.*;
import java.util.*;
import java.io.*;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class UserInputValidator
{
     private static Validator validator;
     
    UserInputValidator()
    {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    public int validateChar(Hero hero)
    {
        Set<ConstraintViolation<Hero>> constraintViolations = validator.validate(hero);
 
        if (constraintViolations.size() > 0) {
            System.out.println("Validation failed, here is why:");
            for (ConstraintViolation<Hero> violation : constraintViolations) {
                System.out.println(violation.getMessage());
            }
            return (0);
        } 
        else
        {
            System.out.println("Valid Object");
        }
        return (1);
     }
}