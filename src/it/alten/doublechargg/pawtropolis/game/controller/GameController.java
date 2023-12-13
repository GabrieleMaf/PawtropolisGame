package it.alten.doublechargg.pawtropolis.game.controller;

import it.alten.doublechargg.pawtropolis.game.model.Player;
import it.alten.doublechargg.pawtropolis.game.utilities.MyLogger;
import it.alten.doublechargg.pawtropolis.game.utilities.Utilities;

import java.util.Scanner;

public class GameController {

    private MyLogger logger = MyLogger.getInstance();
    private Scanner scanner = new Scanner(System.in);
    private CommandController commandController;

    public GameController() {
        this.commandController = new CommandController();
    }

    public MyLogger getLogger() {
        return logger;
    }

    public void setLogger(MyLogger logger) {
        this.logger = logger;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public CommandController getCommandController() {
        return commandController;
    }

    public void setCommandController(CommandController commandController) {
        this.commandController = commandController;
    }

    public Player createPlayer() {
        logger.logInfo("Choose your name");
        return new Player(scanner.nextLine());
    }

    public void startGame(Player player) {
        MapController map = new MapController();
        commandController.setPlayer(player);
        player.setCurrentRoom(map.getRoomList().get(0));
        logger.logInfo(CommandController.helpCommand());
        while (true) {
            logger.logInfo("Write your action");
            chooseInput(scanner.nextLine());
        }
    }


    public void chooseInput(String input) {
        String[] command = input.toLowerCase().split("\\s+");
        switch (command[0]) {
            case "bag":
                logger.logInfo(commandController.bagCommand());
                break;
            case "look":
                logger.logInfo(commandController.lookCommand());
                break;
            case "go":
                if (command.length > 1) {
                    commandController.goCommand(Utilities.getCardinalPoint(command[1]));
                }
                break;
            case "get":
                if (command.length > 1) {
                    commandController.getCommand(command[1]);
                }
                break;
            case "drop":
                if (command.length > 1) {
                    commandController.dropCommand(command[1]);
                }
                break;
            case "exit":
                System.exit(0);
                break;
            default:
                logger.logInfo(CommandController.helpCommand());

        }
    }

}
