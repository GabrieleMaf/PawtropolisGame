package it.alten.doublechargg.pawtropolis.game.command.impl;

import it.alten.doublechargg.pawtropolis.game.controller.CommandController;
import it.alten.doublechargg.pawtropolis.game.controller.GameController;
import it.alten.doublechargg.pawtropolis.game.enums.CardinalPoints;
import it.alten.doublechargg.pawtropolis.game.model.Player;
import it.alten.doublechargg.pawtropolis.game.model.Room;
import it.alten.doublechargg.pawtropolis.game.command.Command;

import java.util.Objects;

public class GoCommand implements Command {


    private GameController gameController;

    public GoCommand(GameController gameController) {
        this.gameController = gameController;
    }

    @Override
    public String execute(String... args) {
        CardinalPoints cardinalPoint = CardinalPoints.findByName(args[0]);
        if(Objects.isNull(cardinalPoint)){
            return "Not valid input";
        }
        if (Objects.nonNull(gameController.getCurrentRoom().getAdjacentRooms().get(cardinalPoint))) {
            gameController.setCurrentRoom(gameController.getCurrentRoom().getAdjacentRooms().get(cardinalPoint));
            return String.format("%s entered the room %s%n", gameController.getPlayer().getName(), gameController.getCurrentRoom().getName());
        } else {
            return "Not existent door";
        }
    }
}
