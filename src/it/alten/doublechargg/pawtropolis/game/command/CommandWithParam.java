package it.alten.doublechargg.pawtropolis.game.command;

public interface CommandWithParam extends Command {
    String execute(String arg);
}
