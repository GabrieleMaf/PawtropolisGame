package it.alten.gmaferri.pawtropolis.game;

public class Item {
    private String name;
    private String description;
    private final int requireSlot;

    public Item(String name, String description, int requireSlot) {
        this.name = name;
        this.description = description;
        this.requireSlot = requireSlot;
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

    public int getRequireSlot() {
        return requireSlot;
    }
}
