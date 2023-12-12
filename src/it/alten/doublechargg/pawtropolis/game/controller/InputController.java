package it.alten.doublechargg.pawtropolis.game.controller;

import it.alten.doublechargg.pawtropolis.animals.model.abstracts.Animal;
import it.alten.doublechargg.pawtropolis.game.enums.CardinalPoints;
import it.alten.doublechargg.pawtropolis.game.model.Item;
import it.alten.doublechargg.pawtropolis.game.model.Player;
import it.alten.doublechargg.pawtropolis.game.model.Room;
import it.alten.doublechargg.pawtropolis.game.utilities.MyLogger;
import it.alten.doublechargg.pawtropolis.game.utilities.Utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;

public class InputController {

    private static final MyLogger logger = MyLogger.getInstance();


    public static String readString() {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader inputReader = new BufferedReader(input);
        try {
            return inputReader.readLine();
        } catch (IOException e) {
            System.err.println("Error while reading user input");
            return "";
        }
    }

    public static void goCommand(CardinalPoints cardinalPoint, Player player) {
        if (Objects.nonNull(player.getCurrentRoom().getDoors().get(cardinalPoint))) {
            player.setCurrentRoom( player.getCurrentRoom().getDoors().get(cardinalPoint).getRoom2());
            logger.logInfo(String.format("%s entered the room %s%n", player.getName(), player.getCurrentRoom().getName()));
        } else {
            logger.logInfo("Not existant door");
        }
    }

    public static String lookCommand(Player player){
        return String.format("You are in room %s%n"+
                "Items: %s%n" +
                 "NPC: %s%n" +
                 "Doors: %s",
        player.getCurrentRoom().getName(),
        Utilities.getItemsOfCurrentRoom(player),
        Utilities.getAnimalsOfCurrentRoom(player),
        Utilities.getDoorsOfCurrentRoom(player));
    }

    public static String bagCommand(Player player){
        if(player.getBag().getItems().isEmpty()){
            return "Empty bag";
        }
        return player.getBag().getItems().stream()
                .map(Item::toString)
                .collect(Collectors.joining(", "));
    }

    public static void getCommand(Player player){
        if (player.getCurrentRoom.getItems().contains(item) && bag.addItem(item)) {
            currentRoom.getItems().remove(item);
            logger.logInfo(String.format("%s get the %s from the room%n", this.name, item.getName()));
        } else if (!currentRoom.getItems().contains(item)) {
            logger.logInfo("Item not present in this room");
        }
    }




}
