package it.alten.doublechargg.pawtropolis.game.observer;

import it.alten.doublechargg.pawtropolis.game.model.Item;
import it.alten.doublechargg.pawtropolis.game.model.Player;

public interface Observable {

    void onEnterRoom();

    void onObjectAdded(Item item, Player player);

    void onObjectRemove(Item item, Player player);

}
