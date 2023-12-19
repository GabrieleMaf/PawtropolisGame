package it.alten.doublechargg.pawtropolis.game.model.command.impl;

import it.alten.doublechargg.pawtropolis.game.enums.CardinalPoints;
import it.alten.doublechargg.pawtropolis.game.model.Player;
import it.alten.doublechargg.pawtropolis.game.model.Room;
import it.alten.doublechargg.pawtropolis.game.model.command.Command;

import java.util.Objects;

public class GoCommand implements Command {

    private String cardinalPointName;
    private Player player;
    private Room currentRoom;

    public GoCommand(String cardinalPointName, Player player, Room room) {
        this.cardinalPointName = cardinalPointName;
        this.player = player;
        this.currentRoom = room;
    }

    @Override
    public String execute() {
        CardinalPoints cardinalPoint = CardinalPoints.findByName(cardinalPointName);
        if(Objects.isNull(cardinalPoint)){
            return "Not valid input";
        }
        if (Objects.nonNull(currentRoom.getAdjacentRooms().get(cardinalPoint))) {
            currentRoom = (currentRoom.getAdjacentRooms().get(cardinalPoint));
            return String.format("%s entered the room %s%n", player.getName(), currentRoom.getName());
        } else {
            return "Not existent door";
        }
    }
}
