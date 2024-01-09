package it.alten.doublechargg.pawtropolis.game.command.impl;

import it.alten.doublechargg.pawtropolis.game.command.interfaces.CommandWithParam;
import it.alten.doublechargg.pawtropolis.game.controller.GameController;

public class ExitCommand implements CommandWithParam {

    private final GameController gameController;

    public ExitCommand() {
        gameController = GameController.getInstance();
    }

    @Override
    public String execute(String arg) {
        gameController.setGameEnded(true);
        return "Exiting game";
    }
}
