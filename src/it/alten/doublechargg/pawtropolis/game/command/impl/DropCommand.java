package it.alten.doublechargg.pawtropolis.game.command.impl;

import it.alten.doublechargg.pawtropolis.game.controller.CommandController;
import it.alten.doublechargg.pawtropolis.game.controller.GameController;
import it.alten.doublechargg.pawtropolis.game.model.Item;
import it.alten.doublechargg.pawtropolis.game.model.Player;
import it.alten.doublechargg.pawtropolis.game.model.Room;
import it.alten.doublechargg.pawtropolis.game.command.Command;

public class DropCommand implements Command {

    private GameController gameController;

    public DropCommand(GameController gameController) {
        this.gameController = gameController;
    }

    @Override
    public String execute(String... args) {
        Item item = gameController.getPlayer().getItemFromBag(args[0]);
        if (gameController.getPlayer().removeItem(item)) {
            gameController.getCurrentRoom().getItems().add(item);
            return String.format("%s dropped the %s in the room%n", gameController.getPlayer().getName(), item.name());
        } else {
            return "Item not present in the bag";
        }
    }

}
