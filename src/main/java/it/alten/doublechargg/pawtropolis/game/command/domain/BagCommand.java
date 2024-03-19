package it.alten.doublechargg.pawtropolis.game.command.domain;

import it.alten.doublechargg.pawtropolis.game.command.domain.abstracts.CommandWithoutParam;
import it.alten.doublechargg.pawtropolis.game.controller.GameManager;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.logging.Level;

@Log
@Component
public class BagCommand extends CommandWithoutParam {
    @Autowired
    protected BagCommand(GameManager gameManager) {
        super(gameManager);
    }

    @Override
    public void execute() {
        log.log(Level.INFO, gameManager.getPlayer().showBagContent());
    }
}
