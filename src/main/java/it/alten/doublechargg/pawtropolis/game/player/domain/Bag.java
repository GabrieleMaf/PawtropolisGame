package it.alten.doublechargg.pawtropolis.game.player.domain;

import lombok.val;

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
        if (item.weight() > getFreeSpace()) {
            return false;
        }
        return items.add(item);
    }

    public boolean removeItem(Item item) {
        return items.remove(item);
    }

    @Override
    public String toString() {
        var bagContent = items.stream()
                .map(Item::toString)
                .collect(Collectors.joining(""));

        return items.isEmpty() ? "Empty bag" : bagContent;

    }

}
