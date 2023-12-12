package it.alten.doublechargg.pawtropolis.game.model;

import it.alten.doublechargg.pawtropolis.animals.model.abstracts.Animal;
import it.alten.doublechargg.pawtropolis.game.enums.CardinalPoints;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

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
}
