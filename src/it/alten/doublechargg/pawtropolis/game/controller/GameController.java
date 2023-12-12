package it.alten.doublechargg.pawtropolis.game.controller;

import it.alten.doublechargg.pawtropolis.game.model.Player;
import it.alten.doublechargg.pawtropolis.game.utilities.MyLogger;
import it.alten.doublechargg.pawtropolis.game.utilities.Utilities;

import java.util.Scanner;

public class GameController {

    private MyLogger logger = MyLogger.getInstance();
    private Scanner scanner = new Scanner(System.in);

    public Player createPlayer() {
        logger.logInfo("Choose your name");
        return new Player(scanner.nextLine());
    }

    public void startGame(Player player1) {
        MapController map = new MapController();

        player1.setCurrentRoom(map.getRoomList().get(0));
        logger.logInfo(CommandController.helpCommand());
        while (true) {
            logger.logInfo("Write your action");
            chooseInput(scanner.nextLine(), player1);
        }
    }


    public void chooseInput(String input, Player player) {
        String[] command = input.toLowerCase().split(" ");
        switch (command[0]) {
            case "bag":
                logger.logInfo(CommandController.bagCommand(player));
                break;
            case "look":
                logger.logInfo(CommandController.lookCommand(player));
                break;
            case "go":
                if (command.length > 1) {
                    CommandController.goCommand(Utilities.getCardinalPoint(command[1]), player);
                }
                break;
            case "get":
                if (command.length > 1) {
                    CommandController.getCommand(player, command[1]);
                }
                break;
            case "drop":
                if (command.length > 1) {
                    CommandController.dropCommand(player, command[1]);
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
