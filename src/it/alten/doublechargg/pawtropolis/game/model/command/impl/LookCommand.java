package it.alten.doublechargg.pawtropolis.game.model.command.impl;

import it.alten.doublechargg.pawtropolis.game.model.Room;
import it.alten.doublechargg.pawtropolis.game.model.command.Command;

public class LookCommand implements Command {

    private final Room room;

    public LookCommand(Room room) {
        this.room = room;
    }

    @Override
    public String execute() {
        return room.toString();
    }
}
