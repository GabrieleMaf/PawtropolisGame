package it.alten.doublechargg.pawtropolis.game.model;

import it.alten.doublechargg.pawtropolis.game.enums.CardinalPoints;
import it.alten.doublechargg.pawtropolis.game.utilities.MyLogger;

import java.util.Objects;

public class Player{

    private static final MyLogger logger = MyLogger.getInstance();
    private final String name;
    private int lifePoint;
    private final Bag bag;
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

    public int getLifePoint() {
        return lifePoint;
    }

    public void setLifePoint(int lifePoint) {
        this.lifePoint = lifePoint;
    }

    public Bag getBag() {
        return bag;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }


    public void dropItem(Item item) {
        if (bag.removeItem(item)) {
            currentRoom.getItems().add(item);
            logger.logInfo(String.format("%s dropped the %s in the room%n", this.name, item.getName()));
        } else {
            logger.logInfo("Item not present in the bag");
        }
    }
}
