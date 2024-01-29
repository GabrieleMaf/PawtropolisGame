package pawtropolis.map.utils;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pawtropolis.animals.domain.Animal;
import pawtropolis.animals.utils.AnimalFactory;
import pawtropolis.game.domain.Item;
import pawtropolis.game.utils.ItemFactory;
import pawtropolis.map.domain.Direction;
import pawtropolis.map.domain.Door;
import pawtropolis.map.domain.Room;

import java.util.*;

@Component
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class RoomFactory {
    private static final Random random = new Random();
    private static final int DEFAULT_ROOM_ANIMALS_QUANTITY = 3;
    private static final int DEFAULT_ROOM_ITEMS_QUANTITY = 5;

    private final ItemFactory itemFactory;
    private final AnimalFactory animalFactory;

    public Room generateGameMap(int depth) {
        String name = "Room" + random.nextInt(100);
        Set<Item> items = itemFactory.getRandomItemsSet(DEFAULT_ROOM_ITEMS_QUANTITY);
        Set<Animal> animals = animalFactory.getRandomAnimalsSet(DEFAULT_ROOM_ANIMALS_QUANTITY);
        Map<Direction, Door> adjacentDoors = new EnumMap<>(Direction.class);
        Room newRoom = new Room(name, items, animals, adjacentDoors);

        if (depth == 0) {
            return newRoom;
        }

        List<Direction> availableDirections = new ArrayList<>(Arrays.asList(Direction.values()));
        int randomAdjacentRoomNumber = random.nextInt(2, availableDirections.size() + 1);

        for (int i = 0; i < randomAdjacentRoomNumber; i++) {
            int randomIndex = random.nextInt(availableDirections.size());
            Direction newDirection = availableDirections.remove(randomIndex);

            Room linkedRoom = generateGameMap(depth - 1);

            connectRoom(newDirection, linkedRoom, newRoom);
        }

        return newRoom;
    }

    public void connectRoom(Direction direction, Room roomA, Room roomB) {
        Door door = new Door(roomA, roomB, random.nextBoolean());
        roomA.putDoor(direction, door);
        roomB.putDoor(Direction.getOppositeDirection(direction), door);
    }
}