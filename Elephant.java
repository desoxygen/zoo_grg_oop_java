/**
 * КОНКРЕТНИЙ КЛАС СЛОНА - ФІНАЛЬНИЙ РІВЕНЬ НАСЛІДУВАННЯ
 * 
 * ДЕМОНСТРОВАНІ КОНЦЕПЦІЇ:
 * 1. НАСЛІДУВАННЯ - наслідує від Mammal
 * 2. ПОЛІМОРФІЗМ - перевизначає makeSound() та getDiet()
 * 3. ІНКАПСУЛЯЦІЯ - private поля з getter/setter
 * 4. ПОНЯТТЯ ОБ'ЄКТІВ ТА ЇХ ЗВ'ЯЗКІВ - конкретна реалізація
 * 5. GRASP "ІНФОРМАЦІЙНИЙ ЕКСПЕРТ" - знає про свої характеристики
 * 
 * СТРУКТУРА:
 * - Конкретний клас (можна створювати екземпляри)
 * - Реалізує всі абстрактні методи
 * - Додає специфічні для слона поля
 * 
 * ВИКОРИСТОВУВАНІ СТРУКТУРИ:
 * - extends - наслідування
 * - private поля - інкапсуляція
 * - getter/setter - інкапсуляція
 * - @Override - перевизначення методу
 * - super - звернення до батьківського класу
 * - String.format - форматування рядків
 * - double - примітивний тип даних
 */
public class Elephant extends Mammal {
    private double trunkLength;
    private double tuskLength;
    
    public Elephant(String name, int birthYear, double trunkLength, double tuskLength) {
        super("Слон", name, birthYear, false, 4);
        this.trunkLength = trunkLength;
        this.tuskLength = tuskLength;
    }
    
    // Геттери та сеттери
    public double getTrunkLength() {
        return trunkLength;
    }
    
    public void setTrunkLength(double trunkLength) {
        this.trunkLength = trunkLength;
    }
    
    public double getTuskLength() {
        return tuskLength;
    }
    
    public void setTuskLength(double tuskLength) {
        this.tuskLength = tuskLength;
    }
    
    // Перевизначення методів для поліморфізму
    @Override
    public String makeSound() {
        return "Трубить: ТУУУУ!";
    }
    
    @Override
    public String getDiet() {
        return "Рослинна їжа (травоїдний)";
    }
    
    @Override
    public String toString() {
        return String.format("%s, хобот: %.1fм, бивні: %.1fм", 
                           super.getMammalInfo(), 
                           trunkLength, 
                           tuskLength);
    }
}
