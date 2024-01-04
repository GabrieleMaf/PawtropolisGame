package it.alten.doublechargg.pawtropolis.game.command.impl;

import it.alten.doublechargg.pawtropolis.game.command.Command;
import it.alten.doublechargg.pawtropolis.game.controller.GameController;
import it.alten.doublechargg.pawtropolis.game.model.Item;
import it.alten.doublechargg.pawtropolis.game.model.Player;
import it.alten.doublechargg.pawtropolis.game.model.Room;

public class DropCommand implements Command {

    private final Player player;
    private final Room currentRoom;

    public DropCommand() {
        player = GameController.getInstance().getPlayer();
        currentRoom = GameController.getInstance().getCurrentRoom();
    }

    @Override
    public String execute(String... args) {
        Item item = player.getItemFromBag(args[0]);
        if (player.removeItem(item)) {
            currentRoom.addItem(item);
            return String.format("%s dropped the %s in the room%n", player.getName(), item.name());
        } else {
            return "Item not present in the bag";
        }
    }

}
