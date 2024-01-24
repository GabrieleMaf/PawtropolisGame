package pawtropolis.game.utils;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pawtropolis.game.domain.Item;

import java.util.*;

@Component
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ItemFactory {
    private static final Random random = new Random();
    private final Map<String, Integer> itemsMap = Map.of(
            "Knife", 1,
            "Katana", 2,
            "Gun", 3,
            "Bazooka", 4,
            "Spada lunga", 5,
            "Pokéball", 5,
            "Masterball", 10,
            "Ultraball", 7,
            "Potion", 4,
            "Key", 2);

    public Item getRandomItem() {
        List<String> keys = new ArrayList<>(itemsMap.keySet());
        String randomKey = keys.get(random.nextInt(keys.size()));
        int value = itemsMap.get(randomKey);

        return new Item(randomKey, value);
    }

    public Set<Item> getRandomItemsSet(int quantity) {
        Set<Item> itemSet = new HashSet<>();
        for (int i = 0; i < quantity; i++) {
            itemSet.add(getRandomItem());
        }
        return itemSet;
    }
}
