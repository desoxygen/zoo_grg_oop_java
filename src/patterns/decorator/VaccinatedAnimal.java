package patterns.decorator;

import model.Animal;

// Decorator: обгортає тварину і додає нову поведінку
public class VaccinatedAnimal extends Animal {
    private Animal wrappedAnimal;

    public VaccinatedAnimal(Animal animal) {
        // Передаємо дані оригінальної тварини в суперклас
        super(animal.getName(), animal.getHealth(), 0, null);
        this.wrappedAnimal = animal;
    }

    @Override
    public void makeSound() {
        wrappedAnimal.makeSound(); // Оригінальний звук
    }

    @Override
    public void eat() {
        wrappedAnimal.eat(); // Оригінальне харчування
    }

    // New functionality
    public void checkVaccinationStatus() {
        System.out.println("Animal " + wrappedAnimal.getName() + " has a vaccination passport ✅");
    }
}