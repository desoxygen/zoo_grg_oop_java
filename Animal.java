/**
 * БАЗОВИЙ КЛАС ДЛЯ ВСІХ ТВАРИН У ЗООПАРКУ
 * 
 * ДЕМОНСТРОВАНІ КОНЦЕПЦІЇ:
 * 1. ПОНЯТТЯ ОБ'ЄКТІВ ТА ЇХ ЗВ'ЯЗКІВ - базовий об'єкт для всіх тварин
 * 2. ІНКАПСУЛЯЦІЯ - private поля з getter/setter методами
 * 3. STATIC - загальний лічильник усіх створених тварин
 * 4. FINAL - незмінні поля (species, name, birthYear)
 * 5. НАСЛІДУВАННЯ - абстрактний клас для наслідування
 * 6. ПОЛІМОРФІЗМ - абстрактні методи для перевизначення
 * 7. GRASP "ІНФОРМАЦІЙНИЙ ЕКСПЕРТ" - об'єкт знає про свої дані
 * 
 * СТРУКТУРА:
 * - Абстрактний клас (не можна створити екземпляр)
 * - Містить загальні поля та методи для всіх тварин
 * - Визначає інтерфейс через абстрактні методи
 * 
 * ВИКОРИСТОВУВАНІ СТРУКТУРИ:
 * - abstract class - абстрактний клас
 * - private поля - інкапсуляція
 * - static поля - загальні для всіх екземплярів
 * - final поля - константи
 * - abstract методи - для поліморфізму
 * - getter/setter - інкапсуляція
 */
public abstract class Animal {
    // final поля - константи (незмінні)
    private final String species;
    private final String name;
    private final int birthYear;
    
    // static поле - загальне для всіх тварин
    private static int totalAnimals = 0;
    
    // private поля - інкапсуляція
    private boolean isHealthy;
    private String habitat;
    
    // Конструктор
    public Animal(String species, String name, int birthYear) {
        this.species = species;
        this.name = name;
        this.birthYear = birthYear;
        this.isHealthy = true;
        this.habitat = "Unknown";
        totalAnimals++; // Збільшуємо лічильник при створенні
    }
    
    // Геттери та сеттери - інкапсуляція
    public String getSpecies() {
        return species;
    }
    
    public String getName() {
        return name;
    }
    
    public int getBirthYear() {
        return birthYear;
    }
    
    public boolean isHealthy() {
        return isHealthy;
    }
    
    public void setHealthy(boolean healthy) {
        this.isHealthy = healthy;
    }
    
    public String getHabitat() {
        return habitat;
    }
    
    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }
    
    // static метод
    public static int getTotalAnimals() {
        return totalAnimals;
    }
    
    // Абстрактні методи для поліморфізму
    public abstract String makeSound();
    public abstract String getDiet();
    
    // Звичайні методи
    public int getAge() {
        return 2024 - birthYear;
    }
    
    public String getInfo() {
        return String.format("%s '%s' (%s), вік: %d років, здоров'я: %s", 
                           species, name, getClass().getSimpleName(), 
                           getAge(), isHealthy ? "добре" : "погане");
    }
    
    @Override
    public String toString() {
        return getInfo();
    }
}
