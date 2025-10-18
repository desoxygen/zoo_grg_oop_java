/**
 * ФАБРИКА ДЛЯ СТВОРЕННЯ ТВАРИН - ПАТТЕРН СТВОРЕННЯ
 * 
 * ДЕМОНСТРОВАНІ КОНЦЕПЦІЇ:
 * 1. ПАТТЕРН "ФАБРИКА" - створює об'єкти без вказання конкретних класів
 * 2. GRASP "ТВОРЕЦЬ" - знає, як створювати об'єкти тварин
 * 3. STATIC МЕТОДИ - можна викликати без створення екземпляра
 * 4. ПРИНЦИПИ DRI, YAGNI, KISS - простий та перевикористовуваний код
 * 5. ПОНЯТТЯ ОБ'ЄКТІВ ТА ЇХ ЗВ'ЯЗКІВ - створює зв'язки між об'єктами
 * 
 * СТРУКТУРА:
 * - Утилітарний клас (тільки static методи)
 * - Приховує складність створення об'єктів
 * - Легко розширюється новими типами тварин
 * 
 * ВИКОРИСТОВУВАНІ СТРУКТУРИ:
 * - static методи - можна викликати без створення екземпляра
 * - switch-case - багатозначне розгалуження
 * - varargs (Object...) - змінна кількість параметрів
 * - String.toLowerCase() - робота з рядками
 * - Math.random() - генерація випадкових чисел
 * - IllegalArgumentException - виняток для некоректних даних
 */
public class AnimalFactory {
    
    // GRASP: Творець - фабрика створює об'єкти, які вона знає як створювати
    public static Animal createAnimal(String animalType, String name, int birthYear, Object... params) {
        switch (animalType.toLowerCase()) {
            case "lion":
                String maneColor = params.length > 0 ? (String) params[0] : "Коричнева";
                boolean isAlpha = params.length > 1 ? (Boolean) params[1] : false;
                return new Lion(name, birthYear, maneColor, isAlpha);
                
            case "elephant":
                double trunkLength = params.length > 0 ? (Double) params[0] : 1.5;
                double tuskLength = params.length > 1 ? (Double) params[1] : 0.8;
                return new Elephant(name, birthYear, trunkLength, tuskLength);
                
            case "eagle":
                double wingspan = params.length > 0 ? (Double) params[0] : 2.0;
                double flightSpeed = params.length > 1 ? (Double) params[1] : 80.0;
                return new Eagle(name, birthYear, wingspan, flightSpeed);
                
            default:
                throw new IllegalArgumentException("Невідомий тип тварини: " + animalType);
        }
    }
    
    // Перевантажені методи для зручності створення
    public static Lion createLion(String name, int birthYear, String maneColor, boolean isAlpha) {
        return new Lion(name, birthYear, maneColor, isAlpha);
    }
    
    public static Elephant createElephant(String name, int birthYear, double trunkLength, double tuskLength) {
        return new Elephant(name, birthYear, trunkLength, tuskLength);
    }
    
    public static Eagle createEagle(String name, int birthYear, double wingspan, double flightSpeed) {
        return new Eagle(name, birthYear, wingspan, flightSpeed);
    }
    
    // Метод для створення випадкової тварини
    public static Animal createRandomAnimal(String name, int birthYear) {
        String[] types = {"lion", "elephant", "eagle"};
        String randomType = types[(int) (Math.random() * types.length)];
        
        switch (randomType) {
            case "lion":
                return createLion(name, birthYear, "Золота", Math.random() > 0.5);
            case "elephant":
                return createElephant(name, birthYear, 1.0 + Math.random() * 1.0, 0.5 + Math.random() * 0.5);
            case "eagle":
                return createEagle(name, birthYear, 1.5 + Math.random() * 1.0, 60 + Math.random() * 40);
            default:
                return createLion(name, birthYear, "Коричнева", false);
        }
    }
}
