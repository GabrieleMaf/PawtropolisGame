package it.alten.doublechargg.pawtropolis.game.utilities;

import it.alten.doublechargg.pawtropolis.animals.utilities.AnimalUtils;
import it.alten.doublechargg.pawtropolis.game.controller.MapController;
import it.alten.doublechargg.pawtropolis.game.enums.CardinalPoints;
import it.alten.doublechargg.pawtropolis.game.model.Item;
import it.alten.doublechargg.pawtropolis.game.model.Player;
import it.alten.doublechargg.pawtropolis.game.model.Room;

import java.util.stream.Collectors;

public class RoomUtils {

    public static String getItemsOfCurrentRoom(Player player) {
        return player.getCurrentRoom()
                .getItems()
                .stream()
                .map(Item::getName)
                .collect(Collectors.joining(", "));
    }

    public static String getAnimalsOfCurrentRoom(Player player) {
        return player.getCurrentRoom()
                .getAnimals()
                .stream()
                .map(AnimalUtils::getNameFormat)
                .collect(Collectors.joining(", "));

    }

    public static String getDoorsOfCurrentRoom(Player player) {
        return player.getCurrentRoom()
                .getDoors()
                .keySet()
                .stream()
                .map(CardinalPoints::toString)
                .collect(Collectors.joining(", "));

    }

    public static Room getRoomByName(String name, MapController map) {
        return map.getRoomList()
                .stream()
                .filter(room -> room.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

}
