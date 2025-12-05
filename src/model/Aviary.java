package model;

import exception.AviaryFullException;
import java.util.ArrayList;
import java.util.List;

public class Aviary {
    private int id;
    private int capacity;
    private List<Animal> animals;

    public Aviary(int id, int capacity) {
        this.id = id;
        this.capacity = capacity;
        this.animals = new ArrayList<>();
    }

    // GRASP: Information Expert
    // Вольєр має інформацію про свою заповненість, тому сам вирішує, чи додати
    // тварину
    public void addAnimal(Animal animal) throws AviaryFullException {
        if (animals.size() >= capacity) {
            throw new AviaryFullException(String.valueOf(id));
        }
        animals.add(animal);
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Aviary #" + id + " (Animals: " + animals.size() + "/" + capacity + ")";
    }
}