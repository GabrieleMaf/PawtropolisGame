package it.alten.doublechargg.pawtropolis.game.command.impl;

import it.alten.doublechargg.pawtropolis.game.command.interfaces.CommandWithParam;
import it.alten.doublechargg.pawtropolis.game.controller.GameController;
import it.alten.doublechargg.pawtropolis.game.enums.CardinalPoints;
import it.alten.doublechargg.pawtropolis.game.model.Player;
import it.alten.doublechargg.pawtropolis.game.model.Room;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Data
@Component
public class GoCommand implements CommandWithParam {

    private ApplicationContext context;
    private Player player;
    private Room currentRoom;
    @Autowired
    public GoCommand(ApplicationContext context) {
        this.context = context;
        player = context.getBean(GameController.class).getPlayer();
        currentRoom = context.getBean(GameController.class).getCurrentRoom();

    }

    @Override
    public String execute(String arg) {
        CardinalPoints cardinalPoint = CardinalPoints.findByName(arg);
        if (Objects.isNull(cardinalPoint)) {
            return "Not valid input";
        }
        if (currentRoom.adjacentRoomExists(cardinalPoint)) {
            context.getBean(GameController.class).setCurrentRoom(currentRoom.getAdjacentRoomByCardinalPoint(cardinalPoint));
            return String.format("%s entered the room %s%n", player.getName(), context.getBean(GameController.class).getCurrentRoom().getName());
        }
        return "Not existent room";

    }
}
