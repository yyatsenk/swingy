package Swingy.src.main.java.com.unit.model;
import java.util.*;
import java.io.*;

public class Hero
{
    private String name;
    private String heroClass;
    private int experience;
    private int attack;
    private int defense;
    private int hit;
    // public Character()
    // {
    //     name = "Noname";
    //     experience = 100;
    //     attack = 200;
    //     defense = 100;
    //     hit = 50;

    // }
    Hero(String name, int age, int power, int ammo)
    {
        ;
    }
    public String getCharName()
    {
        return name;
    }
    public String getCharClass()
    {
        return heroClass;
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
    private Hero(HeroBuilder builder) {
		this.name = builder.name;
		this.heroClass = builder.heroClass;
        this.experience = builder.experience;
        this.attack = builder.attack;
		this.defense = builder.defense;
		this.hit = builder.hit;
	}
    public static class HeroBuilder{
        private String name;
        private String heroClass;
        private int experience;
        private int attack;
        private int defense;
        private int hit;

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
        public Hero build(){
			return new Hero(this);
		}
    }
}