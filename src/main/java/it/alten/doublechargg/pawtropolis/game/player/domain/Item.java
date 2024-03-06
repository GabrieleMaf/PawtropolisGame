package it.alten.doublechargg.pawtropolis.game.player.domain;

public record Item(String name, String description, int weight) {

    @Override
    public String toString() {
        return """
                Item{Name:%s,
                 Description:%s
                 Weight: %s
                 """.formatted(name, description, weight);
    }
}
