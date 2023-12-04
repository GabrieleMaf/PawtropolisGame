package it.alten.gmaferri.pawtropolis.game.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Bag {
    private final List<Item> items;
    private final int slot;
    public Bag(){
        slot = 10;
        items = new ArrayList<>();
    }

    public List<Item> getItems() {
        return items;
    }

    public int getSlot() {
        return slot;
    }

    public int getTotalWeight(){
        return items.stream()
                .mapToInt(Item::getWeight)
                .sum();
    }

    public boolean addItem(Item item){
        if(getTotalWeight() + item.getWeight() < slot ){
            return items.add(item);
        }
        else {
            return false;
        }
    }

    public boolean removeItem(Item item){
       return items.remove(item);
    }

    public String showItems(){
        return items.stream()
                .map(Item::toString)
                .collect(Collectors.joining(""));
    }

}
