package it.alten.doublechargg.pawtropolis.game.map;

import it.alten.doublechargg.pawtropolis.game.animals.AnimalFactory;
import it.alten.doublechargg.pawtropolis.game.map.domain.Room;
import it.alten.doublechargg.pawtropolis.game.player.domain.Item;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class RoomFactory {

    public static final List<Item> items = List.of(
            new Item("Sword", "A sword", 7),
            new Item("Knife", "A knife", 4),
            new Item("Torch", "A Torch", 2),
            new Item("Key", "A key", 1));
    private static final Random RANDOMIZER = new Random();
    private static int count = 0;
    private final AnimalFactory animalFactory;

    public Room createRoom() {
        count++;
        Room room = new Room(Integer.toString(count));
        val MAXIMUM_ITEMS = 4;
        val availableItemsCount = items.size();

        while (room.getItemsNumber() <= RANDOMIZER.nextInt(MAXIMUM_ITEMS + 1)) {
            var selectedItemIndex = RANDOMIZER.nextInt(availableItemsCount);
            room.addItem(items.get(selectedItemIndex));
        }

        val MAXIMUM_ANIMALS = 5;
        while (room.getAnimalNumber() <= RANDOMIZER.nextInt(MAXIMUM_ANIMALS + 1)) {
            room.addAnimal(animalFactory.createAnimal());
        }

        return room;
    }
}
