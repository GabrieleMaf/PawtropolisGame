package it.alten.doublechargg.pawtropolis.game.utilities;

import it.alten.doublechargg.pawtropolis.animals.model.abstracts.Animal;
import it.alten.doublechargg.pawtropolis.game.controller.GameController;
import it.alten.doublechargg.pawtropolis.game.enums.CardinalPoints;
import it.alten.doublechargg.pawtropolis.game.model.Door;
import it.alten.doublechargg.pawtropolis.game.model.Item;
import it.alten.doublechargg.pawtropolis.game.model.Player;

import java.util.Scanner;
import java.util.stream.Collectors;

public class Utilities {

    private Utilities(){}

    private static Scanner scanner = new Scanner(System.in);
    private static GameController gameController = new GameController();

    public static String getAnimalsOfCurrentRoom(Player player){
        return player.getCurrentRoom()
                .getAnimals()
                .stream()
                .map(Animal::getNameFormat)
                .collect(Collectors.joining(", "));

    }

    public static String getItemsOfCurrentRoom(Player player){
        return player.getCurrentRoom()
                .getItems()
                .stream()
                .map(Item::getName)
                .collect(Collectors.joining(", "));
    }

    public static String getDoorsOfCurrentRoom(Player player){
        return player.getCurrentRoom()
                .getDoors()
                .keySet()
                .stream()
                .map(CardinalPoints::toString)
                .collect(Collectors.joining(", "));

    }

    public static Item getItemByNameFromRoom(String name, Player player){
        return player.getCurrentRoom()
                .getItems()
                .stream()
                .filter(item -> item.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    public static Item getItemByNameFromBag(String name, Player player){
        return player.getBag()
                .getItems()
                .stream()
                .filter(item -> item.getName().equalsIgnoreCase(name.toLowerCase()))
                .findFirst()
                .orElse(null);
    }



}
