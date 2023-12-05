package it.alten.doublechargg.pawtropolis.game.observer;

import it.alten.doublechargg.pawtropolis.game.model.Item;
import it.alten.doublechargg.pawtropolis.game.model.Room;

public interface Observable {

    void getItem(Item item, Room room);

    void dropItem(Item item, Room room);

    void registerObserver(Observer observer);

    void notifyObjectAdded(Item item);

    void notifyObjectRemoved(Item item);
}
