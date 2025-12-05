package patterns.factory;

import model.Animal;
import patterns.builder.AnimalBuilder;

public class PredatorFactory implements AnimalFactory {
    @Override
    public Animal createAnimal(String name) {
        return new AnimalBuilder()
                .setType("Lion")
                .setName(name)
                .setHealth(100)
                .build();
    }
}