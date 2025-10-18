/**
 * ГОЛОВНИЙ ДЕМОНСТРАЦІЙНИЙ КЛАС ЗООПАРКУ
 * 
 * ДЕМОНСТРОВАНІ КОНЦЕПЦІЇ:
 * 1. ПОНЯТТЯ ОБ'ЄКТІВ ТА ЇХ ЗВ'ЯЗКІВ - створення та взаємодія об'єктів
 * 2. ІНКАПСУЛЯЦІЯ, STATIC, FINAL - демонстрація в дії
 * 3. НАСЛІДУВАННЯ ТА ПОЛІМОРФІЗМ - ієрархія класів та перевизначення методів
 * 4. GRASP ПАТТЕРНИ - Інформаційний експерт, Творець, Поліморфізм
 * 5. АНТИПАТТЕРН "БОГООБ'ЄКТ" - приклад поганого дизайну
 * 6. ПРИНЦИПИ DRI, YAGNI, KISS - правильне проектування
 * 7. ПАТТЕРНИ СТВОРЕННЯ - Singleton, Factory
 * 
 * СТРУКТУРА:
 * - Головний клас програми (точка входу)
 * - Демонструє всі концепції на практичних прикладах
 * - Показує правильне та неправильне використання паттернів
 * - Освітній матеріал для вивчення ООП
 * 
 * ВИКОРИСТОВУВАНІ СТРУКТУРИ:
 * - public static void main() - точка входу в програму
 * - System.out.println() - виведення на консоль
 * - List<Animal> - колекція тварин
 * - for-each цикл - ітерація по колекціях
 * - if-else - умовне розгалуження
 * - String.format - форматування рядків
 * - Math.random() - генерація випадкових чисел
 * - switch-case - багатозначне розгалуження
 */
