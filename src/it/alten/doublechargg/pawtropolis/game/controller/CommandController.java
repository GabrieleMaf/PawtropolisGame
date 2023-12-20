package it.alten.doublechargg.pawtropolis.game.controller;

import it.alten.doublechargg.pawtropolis.game.command.Command;
import it.alten.doublechargg.pawtropolis.game.command.impl.*;

import java.util.HashMap;
import java.util.Map;

public class CommandController {

    private final Map<String, Command> commands = new HashMap<>();
    private GameController gameController;

    public void setGameController(GameController gameController) {
        this.gameController = gameController;
    }

    public void associateCommands() {
        commands.put("go", new GoCommand(gameController));
        commands.put("look", new LookCommand(gameController));
        commands.put("bag", new BagCommand(gameController));
        commands.put("get", new GetCommand(gameController));
        commands.put("drop", new DropCommand(gameController));
        commands.put("help", new HelpCommand());
        commands.put("exit", new ExitCommand(gameController));
    }

    public Command getCommand(String commandName) {
        return commands.get(commandName);
    }
}
