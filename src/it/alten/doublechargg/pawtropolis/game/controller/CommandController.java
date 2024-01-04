package it.alten.doublechargg.pawtropolis.game.controller;

import it.alten.doublechargg.pawtropolis.game.MyLogger;
import it.alten.doublechargg.pawtropolis.game.command.Command;
import it.alten.doublechargg.pawtropolis.game.command.impl.*;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class CommandController {

    private static final MyLogger logger = MyLogger.getInstance();
    private final Map<String, Class<? extends Command>> commands;

    public CommandController() {
        commands = new HashMap<>();
    }

    public void associateCommands() {
        commands.put("go", GoCommand.class);
        commands.put("look", LookCommand.class);
        commands.put("bag", BagCommand.class);
        commands.put("get", GetCommand.class);
        commands.put("drop", DropCommand.class);
        commands.put("help", HelpCommand.class);
        commands.put("exit", ExitCommand.class);
    }


    public Command createCommand(String commandName) throws
            NoSuchMethodException,
            InvocationTargetException,
            InstantiationException,
            IllegalAccessException {
        return Objects.nonNull(commands.get(commandName)) ? commands.get(commandName).getConstructor().newInstance() : null;
    }

    public void chooseInput(String input) throws
            InvocationTargetException,
            NoSuchMethodException,
            InstantiationException,
            IllegalAccessException {
        List<String> formattedInput = Arrays.asList(input.trim().toLowerCase().split("\\s+"));
        switch (formattedInput.size()) {
            case 1:
                if (Objects.nonNull(createCommand(formattedInput.getFirst()))) {
                    logger.logInfo(createCommand(formattedInput.getFirst()).execute());
                    break;
                }
            case 2:
                if (Objects.nonNull(createCommand(formattedInput.getFirst()))) {
                    logger.logInfo(createCommand(formattedInput.getFirst()).execute(formattedInput.getLast()));
                    break;
                }
            default:
                logger.logError("Not valid Input");
        }
    }

}