public class ZooDemo {
    public static void main(String[] args) {
        System.out.println("=== ДЕМОНСТРАЦІЯ ЗООПАРКУ ===");
        System.out.println("Демонстрація концепцій ООП, GRASP паттернів та принципів проектування\n");
        
        // 1. Демонстрація Singleton паттерну
        System.out.println("1. SINGLETON ПАТТЕРН:");
        ZooManager manager1 = ZooManager.getInstance();
        ZooManager manager2 = ZooManager.getInstance();
        System.out.println("Один і той же об'єкт? " + (manager1 == manager2));
        System.out.println();
        
        // 2. Демонстрація Factory паттерну
        System.out.println("2. FACTORY ПАТТЕРН:");
        Animal lion = AnimalFactory.createLion("Сімба", 2020, "Золота", true);
        Animal elephant = AnimalFactory.createElephant("Дамбо", 2018, 1.8, 1.2);
        Animal eagle = AnimalFactory.createEagle("Орлик", 2021, 2.2, 95.0);
        
        // Створення через загальний метод фабрики
        Animal randomAnimal = AnimalFactory.createRandomAnimal("Випадковий", 2022);
        System.out.println("Створено випадкову тварину: " + randomAnimal);
        System.out.println();
        
        // 3. Демонстрація інкапсуляції, static, final
        System.out.println("3. ІНКАПСУЛЯЦІЯ, STATIC, FINAL:");
        System.out.println("Загальна кількість тварин: " + Animal.getTotalAnimals());
        System.out.println("Лев: " + lion);
        System.out.println("Слон: " + elephant);
        System.out.println("Орел: " + eagle);
        System.out.println();
        
        // 4. Демонстрація наслідування та поліморфізму
        System.out.println("4. НАСЛІДУВАННЯ ТА ПОЛІМОРФІЗМ:");
        java.util.List<Animal> animals = new java.util.ArrayList<>();
        animals.add(lion);
        animals.add(elephant);
        animals.add(eagle);
        
        // Поліморфізм - один інтерфейс, різні реалізації
        for (Animal animal : animals) {
            System.out.println(animal.getName() + " видає звук: " + animal.makeSound());
            System.out.println("Дієта: " + animal.getDiet());
            System.out.println("---");
        }
        System.out.println();
        
        // 5. Демонстрація GRASP паттернів
        System.out.println("5. GRASP ПАТТЕРНИ:");
        
        // Інформаційний експерт
        ZooKeeper keeper1 = new ZooKeeper("Іван", "Всі тварини", 5);
        ZooKeeper keeper2 = new ZooKeeper("Марія", "птахи", 3);
        
        System.out.println("Доглядачі:");
        System.out.println(keeper1);
        System.out.println(keeper2);
        System.out.println();
        
        // Творець - менеджер створює та керує тваринами
        manager1.addAnimal(lion);
        manager1.addAnimal(eagle);
        manager1.addKeeper(keeper1);
        manager1.addKeeper(keeper2);
        
        // 6. Демонстрація принципів DRI, YAGNI, KISS
        System.out.println("6. ПРИНЦИПИ DRI, YAGNI, KISS:");
        
        // DRI - розділення відповідальності
        TicketService ticketService = new TicketService(100.0, 50.0);
        VeterinaryService vetService = new VeterinaryService("Доктор Сміт");
        
    //     // YAGNI - тільки необхідний функціонал
    //     ticketService.sellTicket(true);  // Дорослий квиток
    //     ticketService.sellTicket(false); // Дитячий квиток
        
    //     // KISS - прості операції
    //     System.out.println("Продано квитків: " + ticketService.getSoldTickets());
    //     System.out.println("Виручка: " + ticketService.getTotalRevenue() + " грн");
    //     System.out.println();
        
    //     // 7. Демонстрація поліморфізму в дії
    //     System.out.println("7. ПОЛІМОРФІЗМ В ДІЇ:");
    //     manager1.performAnimalShow();
    //     System.out.println();
        
    //     // 8. Демонстрація догляду за тваринами
    //     System.out.println("8. ДОГЛЯД ЗА ТВАРИНАМИ:");
    //     manager1.careForAnimals();
    //     System.out.println();
        
    //     // 9. Ветеринарна допомога
    //     System.out.println("9. ВЕТЕРИНАРНА ДОПОМОГА:");
    //     eagle.setHealthy(false); // Орел захворів
    //     vetService.checkAllAnimals(animals);
    //     System.out.println("Виліковано тварин: " + vetService.getTreatedAnimals());
    //     System.out.println();
        
    //     // 10. Статистика зоопарку
    //     System.out.println("10. СТАТИСТИКА ЗООПАРКУ:");
    //     manager1.printZooStatistics();
    //     System.out.println();
        
    //     // 11. Демонстрація пошуку тварин
    //     System.out.println("11. ПОШУК ТВАРИН:");
    //     Animal foundAnimal = manager1.findAnimalByName("Сімба");
    //     if (foundAnimal != null) {
    //         System.out.println("Знайдено: " + foundAnimal);
    //     }
        
    //     java.util.List<Animal> lions = manager1.findAnimalsBySpecies("Лев");
    //     System.out.println("Знайдено левів: " + lions.size());
    //     System.out.println();
        
    //     // 12. Демонстрація антипаттерну "Богооб'єкт"
    //     System.out.println("12. АНТИПАТТЕРН 'БОГООБ'ЄКТ':");
    //     System.out.println("Клас BadZooManager демонструє, як НЕ потрібно робити:");
    //     System.out.println("- Один клас робить занадто багато");
    //     System.out.println("- Порушує принцип єдиної відповідальності");
    //     System.out.println("- Складно тестувати та підтримувати");
    //     System.out.println("- Порушує принципи DRI, YAGNI, KISS");
    //     System.out.println();
        
    //     System.out.println("=== ДЕМОНСТРАЦІЯ ЗАВЕРШЕНА ===");
    //     System.out.println("Продемонстровано всі необхідні концепції:");
    //     System.out.println("Об'єкти та їх зв'язки");
    //     System.out.println("Інкапсуляція, static, final");
    //     System.out.println("Наслідування та поліморфізм");
    //     System.out.println("GRASP паттерни: Інформаційний експерт, Творець, Поліморфізм");
    //     System.out.println("Антипаттерн 'Богооб'єкт'");
    //     System.out.println("Принципи DRI, YAGNI, KISS");
    //     System.out.println("Паттерни створення: Singleton, Factory");
    // }
}
