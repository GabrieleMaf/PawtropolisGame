package it.alten.doublechargg.pawtropolis.game.command.impl;

import it.alten.doublechargg.pawtropolis.game.command.interfaces.CommandWithParam;
import it.alten.doublechargg.pawtropolis.game.controller.GameController;
import it.alten.doublechargg.pawtropolis.game.model.Item;
import it.alten.doublechargg.pawtropolis.game.model.Player;
import it.alten.doublechargg.pawtropolis.game.model.Room;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Data
@Component
public class DropCommand implements CommandWithParam {

    private final Player player;
    private final Room currentRoom;

    @Autowired
    public DropCommand(GameController gameController) {
        player = gameController.getPlayer();
        currentRoom = gameController.getCurrentRoom();
    }

    @Override
    public String execute(String arg) {
        Item item = player.getItemFromBag(arg);
        if (player.removeItem(item)) {
            currentRoom.addItem(item);
            return String.format("%s dropped the %s in the room%n", player.getName(), item.name());
        } return "Item not present in the bag";
    }

}
