package it.alten.doublechargg.pawtropolis.game.controller;

import it.alten.doublechargg.pawtropolis.game.enums.CardinalPoints;
import it.alten.doublechargg.pawtropolis.game.factory.RoomFactory;
import it.alten.doublechargg.pawtropolis.game.model.Door;
import it.alten.doublechargg.pawtropolis.game.model.Room;
import it.alten.doublechargg.pawtropolis.game.utilities.Utilities;

import java.util.ArrayList;
import java.util.List;

public class MapController {
    private final List<Room> roomList;
    private RoomFactory roomFactory = RoomFactory.getInstance();

    public MapController() {
        roomList = createMap();
    }

    public List<Room> getRoomList() {
        return roomList;
    }


    public List<Room> createMap() {
        List<Room> roomMap = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            roomMap.add(roomFactory.createRoom());
        }
        connectRooms(CardinalPoints.NORTH, roomMap.get(0), roomMap.get(1));
        connectRooms(CardinalPoints.WEST, roomMap.get(1), roomMap.get(2));
        connectRooms(CardinalPoints.NORTH, roomMap.get(1), roomMap.get(3));
        connectRooms(CardinalPoints.NORTH, roomMap.get(3), roomMap.get(4));
        connectRooms(CardinalPoints.EAST, roomMap.get(4), roomMap.get(5));
        connectRooms(CardinalPoints.SOUTH, roomMap.get(5), roomMap.get(6));
        connectRooms(CardinalPoints.EAST, roomMap.get(6), roomMap.get(7));
        connectRooms(CardinalPoints.EAST, roomMap.get(7), roomMap.get(8));
        connectRooms(CardinalPoints.EAST, roomMap.get(8), roomMap.get(9));
        return roomMap;
    }

    public void connectRooms(CardinalPoints cardinalPoint1, Room room1, Room room2) {
        Door door1 = new Door(room1, room2);
        room1.getDoors().put(cardinalPoint1, door1);
        Door door2 = new Door(room2, room1);
        room2.getDoors().put(Utilities.getOppositeCardinalPoint(cardinalPoint1), door2);
    }


}

