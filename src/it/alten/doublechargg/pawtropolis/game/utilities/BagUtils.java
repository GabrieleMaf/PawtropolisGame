package it.alten.doublechargg.pawtropolis.game.utilities;

import it.alten.doublechargg.pawtropolis.game.model.Item;
import it.alten.doublechargg.pawtropolis.game.model.Player;

public class BagUtils {

    public static int getTotalWeight(Player player) {
        return player.getBag()
                .getItems()
                .stream()
                .mapToInt(Item::getWeight)
                .sum();
    }

    public static int getFreeSpace(Player player){
        return player.getBag().getSlot() - getTotalWeight(player);
    }
}
