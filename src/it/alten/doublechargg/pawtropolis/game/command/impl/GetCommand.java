package it.alten.doublechargg.pawtropolis.game.command.impl;

import it.alten.doublechargg.pawtropolis.game.controller.CommandController;
import it.alten.doublechargg.pawtropolis.game.controller.GameController;
import it.alten.doublechargg.pawtropolis.game.model.Item;
import it.alten.doublechargg.pawtropolis.game.model.Player;
import it.alten.doublechargg.pawtropolis.game.model.Room;
import it.alten.doublechargg.pawtropolis.game.command.Command;

public class GetCommand implements Command {

    private GameController gameController;


    public GetCommand(GameController gameController) {
        this.gameController = gameController;
    }

    @Override
    public String execute(String... args) {
        Item item = gameController.getCurrentRoom().getItemByName(args[0]);
        if (gameController.getCurrentRoom().getItems().contains(item)) {
            if (gameController.getPlayer().getItem(item)) {
                gameController.getCurrentRoom().getItems().remove(item);
                return String.format("%s got the %s from the room%n", gameController.getPlayer().getName(), item.name());
            } else {
                return "Not enough space in bag";
            }
        } else {
            return "Item not present in this room";
        }
    }
}
