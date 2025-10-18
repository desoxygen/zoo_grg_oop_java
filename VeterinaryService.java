/**
 * ВЕТЕРИНАРНА СЛУЖБА - СЕРВІСНИЙ КЛАС
 * 
 * ДЕМОНСТРОВАНІ КОНЦЕПЦІЇ:
 * 1. ПРИНЦИП "DRI" (Don't Repeat Yourself) - перевикористання коду
 * 2. ПРИНЦИП "YAGNI" (You Aren't Gonna Need It) - тільки необхідний функціонал
 * 3. ПРИНЦИП "KISS" (Keep It Simple, Stupid) - прості методи
 * 4. ІНКАПСУЛЯЦІЯ - private поля з getter/setter
 * 5. ПОНЯТТЯ ОБ'ЄКТІВ ТА ЇХ ЗВ'ЯЗКІВ - взаємодія з тваринами
 * 
 * СТРУКТУРА:
 * - Сервісний клас (виконує одну задачу)
 * - Простий та сфокусований функціонал
 * - Демонструє правильне розділення відповідальності
 * 
 * ВИКОРИСТОВУВАНІ СТРУКТУРИ:
 * - private поля - інкапсуляція
 * - getter/setter - інкапсуляція
 * - String - об'єктний тип даних
 * - int - примітивний тип даних
 * - List<Animal> - колекція тварин
 * - for-each цикл - ітерація по колекції
 * - if-else - умовне розгалуження
 */
public class VeterinaryService {
    private String vetName;
    private int treatedAnimals;
    
    public VeterinaryService(String vetName) {
        this.vetName = vetName;
        this.treatedAnimals = 0;
    }
    
    // KISS: простий метод лікування
    public void treatAnimal(Animal animal) {
        if (!animal.isHealthy()) {
            animal.setHealthy(true);
            treatedAnimals++;
            System.out.println(vetName + " вилікував " + animal.getName());
        } else {
            System.out.println(animal.getName() + " вже здоровий");
        }
    }
    
    // YAGNI: тільки необхідні методи
    public int getTreatedAnimals() {
        return treatedAnimals;
    }
    
    public void checkAllAnimals(java.util.List<Animal> animals) {
        System.out.println(vetName + " перевіряє всіх тварин...");
        for (Animal animal : animals) {
            if (!animal.isHealthy()) {
                treatAnimal(animal);
            }
        }
    }
}
