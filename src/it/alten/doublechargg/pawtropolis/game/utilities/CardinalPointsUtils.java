package it.alten.doublechargg.pawtropolis.game.utilities;

import it.alten.doublechargg.pawtropolis.game.enums.CardinalPoints;

public class CardinalPointsUtils {

    private CardinalPointsUtils() {
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
