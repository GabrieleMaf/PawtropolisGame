package it.alten.doublechargg.pawtropolis.game.model.command;

import it.alten.doublechargg.pawtropolis.game.model.Player;

public interface Command {
    String execute(Player player);
}
