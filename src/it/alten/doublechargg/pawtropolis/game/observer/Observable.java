package it.alten.doublechargg.pawtropolis.game.observer;

import it.alten.doublechargg.pawtropolis.game.model.Item;

public interface Observable {

    void add(Item item, String roomName);

    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObjectAdded(Item item);

    void notifyObjectRemoved(Item item);
}
