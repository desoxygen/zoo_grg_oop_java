package exception;

/**
 * Exception thrown when an aviary is full and cannot accept new animals.
 */
public class AviaryFullException extends Exception {

    /**
     * Конструктор з повідомленням про помилку
     * 
     * @param aviaryId ідентифікатор вольєра, який переповнений
     */
    public AviaryFullException(String aviaryId) {
        super("Aviary #" + aviaryId + " is full! Cannot add new animal.");
    }

    /**
     * Конструктор з кастомним повідомленням
     * 
     * @param message повідомлення про помилку
     */
    public AviaryFullException(String aviaryId, String message) {
        super("Aviary #" + aviaryId + ": " + message);
    }
}
