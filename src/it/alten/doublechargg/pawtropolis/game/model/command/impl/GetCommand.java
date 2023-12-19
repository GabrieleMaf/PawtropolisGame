package it.alten.doublechargg.pawtropolis.game.model.command.impl;

import it.alten.doublechargg.pawtropolis.game.model.Item;
import it.alten.doublechargg.pawtropolis.game.model.Player;
import it.alten.doublechargg.pawtropolis.game.model.Room;
import it.alten.doublechargg.pawtropolis.game.model.command.Command;

public class GetCommand implements Command {

    private final Player player;
    private final String itemName;
    private final Room currentRoom;

    public GetCommand(Player player, String itemName, Room currentRoom) {
        this.player = player;
        this.itemName = itemName;
        this.currentRoom = currentRoom;
    }

    @Override
    public String execute() {
        Item item = currentRoom.getItemByName(itemName);
        if (currentRoom.getItems().contains(item)) {
            if (player.getItem(item)) {
                currentRoom.getItems().remove(item);
                return String.format("%s got the %s from the room%n", player.getName(), item.name());
            } else {
                return "Not enough space in bag";
            }
        } else {
            return "Item not present in this room";
        }
    }
}
