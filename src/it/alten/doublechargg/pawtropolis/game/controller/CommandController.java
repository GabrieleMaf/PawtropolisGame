package it.alten.doublechargg.pawtropolis.game.controller;

import it.alten.doublechargg.pawtropolis.game.enums.CardinalPoints;
import it.alten.doublechargg.pawtropolis.game.model.Item;
import it.alten.doublechargg.pawtropolis.game.model.Player;
import it.alten.doublechargg.pawtropolis.game.MyLogger;
import it.alten.doublechargg.pawtropolis.game.utilities.Utilities;

import java.util.Objects;
import java.util.stream.Collectors;

public class CommandController {

    private static final MyLogger logger = MyLogger.getInstance();
    private Player player;

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void goCommand(CardinalPoints cardinalPoint) {
        if (Objects.nonNull(player.getCurrentRoom().getDoors().get(cardinalPoint))) {
            player.setCurrentRoom(player.getCurrentRoom().getDoors().get(cardinalPoint).getRoom2());
            logger.logInfo(String.format("%s entered the room %s%n", player.getName(), player.getCurrentRoom().getName()));
        } else {
            logger.logInfo("Not existent door");
        }
    }

    public String lookCommand() {
        return String.format("You are in room %s%n" +
                        "Items: %s%n" +
                        "NPC: %s%n" +
                        "Doors: %s",
                player.getCurrentRoom().getName(),
                Utilities.getItemsOfCurrentRoom(player),
                Utilities.getAnimalsOfCurrentRoom(player),
                Utilities.getDoorsOfCurrentRoom(player));
    }

    public String bagCommand() {
        if (player.getBag().getItems().isEmpty()) {
            return "Empty bag";
        }
        return player.getBag().getItems().stream()
                .map(Item::toString)
                .collect(Collectors.joining(""));
    }

    public void getCommand(String itemName) {
        Item item = Utilities.getItemByNameFromRoom(itemName, player);
        if (player.getCurrentRoom().getItems().contains(item)) {
            if (item.getWeight() + Utilities.getTotalWeight(player.getBag()) < player.getBag().getSlot()) {
                player.getBag().getItems().add(item);
                player.getCurrentRoom().getItems().remove(item);
                logger.logInfo(String.format("%s got the %s from the room%n", player.getName(), item.getName()));
            } else {
                logger.logWarning("Not enough space in bag");
            }
        } else {
            logger.logInfo("Item not present in this room");
        }
    }

    public void dropCommand(String itemName) {
        Item item = Utilities.getItemByNameFromBag(itemName, player);
        if (player.getBag().getItems().remove(item)) {
            player.getCurrentRoom().getItems().add(item);
            logger.logInfo(String.format("%s dropped the %s in the room%n", player.getName(), item.getName()));
        } else {
            logger.logInfo("Item not present in the bag");
        }
    }

    public static String helpCommand() {
        return String.format("Command List:%n" +
                "1) - bag: Look the items in your bag%n" +
                "2) - look: Look around in the room, doors, items and animals%n" +
                "3) - go <direction>: Change room. Command example: go north%n" +
                "4) - get <item>: Get an item from room. Command example: get torch%n" +
                "5) - drop <item>: Drop an item into the room. Command example: drop torch%n" +
                "6) - exit: Exit from game");
    }

}
