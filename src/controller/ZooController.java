package controller;

import model.Animal;
import model.Aviary;
import patterns.builder.AnimalBuilder;
import patterns.decorator.VaccinatedAnimal;
import patterns.singleton.Zoo;

import java.util.Scanner;

public class ZooController {
    private Zoo zoo;
    private Scanner scanner;

    public ZooController() {
        this.zoo = Zoo.getInstance();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("=== ZOO MANAGEMENT SYSTEM ===");

        // Попередньо створимо один вольєр, щоб було куди селити
        zoo.addAviary(new Aviary(1, 2)); // Вольєр #1 на 2 місця

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add new animal (Builder)");
            System.out.println("2. Feed all (Strategy + Iterator)");
            System.out.println("3. Show zoo state");
            System.out.println("4. Vaccinate last animal (Decorator)");
            System.out.println("0. Exit");
            System.out.print("Choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addAnimalMenu();
                    break;
                case "2":
                    zoo.feedAll();
                    break;
                case "3":
                    printZooState();
                    break;
                case "4":
                    demonstrateDecorator();
                    break;
                case "0":
                    System.out.println("Program ended.");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private void addAnimalMenu() {
        System.out.print("Enter type (Lion/Monkey): ");
        String type = scanner.nextLine();
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        try {
            // Використання Builder
            Animal animal = new AnimalBuilder()
                    .setType(type)
                    .setName(name)
                    .setHealth(100)
                    .build();

            // Спроба поселити у вольєр #1
            zoo.addAnimalToAviary(animal, 1);

        } catch (Exception e) {
            System.out.println("Error creating animal: " + e.getMessage());
        }
    }

    private void printZooState() {
        for (Aviary aviary : zoo.getAviaries()) {
            System.out.println(aviary);
            for (Animal animal : aviary.getAnimals()) {
                System.out.println(" - " + animal);
            }
        }
    }

    private void demonstrateDecorator() {
        // Демонстрація роботи декоратора на першій тварині
        if (!zoo.getAviaries().isEmpty() && !zoo.getAviaries().get(0).getAnimals().isEmpty()) {
            Animal original = zoo.getAviaries().get(0).getAnimals().get(0);
            VaccinatedAnimal vaccinated = new VaccinatedAnimal(original);
            vaccinated.checkVaccinationStatus();
        } else {
            System.out.println("No animals to vaccinate!");
        }
    }
}