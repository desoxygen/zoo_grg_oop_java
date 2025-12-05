package patterns.factory;

import model.Animal;

/**
 * Factory pattern interface for creating animals.
 * This demonstrates the Factory Method pattern.
 */
public interface AnimalFactory {
    /**
     * Creates an animal with the given name.
     * 
     * @param name the name of the animal to create
     * @return the created animal
     */
    Animal createAnimal(String name);
}
