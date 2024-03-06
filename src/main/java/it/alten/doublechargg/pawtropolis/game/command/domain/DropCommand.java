package it.alten.doublechargg.pawtropolis.game.command.domain;

import it.alten.doublechargg.pawtropolis.game.command.domain.abstracts.CommandWithParam;
import it.alten.doublechargg.pawtropolis.game.controller.GameManager;
import lombok.extern.java.Log;
import lombok.val;
import org.springframework.stereotype.Component;

import java.util.logging.Level;

import static java.lang.StringTemplate.STR;

@Component
@Log
public class DropCommand extends CommandWithParam {

    protected DropCommand(GameManager gameManager) {
        super(gameManager);
    }

    @Override
    public void execute(String arg) {

        var player = gameManager.getPlayer();
        var currentRoom = gameManager.getCurrentRoom();
        var item = player.getItemFromBag(arg);

        var commandResult = player.removeItem(item) && currentRoom.addItem(item) ?
                "%s dropped the %s in the room.".formatted(player.getName(), item.name()) :
                "Item not present in the bag.";

        log.log(Level.INFO, commandResult);
    }
}
