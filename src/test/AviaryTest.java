package test;

import exception.AviaryFullException;
import model.Animal;
import model.Aviary;
import model.Lion;
import model.Monkey;

/**
 * Unit tests for Aviary class.
 * Tests capacity management and exception handling.
 */
public class AviaryTest {

    public static void main(String[] args) {
        System.out.println("=== Running Aviary Tests ===\n");

        int passed = 0;
        int failed = 0;

        // Test 1: Create aviary with correct capacity
        try {
            Aviary aviary = new Aviary(1, 5);
            assert aviary.getId() == 1 : "ID should be 1";
            assert aviary.getAnimals().size() == 0 : "Should start empty";

            System.out.println("Test 1 PASSED: Create aviary with correct capacity");
            passed++;
        } catch (AssertionError | Exception e) {
            System.out.println("Test 1 FAILED: " + e.getMessage());
            failed++;
        }

        // Test 2: Add animal successfully
        try {
            Aviary aviary = new Aviary(2, 3);
            Animal lion = new Lion("Simba", 100, 5);
            aviary.addAnimal(lion);

            assert aviary.getAnimals().size() == 1 : "Should have 1 animal";
            assert aviary.getAnimals().get(0).getName().equals("Simba") : "Animal name should be Simba";

            System.out.println("Test 2 PASSED: Add animal successfully");
            passed++;
        } catch (AssertionError | Exception e) {
            System.out.println("Test 2 FAILED: " + e.getMessage());
            failed++;
        }

        // Test 3: Add multiple animals
        try {
            Aviary aviary = new Aviary(3, 5);
            aviary.addAnimal(new Lion("Lion1", 100, 3));
            aviary.addAnimal(new Monkey("Monkey1", 80, 2));
            aviary.addAnimal(new Lion("Lion2", 90, 4));

            assert aviary.getAnimals().size() == 3 : "Should have 3 animals";

            System.out.println("Test 3 PASSED: Add multiple animals");
            passed++;
        } catch (AssertionError | Exception e) {
            System.out.println("Test 3 FAILED: " + e.getMessage());
            failed++;
        }

        // Test 4: Throw exception when aviary is full
        try {
            Aviary aviary = new Aviary(4, 2);
            aviary.addAnimal(new Lion("Lion1", 100, 3));
            aviary.addAnimal(new Monkey("Monkey1", 80, 2));

            // This should throw AviaryFullException
            aviary.addAnimal(new Lion("Lion2", 90, 4));

            System.out.println("Test 4 FAILED: Should throw AviaryFullException when full");
            failed++;
        } catch (AviaryFullException e) {
            assert e.getMessage().contains("Aviary #4") : "Exception message should contain aviary ID";
            System.out.println("Test 4 PASSED: Correctly throws AviaryFullException when full");
            passed++;
        } catch (Exception e) {
            System.out.println("Test 4 FAILED: Wrong exception type: " + e.getMessage());
            failed++;
        }

        try {
            Aviary aviary = new Aviary(5, 10);
            aviary.addAnimal(new Lion("Test", 100, 1));

            String str = aviary.toString();
            assert str.contains("Aviary #5") : "Should contain aviary ID";
            assert str.contains("1/10") : "Should show correct count";

            System.out.println("Test 5 PASSED: Aviary toString format correct");
            passed++;
        } catch (AssertionError | Exception e) {
            System.out.println("Test 5 FAILED: " + e.getMessage());
            failed++;
        }

        // Test 6: Exception message contains correct aviary ID
        try {
            Aviary aviary = new Aviary(99, 1);
            aviary.addAnimal(new Lion("First", 100, 1));

            try {
                aviary.addAnimal(new Lion("Second", 100, 1));
                System.out.println("Test 6 FAILED: Should throw exception");
                failed++;
            } catch (AviaryFullException e) {
                assert e.getMessage().contains("99") : "Exception should contain aviary ID 99";
                System.out.println("Test 6 PASSED: Exception message contains correct aviary ID");
                passed++;
            }
        } catch (Exception e) {
            System.out.println("Test 6 FAILED: " + e.getMessage());
            failed++;
        }

        System.out.println("\n=== Test Summary ===");
        System.out.println("Passed: " + passed);
        System.out.println("Failed: " + failed);
        System.out.println("Total: " + (passed + failed));
        System.out.println("Success Rate: " + (passed * 100 / (passed + failed)) + "%");
    }
}
