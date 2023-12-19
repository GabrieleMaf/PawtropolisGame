package it.alten.doublechargg.pawtropolis.game.model.command.impl;

import it.alten.doublechargg.pawtropolis.game.enums.CardinalPoints;
import it.alten.doublechargg.pawtropolis.game.model.Player;
import it.alten.doublechargg.pawtropolis.game.model.Room;
import it.alten.doublechargg.pawtropolis.game.model.command.Command;

public class GoCommand implements Command {

    private CardinalPoints direction;
    private Player player;
    private Room currentRoom;

    public GoCommand(CardinalPoints direction, Player player, Room room) {
        this.direction = direction;
        this.player = player;
        this.currentRoom = room;
    }

    @Override
    public String execute() {
        return null;
    }
}
