package it.alten.gmaferri.pawtropolis.game.model;

import it.alten.gmaferri.pawtropolis.game.model.Bag;

public class Player {
    private String name;
    private int lifePoint;
    private Bag bag;

    public Player(String name, int lifePoint, Bag bag){
        this.name = name;
        this.lifePoint = lifePoint;
        this.bag = bag;
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
}
