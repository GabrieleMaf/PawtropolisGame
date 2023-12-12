package it.alten.doublechargg.pawtropolis.game.model;

import it.alten.doublechargg.pawtropolis.animals.model.abstracts.Animal;
import it.alten.doublechargg.pawtropolis.game.enums.CardinalPoints;

import java.util.*;
import java.util.stream.Collectors;

public class Room {

    private String name;
    private List<Item> items;
    private List<Animal> animals;
    private EnumMap<CardinalPoints, Door> doors;


    public Room(String name) {
        this.name = name;
        items = new ArrayList<>();
        animals = new ArrayList<>();
        doors = new EnumMap<>(CardinalPoints.class);
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

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public Map<CardinalPoints, Door> getDoors() {
        return doors;
    }

    public void setDoors(EnumMap<CardinalPoints, Door> doors) {
        this.doors = doors;
    }

    public Item getItemById(Long id) {
        return items.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst()
                .orElse(null);
    }


    public String showDoors() {
        return doors
                .keySet()
                .stream()
                .map(CardinalPoints::toString)
                .collect(Collectors.joining("\n"));
    }

    public String showAnimals(){
        return animals.stream()
                .map(Animal::getNameFormat)
                .collect(Collectors.joining(", "));
    }
    public String showItems() {
        return items.stream()
                .map(Item::getName)
                .collect(Collectors.joining(", "));
    }

    public String showContent(){
        return String.format("You are in room %s%n" +
                "Items: %s%n" +
                "NPC: %s%n" +
                "Doors: %s",
                name, showItems(), showAnimals(), showDoors());
    }

}
