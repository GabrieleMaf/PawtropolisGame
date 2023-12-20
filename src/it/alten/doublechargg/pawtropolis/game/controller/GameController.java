package it.alten.doublechargg.pawtropolis.game.controller;

import it.alten.doublechargg.pawtropolis.game.MyLogger;
import it.alten.doublechargg.pawtropolis.game.model.Player;
import it.alten.doublechargg.pawtropolis.game.model.Room;

import java.util.Scanner;

public class GameController {

    private final MyLogger logger = MyLogger.getInstance();
    private final Scanner scanner = new Scanner(System.in);
    private final CommandController commandController = new CommandController();

    private boolean gameEnded = false;
    private Player player;
    private Room currentRoom;

    public Player getPlayer() {
        return player;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public void setGameEnded(boolean gameEnded) {
        this.gameEnded = gameEnded;
    }

    public Player createPlayer() {
        logger.logInfo("Choose your name");
        return new Player(scanner.nextLine());
    }

    public void startGame() {
        MapController map = new MapController();
        map.createMap();
        setPlayer(createPlayer());
        setCurrentRoom(map.getRoomList().getFirst());
        commandController.setGameController(this);
        commandController.associateCommands();
        logger.logInfo(commandController.getCommand("help").execute());
        while (!gameEnded) {
            logger.logInfo("Write your action");
            chooseInput(scanner.nextLine());
        }
    }

    public void chooseInput(String input) {
        String[] formattedInput = input.trim().toLowerCase().split("\\s+");
        switch (formattedInput.length){
            case 1:
                logger.logInfo(commandController.getCommand(formattedInput[0]).execute());
                break;
            case 2:
                logger.logInfo(commandController.getCommand(formattedInput[0]).execute(formattedInput[1]));
                break;
            default:
                logger.logInfo("Not valid Input");
        }
    }
}

