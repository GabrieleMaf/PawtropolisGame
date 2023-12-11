package it.alten.doublechargg.pawtropolis.game.model;

import it.alten.doublechargg.pawtropolis.game.enums.CardinalPoints;
import it.alten.doublechargg.pawtropolis.game.utilities.MyLogger;

import java.util.Objects;

public class Player{
    private final String name;
    private int lifePoint;
    private final Bag bag;
    private Room currentRoom;

    private static final MyLogger logger = MyLogger.getInstance();

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

    //unire il metodo enterRoom con changeRoom.
    public void enterRoom(Room room) {
        currentRoom = room;
        logger.logInfo(String.format("%s è entrato nella stanza %s%n", this.name, currentRoom.getName()));
    }

    public void changeRoom(CardinalPoints cardinalPoint) {
        if (Objects.nonNull(currentRoom.getDoors().get(cardinalPoint))) {
            enterRoom(currentRoom.getDoors().get(cardinalPoint).getRoom2());
        } else {
            logger.logInfo("Porta non presente");
        }
    }

    public String lookRoom() {
        return currentRoom.showContent();
    }

    public String lookBagItems() {
        return bag.showBagItems();
    }

    public void getItem(Item item) {
        if (currentRoom.getItems().contains(item) && bag.addItem(item)) {
            currentRoom.getItems().remove(item);
            logger.logInfo(String.format("%s ha preso l'oggetto %s dalla stanza %s%n", this.name, item.getName(), currentRoom.getName()));
        } else if (!currentRoom.getItems().contains(item)) {
            logger.logInfo(String.format("Oggetto %s non presente nella stanza", item.getName()));
        }
    }

    public void dropItem(Item item) {
        if (bag.removeItem(item)) {
            currentRoom.getItems().add(item);
            logger.logInfo(String.format("%s ha gettato l'oggetto %s nella stanza %s%n", this.name, item.getName(), currentRoom.getName()));
        } else {
            logger.logInfo("Oggetto non presente nella borsa");
        }
    }
}
