package it.alten.doublechargg.pawtropolis.game.model;

import it.alten.doublechargg.pawtropolis.animals.model.abstracts.Animal;
import it.alten.doublechargg.pawtropolis.game.enums.CardinalPoints;

import java.util.*;
import java.util.stream.Collectors;

public class Room {

    private static Long count = 1L;
    private String name;
    private final List<Item> items;
    private final List<Animal> animals;
    private final EnumMap<CardinalPoints, Room> adjacentRooms;



    public Room(String name) {
        count++;
        this.name = name;
        items = new ArrayList<>();
        animals = new ArrayList<>();
        adjacentRooms = new EnumMap<>(CardinalPoints.class);
    }

    public static Long getCountRoom() {
        return count;
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

    public Map<CardinalPoints, Room> getAdjacentRooms() {
        return adjacentRooms;
    }

    public int getItemsNumber(){
        return items.size();
    }
    public boolean addItem(Item item){
        return items.add(item);
    }
    public boolean removeItem(Item item){
        return items.remove(item);
    }

    public void addAdjacentRoom(CardinalPoints cardinalPoint, Room room){
        adjacentRooms.put(cardinalPoint, room);
    }

    public void removeAdjacentRoom(CardinalPoints cardinalPoint){
        adjacentRooms.remove(cardinalPoint);
    }

    public int getAnimalsNumber(){
        return animals.size();
    }

    public boolean addAnimal(Animal animal){
        return animals.add(animal);
    }
    public boolean removeItem(Animal animal){
        return animals.remove(animal);
    }

    public Room getAdjacentRoomByCardinalPoint(CardinalPoints cardinalPoint){
        return adjacentRooms.get(cardinalPoint);
    }

    public boolean adjacentRoomExists(CardinalPoints cardinalPoint){
        return Objects.nonNull(adjacentRooms.get(cardinalPoint));
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
