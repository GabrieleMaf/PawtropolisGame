package it.alten.doublechargg.pawtropolis.game.map.domain;

import it.alten.doublechargg.pawtropolis.game.animals.domain.abstracts.Animal;
import it.alten.doublechargg.pawtropolis.game.map.enums.CardinalPoints;
import it.alten.doublechargg.pawtropolis.game.player.domain.Item;
import lombok.Getter;
import lombok.Setter;

import java.util.*;
import java.util.stream.Collectors;


public class Room {

    private final List<Item> items;
    private final List<Animal> animals;
    private final EnumMap<CardinalPoints, Door> adjacentRooms;
    @Getter
    @Setter
    private String name;

    public Room(String name) {
        this.name = name;
        items = new ArrayList<>();
        animals = new ArrayList<>();
        adjacentRooms = new EnumMap<>(CardinalPoints.class);
    }

    public int getItemsNumber() {
        return items.size();
    }

    public boolean addItem(Item item) {
        return items.add(item);
    }

    public boolean removeItem(Item item) {
        return items.remove(item);
    }

    public boolean containsItem(Item item) {
        return items.contains(item);
    }

    public void addDoor(CardinalPoints cardinalPoint, Door door) {
        adjacentRooms.put(cardinalPoint, door);
    }

    public void removeAdjacentRoom(CardinalPoints cardinalPoint) {
        adjacentRooms.remove(cardinalPoint);
    }

    public boolean adjacentRoomExists(CardinalPoints cardinalPoint) {
        return Objects.nonNull(adjacentRooms.get(cardinalPoint));
    }

    public int getAnimalNumber() {
        return animals.size();
    }

    public boolean addAnimal(Animal animal) {
        return animals.add(animal);
    }

    public boolean removeItem(Animal animal) {
        return animals.remove(animal);
    }

    public Door getDoorByCardinalPoint(CardinalPoints cardinalPoint) {
        return adjacentRooms.get(cardinalPoint);
    }


    public Optional<Item> getItemByName(String name) {
        return items.stream()
                .filter(item -> item.name().equalsIgnoreCase(name))
                .findAny();
    }

    private String getItemsListAsString() {
        return items.stream()
                .map(Item::name)
                .collect(Collectors.joining(", "));
    }

    private String getAnimalsListAsString() {
        return animals.stream()
                .map(animal -> "%s(%s)".formatted(animal.getName(), animal.getClass().getSimpleName()))
                .collect(Collectors.joining(", "));

    }

    private String getDoorListAsString() {
        return adjacentRooms.entrySet()
                .stream()
                .map(entry -> "%s[%s]".formatted(entry.getKey(), entry.getValue().showState()))
                .collect(Collectors.joining(", "));

    }

    @Override
    public String toString() {
        return """
                You are in room %s
                Items: %s
                NPC: %s
                Doors: %s"""
                .formatted(name,
                        getItemsListAsString(),
                        getAnimalsListAsString(),
                        getDoorListAsString());

    }
}
