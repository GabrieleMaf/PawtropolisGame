package it.alten.doublechargg.pawtropolis.game.model;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@ToString
@EqualsAndHashCode
public class Player {

    @Getter
    private final String name;
    private final Bag bag;
    @Getter
    @Setter
    private int lifePoints;

    public Player(String name) {
        this.name = name;
        val DEFAULT_LIFEPOINTS = 20;
        this.lifePoints = DEFAULT_LIFEPOINTS;
        this.bag = new Bag();
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