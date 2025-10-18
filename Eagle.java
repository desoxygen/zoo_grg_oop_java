/**
 * КОНКРЕТНИЙ КЛАС ОРЛА - ФІНАЛЬНИЙ РІВЕНЬ НАСЛІДУВАННЯ
 * 
 * ДЕМОНСТРОВАНІ КОНЦЕПЦІЇ:
 * 1. НАСЛІДУВАННЯ - наслідує від Bird
 * 2. ПОЛІМОРФІЗМ - перевизначає makeSound() та getDiet()
 * 3. ІНКАПСУЛЯЦІЯ - private поля з getter/setter
 * 4. ПОНЯТТЯ ОБ'ЄКТІВ ТА ЇХ ЗВ'ЯЗКІВ - конкретна реалізація
 * 5. GRASP "ІНФОРМАЦІЙНИЙ ЕКСПЕРТ" - знає про свої характеристики
 * 
 * СТРУКТУРА:
 * - Конкретний клас (можна створювати екземпляри)
 * - Реалізує всі абстрактні методи
 * - Додає специфічні для орла поля
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
public class Eagle extends Bird {
    private double wingspan;
    private double flightSpeed;
    
    public Eagle(String name, int birthYear, double wingspan, double flightSpeed) {
        super("Орел", name, birthYear, true, "Коричневий");
        this.wingspan = wingspan;
        this.flightSpeed = flightSpeed;
    }
    
    // Геттери та сеттери
    public double getWingspan() {
        return wingspan;
    }
    
    public void setWingspan(double wingspan) {
        this.wingspan = wingspan;
    }
    
    public double getFlightSpeed() {
        return flightSpeed;
    }
    
    public void setFlightSpeed(double flightSpeed) {
        this.flightSpeed = flightSpeed;
    }
    
    // Перевизначення методів для поліморфізму
    @Override
    public String makeSound() {
        return "Кричить: КИИИИ!";
    }
    
    @Override
    public String getDiet() {
        return "М'ясо (хижий птах)";
    }
    
    @Override
    public String toString() {
        return String.format("%s, розмах крил: %.1fм, швидкість: %.1f км/год", 
                           super.getBirdInfo(), 
                           wingspan, 
                           flightSpeed);
    }
}
