package it.alten.doublechargg.pawtropolis.game.utilities;

import it.alten.doublechargg.pawtropolis.game.model.Item;
import it.alten.doublechargg.pawtropolis.game.model.Player;

public class ItemUtils {


    public static Item getItemByNameFromRoom(String name, Player player) {
        return player.getCurrentRoom()
                .getItems()
                .stream()
                .filter(item -> item.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    public static Item getItemByNameFromBag(String name, Player player) {
        return player.getBag()
                .getItems()
                .stream()
                .filter(item -> item.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }
}
