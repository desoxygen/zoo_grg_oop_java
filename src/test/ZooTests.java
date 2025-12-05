package test;

import exception.AviaryFullException;
import model.Animal;
import model.Aviary;
import model.Lion;
import patterns.builder.AnimalBuilder;
import patterns.singleton.Zoo;

public class ZooTests {

    public static void main(String[] args) {
        System.out.println("=== TDD TESTS STARTED ===");

        testSingleton();
        testBuilder();
        testAviaryLimit();

        System.out.println("=== ALL TESTS PASSED ===");
    }

    // Тест 1: Перевірка Singleton (чи це той самий об'єкт?)
    public static void testSingleton() {
        Zoo zoo1 = Zoo.getInstance();
        Zoo zoo2 = Zoo.getInstance();
        if (zoo1 == zoo2) {
            System.out.println("[PASS] Singleton Test: Objects are identical.");
        } else {
            System.err.println("[FAIL] Singleton Test: Different objects created!");
        }
    }

    // Тест 2: Перевірка Builder (чи правильно створюється тварина?)
    public static void testBuilder() {
        Animal lion = new AnimalBuilder()
                .setType("Lion")
                .setName("TestLion")
                .setHealth(90)
                .build();

        if (lion instanceof Lion && lion.getName().equals("TestLion") && lion.getHealth() == 90) {
            System.out.println("[PASS] Builder Test: Animal created correctly.");
        } else {
            System.err.println("[FAIL] Builder Test: Parameter error.");
        }
    }

    // Тест 3: Перевірка виключення (Exception)
    public static void testAviaryLimit() {
        Aviary aviary = new Aviary(99, 1); // Місткість 1
        try {
            aviary.addAnimal(new Lion("Leo1", 100, 5));
            aviary.addAnimal(new Lion("Leo2", 100, 5)); // Тут має впасти
            System.err.println("[FAIL] Exception Test: Exception AviaryFullException not thrown!");
        } catch (AviaryFullException e) {
            System.out.println("[PASS] Exception Test: Exception AviaryFullException caught.");
        }
    }
}