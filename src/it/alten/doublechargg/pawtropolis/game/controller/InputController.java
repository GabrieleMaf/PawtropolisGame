package it.alten.doublechargg.pawtropolis.game.controller;

import it.alten.doublechargg.pawtropolis.game.MyLogger;
import it.alten.doublechargg.pawtropolis.game.command.interfaces.Command;
import it.alten.doublechargg.pawtropolis.game.CommandFactory;
import it.alten.doublechargg.pawtropolis.game.command.interfaces.CommandWithParam;
import it.alten.doublechargg.pawtropolis.game.command.interfaces.CommandWithoutParam;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class InputController {
    private static InputController instance;
    private final CommandFactory commandFactory;

    private static final MyLogger logger = MyLogger.getInstance();


    private InputController(){
        commandFactory = CommandFactory.getInstance();
    }

    public static synchronized InputController getInstance() {
        if (Objects.isNull(instance)) {
            instance = new InputController();
        }
        return instance;
    }

    public void handleInput(String input) throws
            InvocationTargetException,
            NoSuchMethodException,
            InstantiationException,
            IllegalAccessException,
            ClassNotFoundException{
        List<String> formattedInput = Arrays.asList(input.trim().toLowerCase().split("\\s+"));
        Command command = commandFactory.createCommand(formattedInput.getFirst());
        switch(command){
            case CommandWithoutParam commandWithoutParam:
                logger.logInfo(commandWithoutParam.execute());
                break;
            case CommandWithParam commandWithParam:
                logger.logInfo(commandWithParam.execute(formattedInput.getLast()));
                break;
            default:
                logger.logError("Not Valid Input");
        }
    }
}
