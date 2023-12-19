package it.alten.doublechargg.pawtropolis.game.controller;

import it.alten.doublechargg.pawtropolis.game.enums.CardinalPoints;
import it.alten.doublechargg.pawtropolis.game.model.Item;
import it.alten.doublechargg.pawtropolis.game.model.Player;
import it.alten.doublechargg.pawtropolis.game.model.Room;
import it.alten.doublechargg.pawtropolis.game.model.command.Command;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CommandController {

    private final Map<String, Command> commands = new HashMap<>();
    private Player player;
    private Room currentRoom;

    public Map<String, Command> getCommands() {
        return commands;
    }

    public void associateCommands() throws NoSuchMethodException {
            commands.put("go", CommandController.class.getMethod("goCommand", String.class));
            commands.put("look", CommandController.class.getMethod("lookCommand"));
            commands.put("bag", CommandController.class.getMethod("bagCommand"));
            commands.put("get", CommandController.class.getMethod("getCommand", String.class));
            commands.put("drop", CommandController.class.getMethod("dropCommand", String.class));
            commands.put("help",  CommandController.class.getMethod("helpCommand"));
            commands.put("exit", CommandController.class.getMethod("exitCommand"));
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }


}
