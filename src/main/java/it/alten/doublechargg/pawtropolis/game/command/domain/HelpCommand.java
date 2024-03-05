package it.alten.doublechargg.pawtropolis.game.command.domain;

import it.alten.doublechargg.pawtropolis.game.command.domain.abstracts.CommandWithoutParam;
import it.alten.doublechargg.pawtropolis.game.controller.GameManager;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

@Component
@Log
public class HelpCommand extends CommandWithoutParam {

    protected HelpCommand(GameManager gameManager) {
        super(gameManager);
    }

    @Override
    public void execute() {
        log.info("""
                Command List:
                "1) - bag: Look the items in your bag
                "2) - look: Look around in the room, doors, items and animals
                "3) - go <direction>: Change room. Command example: go north
                "4) - get <item>: Get an item from room. Command example: get torch
                "5) - drop <item>: Drop an item into the room. Command example: drop torch
                "6) - help: Prints this command
                "7) - exit: Exit from game""");
    }
}
