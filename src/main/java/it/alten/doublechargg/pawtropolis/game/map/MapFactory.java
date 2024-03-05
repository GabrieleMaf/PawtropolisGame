package it.alten.doublechargg.pawtropolis.game.map;

import it.alten.doublechargg.pawtropolis.game.map.domain.Door;
import it.alten.doublechargg.pawtropolis.game.map.domain.Room;
import it.alten.doublechargg.pawtropolis.game.map.enums.CardinalPoints;
import lombok.Getter;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
@Component
public class MapFactory {

    private static final Random RANDOMIZER = new Random();
    private final List<Room> roomList;
    private final RoomFactory roomFactory;

    @Autowired
    private MapFactory(RoomFactory roomFactory) {
        this.roomFactory = roomFactory;
        roomList = new ArrayList<>();
    }

    public void createMap() {
        val MINIMUM_ROOMS = 8;
        val MAXIMUM_ROOMS = 15;
        val roomNumber = RANDOMIZER.nextInt(MINIMUM_ROOMS, MAXIMUM_ROOMS + 1);

        for (int i = 0; i <= roomNumber; i++) {
            roomList.add(roomFactory.createRoom());
        }

        for (int i = 0; i < roomNumber - 1; i++) {

            var selectedCardinalPointIndex = RANDOMIZER.nextInt(CardinalPoints.values().length);
            var randomCardinalPoint = CardinalPoints.values()[selectedCardinalPointIndex];

            while (roomList.get(i).adjacentRoomExists(randomCardinalPoint)) {
                selectedCardinalPointIndex = RANDOMIZER.nextInt(CardinalPoints.values().length);
                randomCardinalPoint = CardinalPoints.values()[selectedCardinalPointIndex];
            }
            connectRooms(randomCardinalPoint, roomList.get(i), roomList.get(i + 1));
        }
    }

    public void connectRooms(CardinalPoints cardinalPoint, Room roomA, Room roomB) {
        var door = new Door(roomA, roomB, RANDOMIZER.nextBoolean());

        if (door.isLocked()){
            roomA.addItem(RoomFactory.items.get(3));
        }
        roomA.addDoor(cardinalPoint, door);
        roomB.addDoor(CardinalPoints.getOppositeCardinalPoint(cardinalPoint), door);
    }

}

