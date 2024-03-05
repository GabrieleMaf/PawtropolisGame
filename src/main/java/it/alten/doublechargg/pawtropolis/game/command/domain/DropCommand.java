package it.alten.doublechargg.pawtropolis.game.command.domain;

import it.alten.doublechargg.pawtropolis.game.command.domain.abstracts.CommandWithParam;
import it.alten.doublechargg.pawtropolis.game.controller.GameManager;
import lombok.extern.java.Log;
import lombok.val;
import org.springframework.stereotype.Component;

import java.util.logging.Level;

@Component
@Log
public class DropCommand extends CommandWithParam {

    protected DropCommand(GameManager gameManager) {
        super(gameManager);
    }

    @Override
    public void execute(String arg) {

        val player = gameManager.getPlayer();
        val currentRoom = gameManager.getCurrentRoom();
        val item = player.getItemFromBag(arg);

        val commandResult = player.removeItem(item) && currentRoom.addItem(item) ?
                STR."\{player.getName()} dropped the \{item.name()} in the room." :
                "Item not present in the bag.";

        log.log(Level.INFO, commandResult);
    }
}
