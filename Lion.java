/**
 * КОНКРЕТНИЙ КЛАС ЛЕВА - ФІНАЛЬНИЙ РІВЕНЬ НАСЛІДУВАННЯ
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
 * - Додає специфічні для лева поля
 * 
 * ВИКОРИСТОВУВАНІ СТРУКТУРИ:
 * - extends - наслідування
 * - private поля - інкапсуляція
 * - getter/setter - інкапсуляція
 * - @Override - перевизначення методу
 * - super - звернення до батьківського класу
 * - String.format - форматування рядків
 */
public class Lion extends Mammal {
    private String maneColor;
    private boolean isAlpha;
    
    public Lion(String name, int birthYear, String maneColor, boolean isAlpha) {
        super("Лев", name, birthYear, true, 4);
        this.maneColor = maneColor;
        this.isAlpha = isAlpha;
    }
    
    // Геттери та сеттери
    public String getManeColor() {
        return maneColor;
    }
    
    public void setManeColor(String maneColor) {
        this.maneColor = maneColor;
    }
    
    public boolean isAlpha() {
        return isAlpha;
    }
    
    public void setAlpha(boolean alpha) {
        isAlpha = alpha;
    }
    
    // Перевизначення методів для поліморфізму
    @Override
    public String makeSound() {
        return "Ричить: РРРРР!";
    }
    
    @Override
    public String getDiet() {
        return "М'ясо (хижак)";
    }
    
    @Override
    public String toString() {
        return String.format("%s, грива: %s, альфа: %s", 
                           super.getMammalInfo(), 
                           maneColor, 
                           isAlpha ? "так" : "ні");
    }
}
