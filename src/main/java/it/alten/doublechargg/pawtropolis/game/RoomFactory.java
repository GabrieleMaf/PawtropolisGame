package it.alten.doublechargg.pawtropolis.game;

import it.alten.doublechargg.pawtropolis.animals.AnimalFactory;
import it.alten.doublechargg.pawtropolis.game.model.Item;
import it.alten.doublechargg.pawtropolis.game.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RoomFactory {

    public static int count = 0;
    private static final Random randomizer = new Random();

    @Autowired
    private ApplicationContext context;


    private final Item[] items = {
            new Item(1L, "Sword", "A sword", 7),
            new Item(2L, "Knife", "A knife", 4),
            new Item(3L, "Torch", "A Torch", 2)
    };

    public Room createRoom() {
        count++;
        Room room = new Room(Integer.toString(count));
        final int maximumItems = 4;
        final int availableItemsCount = items.length;
        while (room.getItemsNumber() <= randomizer.nextInt( maximumItems + 1)) {
            int selectedItemIndex = randomizer.nextInt(availableItemsCount);
            room.addItem(items[selectedItemIndex]);
        }
        final int maximumAnimals = 5;
        while (room.getAnimalNumber() <= randomizer.nextInt(maximumAnimals + 1)) {
            room.addAnimal(context.getBean(AnimalFactory.class).createAnimal());
        }
        return room;
    }
}
