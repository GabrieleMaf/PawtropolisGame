package it.alten.doublechargg.pawtropolis.game.controller;

import it.alten.doublechargg.pawtropolis.game.enums.CardinalPoints;
import it.alten.doublechargg.pawtropolis.game.model.Item;
import it.alten.doublechargg.pawtropolis.game.model.Player;
import it.alten.doublechargg.pawtropolis.game.observer.Observer;

import java.util.Scanner;

public class GameController implements Observer {

    private Scanner scanner = new Scanner(System.in);
    private boolean gameEnded = false;


    public Player createPlayer(){
        System.out.println("Scegli il nome del tuo giocatore");
        return new Player(scanner.next(), this);
    }

    public void startGame(Player player1){
        Scanner scanner = new Scanner(System.in);
        MapController map = new MapController();

        player1.enterRoom(map.getRoomList().get(0));
        do {
            System.out.println("Cosa vuoi fare?");
            System.out.println("1-Guarda nella stanza");
            System.out.println("2-Cambia stanza");
            System.out.println("3-Esci dal gioco");
            switch (scanner.nextInt()){
                case 1:
                    System.out.println(player1.look());
                    break;
                case 2:
                    System.out.println("Quale porta scegli?");
                    System.out.println("1-NORTH");
                    System.out.println("2-EAST");
                    System.out.println("3-WEST");
                    System.out.println("4-SOUTH");
                    switch (scanner.nextInt()){
                        case 1:
                            player1.changeRoom(CardinalPoints.NORTH);
                            break;
                        case 2:
                            player1.changeRoom(CardinalPoints.EAST);
                            break;
                        case 3:
                            player1.changeRoom(CardinalPoints.WEST);
                            break;
                        case 4:
                            player1.changeRoom(CardinalPoints.SOUTH);
                            break;
                        default:
                            System.err.println("Operazione non permessa");
                            break;
                    }
                    break;
                case 3:
                    gameEnded = true;
                    break;
                default:
                    System.err.println("Operazione non permessa");
                    break;
            }
        } while (!gameEnded);
    }

    @Override
    public void notifyOnEnterRoom(Player player) {
        System.out.printf("%s è entrato nella stanza %s%n", player.getName(), player.getCurrentRoom().getName());
    }

    @Override
    public void notifyObjectAdded(Item item, Player player) {
        System.out.printf("%s è ha preso l'oggetto %s dalla stanza%n", player.getName(), item.getName());
    }

    @Override
    public void notifyObjectRemove(Item item, Player player) {
        System.out.printf("%s è ha preso l'oggetto %s dalla stanza%n", player.getName(), item.getName());
    }
}
