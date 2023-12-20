package it.alten.doublechargg.pawtropolis.game.command.impl;

import it.alten.doublechargg.pawtropolis.game.command.Command;
import it.alten.doublechargg.pawtropolis.game.controller.GameController;

public class ExitCommand implements Command {

    private final GameController gameController;

    public ExitCommand(GameController gameController) {
        this.gameController = gameController;
    }

    @Override
    public String execute(String... args) {
        gameController.setGameEnded(true);
        return "Exiting game";
    }
}
