package it.alten.doublechargg.pawtropolis.game.model;

import java.util.ArrayList;
import java.util.List;

public class Bag {

    private final List<Item> items;
    private final int slot;

    public Bag() {
        slot = 10;
        items = new ArrayList<>();
    }

    public int getSlot() {
        return slot;
    }

    public List<Item> getItems(){
        return items;
    }


}
