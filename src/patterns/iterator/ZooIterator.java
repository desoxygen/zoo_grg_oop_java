package patterns.iterator;

import model.Animal;
import model.Aviary;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class ZooIterator implements Iterator<Animal> {
    private List<Aviary> aviaries;
    private int currentAviaryIndex = 0;
    private int currentAnimalIndex = 0;

    public ZooIterator(List<Aviary> aviaries) {
        this.aviaries = aviaries;
    }

    @Override
    public boolean hasNext() {
        // Шукаємо наступну тварину, пропускаючи порожні вольєри
        while (currentAviaryIndex < aviaries.size()) {
            List<Animal> animals = aviaries.get(currentAviaryIndex).getAnimals();
            if (currentAnimalIndex < animals.size()) {
                return true;
            }
            // Переходимо до наступного вольєру
            currentAviaryIndex++;
            currentAnimalIndex = 0;
        }
        return false;
    }

    @Override
    public Animal next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return aviaries.get(currentAviaryIndex).getAnimals().get(currentAnimalIndex++);
    }
}