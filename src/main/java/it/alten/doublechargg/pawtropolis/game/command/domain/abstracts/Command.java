package it.alten.doublechargg.pawtropolis.game.command.domain.abstracts;

import it.alten.doublechargg.pawtropolis.game.controller.GameManager;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class Command {

    protected final GameManager gameManager;


}
