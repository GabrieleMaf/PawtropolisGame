package it.alten.doublechargg.pawtropolis.game.utilities;

import it.alten.doublechargg.pawtropolis.game.enums.CardinalPoints;

public class CardinalPointsUtils {

    public static CardinalPoints getCardinalPoint(String input) {
        return switch (input.toLowerCase()) {
            case "north" -> CardinalPoints.NORTH;
            case "east" -> CardinalPoints.EAST;
            case "west" -> CardinalPoints.WEST;
            case "south" -> CardinalPoints.SOUTH;
            default -> throw new IllegalArgumentException("Non existent cardinal point");
        };
    }

    public static CardinalPoints getOppositeCardinalPoint(CardinalPoints cardinalPoint) {
        switch (cardinalPoint) {
            case NORTH -> {
                return CardinalPoints.SOUTH;
            }
            case SOUTH -> {
                return CardinalPoints.NORTH;
            }
            case EAST -> {
                return CardinalPoints.WEST;
            }
            default -> {
                return CardinalPoints.EAST;
            }
        }
    }

}
