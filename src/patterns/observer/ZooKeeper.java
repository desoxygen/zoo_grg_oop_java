package patterns.observer;

public class ZooKeeper implements ZooObserver {
    private String name;

    public ZooKeeper(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println("[ZooKeeper " + name + "] Received message: " + message);
    }
}