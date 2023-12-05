package it.alten.doublechargg.pawtropolis.game.model;

import it.alten.doublechargg.pawtropolis.game.observer.Observer;

public class Player implements Observer {
    private String name;
    private int lifePoint;
    private Bag bag;

    private Room currentRoom;


    public Player(String name, int lifePoint, Bag bag){
        this.name = name;
        this.lifePoint = lifePoint;
        this.bag = bag;
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

    public void getItem(Item item, Room currentRoom){
        if(currentRoom.getItems().contains(item)){
            bag.addItem(item);
        }
    }

    @Override
    public void onEnterRoom(Room room) {
        room.setPlayer(this);
        System.out.printf("%s è entrato nella stanza %s%n", name, room);
    }

    @Override
    public void onLeaveRoom(Room room) {
        room.setPlayer(null);
        System.out.printf("%s ha lasciato la stanza %s%n", name, room);
    }

    @Override
    public void onObjectAdded(Item item, Room room) {

        System.out.printf("%s ha preso l'oggetto %s nella stanza %s%n", name, item.getName(), room.getName());
    }

    @Override
    public void onObjectRemove(Item item, Room room) {
        System.out.printf("%s ha lasciato l'oggetto %s nella stanza %s%n", name, item.getName(), room.getName());
    }




}
