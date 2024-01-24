package pawtropolis.animals.utils;


import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pawtropolis.animals.domain.Animal;
import pawtropolis.animals.domain.Eagle;
import pawtropolis.animals.domain.Lion;
import pawtropolis.animals.domain.Tiger;

import java.time.LocalDate;
import java.util.*;
@Component
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class AnimalFactory {
    private static final Random random = new Random();
    private final List<String> nameList = new ArrayList<>(Arrays.asList("Fuffi", "Spot", "Gwaihir", "Shaggy", "Ciccio"));
    private final List<String> foodList = new ArrayList<>(Arrays.asList("Meat", "Fruit", "Steak", "Caccole", "Fish"));

    public Animal getRandomAnimal() {
        return switch (random.nextInt(3)) {
            case 0 -> new Eagle(nameList.get(random.nextInt(nameList.size())),
                    foodList.get(random.nextInt(foodList.size())),
                    random.nextInt(15),
                    LocalDate.now(),
                    random.nextDouble(8),
                    random.nextInt(102),
                    random.nextDouble(61.4)
            );
            case 1 -> new Lion(nameList.get(random.nextInt(nameList.size())),
                    foodList.get(random.nextInt(foodList.size())),
                    random.nextInt(15),
                    LocalDate.now(),
                    random.nextDouble(190),
                    random.nextInt(120),
                    random.nextDouble(80));
            case 2 -> new Tiger(nameList.get(random.nextInt(nameList.size())),
                    foodList.get(random.nextInt(foodList.size())),
                    random.nextInt(15),
                    LocalDate.now(),
                    random.nextDouble(200),
                    random.nextInt(130),
                    random.nextDouble(80));
            default -> null;
        };
    }

    public Set<Animal> getRandomAnimalsSet(int quantity) {
        Set<Animal> animalSet = new HashSet<>();
        for (int i = 0; i < quantity; i++) {
            animalSet.add(getRandomAnimal());
        }
        return animalSet;
    }
}
