package it.alten.doublechargg.pawtropolis.game.model;

import it.alten.doublechargg.pawtropolis.animals.model.abstracts.Animal;
import it.alten.doublechargg.pawtropolis.game.enums.CardinalPoints;

import java.util.*;
import java.util.stream.Collectors;

public class Room {

    private static int idRoom = 1;
    private final List<Item> items;
    private final List<Animal> animals;
    private final EnumMap<CardinalPoints, Room> adjacentRooms;
    private String name;


    public Room(String name) {
        idRoom++;
        this.name = name;
        items = new ArrayList<>();
        animals = new ArrayList<>();
        adjacentRooms = new EnumMap<>(CardinalPoints.class);
    }

    public static int getIdRoom() {
        return idRoom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getItems() {
        return items;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public Map<CardinalPoints, Room> getAdjacentRooms() {
        return adjacentRooms;
    }

    public Item getItemByName(String name) {
        return items.stream()
                .filter(item -> item.name().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    private String getItemsListAsString() {
        return items.stream()
                .map(Item::name)
                .collect(Collectors.joining(", "));
    }

    private String getAnimalsListAsString() {
        return animals.stream()
                .map(animal -> String.format("%s(%s)", animal.getName(), animal.getClass().getSimpleName()))
                .collect(Collectors.joining(", "));

    }

    private String getAdjacentRoomListAsString() {
        return adjacentRooms.keySet()
                .stream()
                .map(CardinalPoints::getName)
                .collect(Collectors.joining(", "));

    }

    @Override
    public String toString() {
        return String.format("You are in room %s%n" +
                        "Items: %s%n" +
                        "NPC: %s%n" +
                        "Doors: %s",
                name, getItemsListAsString(), getAnimalsListAsString(), getAdjacentRoomListAsString());
    }
}
