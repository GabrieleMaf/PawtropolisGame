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

    public boolean getItem(Item item){
        return bag.addItem(item);
    }

    public boolean removeItem(Item item){
        return bag.removeItem(item);
    }

    public Item getItemFromBag(String itemName){
        return bag.getItemByName(itemName);
    }

    public String showBagContent(){
        return bag.toString();
    }

}
