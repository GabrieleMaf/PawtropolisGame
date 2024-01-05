package it.alten.doublechargg.pawtropolis.game.command.impl;

import it.alten.doublechargg.pawtropolis.game.command.Command;
import it.alten.doublechargg.pawtropolis.game.command.CommandWithParam;
import it.alten.doublechargg.pawtropolis.game.controller.GameController;
import it.alten.doublechargg.pawtropolis.game.enums.CardinalPoints;
import it.alten.doublechargg.pawtropolis.game.model.Player;
import it.alten.doublechargg.pawtropolis.game.model.Room;

import java.util.Objects;

public class GoCommand implements CommandWithParam {

    private final Player player;
    private final Room currentRoom;

    public GoCommand() {
        player = GameController.getInstance().getPlayer();
        currentRoom = GameController.getInstance().getCurrentRoom();
    }

    @Override
    public String execute(String arg) {
        CardinalPoints cardinalPoint = CardinalPoints.findByName(arg);
        if (Objects.isNull(cardinalPoint)) {
            return "Not valid input";
        }
        if (currentRoom.adjacentRoomExists(cardinalPoint)) {
            GameController.getInstance().setCurrentRoom(currentRoom.getAdjacentRoomByCardinalPoint(cardinalPoint));
            return String.format("%s entered the room %s%n", player.getName(), GameController.getInstance().getCurrentRoom().getName());
        }
        return "Not existent door";

    }
}
