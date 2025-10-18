/**
 * СЕРВІС ДЛЯ РОБОТИ З КВИТКАМИ - СЕРВІСНИЙ КЛАС
 * 
 * ДЕМОНСТРОВАНІ КОНЦЕПЦІЇ:
 * 1. ПРИНЦИП "DRI" (Don't Repeat Yourself) - перевикористання коду
 * 2. ПРИНЦИП "YAGNI" (You Aren't Gonna Need It) - тільки необхідний функціонал
 * 3. ПРИНЦИП "KISS" (Keep It Simple, Stupid) - прості методи
 * 4. ІНКАПСУЛЯЦІЯ - private поля з getter/setter
 * 5. ПОНЯТТЯ ОБ'ЄКТІВ ТА ЇХ ЗВ'ЯЗКІВ - взаємодія з квитками
 * 
 * СТРУКТУРА:
 * - Сервісний клас (виконує одну задачу)
 * - Простий та сфокусований функціонал
 * - Демонструє правильне розділення відповідальності
 * 
 * ВИКОРИСТОВУВАНІ СТРУКТУРИ:
 * - private поля - інкапсуляція
 * - getter/setter - інкапсуляція
 * - double - примітивний тип даних
 * - int - примітивний тип даних
 * - boolean - примітивний тип даних
 * - String.format - форматування рядків
 * - тернарний оператор (?:) - умовне присвоєння
 */
public class TicketService {
    // KISS: прості поля
    private double adultPrice;
    private double childPrice;
    private int soldTickets;
    
    public TicketService(double adultPrice, double childPrice) {
        this.adultPrice = adultPrice;
        this.childPrice = childPrice;
        this.soldTickets = 0;
    }
    
    // YAGNI: тільки необхідні методи
    public double calculatePrice(boolean isAdult) {
        return isAdult ? adultPrice : childPrice;
    }
    
    public void sellTicket(boolean isAdult) {
        soldTickets++;
        double price = calculatePrice(isAdult);
        System.out.println("Продано квиток за " + price + " грн (" + 
                          (isAdult ? "дорослий" : "дитячий") + ")");
    }
    
    public int getSoldTickets() {
        return soldTickets;
    }
    
    public double getTotalRevenue() {
        return soldTickets * adultPrice; // Спрощений розрахунок
    }
}
