package it.alten.doublechargg.pawtropolis.game.command.domain;

import it.alten.doublechargg.pawtropolis.game.command.domain.abstracts.CommandWithParam;
import it.alten.doublechargg.pawtropolis.game.controller.GameManager;
import it.alten.doublechargg.pawtropolis.game.map.domain.Room;
import it.alten.doublechargg.pawtropolis.game.player.domain.Item;
import it.alten.doublechargg.pawtropolis.game.player.domain.Player;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.logging.Level;

@Component
@Log
public class GetCommand extends CommandWithParam {

    protected GetCommand(GameManager gameManager) {
        super(gameManager);
    }

    @Override
    public void execute(String arg) {
        var player = gameManager.getPlayer();
        var currentRoom = gameManager.getCurrentRoom();

        if (currentRoom.getItemByName(arg).isPresent()) {

            var item = currentRoom.getItemByName(arg).get();
            var commandResult = player.addItem(item) && currentRoom.removeItem(item) ?
                    STR."\{player.getName()} got the \{item.name()} from the room." :
                    "Not enough space in bag.";

            log.log(Level.INFO, commandResult);
            return;
        }
        log.log(Level.SEVERE, "Item not present in this room.");
    }
}
