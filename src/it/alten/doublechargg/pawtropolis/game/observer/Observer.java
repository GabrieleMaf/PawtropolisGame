package it.alten.doublechargg.pawtropolis.game.observer;

import it.alten.doublechargg.pawtropolis.game.model.Item;
import it.alten.doublechargg.pawtropolis.game.model.Player;

public interface Observer {

    void notifyOnEnterRoom(Player player);

    void notifyObjectAdded(Item item, Player player);

    void notifyObjectRemove(Item item, Player player);
}
