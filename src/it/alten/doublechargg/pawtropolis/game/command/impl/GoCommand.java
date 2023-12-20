package it.alten.doublechargg.pawtropolis.game.command.impl;

import it.alten.doublechargg.pawtropolis.game.command.Command;
import it.alten.doublechargg.pawtropolis.game.controller.GameController;
import it.alten.doublechargg.pawtropolis.game.enums.CardinalPoints;

import java.util.Objects;

public class GoCommand implements Command {


    private final GameController gameController;

    public GoCommand(GameController gameController) {
        this.gameController = gameController;
    }

    @Override
    public String execute(String... args) {
        CardinalPoints cardinalPoint = CardinalPoints.findByName(args[0]);
        if (Objects.isNull(cardinalPoint)) {
            return "Not valid input";
        }
        if (gameController.getCurrentRoom().adjacentRoomExists(cardinalPoint)) {
            gameController.setCurrentRoom(gameController.getCurrentRoom().getAdjacentRoomByCardinalPoint(cardinalPoint));
            return String.format("%s entered the room %s%n", gameController.getPlayer().getName(), gameController.getCurrentRoom().getName());
        }
        return "Not existent door";
    }
}
