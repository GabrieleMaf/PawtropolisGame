package it.alten.doublechargg.pawtropolis.game.command.interfaces;

@FunctionalInterface
public interface CommandWithoutParam extends Command {
    String execute();
}
