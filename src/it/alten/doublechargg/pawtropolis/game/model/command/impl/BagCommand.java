package it.alten.doublechargg.pawtropolis.game.model.command.impl;

import it.alten.doublechargg.pawtropolis.game.model.Player;
import it.alten.doublechargg.pawtropolis.game.model.command.Command;

public class BagCommand implements Command {

    public String execute(Player player) {
        return player.getBag().toString();
    }
}
