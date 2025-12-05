package patterns.singleton;

import exception.AviaryFullException;
import model.Animal;
import model.Aviary;
import patterns.observer.ZooObserver;

import java.util.ArrayList;
import java.util.List;
import patterns.iterator.ZooIterator;
import java.util.Iterator;

public class Zoo {
    // 1. Статичне поле для зберігання єдиного екземпляра
    private static Zoo instance;

    // Списки ресурсів
    private List<Aviary> aviaries;
    private List<ZooObserver> observers;

    // 2. Приватний конструктор (ніхто зовні не може створити new Zoo())
    private Zoo() {
        aviaries = new ArrayList<>();
        observers = new ArrayList<>();
        System.out.println("Zoo opened! (Singleton initialized)");
    }

    // 3. Публічний метод для доступу
    public static Zoo getInstance() {
        if (instance == null) {
            instance = new Zoo();
        }
        return instance;
    }

    // --- Методи управління (Controller logic) ---
    public Iterator<Animal> iterator() {
        return new ZooIterator(this.aviaries);
    }

    public void addAviary(Aviary aviary) {
        aviaries.add(aviary);
        notifyObservers("New aviary #" + aviary.getId() + " built.");
    }

    public void addAnimalToAviary(Animal animal, int aviaryId) {
        for (Aviary aviary : aviaries) {
            if (aviary.getId() == aviaryId) {
                try {
                    aviary.addAnimal(animal);
                    notifyObservers("Animal " + animal.getName() + " successfully settled in aviary #" + aviaryId);
                } catch (AviaryFullException e) {
                    System.err.println("Error: " + e.getMessage());
                    notifyObservers("Failure! Could not settle " + animal.getName() + " (Aviary is full)");
                }
                return;
            }
        }
        System.out.println("Aviary #" + aviaryId + " not found!");
    }

    public void feedAll() {
        notifyObservers("Feeding time! Starting to feed all animals.");
        for (Aviary aviary : aviaries) {
            for (Animal animal : aviary.getAnimals()) {
                animal.eat();
            }
        }
    }

    // --- Observer Logic ---
    public void addObserver(ZooObserver observer) {
        observers.add(observer);
    }

    private void notifyObservers(String message) {
        for (ZooObserver observer : observers) {
            observer.update(message);
        }
    }

    public List<Aviary> getAviaries() {
        return aviaries;
    }

    // Iterator pattern support
    public patterns.iterator.ZooIterator getAnimalIterator() {
        return new patterns.iterator.ZooIterator(aviaries);
    }
}