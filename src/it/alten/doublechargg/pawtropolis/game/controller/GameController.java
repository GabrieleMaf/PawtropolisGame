package it.alten.doublechargg.pawtropolis.game.controller;

import it.alten.doublechargg.pawtropolis.game.model.Player;
import it.alten.doublechargg.pawtropolis.game.utilities.MyLogger;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.Scanner;

public class GameController {


    private final MyLogger logger = MyLogger.getInstance();
    private final Scanner scanner = new Scanner(System.in);
    private final CommandController commandController;

    public GameController() {
        this.commandController = new CommandController();
    }


    public Player createPlayer() {
        logger.logInfo("Choose your name");
        return new Player(scanner.nextLine());
    }

    public void startGame() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        MapController map = new MapController();
        map.createMap();
        commandController.setPlayer(createPlayer());
        commandController.setCurrentRoom(map.getRoomList().getFirst());
        commandController.associateCommands();
        logger.logInfo(commandController.helpCommand());
        while (true) {
            logger.logInfo("Write your action");
            chooseInput(scanner.nextLine());
        }
    }

    public void chooseInput(String input) throws InvocationTargetException, IllegalAccessException {
        String[] command = input.toLowerCase().split("\\s+");
        if (command.length > 0) {
            Method method = commandController.getCommands().get(command[0]);
            if (Objects.nonNull(method)) {
                if (command.length > 1) {
                    logger.logInfo((String) method.invoke(commandController, command[1]));
                } else {
                    logger.logInfo((String) method.invoke(commandController));
                }
            } else {
                logger.logError("Not valid input");
            }
        } else {
            logger.logError("Not valid input");
        }
    }
}

