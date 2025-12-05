package patterns.strategy;

public class PlantDiet implements FeedingStrategy {
    @Override
    public void feed() {
        System.out.println("Eating bananas and plants (Herbivore)... ");
    }
}