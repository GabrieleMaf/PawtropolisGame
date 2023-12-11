package it.alten.doublechargg.pawtropolis.game.controller;

import it.alten.doublechargg.pawtropolis.game.enums.CardinalPoints;
import it.alten.doublechargg.pawtropolis.game.model.Player;
import it.alten.doublechargg.pawtropolis.game.utilities.MyLogger;

import java.util.Scanner;

public class GameController {
    MyLogger logger = MyLogger.getInstance();
    private Player player1;

    private Scanner scanner = new Scanner(System.in);

    public Player createPlayer() {
        logger.logInfo("Scegli il nome del tuo giocatore");
        return new Player(scanner.next());
    }

    public void startGame(Player player1) {
        MapController map = new MapController();

        player1.enterRoom(map.getRoomList().get(0));
        logger.logInfo(getHelp());
        while (true) {
            chooseInput(scanner.next(), player1);
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
                throw new IllegalArgumentException("Punto cardinale inesistente");
        }


    }

    //Sistemare l'input dei comandi

    public String getHelp() {
        return String.format("Elenco comandi:%n" +
                "1) - bag: Guarda gli oggetti nella borsa%n" +
                "2) - look: Guarda la stanza%n" +
                "3) - go: Cambia stanza%n" +
                "4) - exit: Esci dal gioco");
    }

    public void chooseInput(String input, Player player) {
        switch (input.toLowerCase()) {
            case "bag":
                logger.logInfo(player.lookBagItems());
                break;
            case "look":
                logger.logInfo(player.lookRoom());
                break;
            case "go":
                logger.logInfo("Scrivi la cordinata");
                player.changeRoom(getCardinalPoint(scanner.next().toLowerCase()));
                break;
            case "exit":
                System.exit(0);
            default:
                logger.logInfo(getHelp());

        }
    }

}
