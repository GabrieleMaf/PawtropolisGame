package it.alten.doublechargg.pawtropolis.game.controller;

import it.alten.doublechargg.pawtropolis.game.enums.CardinalPoints;
import it.alten.doublechargg.pawtropolis.game.model.Item;
import it.alten.doublechargg.pawtropolis.game.model.Player;
import it.alten.doublechargg.pawtropolis.game.model.Room;
import it.alten.doublechargg.pawtropolis.game.utilities.MyLogger;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.Objects;

public class CommandController {

    private static final MyLogger logger = MyLogger.getInstance();

    private Map<String, Method> commands;
    private Player player;
    private Room currentRoom;

    /*public void associateCommands() {
        commands.put("go", CommandController.class.getMethod("goCommand", CardinalPoints.class));
        commands.put("look", CommandController.class.getMethod("lookCommand"));
        commands.put("bag", CommandController.class.getMethod("bagCommand"));
        commands.put("get", CommandController.class.getMethod("getCommand", String.class));
        commands.put("drop", CommandController.class.getMethod("dropCommand", String.class));
    }*/

    public static String helpCommand() {
        return String.format("Command List:%n" +
                "1) - bag: Look the items in your bag%n" +
                "2) - look: Look around in the room, doors, items and animals%n" +
                "3) - go <direction>: Change room. Command example: go north%n" +
                "4) - get <item>: Get an item from room. Command example: get torch%n" +
                "5) - drop <item>: Drop an item into the room. Command example: drop torch%n" +
                "6) - help: Prints this command%n" +
                "7) - exit: Exit from game");
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public void goCommand(CardinalPoints cardinalPoint) {
        if (Objects.nonNull(currentRoom.getAdjacentRooms().get(cardinalPoint))) {
            currentRoom = (currentRoom.getAdjacentRooms().get(cardinalPoint));
            logger.logInfo(String.format("%s entered the room %s%n", player.getName(), currentRoom.getName()));
        } else {
            logger.logInfo("Not existent door");
        }
    }

    public String lookCommand() {
        return currentRoom.toString();
    }

    public String bagCommand() {
        return player.getBag().toString();
    }

    public void getCommand(String itemName) {
        Item item = currentRoom.getItemByName(itemName);
        if (currentRoom.getItems().contains(item)) {
            if (player.getBag().addItem(item)) {
                currentRoom.getItems().remove(item);
                logger.logInfo(String.format("%s got the %s from the room%n", player.getName(), item.name()));
            } else {
                logger.logWarning("Not enough space in bag");
            }
        } else {
            logger.logWarning("Item not present in this room");
        }
    }

    public void dropCommand(String itemName) {
        Item item = player.getBag().getItemByName(itemName);
        if (player.getBag().removeItem(item)) {
            currentRoom.getItems().add(item);
            logger.logInfo(String.format("%s dropped the %s in the room%n", player.getName(), item.name()));
        } else {
            logger.logWarning("Item not present in the bag");
        }
    }

}
