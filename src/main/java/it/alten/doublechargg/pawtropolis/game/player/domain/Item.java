package it.alten.doublechargg.pawtropolis.game.player.domain;

public record Item(String name, String description, int weight) {

    @Override
    public String toString() {
        return STR."""
                       Item{Name:\{name},
                        Description:\{description}
                        Weight:\{weight}
                        """;
    }
}
