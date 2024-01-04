package it.alten.doublechargg.pawtropolis.game;

import it.alten.doublechargg.pawtropolis.animals.AnimalFactory;
import it.alten.doublechargg.pawtropolis.game.model.Item;
import it.alten.doublechargg.pawtropolis.game.model.Room;

import java.util.Objects;
import java.util.Random;

public class RoomFactory {

    private static final Random randomizer = new Random();
    private static RoomFactory instance;
    private final AnimalFactory animalFactory;

    private final Item[] items = {
            new Item(1L, "Sword", "A sword", 7),
            new Item(2L, "Knife", "A knife", 4),
            new Item(3L, "Torch", "A Torch", 2)
    };

    private RoomFactory() {
        animalFactory = AnimalFactory.getInstance();
    }

    public static synchronized RoomFactory getInstance() {
        if (Objects.isNull(instance)) {
            instance = new RoomFactory();
        }
        return instance;
    }

    public Room createRoom() {
        Room room = new Room(Long.toString(Room.getCountRoom()));
        final int MAX_ITEMS = 4;
        final int availableItemsCount = items.length;
        while (room.getItemsNumber() <= randomizer.nextInt(MAX_ITEMS + 1)) {
            int selectedItemIndex = randomizer.nextInt(availableItemsCount);
            room.addItem(items[selectedItemIndex]);
        }
        final int MAX_ANIMALS = 5;
        while (room.getAnimalNumber() <= randomizer.nextInt(MAX_ANIMALS + 1)) {
            room.addAnimal(animalFactory.createAnimal());
        }
        return room;
    }
}
