/**
 * МЕНЕДЖЕР ЗООПАРКУ - КЕРУЮЧИЙ КЛАС
 * 
 * ДЕМОНСТРОВАНІ КОНЦЕПЦІЇ:
 * 1. ПАТТЕРН "SINGLETON" - єдиний екземпляр в системі
 * 2. GRASP "ІНФОРМАЦІЙНИЙ ЕКСПЕРТ" - знає про всіх тварин та доглядачів
 * 3. GRASP "ТВОРЕЦЬ" - створює та керує колекціями
 * 4. GRASP "ПОЛІМОРФІЗМ" - працює з різними типами тварин
 * 5. ІНКАПСУЛЯЦІЯ - private поля з getter/setter
 * 6. ПРИНЦИПИ DRI, YAGNI, KISS - чітке розділення відповідальності
 * 
 * СТРУКТУРА:
 * - Керуючий клас (координує роботу системи)
 * - Єдиний екземпляр (Singleton)
 * - Містить колекції тварин та доглядачів
 * - Надає методи для управління зоопарком
 * 
 * ВИКОРИСТОВУВАНІ СТРУКТУРИ:
 * - static поля - загальні для всіх екземплярів
 * - private конструктор - для Singleton
 * - getInstance() - метод створення єдиного екземпляра
 * - List<Animal> - колекція тварин
 * - List<ZooKeeper> - колекція доглядачів
 * - Map<String, Integer> - колекція для підрахунку
 * - for-each цикл - ітерація по колекціях
 * - String.format - форматування рядків
 */
public class ZooManager {
    // Singleton - єдиний екземпляр
    private static ZooManager instance;
    
    // Приватний конструктор
    private ZooManager() {
        this.zooName = "Головний зоопарк";
        this.animals = new java.util.ArrayList<>();
        this.keepers = new java.util.ArrayList<>();
    }
    
    // Метод отримання єдиного екземпляра
    public static ZooManager getInstance() {
        if (instance == null) {
            instance = new ZooManager();
        }
        return instance;
    }
    
    // Дані зоопарку
    private String zooName;
    private java.util.List<Animal> animals;
    private java.util.List<ZooKeeper> keepers;
    
    // Геттери
    public String getZooName() {
        return zooName;
    }
    
    public java.util.List<Animal> getAnimals() {
        return new java.util.ArrayList<>(animals); // Захисна копія
    }
    
    public java.util.List<ZooKeeper> getKeepers() {
        return new java.util.ArrayList<>(keepers); // Захисна копія
    }
    
    // GRASP: Інформаційний експерт - менеджер знає про всіх тварин
    public void addAnimal(Animal animal) {
        animals.add(animal);
        System.out.println("Додано тварину: " + animal.getName());
    }
    
    public void addKeeper(ZooKeeper keeper) {
        keepers.add(keeper);
        System.out.println("Додано доглядача: " + keeper.getName());
    }
    
    public Animal findAnimalByName(String name) {
        for (Animal animal : animals) {
            if (animal.getName().equals(name)) {
                return animal;
            }
        }
        return null;
    }
    
    public java.util.List<Animal> findAnimalsBySpecies(String species) {
        java.util.List<Animal> result = new java.util.ArrayList<>();
        for (Animal animal : animals) {
            if (animal.getSpecies().equals(species)) {
                result.add(animal);
            }
        }
        return result;
    }
    
    // Статистика зоопарку
    public void printZooStatistics() {
        System.out.println("\n=== Статистика зоопарку '" + zooName + "' ===");
        System.out.println("Всього тварин: " + animals.size());
        System.out.println("Всього доглядачів: " + keepers.size());
        System.out.println("Загальна кількість тварин (включаючи видалені): " + Animal.getTotalAnimals());
        
        // Групування за видами
        java.util.Map<String, Integer> speciesCount = new java.util.HashMap<>();
        for (Animal animal : animals) {
            speciesCount.put(animal.getSpecies(), speciesCount.getOrDefault(animal.getSpecies(), 0) + 1);
        }
        
        System.out.println("\nТварини за видами:");
        for (java.util.Map.Entry<String, Integer> entry : speciesCount.entrySet()) {
            System.out.println("- " + entry.getKey() + ": " + entry.getValue());
        }
    }
    
    // Демонстрація поліморфізму
    public void performAnimalShow() {
        System.out.println("\n=== Вистава тварин ===");
        for (Animal animal : animals) {
            System.out.println(animal.getName() + ": " + animal.makeSound());
        }
    }
    
    // Догляд за тваринами
    public void careForAnimals() {
        System.out.println("\n=== Догляд за тваринами ===");
        for (Animal animal : animals) {
            // Знаходимо підходящого доглядача
            ZooKeeper assignedKeeper = null;
            for (ZooKeeper keeper : keepers) {
                if (keeper.canCareFor(animal)) {
                    assignedKeeper = keeper;
                    break;
                }
            }
            
            if (assignedKeeper != null) {
                assignedKeeper.feedAnimal(animal);
                assignedKeeper.checkHealth(animal);
            } else {
                System.out.println("Немає підходящого доглядача для " + animal.getName());
            }
        }
    }
}
