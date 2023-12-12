package it.alten.doublechargg.pawtropolis.game.model;

import it.alten.doublechargg.pawtropolis.game.utilities.MyLogger;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Bag {
    private static final MyLogger logger = MyLogger.getInstance();

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

    public String showBagItems() {
        if(items.isEmpty()){
            logger.logWarning("Empty bag");
            return " ";
        }
        return items.stream()
                .map(Item::toString)
                .collect(Collectors.joining(", "));
    }

    public int getTotalWeight() {
        return items.stream()
                .mapToInt(Item::getWeight)
                .sum();
    }

    public boolean addItem(Item item) {
        if (getTotalWeight() + item.getWeight() < slot) {
            logger.logInfo(String.format("Added %s", item.getName()));
            return items.add(item);
        } else {
            logger.logWarning(String.format("Not enough space to add %s", item.getName()));
            return false;
        }
    }

    public boolean removeItem(Item item) {
        return items.remove(item);
    }

}
