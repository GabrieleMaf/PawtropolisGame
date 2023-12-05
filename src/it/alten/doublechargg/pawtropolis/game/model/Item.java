package it.alten.doublechargg.pawtropolis.game.model;

public class Item {
    private String name;
    private String description;
    private final int weight;

    public Item(String name, String description, int weight) {
        this.name = name;
        this.description = description;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return String.format("Item{name: \"%s\"," +
                "description: \"%s\", " +
                "weight %d%n}",
                name, description, weight);
    }
}
