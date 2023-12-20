package it.alten.doublechargg.pawtropolis.game.command.impl;

import it.alten.doublechargg.pawtropolis.game.command.Command;
import it.alten.doublechargg.pawtropolis.game.controller.GameController;

public class LookCommand implements Command {

    private final GameController gameController;

    public LookCommand(GameController gameController) {
        this.gameController = gameController;
    }

    @Override
    public String execute(String... args) {
        return gameController.getCurrentRoom().toString();
    }
}
