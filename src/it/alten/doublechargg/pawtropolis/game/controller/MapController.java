package it.alten.doublechargg.pawtropolis.game.controller;

import it.alten.doublechargg.pawtropolis.game.enums.CardinalPoints;
import it.alten.doublechargg.pawtropolis.game.model.Room;
import it.alten.doublechargg.pawtropolis.game.utilities.RoomFactory;

import java.util.ArrayList;
import java.util.List;

public class MapController {
    private final List<Room> roomList = new ArrayList<>();

    public void createMap(){
        RoomFactory roomFactory = RoomFactory.getInstance();
        for (int i = 0; i <= 10; i++) {
            roomList.add(roomFactory.createRoom());
        }
        connectRooms(CardinalPoints.NORTH, roomList.get(0), roomList.get(1));
        connectRooms(CardinalPoints.WEST, roomList.get(1), roomList.get(2));
        connectRooms(CardinalPoints.NORTH, roomList.get(1), roomList.get(3));
        connectRooms(CardinalPoints.NORTH, roomList.get(3), roomList.get(4));
        connectRooms(CardinalPoints.EAST, roomList.get(4), roomList.get(5));
        connectRooms(CardinalPoints.SOUTH, roomList.get(5), roomList.get(6));
        connectRooms(CardinalPoints.EAST, roomList.get(6), roomList.get(7));
        connectRooms(CardinalPoints.EAST, roomList.get(7), roomList.get(8));
        connectRooms(CardinalPoints.EAST, roomList.get(8), roomList.get(9));
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public void connectRooms(CardinalPoints cardinalPoint, Room room1, Room room2) {
        room1.getAdjacentRooms().put(cardinalPoint, room2);
        room2.getAdjacentRooms().put(CardinalPoints.getOppositeCardinalPoint(cardinalPoint), room1);
    }

}

