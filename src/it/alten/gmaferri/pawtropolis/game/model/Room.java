package it.alten.gmaferri.pawtropolis.game.model;

import it.alten.gmaferri.pawtropolis.animals.model.abstracts.Animal;
import it.alten.gmaferri.pawtropolis.game.model.Item;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private String name;
    private List<Item> items;
    private List<Animal> animals;

    public Room(String name) {
        this.name = name;
        items = new ArrayList<>();
        animals = new ArrayList<>();
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

}
