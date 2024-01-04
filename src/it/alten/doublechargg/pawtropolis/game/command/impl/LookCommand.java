package it.alten.doublechargg.pawtropolis.game.command.impl;

import it.alten.doublechargg.pawtropolis.game.command.Command;
import it.alten.doublechargg.pawtropolis.game.controller.GameController;
import it.alten.doublechargg.pawtropolis.game.model.Room;

public class LookCommand implements Command {

    private final Room currentRoom;

    public LookCommand() {
        currentRoom = GameController.getInstance().getCurrentRoom();
    }

    @Override
    public String execute(String... args) {
        return currentRoom.toString();
    }
}
