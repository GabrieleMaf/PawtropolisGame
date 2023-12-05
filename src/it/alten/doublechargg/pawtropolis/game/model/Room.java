package it.alten.doublechargg.pawtropolis.game.model;

import it.alten.doublechargg.pawtropolis.animals.model.abstracts.Animal;
import it.alten.doublechargg.pawtropolis.game.enums.CardinalPoints;
import it.alten.doublechargg.pawtropolis.game.observer.Observable;
import it.alten.doublechargg.pawtropolis.game.observer.Observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Room implements Observable {
    private String name;
    private List<Item> items;
    private List<Animal> animals;
    private Map<CardinalPoints, Door> doors;
    private List<Observer> observers;


    public Room(String name) {
        this.name = name;
        items = new ArrayList<>();
        animals = new ArrayList<>();
        doors = new HashMap<>();
        observers = new ArrayList<>();
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

    public void setDoors(Map<CardinalPoints, Door> doors) {
        this.doors = doors;
    }



    @Override
    public void add(Item item, String roomName) {
        items.add(item);
        notifyObjectAdded(item);
    }

    @Override
    public void registerObserver(Observer observer) {
        if (!observers.contains(observer)){
            observers.add(observer);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObjectAdded(Item item) {
        for(Observer observer : observers){
            observer.update(this, name);
        }
    }

    @Override
    public void notifyObjectRemoved(Item item) {
        for(Observer observer : observers){
            observer.remove(this, name);
        }
    }
}
