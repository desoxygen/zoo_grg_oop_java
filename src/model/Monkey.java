package model;

import patterns.strategy.PlantDiet;

public class Monkey extends Animal {
    public Monkey(String name, int health, int age) {
        super(name, health, age, new PlantDiet());
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " says: U-u-u, a-a-a!");
    }
}