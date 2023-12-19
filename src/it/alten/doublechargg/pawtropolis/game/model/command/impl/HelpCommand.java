package it.alten.doublechargg.pawtropolis.game.model.command.impl;

import it.alten.doublechargg.pawtropolis.game.model.command.Command;

public class HelpCommand implements Command {

    @Override
    public String execute() {
        return String.format("Command List:%n" +
                "1) - bag: Look the items in your bag%n" +
                "2) - look: Look around in the room, doors, items and animals%n" +
                "3) - go <direction>: Change room. Command example: go north%n" +
                "4) - get <item>: Get an item from room. Command example: get torch%n" +
                "5) - drop <item>: Drop an item into the room. Command example: drop torch%n" +
                "6) - help: Prints this command%n" +
                "7) - exit: Exit from game");
    }
}
