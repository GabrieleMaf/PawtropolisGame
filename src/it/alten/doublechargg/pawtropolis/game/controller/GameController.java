package it.alten.doublechargg.pawtropolis.game.controller;

import it.alten.doublechargg.pawtropolis.game.enums.CardinalPoints;
import it.alten.doublechargg.pawtropolis.game.model.Player;
import it.alten.doublechargg.pawtropolis.game.utilities.MyLogger;

import java.util.Scanner;

public class GameController {


    private final MyLogger logger = MyLogger.getInstance();
    private final Scanner scanner = new Scanner(System.in);
    private final CommandController commandController;

    public GameController(){
        this.commandController = new CommandController();
    }


    public Player createPlayer() {
        logger.logInfo("Choose your name");
        return new Player(scanner.nextLine());
    }

    public void startGame(){
        MapController map = new MapController();
        commandController.setPlayer(createPlayer());
        commandController.setCurrentRoom(map.getRoomList().getFirst());
        logger.logInfo(CommandController.helpCommand());
        while (true) {
            logger.logInfo("Write your action");
            chooseInput(scanner.nextLine());
        }
    }

    public void chooseInput(String input) {
        String[] command = input.toLowerCase().split("\\s+");
        if (command.length > 0) {
            switch (command[0]){
                case "go":
                    commandController.goCommand(CardinalPoints.valueOf(command[1].toUpperCase()));
                    break;
                case "bag":
                    logger.logInfo(commandController.bagCommand());
                    break;
                case "look":
                    logger.logInfo(commandController.lookCommand());
                    break;
                case "get":
                    commandController.getCommand(command[1]);
                    break;
                case "drop":
                    commandController.dropCommand(command[1]);
                    break;
                case "exit":
                    System.exit(0);
                    break;
                default:
                    logger.logInfo(CommandController.helpCommand());
            }
        }
    }
}
