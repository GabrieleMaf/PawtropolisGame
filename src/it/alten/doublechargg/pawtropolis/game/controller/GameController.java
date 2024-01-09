package it.alten.doublechargg.pawtropolis.game.controller;

import it.alten.doublechargg.pawtropolis.game.MyLogger;
import it.alten.doublechargg.pawtropolis.game.CommandFactory;
import it.alten.doublechargg.pawtropolis.game.command.interfaces.CommandWithoutParam;
import it.alten.doublechargg.pawtropolis.game.model.Player;
import it.alten.doublechargg.pawtropolis.game.model.Room;

import java.lang.reflect.InvocationTargetException;
import java.util.Objects;
import java.util.Scanner;


public class GameController {

    private static final MyLogger logger = MyLogger.getInstance();
    private static final Scanner scanner = new Scanner(System.in);
    private static GameController instance;

    private final InputController inputController;
    private boolean gameEnded;
    private Player player;
    private Room currentRoom;

    private GameController() {
        gameEnded = false;
        inputController = InputController.getInstance();
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
        try {
            logger.logInfo(((CommandWithoutParam) CommandFactory.getInstance().createCommand("Help")).execute());
        } catch (InvocationTargetException |
                 NoSuchMethodException |
                 InstantiationException |
                 IllegalAccessException |
                 ClassNotFoundException e) {
            e.printStackTrace();
        }
        while (!gameEnded) {
            logger.logInfo("Write your action");
            try {
                inputController.handleInput(scanner.nextLine());
            } catch (InvocationTargetException |
                     NoSuchMethodException |
                     InstantiationException |
                     IllegalAccessException |
                     ClassNotFoundException e) {
                logger.logError("Not valid Input");
            }
        }
    }
}

