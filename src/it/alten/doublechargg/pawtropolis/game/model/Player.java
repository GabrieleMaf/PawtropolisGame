package it.alten.doublechargg.pawtropolis.game.model;

import it.alten.doublechargg.pawtropolis.game.enums.CardinalPoints;
import it.alten.doublechargg.pawtropolis.game.observer.Observable;
import it.alten.doublechargg.pawtropolis.game.observer.Observer;

import java.util.Objects;

public class Player implements Observable{
    private String name;
    private int lifePoint;
    private Bag bag;
    private Room currentRoom;
    private final Observer observer;


    public Player(String name, Observer observer) {
        this.name = name;
        this.lifePoint = 20;
        this.bag = new Bag();
        currentRoom = null;
        this.observer = observer;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLifePoint() {
        return lifePoint;
    }

    public void setLifePoint(int lifePoint) {
        this.lifePoint = lifePoint;
    }

    public Bag getBag() {
        return bag;
    }

    public void setBag(Bag bag) {
        this.bag = bag;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public void getItem(Item item) {
        if (currentRoom.getItems().contains(item) && bag.addItem(item)) {
            currentRoom.getItems().remove(item);
            onObjectAdded(item, this);
        } else if (!currentRoom.getItems().contains(item)) {
            System.err.println("Oggetto non presente nella stanza");
        }
    }

    public void dropItem(Item item) {
        if (bag.removeItem(item)) {
            currentRoom.getItems().add(item);
            onObjectRemove(item, this);
        } else {
            System.err.println("Oggetto non presente nella borsa");
        }
    }

    public String look() {
        return String.format("Animali : %s%n")
    }

    public String lookRoomItems() {
        return currentRoom.showItems();
    }

    public String lookBagItems() {
        return bag.showItems();
    }

    public void enterRoom(Room room) {
        currentRoom = room;
        onEnterRoom();
    }

    public void changeRoom(CardinalPoints cardinalPoint) {
        if (Objects.nonNull(currentRoom.getDoors().get(cardinalPoint))) {
            enterRoom(currentRoom.getDoors().get(cardinalPoint).getRoom2());
        } else {
            System.err.println("Porta non presente");
        }
    }


    @Override
    public void onEnterRoom() {
        observer.notifyOnEnterRoom(this);
    }

    @Override
    public void onObjectAdded(Item item, Player player) {
        observer.notifyObjectAdded(item, this);
    }

    @Override
    public void onObjectRemove(Item item, Player player) {
        observer.notifyObjectRemove(item, this);
    }

}
