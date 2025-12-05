package patterns.strategy;

public class MeatDiet implements FeedingStrategy {
    @Override
    public void feed() {
        System.out.println("Eating meat (Predator)... ");
    }
}