package it.alten.doublechargg.pawtropolis.game.model;

public class Player {

    private final String name;
    private final Bag bag;
    private int lifePoint;

    public Player(String name) {
        this.name = name;
        this.lifePoint = 20;
        this.bag = new Bag();
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

}
