package it.alten.doublechargg.pawtropolis.game.model;

public class Player {

    private static final int DEFAULT_LIFEPOINTS = 20;
    private final String name;
    private final Bag bag;
    private int lifePoints;

    public Player(String name) {
        this.name = name;
        this.lifePoints = DEFAULT_LIFEPOINTS;
        this.bag = new Bag();
    }

    public String getName() {
        return name;
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    public boolean addItem(Item item) {
        return bag.addItem(item);
    }

    public boolean removeItem(Item item) {
        return bag.removeItem(item);
    }

    public Item getItemFromBag(String itemName) {
        return bag.getItemByName(itemName);
    }

    public String showBagContent() {
        return bag.toString();
    }

}
