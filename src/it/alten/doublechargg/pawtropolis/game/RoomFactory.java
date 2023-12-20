package it.alten.doublechargg.pawtropolis.game;

import it.alten.doublechargg.pawtropolis.animals.AnimalFactory;
import it.alten.doublechargg.pawtropolis.game.model.Item;
import it.alten.doublechargg.pawtropolis.game.model.Room;

import java.util.Objects;
import java.util.Random;

public class RoomFactory {


    private static RoomFactory instance = null;
    private final Random randomizer = new Random();
    private final AnimalFactory animalFactory = AnimalFactory.getInstance();
    Item[] items = {
            new Item(1L, "Sword", "A sword", 7),
            new Item(2L, "Knife", "A knife", 4),
            new Item(3L, "Torch", "A Torch", 2)
    };

    private RoomFactory() {
    }

    public static synchronized RoomFactory getInstance() {
        if (Objects.isNull(instance)) {
            instance = new RoomFactory();
        }
        return instance;
    }

    public Room createRoom() {
        Room room = new Room(Long.toString(Room.getCountRoom()));
        while (room.getItemsNumber() <= randomizer.nextInt(4)) {
            room.addItem(items[randomizer.nextInt(items.length)]);

        }
        while (room.getAnimalsNumber() <= randomizer.nextInt(5)) {
            room.addAnimal(animalFactory.createAnimal());
        }
        return room;
    }
}
