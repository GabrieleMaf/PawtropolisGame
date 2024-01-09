package it.alten.doublechargg.pawtropolis.game.command.impl;

import it.alten.doublechargg.pawtropolis.game.command.interfaces.CommandWithParam;
import it.alten.doublechargg.pawtropolis.game.controller.GameController;
import it.alten.doublechargg.pawtropolis.game.model.Item;
import it.alten.doublechargg.pawtropolis.game.model.Player;
import it.alten.doublechargg.pawtropolis.game.model.Room;

public class DropCommand implements CommandWithParam {

    private final Player player;
    private final Room currentRoom;

    public DropCommand() {
        player = GameController.getInstance().getPlayer();
        currentRoom = GameController.getInstance().getCurrentRoom();
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
