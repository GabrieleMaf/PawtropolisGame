package it.alten.gmaferri.pawtropolis.game;

import it.alten.gmaferri.pawtropolis.animals.model.abstracts.Animal;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private String name;
    private List<Item> items;
    private List<Animal> animals;
    private List<Room> rooms;

    public Room(String name) {
        this.name = name;
        items = new ArrayList<>();
        animals = new ArrayList<>();
        rooms = new ArrayList<>();
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

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}
