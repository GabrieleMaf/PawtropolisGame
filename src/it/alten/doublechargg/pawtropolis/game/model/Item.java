package it.alten.doublechargg.pawtropolis.game.model;

public class Item {

    private Long id;
    private String name;
    private String description;
    private final int weight;

    public Item(Long id, String name, String description, int weight) {
        this.id = id;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("Item{name:\"%s\", " +
                "description:\"%s\", " +
                "weight:%d}%n",
                name, description, weight);
    }
}
