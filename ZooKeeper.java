/**
 * КЛАС ДОГЛЯДАЧА ЗООПАРКУ - СЕРВІСНИЙ КЛАС
 * 
 * ДЕМОНСТРОВАНІ КОНЦЕПЦІЇ:
 * 1. GRASP "ІНФОРМАЦІЙНИЙ ЕКСПЕРТ" - знає, як доглядати за тваринами
 * 2. ІНКАПСУЛЯЦІЯ - private поля з getter/setter
 * 3. ПОНЯТТЯ ОБ'ЄКТІВ ТА ЇХ ЗВ'ЯЗКІВ - взаємодія з об'єктами Animal
 * 4. ПРИНЦИПИ DRI, YAGNI, KISS - простий та сфокусований функціонал
 * 
 * СТРУКТУРА:
 * - Сервісний клас (виконує конкретні функції)
 * - Містить методи для роботи з тваринами
 * - Демонструє правильне розділення відповідальності
 * 
 * ВИКОРИСТОВУВАНІ СТРУКТУРИ:
 * - private поля - інкапсуляція
 * - getter/setter - інкапсуляція
 * - String - об'єктний тип даних
 * - int - примітивний тип даних
 * - boolean - примітивний тип даних
 * - String.format - форматування рядків
 * - StringBuilder - для ефективної роботи з рядками
 */
public class ZooKeeper {
    private String name;
    private String specialization;
    private int experience;
    
    public ZooKeeper(String name, String specialization, int experience) {
        this.name = name;
        this.specialization = specialization;
        this.experience = experience;
    }
    
    // Геттеры и сеттеры
    public String getName() {
        return name;
    }
    
    public String getSpecialization() {
        return specialization;
    }
    
    public int getExperience() {
        return experience;
    }
    
    // GRASP: Інформаційний експерт - методи, що працюють з даними доглядача
    public boolean canCareFor(Animal animal) {
        // Доглядач знає, чи може він доглядати за конкретною твариною
        if (specialization.equals("Всі тварини")) {
            return true;
        }
        return animal.getClass().getSimpleName().toLowerCase().contains(specialization.toLowerCase());
    }
    
    public String getCareInstructions(Animal animal) {
        // Доглядач знає інструкції з догляду
        StringBuilder instructions = new StringBuilder();
        instructions.append("Інструкції з догляду для ").append(animal.getName()).append(":\n");
        instructions.append("- Годування: ").append(animal.getDiet()).append("\n");
        instructions.append("- Звуки: ").append(animal.makeSound()).append("\n");
        instructions.append("- Середовище проживання: ").append(animal.getHabitat()).append("\n");
        
        if (animal.isHealthy()) {
            instructions.append("- Статус здоров'я: хороший\n");
        } else {
            instructions.append("- Потрібна ветеринарна допомога\n");
        }
        
        return instructions.toString();
    }
    
    public void feedAnimal(Animal animal) {
        System.out.println(name + " годує " + animal.getName() + " (" + animal.getDiet() + ")");
    }
    
    public void checkHealth(Animal animal) {
        System.out.println(name + " перевіряє здоров'я " + animal.getName());
        if (!animal.isHealthy()) {
            System.out.println("Увага! " + animal.getName() + " потребує ветеринара!");
        }
    }
    
    @Override
    public String toString() {
        return String.format("Доглядач: %s, спеціалізація: %s, досвід: %d років", 
                           name, specialization, experience);
    }
}
