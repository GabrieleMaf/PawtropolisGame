package it.alten.doublechargg.pawtropolis.game.controller;

import it.alten.doublechargg.pawtropolis.game.CommandFactory;
import it.alten.doublechargg.pawtropolis.game.command.interfaces.Command;
import it.alten.doublechargg.pawtropolis.game.command.interfaces.CommandWithParam;
import it.alten.doublechargg.pawtropolis.game.command.interfaces.CommandWithoutParam;
import it.alten.doublechargg.pawtropolis.game.exceptions.CommandFailedException;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Synchronized;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;

@Log
@Component
@Data
public class InputController {

    private CommandFactory commandFactory;

    @Autowired
    public InputController(CommandFactory commandFactory) {
        this.commandFactory = commandFactory;
    }

    public void handleInput(String input) throws CommandFailedException {
        List<String> formattedInput = Arrays.asList(input.trim().toLowerCase().split("\\s+"));
        Command command = commandFactory.createCommand(formattedInput.getFirst());
        switch (command) {
            case CommandWithoutParam commandWithoutParam:
                log.info(commandWithoutParam.execute());
                break;
            case CommandWithParam commandWithParam:
                log.info(commandWithParam.execute(formattedInput.getLast()));
                break;
            default:
                log.log(Level.SEVERE, "Not Valid Input");
        }
    }
}
