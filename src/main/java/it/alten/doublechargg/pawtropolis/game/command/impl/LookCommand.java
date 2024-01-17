package it.alten.doublechargg.pawtropolis.game.command.impl;

import it.alten.doublechargg.pawtropolis.game.command.interfaces.CommandWithoutParam;
import it.alten.doublechargg.pawtropolis.game.controller.GameController;
import it.alten.doublechargg.pawtropolis.game.model.Room;

public class LookCommand implements CommandWithoutParam {

    private Room currentRoom;

    public LookCommand(GameController gameController) {
        this.currentRoom = gameController.getCurrentRoom();
    }

    public String execute() {
        return currentRoom.toString();
    }
}
