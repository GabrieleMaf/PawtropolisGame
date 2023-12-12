package it.alten.doublechargg.pawtropolis.game.controller;

import it.alten.doublechargg.pawtropolis.game.enums.CardinalPoints;
import it.alten.doublechargg.pawtropolis.game.model.Player;
import it.alten.doublechargg.pawtropolis.game.model.Room;
import it.alten.doublechargg.pawtropolis.game.utilities.MyLogger;

import java.util.Scanner;

public class GameController {

    private MyLogger logger = MyLogger.getInstance();
    private Scanner scanner = new Scanner(System.in);

    private Player player1;
    private Room room;

    public Player createPlayer() {
        logger.logInfo("Choose your name");
        return new Player(scanner.nextLine());
    }

    public void startGame(Player player1) {
        MapController map = new MapController();

        player1.setCurrentRoom(map.getRoomList().get(0));
        logger.logInfo(getHelp());
        while (true) {
            logger.logInfo("Write your action");
            chooseInput(scanner.nextLine(), player1);
        }
    }

    public CardinalPoints getCardinalPoint(String input) {

        switch (input.toLowerCase()) {
            case "north":
                return CardinalPoints.NORTH;
            case "east":
                return CardinalPoints.EAST;
            case "west":
                return CardinalPoints.WEST;
            case "south":
                return CardinalPoints.SOUTH;
            default:
                throw new IllegalArgumentException("Non existent cardinal point");
        }


    }

    //Sistemare l'input dei comandi

    public String getHelp() {
        return String.format("Command List:%n" +
                "1) - bag: Look the items in your bag%n" +
                "2) - look: Look around in the room, doors, items and animals%n" +
                "3) - go <direction>: Change room. Command example: go north%n" +
                "4) - get <item>: Get an item from room. Command example: get torch%n" +
                "5) - drop <item>: Drop an item into the room. Command example: drop torch%n" +
                "6) - exit: Exit from game");
    }

    public void chooseInput(String input, Player player) {
        String[] command = input.toLowerCase().split(" ");
        switch (command[0]) {
            case "bag":
                logger.logInfo(player.lookBagItems());
                break;
            case "look":
                logger.logInfo(player.lookRoom());
                break;
            case "go":
                if (command.length > 1) {
                    player.changeRoom(getCardinalPoint(command[1]));
                }
                break;
            case "get":
                if (command.length > 1){
                    player.getItem(player.getItemByNameFromRoom(command[1]));
                }
                break;
            case "drop":
                if (command.length > 1) {
                    player.dropItem(player.getItemByNameFromBag(command[1]));
                }
                break;
            case "exit":
                System.exit(0);
                break;
            default:
                logger.logInfo(getHelp());

        }
    }

}
