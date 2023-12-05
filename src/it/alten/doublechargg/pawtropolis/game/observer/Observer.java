package it.alten.doublechargg.pawtropolis.game.observer;

import it.alten.doublechargg.pawtropolis.game.model.Item;
import it.alten.doublechargg.pawtropolis.game.model.Room;

public interface Observer {
    void onEnterRoom(Room room);
    void onLeaveRoom(Room room);

    void onObjectAdded(Item item, Room room);
    void onObjectRemove(Item item, Room room);

}
