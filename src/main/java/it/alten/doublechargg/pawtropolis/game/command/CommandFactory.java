package it.alten.doublechargg.pawtropolis.game.command;

import it.alten.doublechargg.pawtropolis.game.command.domain.abstracts.Command;
import it.alten.doublechargg.pawtropolis.game.command.exceptions.CommandFailedException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CommandFactory {

    private final BeanFactory beanFactory;

    public Command createCommand(String commandName) throws CommandFailedException {
        commandName = commandName.substring(0, 1).toUpperCase() + commandName.substring(1);
        try {
            return (Command) beanFactory.getBean(Class.forName("it.alten.doublechargg.pawtropolis.game.command.domain.%sCommand".formatted(commandName)));

        } catch (ClassNotFoundException e) {
            throw new CommandFailedException("There was an error in command execution", e);
        }
    }

}

