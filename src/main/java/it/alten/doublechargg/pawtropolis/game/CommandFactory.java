package it.alten.doublechargg.pawtropolis.game;

import it.alten.doublechargg.pawtropolis.game.command.interfaces.Command;
import it.alten.doublechargg.pawtropolis.game.controller.GameController;
import it.alten.doublechargg.pawtropolis.game.exceptions.CommandFailedException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;

@Component
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CommandFactory {

    private ApplicationContext context;

    public Command createCommand(String commandName) throws CommandFailedException {
        commandName = commandName.substring(0, 1).toUpperCase() + commandName.substring(1);
        try {
            return (Command) Class.forName(String.format("it.alten.doublechargg.pawtropolis.game.command.impl.%sCommand", commandName))
                    .getConstructor(GameController.class)
                    .newInstance(context.getBean(GameController.class));
        } catch (InvocationTargetException |
                 NoSuchMethodException |
                 InstantiationException |
                 IllegalAccessException |
                 ClassNotFoundException e) {
            throw new CommandFailedException("There was an error in command execution", e);
        }
    }

}

