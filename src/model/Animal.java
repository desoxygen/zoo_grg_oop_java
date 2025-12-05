package model;

import patterns.strategy.FeedingStrategy;

public abstract class Animal {
    private String name;
    private int health; // 0-100
    private int age;
    protected FeedingStrategy feedingStrategy;

    public Animal(String name, int health, int age, FeedingStrategy feedingStrategy) {
        this.name = name;
        this.health = health;
        this.age = age;
        this.feedingStrategy = feedingStrategy;
    }

    public abstract void makeSound();

    public void eat() {
        if (feedingStrategy != null) {
            System.out.print(name + ": ");
            feedingStrategy.feed();
        }
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public String toString() {
        return "Animal: " + name + " (Health: " + health + ", Age: " + age + ")";
    }
}