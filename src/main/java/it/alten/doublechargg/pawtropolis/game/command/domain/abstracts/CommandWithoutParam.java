package it.alten.doublechargg.pawtropolis.game.command.domain.abstracts;

import it.alten.doublechargg.pawtropolis.game.controller.GameManager;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class CommandWithoutParam extends Command {

    @Autowired
    protected CommandWithoutParam(GameManager gameManager) {
        super(gameManager);
    }

    public abstract void execute();
}
