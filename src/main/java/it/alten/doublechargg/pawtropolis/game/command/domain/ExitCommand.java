package it.alten.doublechargg.pawtropolis.game.command.domain;

import it.alten.doublechargg.pawtropolis.game.command.domain.abstracts.CommandWithParam;
import it.alten.doublechargg.pawtropolis.game.controller.GameManager;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import java.util.logging.Level;

@Component
@Log
public class ExitCommand extends CommandWithParam {

    protected ExitCommand(GameManager gameManager) {
        super(gameManager);
    }
    @Override
    public void execute(String arg) {
        gameManager.setGameEnded(true);
        log.log(Level.INFO, "Exiting game.");
    }
}
