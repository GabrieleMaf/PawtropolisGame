package it.alten.doublechargg.pawtropolis.game.model.command.impl;

import it.alten.doublechargg.pawtropolis.game.model.Item;
import it.alten.doublechargg.pawtropolis.game.model.Player;
import it.alten.doublechargg.pawtropolis.game.model.Room;
import it.alten.doublechargg.pawtropolis.game.model.command.Command;

public class DropCommand implements Command {

    private Player player;
    private String itemName;
    private Room currentRoom;

    public DropCommand(Player player, String itemName, Room currentRoom) {
        this.player = player;
        this.itemName = itemName;
        this.currentRoom = currentRoom;
    }

    @Override
    public String execute() {
        Item item = player.getItemFromBag(itemName);
        if (player.removeItem(item)) {
            currentRoom.getItems().add(item);
            return String.format("%s dropped the %s in the room%n", player.getName(), item.name());
        } else {
            return "Item not present in the bag";
        }
    }

}
