package Swingy.src.main.java.com.unit.controller;
import java.util.*;
import java.io.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.Valid;

// TODO : set proper validation attributes
public class Hero
{
    private Movement move;
    @NotNull
    private String name;
    private String heroClass;
    private int level;
    private int experience;
    @NotNull
    private int attack;
    @NotNull
    private int defense;
    @NotNull
    private int hit;
    private int posX = 0;
    private int posY = 0;
    Hero()
    {
        
    }
    public String getCharName()
    {
        return name;
    }
    public String getCharClass()
    {
        return heroClass;
    }
    public int getCharLevel()
    {
        return level;
    }
    public int getCharExperience()
    {
        return experience;
    }
    public int getCharAttack()
    {
        return attack;
    }
    public int getCharDefense()
    {
        return defense;
    }
    public int getCharHit()
    {
        return hit;
    }
    public Movement getMovement()
    {
        return move;
    }
    public int getPosX()
    {
        return posX;
    }
    public int getPosY()
    {
        return posY;
    }
    public void setPosX(int x)
    {
        this.posX = x;
    }
    public void setPosY(int y)
    {
        this.posY = y;
    }
    public void setMovement(Movement m)
    {
        this.move = m;
    }
    public void setExperience(int experience)
    {
        this.experience = experience;
    }
    public void setCharLevel(int level)
    {
        this.level = level;
    }
    private Hero(HeroBuilder builder) {
		this.name = builder.name;
        this.heroClass = builder.heroClass;
        this.level = builder.level;
        this.experience = builder.experience;
        this.attack = builder.attack;
		this.defense = builder.defense;
        this.hit = builder.hit;
        this.posX = builder.posX;
        this.posY = builder.posY;
	}
    public static class HeroBuilder{
        private Movement move;
        private String name;
        private String heroClass;
        private int level;
        private int experience;
        private int attack;
        private int defense;
        private int hit;
        private int posX = 0;
        private int posY = 0;

        public HeroBuilder()
        {}
        public HeroBuilder setName(String name) {
			this.name = name;
			return this;
        }
        public HeroBuilder setHeroClass(String heroClass) {
			this.heroClass = heroClass;
			return this;
        }
        public HeroBuilder setLevel(int level) {
			this.level = level;
			return this;
        }
        public HeroBuilder setExperience(int experience) {
			this.experience = experience;
			return this;
        }
        public HeroBuilder setAttack(int attack) {
			this.attack = attack;
			return this;
        }
        public HeroBuilder setDefense(int defense) {
			this.defense = defense;
			return this;
        }
        public HeroBuilder setHit(int hit) {
			this.hit = hit;
			return this;
        }
        public HeroBuilder setMovement(Movement m) {
			this.move = m;
			return this;
        }
        public HeroBuilder setPosX(int x) {
			this.posX = x;
			return this;
        }
        public HeroBuilder setPosY(int y) {
			this.posY = y;
			return this;
        }
        
        public Hero build(){
			return new Hero(this);
		}
    }
}