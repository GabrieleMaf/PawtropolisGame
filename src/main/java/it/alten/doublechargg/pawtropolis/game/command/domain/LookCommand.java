package it.alten.doublechargg.pawtropolis.game.command.domain;

import it.alten.doublechargg.pawtropolis.game.command.domain.abstracts.CommandWithoutParam;
import it.alten.doublechargg.pawtropolis.game.controller.GameManager;
import it.alten.doublechargg.pawtropolis.game.map.domain.Room;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.logging.Level;


@Component
@Log
public class LookCommand extends CommandWithoutParam {
    @Autowired
    protected LookCommand(GameManager gameManager) {
        super(gameManager);
    }

    public void execute() {
        Room currentRoom = gameManager.getCurrentRoom();
        log.log(Level.INFO, currentRoom.toString());
    }
}
