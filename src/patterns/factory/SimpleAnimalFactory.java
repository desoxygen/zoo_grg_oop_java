package patterns.factory;

import model.Animal;
import patterns.builder.AnimalBuilder;

public class SimpleAnimalFactory {
    // Factory Method: приховує складність Builder'а для простих випадків
    public static Animal createPredator(String name) {
        return new AnimalBuilder()
                .setType("Lion")
                .setName(name)
                .setHealth(100)
                .build();
    }

    public interface AnimalFactory {
        Animal createAnimal(String name);
    }

    public static Animal createHerbivore(String name) {
        return new AnimalBuilder()
                .setType("Monkey")
                .setName(name)
                .setHealth(80)
                .build();
    }
}