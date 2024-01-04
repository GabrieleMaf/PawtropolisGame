package it.alten.doublechargg.pawtropolis.game.controller;

import it.alten.doublechargg.pawtropolis.game.RoomFactory;
import it.alten.doublechargg.pawtropolis.game.enums.CardinalPoints;
import it.alten.doublechargg.pawtropolis.game.model.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MapController {

    private static final Random randomizer = new Random();
    private final List<Room> roomList;

    public MapController() {
        roomList = new ArrayList<>();
    }

    public void createMap() {
        RoomFactory roomFactory = RoomFactory.getInstance();
        final int roomNumber = randomizer.nextInt(8, 15);
        for (int i = 0; i <= roomNumber; i++) {
            roomList.add(roomFactory.createRoom());
        }
        for (int i = 0; i < roomNumber - 1; i++) {
            int selectedCardinalPointIndex = randomizer.nextInt(CardinalPoints.values().length);
            while (roomList.get(i).adjacentRoomExists(CardinalPoints.values()[selectedCardinalPointIndex])) {
                selectedCardinalPointIndex = randomizer.nextInt(CardinalPoints.values().length);
            }
            connectRooms(CardinalPoints.values()[selectedCardinalPointIndex], roomList.get(i), roomList.get(i + 1));
        }
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public void connectRooms(CardinalPoints cardinalPoint, Room room1, Room room2) {
        room1.addAdjacentRoom(cardinalPoint, room2);
        room2.addAdjacentRoom(CardinalPoints.getOppositeCardinalPoint(cardinalPoint), room1);
    }

}

