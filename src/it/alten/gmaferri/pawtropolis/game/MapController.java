package it.alten.gmaferri.pawtropolis.game;

import it.alten.gmaferri.pawtropolis.game.factory.RoomFactory;
import it.alten.gmaferri.pawtropolis.game.model.Room;

public class MapController {
    private Room[][] rooms;

    public MapController(){
        rooms = createMap();
    }

    public Room[][] getRooms() {
        return rooms;
    }

    public void setRooms(Room[][] rooms) {
        this.rooms = rooms;
    }

    public static Room[][] createMap(){
        RoomFactory roomFactory = RoomFactory.getInstance();
        return new Room[][] {
                {roomFactory.createRoom(), null, null, null},
                {roomFactory.createRoom(), roomFactory.createRoom(), roomFactory.createRoom(), null},
                {roomFactory.createRoom(), roomFactory.createRoom(), null, roomFactory.createRoom() },
                {roomFactory.createRoom(), roomFactory.createRoom(), null, roomFactory.createRoom()}
        };

    }



}
