package it.alten.doublechargg.pawtropolis.game.command.impl;

import it.alten.doublechargg.pawtropolis.game.command.interfaces.CommandWithParam;
import it.alten.doublechargg.pawtropolis.game.controller.GameController;
import it.alten.doublechargg.pawtropolis.game.model.Item;
import it.alten.doublechargg.pawtropolis.game.model.Player;
import it.alten.doublechargg.pawtropolis.game.model.Room;


public class GetCommand implements CommandWithParam {

    private final Player player;
    private final Room currentRoom;

    public GetCommand() {
        player = GameController.getInstance().getPlayer();
        currentRoom = GameController.getInstance().getCurrentRoom();
    }

    @Override
    public String execute(String arg) {
        Item item = currentRoom.getItemByName(arg);
        if (currentRoom.containsItem(item)) {
            if (player.addItem(item)) {
                currentRoom.removeItem(item);
                return String.format("%s got the %s from the room%n", player.getName(), item.name());
            }
        }
        return "Item not present in this room";
        }
}
