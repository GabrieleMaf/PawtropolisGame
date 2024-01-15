package it.alten.doublechargg.pawtropolis.game.model;

import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Bag {
    private final List<Item> items;
    private final int slot;

    public Bag() {
        val DEFAULT_SLOTS = 10;
        slot = DEFAULT_SLOTS;
        items = new ArrayList<>();
    }

    public Item getItemByName(String name) {
        return items
                .stream()
                .filter(item -> item.name().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    public int getTotalWeight() {
        return items.stream()
                .mapToInt(Item::weight)
                .sum();
    }

    public int getFreeSpace() {
        return slot - getTotalWeight();
    }

    public boolean addItem(Item item) {
        if (item.weight() <= getFreeSpace()) {
            return items.add(item);
        }
        return false;
    }

    public boolean removeItem(Item item) {
        return items.remove(item);
    }

    @Override
    public String toString() {
        if (items.isEmpty()) {
            return "Empty bag";
        }
        return items.stream()
                .map(Item::toString)
                .collect(Collectors.joining(""));
    }

}
