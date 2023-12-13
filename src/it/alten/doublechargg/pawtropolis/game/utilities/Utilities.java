package it.alten.doublechargg.pawtropolis.game.utilities;

import it.alten.doublechargg.pawtropolis.animals.model.abstracts.Animal;
import it.alten.doublechargg.pawtropolis.game.controller.MapController;
import it.alten.doublechargg.pawtropolis.game.enums.CardinalPoints;
import it.alten.doublechargg.pawtropolis.game.model.Bag;
import it.alten.doublechargg.pawtropolis.game.model.Item;
import it.alten.doublechargg.pawtropolis.game.model.Player;
import it.alten.doublechargg.pawtropolis.game.model.Room;

import java.util.stream.Collectors;

public class Utilities {

    private Utilities() {
    }

    public static String getNameFormat(Animal animal) {
        return String.format("%s(%s)", animal.getName(), animal.getClass().getSimpleName());
    }

    public static int getTotalWeight(Bag bag) {
        return bag.getItems().stream()
                .mapToInt(Item::getWeight)
                .sum();
    }

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
                .map(Utilities::getNameFormat)
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

    public static CardinalPoints getCardinalPoint(String input) {
        return switch (input.toLowerCase()) {
            case "north" -> CardinalPoints.NORTH;
            case "east" -> CardinalPoints.EAST;
            case "west" -> CardinalPoints.WEST;
            case "south" -> CardinalPoints.SOUTH;
            default -> throw new IllegalArgumentException("Non existent cardinal point");
        };
    }

    public static CardinalPoints getOppositeCardinalPoint(CardinalPoints cardinalPoint) {
        switch (cardinalPoint) {
            case NORTH -> {
                return CardinalPoints.SOUTH;
            }
            case SOUTH -> {
                return CardinalPoints.NORTH;
            }
            case EAST -> {
                return CardinalPoints.WEST;
            }
            default -> {
                return CardinalPoints.EAST;
            }
        }
    }

    public static Room getRoomByName(String name, MapController map) {
        return map.getRoomList()
                .stream()
                .filter(room -> room.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

}
