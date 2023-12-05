package it.alten.doublechargg.pawtropolis.game;

import it.alten.doublechargg.pawtropolis.game.enums.CardinalPoints;
import it.alten.doublechargg.pawtropolis.game.factory.RoomFactory;
import it.alten.doublechargg.pawtropolis.game.model.Door;
import it.alten.doublechargg.pawtropolis.game.model.Room;

import java.util.ArrayList;
import java.util.List;

public class MapController {
    private final List<Room> roomList;

    public MapController() {
        roomList = new ArrayList<>();
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public void addRoom(Room room){
        roomList.add(room);
    }

    public Room getRoomByName(String name){
        return roomList.stream()
                .filter(room -> room.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public CardinalPoints getOpposite(CardinalPoints cardinalPoint) {
        switch (cardinalPoint) {
            case NORTH -> {
                return CardinalPoints.SOUTH;
            }
            case SOUTH -> {
                return CardinalPoints.NORTH;
            }
            case EAST -> {
                return CardinalPoints.WEST;
            }
            case WEST -> {
                return CardinalPoints.EAST;
            }
            default -> {
                return null;
            }
        }
    }

    public void createMap() {
        for (int i = 0; i<=10; i++){
            roomList.add(new Room(Integer.toString(i)));
        }
    }

    public void connectRooms(CardinalPoints cardinalPoint1, Room room1, Room room2){
        Door door = new Door(room1, room2);
        room1.getDoors().put(cardinalPoint1, door);
        room2.getDoors().put(getOpposite(cardinalPoint1), door);
    }
}

