package it.alten.doublechargg.pawtropolis.game;

import it.alten.doublechargg.pawtropolis.game.command.interfaces.Command;
import it.alten.doublechargg.pawtropolis.game.command.interfaces.CommandWithParam;
import it.alten.doublechargg.pawtropolis.game.command.interfaces.CommandWithoutParam;

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
//TODO CORREGGERE ECCEZIONI
    public Command createCommand(String commandName) throws
            NoSuchMethodException,
            InvocationTargetException,
            InstantiationException,
            IllegalAccessException,
            ClassNotFoundException {
        commandName = commandName.substring(0,1).toUpperCase() + commandName.substring(1);
        return (Command) Class.forName(String.format("it.alten.doublechargg.pawtropolis.game.command.impl.%sCommand", commandName)).getConstructor().newInstance();
    }

    }

