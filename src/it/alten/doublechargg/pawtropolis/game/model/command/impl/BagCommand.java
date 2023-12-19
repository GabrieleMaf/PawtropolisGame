package it.alten.doublechargg.pawtropolis.game.model.command.impl;

import it.alten.doublechargg.pawtropolis.game.model.Player;
import it.alten.doublechargg.pawtropolis.game.model.command.Command;

public class BagCommand implements Command {

    private final Player player;

    public BagCommand(Player player) {
        this.player = player;
    }

    @Override
    public String execute() {
        return player.showBagContent();
    }
}
