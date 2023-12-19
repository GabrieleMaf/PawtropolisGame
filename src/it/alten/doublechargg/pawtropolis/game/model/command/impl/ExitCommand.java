package it.alten.doublechargg.pawtropolis.game.model.command.impl;

import it.alten.doublechargg.pawtropolis.game.model.command.Command;

public class ExitCommand implements Command {

    @Override
    public String execute() {
        System.exit(0);
        return "Exiting game";
    }
}
