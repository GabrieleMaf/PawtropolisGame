package it.alten.doublechargg.pawtropolis.game.command.impl;

import it.alten.doublechargg.pawtropolis.game.command.interfaces.CommandWithoutParam;
import it.alten.doublechargg.pawtropolis.game.controller.GameController;
import it.alten.doublechargg.pawtropolis.game.model.Room;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Data
@Component
public class LookCommand implements CommandWithoutParam {

    private Room currentRoom;
    @Autowired
    public LookCommand(ApplicationContext context) {
        this.currentRoom = context.getBean(GameController.class).getCurrentRoom();
    }

    public String execute() {
        return currentRoom.toString();
    }
}
