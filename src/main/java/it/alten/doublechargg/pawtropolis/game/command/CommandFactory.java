package it.alten.doublechargg.pawtropolis.game.command;

import it.alten.doublechargg.pawtropolis.game.command.domain.abstracts.Command;
import it.alten.doublechargg.pawtropolis.game.command.exceptions.CommandFailedException;
import it.alten.doublechargg.pawtropolis.game.controller.GameManager;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;

@Component
@RequiredArgsConstructor
public class CommandFactory {

    private final ApplicationContext context;

    public Command createCommand(String commandName) throws CommandFailedException {
        commandName = commandName.substring(0, 1).toUpperCase() + commandName.substring(1);
        try {
            return (Command) Class.forName(STR."it.alten.doublechargg.pawtropolis.game.command.impl.\{commandName}Command")
                    .getConstructor(GameManager.class)
                    .newInstance(context.getBean(GameManager.class));
        } catch (InvocationTargetException |
                 NoSuchMethodException |
                 InstantiationException |
                 IllegalAccessException |
                 ClassNotFoundException e) {
            throw new CommandFailedException("There was an error in command execution", e);
        }
    }

}

