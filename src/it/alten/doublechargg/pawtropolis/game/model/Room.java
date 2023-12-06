package it.alten.doublechargg.pawtropolis.game.model;

import it.alten.doublechargg.pawtropolis.animals.model.abstracts.Animal;
import it.alten.doublechargg.pawtropolis.game.enums.CardinalPoints;
import it.alten.doublechargg.pawtropolis.game.observer.Observable;
import it.alten.doublechargg.pawtropolis.game.observer.Observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Room {
    private String name;
    private List<Item> items;
    private List<Animal> animals;
    private Map<CardinalPoints, Door> doors;
    private Player player;


    public Room(String name) {
        this.name = name;
        items = new ArrayList<>();
        animals = new ArrayList<>();
        doors = new HashMap<>();
        player = null;
    }

    public String getName() {
        return name;
    }

    public String showDoors() {
        return doors
                .keySet()
                .stream()
                .map(CardinalPoints::toString)
                .collect(Collectors.joining(" "));
    }

    public String showItems() {
        return items.stream()
                .map(Item::toString)
                .collect(Collectors.joining(""));
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

    public void setDoors(Map<CardinalPoints, Door> doors) {
        this.doors = doors;
    }

    public Item getItemById(Long id) {
        return items.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

}
