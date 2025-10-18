/**
 * КЛАС ПТАХІВ - ПРОМІЖНИЙ РІВЕНЬ НАСЛІДУВАННЯ
 * 
 * ДЕМОНСТРОВАНІ КОНЦЕПЦІЇ:
 * 1. НАСЛІДУВАННЯ - наслідує від Animal
 * 2. ПОЛІМОРФІЗМ - перевизначає метод getDiet()
 * 3. ІНКАПСУЛЯЦІЯ - private поля з getter/setter
 * 4. ПОНЯТТЯ ОБ'ЄКТІВ ТА ЇХ ЗВ'ЯЗКІВ - зв'язок з батьківським класом
 * 
 * СТРУКТУРА:
 * - Абстрактний клас (проміжний рівень)
 * - Додає специфічні для птахів поля
 * - Альтернативна гілка наслідування від Animal
 * 
 * ВИКОРИСТОВУВАНІ СТРУКТУРИ:
 * - extends - наслідування
 * - abstract class - абстрактний клас
 * - private поля - інкапсуляція
 * - getter/setter - інкапсуляція
 * - @Override - перевизначення методу
 * - super - звернення до батьківського класу
 */
public abstract class Bird extends Animal {
    private boolean canFly;
    private String featherColor;
    
    public Bird(String species, String name, int birthYear, boolean canFly, String featherColor) {
        super(species, name, birthYear);
        this.canFly = canFly;
        this.featherColor = featherColor;
    }
    
    // Геттери та сеттери
    public boolean canFly() {
        return canFly;
    }
    
    public void setCanFly(boolean canFly) {
        this.canFly = canFly;
    }
    
    public String getFeatherColor() {
        return featherColor;
    }
    
    public void setFeatherColor(String featherColor) {
        this.featherColor = featherColor;
    }
    
    // Перевизначення методу для поліморфізму
    @Override
    public String getDiet() {
        return "Насіння та комахи";
    }
    
    // Новий метод, специфічний для птахів
    public String getBirdInfo() {
        return String.format("%s, політ: %s, колір пір'я: %s", 
                           super.getInfo(), 
                           canFly ? "може" : "не може", 
                           featherColor);
    }
}
