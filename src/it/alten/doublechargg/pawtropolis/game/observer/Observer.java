package it.alten.doublechargg.pawtropolis.game.observer;

import it.alten.doublechargg.pawtropolis.game.model.Item;
import it.alten.doublechargg.pawtropolis.game.model.Player;
import it.alten.doublechargg.pawtropolis.game.model.Room;

public interface Observer {
    void onEnterRoom(Room room, Player player);

    void onObjectAdded(Item item, Room room, Player player);

    void onObjectRemove(Item item, Room room, Player player);

}
