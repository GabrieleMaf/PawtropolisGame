package it.alten.doublechargg.pawtropolis.game.observer;

import it.alten.doublechargg.pawtropolis.game.model.Item;

public interface Observable {

    void add(Observable observable, Object arg);

    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObjectAdded(Item item);

    void notifyObjectRemoved(Item item);
}
