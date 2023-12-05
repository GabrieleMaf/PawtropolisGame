package it.alten.doublechargg.pawtropolis.game.observer;

import it.alten.doublechargg.pawtropolis.game.model.Item;

public interface Observer {

    void onObjectAdded(Item item, String roomName);

    void onObjectRemoved(Item item, String roomName);




}
