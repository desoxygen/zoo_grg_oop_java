package main;

import controller.ZooController;
import patterns.observer.ZooKeeper;
import patterns.singleton.Zoo;

public class Main {
    public static void main(String[] args) {
        // 1. Отримуємо екземпляр зоопарку
        Zoo zoo = Zoo.getInstance();

        // 2. Наймаємо доглядача (Observer)
        ZooKeeper keeper = new ZooKeeper("Alex");
        zoo.addObserver(keeper);

        // 3. Запускаємо контролер
        ZooController controller = new ZooController();
        controller.start();
    }
}