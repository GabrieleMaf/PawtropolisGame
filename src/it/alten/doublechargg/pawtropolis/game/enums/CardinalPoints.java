package it.alten.doublechargg.pawtropolis.game.enums;

import java.util.Arrays;

public enum CardinalPoints {
    NORTH("North"),
    EAST("East"),
    SOUTH("South"),
    WEST("West");

    private final String name;
    CardinalPoints(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static CardinalPoints getOppositeCardinalPoint(CardinalPoints cardinalPoint) {
        switch (cardinalPoint) {
            case NORTH -> {
                return SOUTH;
            }
            case SOUTH -> {
                return NORTH;
            }
            case EAST -> {
                return WEST;
            }
            default -> {
                return EAST;
            }
        }
    }


    public static CardinalPoints findByName(String name){
        return Arrays.stream(values())
                .filter(cardinalPoint -> cardinalPoint.name().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    }
