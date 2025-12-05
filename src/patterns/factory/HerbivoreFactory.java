package patterns.factory;

import model.Animal;
import patterns.builder.AnimalBuilder;

public class HerbivoreFactory implements AnimalFactory {
    @Override
    public Animal createAnimal(String name) {
        return new AnimalBuilder()
                .setType("Monkey")
                .setName(name)
                .setHealth(80)
                .build();
    }
}