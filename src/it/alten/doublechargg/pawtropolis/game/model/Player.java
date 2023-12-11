package it.alten.doublechargg.pawtropolis.game.model;

import it.alten.doublechargg.pawtropolis.game.enums.CardinalPoints;

import java.util.Objects;

public class Player{
    private String name;
    private int lifePoint;
    private Bag bag;
    private Room currentRoom;


    public Player(String name) {
        this.name = name;
        this.lifePoint = 20;
        this.bag = new Bag();
        currentRoom = null;

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
            System.out.printf("%s ha preso l'oggetto %s dalla stanza %s%n", this.name, item.getName(), currentRoom.getName());
        } else if (!currentRoom.getItems().contains(item)) {
            System.err.println("Oggetto non presente nella stanza");
        }
    }

    public void dropItem(Item item) {
        if (bag.removeItem(item)) {
            currentRoom.getItems().add(item);
            System.out.printf("%s ha gettato l'oggetto %s nella stanza %s%n", this.name, item.getName(), currentRoom.getName());
        } else {
            System.err.println("Oggetto non presente nella borsa");
        }
    }

    public String look() {
        return String.format("You are in the room %s%n" +
                        "Items: %s%n"+
                        "Animals: %s%n" +
                        "Doors: %s%n",
                currentRoom.getName(),lookAnimals(), lookRoomItems(), lookDoors());
    }

    public String lookDoors(){
        return currentRoom.showDoors();
    }

    public String lookAnimals(){
        return currentRoom.showAnimals();
    }

    public String lookRoomItems() {
        return currentRoom.showItems();
    }

    public String lookBagItems() {
        return bag.showItems();
    }

    public void enterRoom(Room room) {
        currentRoom = room;
        System.out.printf("%s è entrato nella stanza %s%n", this.name, currentRoom.getName());
    }

    public void changeRoom(CardinalPoints cardinalPoint) {
        if (Objects.nonNull(currentRoom.getDoors().get(cardinalPoint))) {
            enterRoom(currentRoom.getDoors().get(cardinalPoint).getRoom2());
        } else {
            System.err.println("Porta non presente");
        }
    }

}
