package it.alten.doublechargg.pawtropolis.game.command.impl;

import it.alten.doublechargg.pawtropolis.game.command.interfaces.CommandWithoutParam;
import it.alten.doublechargg.pawtropolis.game.controller.GameController;
import it.alten.doublechargg.pawtropolis.game.model.Player;

public class BagCommand implements CommandWithoutParam {

    private final Player player;

    public BagCommand() {
        player = GameController.getInstance().getPlayer();
    }

    @Override
    public String execute() {
        return player.showBagContent();
    }
}
