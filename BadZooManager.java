/**
 * ПОГАНИЙ ПРИКЛАД - ДЕМОНСТРАЦІЯ АНТИПАТТЕРНУ "БОГООБ'ЄКТ"
 * 
 * ДЕМОНСТРОВАНІ КОНЦЕПЦІЇ:
 * 1. АНТИПАТТЕРН "БОГООБ'ЄКТ" - один клас робить занадто багато
 * 2. ПОРУШЕННЯ ПРИНЦИПІВ DRI, YAGNI, KISS
 * 3. ПОРУШЕННЯ ПРИНЦИПУ ЄДИНОЇ ВІДПОВІДАЛЬНОСТІ (SRP)
 * 4. ПОГАНИЙ ПРИКЛАД ПРОЕКТУВАННЯ
 * 
 * СТРУКТУРА:
 * - Один клас намагається робити ВСЕ
 * - Змішує різні області відповідальності
 * - Складно тестувати та підтримувати
 * - Порушує всі принципи хорошого дизайну
 * 
 * УВАГА: Це приклад того, як НЕ потрібно робити!
 * 
 * ВИКОРИСТОВУВАНІ СТРУКТУРИ (НЕПРАВИЛЬНО):
 * - Один клас з багатьма полями різних типів
 * - Змішування різних областей відповідальності
 * - Порушення принципу єдиної відповідальності
 * - Складність тестування та підтримки
 */
public class BadZooManager {
    // Антипаттерн: один клас робить ВСЕ
    private java.util.List<Animal> animals;
    private java.util.List<ZooKeeper> keepers;
    private java.util.List<String> tickets;
    private java.util.Map<String, Double> prices;
    private java.util.List<String> events;
    private String weather;
    private double budget;
    private int visitors;
    
    public BadZooManager() {
        this.animals = new java.util.ArrayList<>();
        this.keepers = new java.util.ArrayList<>();
        this.tickets = new java.util.ArrayList<>();
        this.prices = new java.util.HashMap<>();
        this.events = new java.util.ArrayList<>();
        this.budget = 100000;
        this.visitors = 0;
    }
    
    // Методи для роботи з тваринами
    public void addAnimal(Animal animal) { /* ... */ }
    public void feedAnimal(Animal animal) { /* ... */ }
    public void checkAnimalHealth(Animal animal) { /* ... */ }
    
    // Методи для роботи з квитками
    public void sellTicket(String type) { /* ... */ }
    public double calculatePrice(String ticketType) { return 0.0; }
    public void processRefund(String ticketId) { /* ... */ }
    
    // Методи для роботи з подіями
    public void scheduleEvent(String event) { /* ... */ }
    public void cancelEvent(String eventId) { /* ... */ }
    public void notifyVisitors(String message) { /* ... */ }
    
    // Методи для роботи з погодою
    public void updateWeather(String weather) { /* ... */ }
    public boolean isGoodWeatherForVisit() { return false; }
    
    // Методи для роботи з фінансами
    public void updateBudget(double amount) { /* ... */ }
    public void paySalaries() { /* ... */ }
    public void buyFood() { /* ... */ }
    
    // Методи для роботи з відвідувачами
    public void registerVisitor() { /* ... */ }
    public void trackVisitorMovement(String visitorId) { /* ... */ }
    
    // І ще десятки інших методів...
    
    // ПРОБЛЕМА: один клас знає і робить занадто багато!
    // Порушує принципи SRP, DRI, KISS
}
