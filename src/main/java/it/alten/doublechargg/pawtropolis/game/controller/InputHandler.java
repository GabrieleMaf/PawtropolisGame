package it.alten.doublechargg.pawtropolis.game.controller;

import it.alten.doublechargg.pawtropolis.game.command.CommandFactory;
import it.alten.doublechargg.pawtropolis.game.command.domain.abstracts.Command;
import it.alten.doublechargg.pawtropolis.game.command.domain.abstracts.CommandWithParam;
import it.alten.doublechargg.pawtropolis.game.command.domain.abstracts.CommandWithoutParam;
import it.alten.doublechargg.pawtropolis.game.command.exceptions.CommandFailedException;
import lombok.Data;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

@Log
@Component
@Data
public class InputHandler {

    private final CommandFactory commandFactory;

    public void handleInput(String input) throws CommandFailedException {

        List<String> formattedInput = Arrays.asList(input.trim().toLowerCase().split("\\s+"));
        var command = commandFactory.createCommand(formattedInput.getFirst());

        switch (command) {
            case CommandWithoutParam commandWithoutParam:
                commandWithoutParam.execute();
                break;
            case CommandWithParam commandWithParam:
                commandWithParam.execute(formattedInput.getLast());
                break;
            default:
                log.log(Level.SEVERE, "Not Valid Input");
        }
    }
}
