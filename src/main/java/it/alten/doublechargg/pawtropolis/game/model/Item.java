package it.alten.doublechargg.pawtropolis.game.model;

public record Item(Long id, String name, String description, int weight) {

    @Override
    public String toString() {
        return String.format("Item{ID: %d, " +
                        "name:\"%s\", " +
                        "description:\"%s\", " +
                        "weight:%d}%n",
                id, name, description, weight);
    }
}
