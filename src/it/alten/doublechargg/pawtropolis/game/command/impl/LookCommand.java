package it.alten.doublechargg.pawtropolis.game.command.impl;

import it.alten.doublechargg.pawtropolis.game.command.Command;
import it.alten.doublechargg.pawtropolis.game.command.CommandWithoutParam;
import it.alten.doublechargg.pawtropolis.game.controller.GameController;
import it.alten.doublechargg.pawtropolis.game.model.Room;

public class LookCommand implements CommandWithoutParam {

    private final Room currentRoom;

    public LookCommand() {
        currentRoom = GameController.getInstance().getCurrentRoom();
    }


    public String execute() {
        return currentRoom.toString();
    }
}
