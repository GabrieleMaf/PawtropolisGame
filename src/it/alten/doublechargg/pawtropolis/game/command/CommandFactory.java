package it.alten.doublechargg.pawtropolis.game.command;

import it.alten.doublechargg.pawtropolis.game.MyLogger;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class CommandFactory {

    private static CommandFactory instance;
    private static final MyLogger logger = MyLogger.getInstance();


    private CommandFactory(){}

    public static synchronized CommandFactory getInstance() {
        if (Objects.isNull(instance)) {
            instance = new CommandFactory();
        }
        return instance;
    }

    public Command createCommand(String commandName) throws
            NoSuchMethodException,
            InvocationTargetException,
            InstantiationException,
            IllegalAccessException,
            ClassNotFoundException {
        commandName = commandName.substring(0,1).toUpperCase() + commandName.substring(1);
        return (Command) Class.forName(String.format("it.alten.doublechargg.pawtropolis.game.command.impl.%sCommand", commandName)).getConstructor().newInstance();
    }

    public void chooseInput(String input) throws
            InvocationTargetException,
            NoSuchMethodException,
            InstantiationException,
            IllegalAccessException,
            ClassNotFoundException{
        List<String> formattedInput = Arrays.asList(input.trim().toLowerCase().split("\\s+"));
        Command command = createCommand(formattedInput.getFirst());
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

