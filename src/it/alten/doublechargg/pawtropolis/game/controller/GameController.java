package it.alten.doublechargg.pawtropolis.game.controller;

import it.alten.doublechargg.pawtropolis.game.MyLogger;
import it.alten.doublechargg.pawtropolis.game.model.Player;
import it.alten.doublechargg.pawtropolis.game.model.Room;

import java.lang.reflect.InvocationTargetException;
import java.util.Objects;
import java.util.Scanner;

public class GameController {

    private static final MyLogger logger = MyLogger.getInstance();
    private static final Scanner scanner = new Scanner(System.in);
    private static GameController instance;

    private final CommandController commandController;
    private boolean gameEnded;
    private Player player;
    private Room currentRoom;

    private GameController() {
        gameEnded = false;
        commandController = new CommandController();
    }

    public static synchronized GameController getInstance() {
        if (Objects.isNull(instance)) {
            instance = new GameController();
        }
        return instance;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Room getCurrentRoom() {
        return currentRoom;
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
        commandController.associateCommands();
        try {
            logger.logInfo(commandController.createCommand("help").execute());
        } catch (InvocationTargetException |
                 NoSuchMethodException |
                 InstantiationException |
                 IllegalAccessException e) {
            e.printStackTrace();
        }
        while (!gameEnded) {
            logger.logInfo("Write your action");
            try {
                commandController.chooseInput(scanner.nextLine());
            } catch (InvocationTargetException |
                     NoSuchMethodException |
                     InstantiationException |
                     IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }


}

