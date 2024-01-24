package pawtropolis.map.domain;

import lombok.RequiredArgsConstructor;
import pawtropolis.animals.domain.Animal;
import pawtropolis.game.domain.Item;

import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class Room {
    private final String name;
    private final Set<Item> items;
    private final Set<Animal> animals;
    private final Map<Direction, Door> adjacentDoors;

    public Optional<Item> getItemByName(String itemName) {
        return items.stream()
                .filter(i -> i.getName().equalsIgnoreCase(itemName))
                .findAny();
    }

    public Door getAdjacentDoorByDirection(Direction direction) {
        return adjacentDoors.get(direction);
    }

    public void putAdjacentRoom(Direction linkedDirection, Door door) {
        adjacentDoors.put(linkedDirection, door);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public void addItem(Item item) {
        items.add(item);
    }

    @Override
    public String toString() {
        String itemsString = items.stream()
                .map(Item::getName)
                .collect(Collectors.joining(", ", "Items: ", "\n"));

        String animalsString = animals.stream()
                .map(animal -> animal.getName().concat("(" + animal.getClass().getSimpleName() + ")"))
                .collect(Collectors.joining(", ", "NPC: ", "\n"));

        String doors =  adjacentDoors.keySet()
                .stream()
                .map(direction -> String.format("%s[%s]",direction.getLabel(),getAdjacentDoorByDirection(direction).showState()))
                .collect(Collectors.joining(", ", "DOORS:", "\n"));

        return String.format("You are in %s%n%s%s%s", name, itemsString, animalsString, doors);
    }
}