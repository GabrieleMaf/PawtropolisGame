package it.alten.doublechargg.pawtropolis.game.command.impl;

import it.alten.doublechargg.pawtropolis.game.command.Command;
import it.alten.doublechargg.pawtropolis.game.controller.GameController;

public class BagCommand implements Command {

    private final GameController gameController;

    public BagCommand(GameController gameController) {
        this.gameController = gameController;
    }

    @Override
    public String execute(String... args) {
        return gameController.getPlayer().showBagContent();
    }
}
