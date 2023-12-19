package it.alten.doublechargg.pawtropolis.game.controller;

import it.alten.doublechargg.pawtropolis.game.enums.CardinalPoints;
import it.alten.doublechargg.pawtropolis.game.model.Item;
import it.alten.doublechargg.pawtropolis.game.model.Player;
import it.alten.doublechargg.pawtropolis.game.model.Room;
import it.alten.doublechargg.pawtropolis.game.model.command.Command;
import it.alten.doublechargg.pawtropolis.game.model.command.impl.*;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CommandController {

    private final Map<String, Class<? extends Command>> commands = new HashMap<>();
    private Player player;
    private Room currentRoom;

    public void associateCommands(){
            commands.put("go", GoCommand.class);
            commands.put("look", LookCommand.class);
            commands.put("bag", BagCommand.class);
            commands.put("get", GetCommand.class);
            commands.put("drop", DropCommand.class);
            commands.put("help",  HelpCommand.class);
            commands.put("exit", ExitCommand.class);
    }

    public String executeCommand(Command command){
        return command.execute();
    }

    public void createCommand(String commandName) throws NoSuchMethodException {
        commands.get(commandName).getMethod(commands.get(commandName).getSimpleName()).invoke(this);
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }


}
