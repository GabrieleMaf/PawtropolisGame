package it.alten.doublechargg.pawtropolis.game.controller;

import it.alten.doublechargg.pawtropolis.game.enums.CardinalPoints;
import it.alten.doublechargg.pawtropolis.game.model.Item;
import it.alten.doublechargg.pawtropolis.game.model.Player;
import it.alten.doublechargg.pawtropolis.game.model.Room;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CommandController {

    private Map<String, Method> commands;
    private Player player;
    private Room currentRoom;

    public CommandController(){
        commands = new HashMap<>();
    }

    public Map<String, Method> getCommands() {
        return commands;
    }

    public void associateCommands(){
        try {
        commands.put("go", CommandController.class.getMethod("goCommand", String.class));
        commands.put("look", CommandController.class.getMethod("lookCommand"));
        commands.put("bag", CommandController.class.getMethod("bagCommand"));
        commands.put("get", CommandController.class.getMethod("getCommand", String.class));
        commands.put("drop", CommandController.class.getMethod("dropCommand", String.class));
        commands.put("help",  CommandController.class.getMethod("helpCommand"));
        commands.put("exit", CommandController.class.getMethod("exitCommand"));
    }catch (NoSuchMethodException e){
            e.printStackTrace();
        }

    }

    public String helpCommand() {
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

    public String goCommand(String cardinalPointName) {
        CardinalPoints cardinalPoint = CardinalPoints.findByName(cardinalPointName);
        if(Objects.isNull(cardinalPoint)){
            return "Not valid input";
        }
        if (Objects.nonNull(currentRoom.getAdjacentRooms().get(cardinalPoint))) {
            currentRoom = (currentRoom.getAdjacentRooms().get(cardinalPoint));
            return String.format("%s entered the room %s%n", player.getName(), currentRoom.getName());
        } else {
            return "Not existent door";
        }
    }

    public String lookCommand() {
        return currentRoom.toString();
    }

    public String bagCommand() {
        return player.getBag().toString();
    }

    public String getCommand(String itemName) {
        Item item = currentRoom.getItemByName(itemName);
        if (currentRoom.getItems().contains(item)) {
            if (player.getBag().addItem(item)) {
                currentRoom.getItems().remove(item);
                return String.format("%s got the %s from the room%n", player.getName(), item.name());
            } else {
                return "Not enough space in bag";
            }
        } else {
            return "Item not present in this room";
        }
    }

    public String dropCommand(String itemName) {
        Item item = player.getBag().getItemByName(itemName);
        if (player.getBag().removeItem(item)) {
            currentRoom.getItems().add(item);
            return String.format("%s dropped the %s in the room%n", player.getName(), item.name());
        } else {
            return "Item not present in the bag";
        }
    }

    public String exitCommand(){
        System.exit(0);
        return "Exiting game";
    }

}
