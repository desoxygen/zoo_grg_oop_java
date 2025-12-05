package model;

import patterns.strategy.MeatDiet;

public class Lion extends Animal {
    public Lion(String name, int health, int age) {
        super(name, health, age, new MeatDiet());
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " says: Rrrrr-aaaaar!");
    }
}