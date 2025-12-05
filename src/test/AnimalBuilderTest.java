package test;

import model.Animal;
import model.Lion;
import model.Monkey;
import patterns.builder.AnimalBuilder;

public class AnimalBuilderTest {

    public static void main(String[] args) {
        System.out.println("=== Running AnimalBuilder Tests ===\n");

        int passed = 0;
        int failed = 0;

        // Test 1: Build Lion successfully
        try {
            Animal lion = new AnimalBuilder()
                    .setType("Lion")
                    .setName("Simba")
                    .setHealth(100)
                    .setAge(5)
                    .build();

            assert lion instanceof Lion : "Should create Lion instance";
            assert lion.getName().equals("Simba") : "Name should be Simba";
            assert lion.getHealth() == 100 : "Health should be 100";

            System.out.println("Test 1 PASSED: Build Lion successfully");
            passed++;
        } catch (AssertionError | Exception e) {
            System.out.println("Test 1 FAILED: " + e.getMessage());
            failed++;
        }

        try {
            Animal monkey = new AnimalBuilder()
                    .setType("Monkey")
                    .setName("George")
                    .setHealth(80)
                    .build();

            assert monkey instanceof Monkey : "Should create Monkey instance";
            assert monkey.getName().equals("George") : "Name should be George";

            System.out.println("Test 2 PASSED: Build Monkey successfully");
            passed++;
        } catch (AssertionError | Exception e) {
            System.out.println("Test 2 FAILED: " + e.getMessage());
            failed++;
        }

        // Test 3: Default values work correctly
        try {
            Animal lion = new AnimalBuilder()
                    .setType("Lion")
                    .setName("Mufasa")
                    .build();

            assert lion.getHealth() == 100 : "Default health should be 100";

            System.out.println("Test 3 PASSED: Default values work correctly");
            passed++;
        } catch (AssertionError | Exception e) {
            System.out.println("Test 3 FAILED: " + e.getMessage());
            failed++;
        }
        System.out.println("\n=== Test Summary ===");
        System.out.println("Passed: " + passed);
        System.out.println("Failed: " + failed);
        System.out.println("Total: " + (passed + failed));
        System.out.println("Success Rate: " + (passed * 100 / (passed + failed)) + "%");
    }
}
