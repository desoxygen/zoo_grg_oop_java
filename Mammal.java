/**
 * КЛАС ССАВЦІВ - ПРОМІЖНИЙ РІВЕНЬ НАСЛІДУВАННЯ
 * 
 * ДЕМОНСТРОВАНІ КОНЦЕПЦІЇ:
 * 1. НАСЛІДУВАННЯ - наслідує від Animal
 * 2. ПОЛІМОРФІЗМ - перевизначає метод getDiet()
 * 3. ІНКАПСУЛЯЦІЯ - private поля з getter/setter
 * 4. ПОНЯТТЯ ОБ'ЄКТІВ ТА ЇХ ЗВ'ЯЗКІВ - зв'язок з батьківським класом
 * 
 * СТРУКТУРА:
 * - Абстрактний клас (проміжний рівень)
 * - Додає специфічні для ссавців поля
 * - Розширює функціональність базового класу
 * 
 * ВИКОРИСТОВУВАНІ СТРУКТУРИ:
 * - extends - наслідування
 * - abstract class - абстрактний клас
 * - private поля - інкапсуляція
 * - getter/setter - інкапсуляція
 * - @Override - перевизначення методу
 * - super - звернення до батьківського класу
 */
public abstract class Mammal extends Animal {
    private boolean hasFur;
    private int numberOfLegs;
    
    public Mammal(String species, String name, int birthYear, boolean hasFur, int numberOfLegs) {
        super(species, name, birthYear);
        this.hasFur = hasFur;
        this.numberOfLegs = numberOfLegs;
    }
    
    // Геттери та сеттери
    public boolean hasFur() {
        return hasFur;
    }
    
    public void setHasFur(boolean hasFur) {
        this.hasFur = hasFur;
    }
    
    public int getNumberOfLegs() {
        return numberOfLegs;
    }
    
    public void setNumberOfLegs(int numberOfLegs) {
        this.numberOfLegs = numberOfLegs;
    }
    
    // Перевизначення методу для поліморфізму
    @Override
    public String getDiet() {
        return "Змішана дієта";
    }
    
    // Новий метод, специфічний для ссавців
    public String getMammalInfo() {
        return String.format("%s, хутро: %s, ніг: %d", 
                           super.getInfo(), 
                           hasFur ? "є" : "немає", 
                           numberOfLegs);
    }
}
