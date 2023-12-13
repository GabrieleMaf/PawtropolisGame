package it.alten.doublechargg.pawtropolis.game;

import it.alten.doublechargg.pawtropolis.animals.AnimalFactory;
import it.alten.doublechargg.pawtropolis.game.model.Item;
import it.alten.doublechargg.pawtropolis.game.model.Room;

import java.util.Objects;
import java.util.Random;

public class RoomFactory {

    private static int idRoom = 0;
    private final Random randomizer = new Random();
    private final AnimalFactory animalFactory = AnimalFactory.getInstance();
    private static RoomFactory instance = null;

    private RoomFactory() {
    }

    public static synchronized RoomFactory getInstance() {
        if (Objects.isNull(instance)) {
            instance = new RoomFactory();
        }
        return instance;
    }

    Item[] items = {
            new Item(1L, "Sword", "A sword", 7),
            new Item(2L, "Knife", "A knife", 4),
            new Item(3L, "Torch", "A Torch", 2)
    };


    public Room createRoom() {
        idRoom++;
        Room room = new Room(Integer.toString(idRoom));
        while (room.getItems().size() <= 4) {
            room.getItems().add(items[randomizer.nextInt(items.length)]);

        }

        while (room.getAnimals().size() <= randomizer.nextInt(5)) {
            room.getAnimals().add(animalFactory.createAnimal());
        }
        return room;
    }
}
