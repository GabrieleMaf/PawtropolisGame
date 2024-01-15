package it.alten.doublechargg.pawtropolis.game.controller;

import it.alten.doublechargg.pawtropolis.game.RoomFactory;
import it.alten.doublechargg.pawtropolis.game.enums.CardinalPoints;
import it.alten.doublechargg.pawtropolis.game.model.Room;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@Getter
@Component
public class MapController {

    private static final Random randomizer = new Random();
    private final List<Room> roomList = new ArrayList<>();
    private RoomFactory roomFactory;
    private MapController(RoomFactory roomFactory) {
        this.roomFactory = roomFactory;
    }

    public void createMap() {

        val minimumRooms = 8;
        val maximumRooms = 15;
        final int roomNumber = randomizer.nextInt(minimumRooms, maximumRooms+1);
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

    public void connectRooms(CardinalPoints cardinalPoint, Room room1, Room room2) {
        room1.addAdjacentRoom(cardinalPoint, room2);
        room2.addAdjacentRoom(CardinalPoints.getOppositeCardinalPoint(cardinalPoint), room1);
    }

}

