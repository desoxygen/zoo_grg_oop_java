package patterns.builder;

import model.Animal;
import model.Lion;
import model.Monkey;

public class AnimalBuilder {
    private String name;
    private int health = 100; // Значення за замовчуванням
    private int age = 1;
    private String type;

    // Ланцюжок викликів (Fluent Interface)
    public AnimalBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public AnimalBuilder setHealth(int health) {
        this.health = health;
        return this;
    }

    public AnimalBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public AnimalBuilder setType(String type) {
        this.type = type;
        return this;
    }

    public Animal build() {
        if (name == null || type == null) {
            throw new IllegalStateException("Name and type must be specified!");
        }

        if (type.equalsIgnoreCase("Lion")) {
            return new Lion(name, health, age);
        } else if (type.equalsIgnoreCase("Monkey")) {
            return new Monkey(name, health, age);
        } else {
            throw new IllegalArgumentException("Unknown animal type: " + type);
        }
    }
}