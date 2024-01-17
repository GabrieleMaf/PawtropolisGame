package it.alten.doublechargg.pawtropolis.game.command.interfaces;

@FunctionalInterface
public interface CommandWithParam extends Command {
    String execute(String arg);
}
