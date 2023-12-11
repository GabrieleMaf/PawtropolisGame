package it.alten.doublechargg.pawtropolis.game.controller;

import it.alten.doublechargg.pawtropolis.game.enums.CardinalPoints;
import it.alten.doublechargg.pawtropolis.game.model.Item;
import it.alten.doublechargg.pawtropolis.game.model.Player;
import it.alten.doublechargg.pawtropolis.game.observer.Observer;

import java.util.Scanner;

public class GameController implements Observer {

    private Scanner scanner = new Scanner(System.in);

    public Player createPlayer(){
        System.out.println("Scegli il nome del tuo giocatore");
        return new Player(scanner.next(), this);
    }

    public void startGame(Player player1){
        MapController map = new MapController();

        player1.enterRoom(map.getRoomList().get(0));
        System.out.println(getHelp());
        while (true){
            chooseInput(scanner.next(), player1);
        }
    }

    public CardinalPoints getCardinalPoint(String input){

            switch (input.toLowerCase()){
                case "north":
                    return CardinalPoints.NORTH;
                case  "east":
                    return CardinalPoints.EAST;
                case "west":
                    return CardinalPoints.WEST;
                case "south":
                    return CardinalPoints.SOUTH;
                default:
                    throw new IllegalArgumentException("Punto cardinale inesistente");
            }


    }

    public String getHelp(){
        return String.format("Elenco comandi:%n" +
                "1) - bag: Guarda gli oggetti nella borsa%n" +
                "2) - look: Guarda la stanza%n" +
                "3) - go: Cambia stanza%n" +
                "4) - exit: Esci dal gioco");
    }

    public void chooseInput(String input, Player player){
        switch (input.toLowerCase()){
            case "bag":
                System.out.println(player.lookBagItems());
                break;
            case "look":
                System.out.println(player.look());
                break;
            case "go":
                System.out.println("Scrivi la cordinata");
                player.changeRoom(getCardinalPoint(scanner.next().toLowerCase()));
                break;
            case "exit":
                System.exit(0);
            default:
                System.out.println(getHelp());

        }

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
