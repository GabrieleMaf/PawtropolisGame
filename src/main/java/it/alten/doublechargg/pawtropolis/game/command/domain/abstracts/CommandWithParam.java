package it.alten.doublechargg.pawtropolis.game.command.domain.abstracts;

import it.alten.doublechargg.pawtropolis.game.controller.GameManager;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class CommandWithParam extends Command {

    @Autowired
    protected CommandWithParam(GameManager gameManager) {
        super(gameManager);
    }

    public abstract void execute(String arg);
}
