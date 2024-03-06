package it.alten.doublechargg.pawtropolis.game.command.domain;

import it.alten.doublechargg.pawtropolis.game.command.domain.abstracts.CommandWithParam;
import it.alten.doublechargg.pawtropolis.game.controller.GameManager;
import it.alten.doublechargg.pawtropolis.game.controller.utils.InputReader;
import it.alten.doublechargg.pawtropolis.game.map.enums.CardinalPoints;
import it.alten.doublechargg.pawtropolis.game.player.domain.Player;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.logging.Level;

@Component
@Log
public class GoCommand extends CommandWithParam {


    protected GoCommand(GameManager gameManager) {
        super(gameManager);
    }

    public void unlockDoor(Player player){
        log.info("The door is locked: would you like to use an item to unlock it?(y/n)");
        var answer = InputReader.readString();

        if (answer.equalsIgnoreCase("y")){
            log.info("Type the name of the chosen item");
            var answer2 = InputReader.readString();

            if (answer2.equalsIgnoreCase("key")){
                var result = player.removeItem(player.getItemFromBag("key")) ?
                        "You unlocked the door!" :
                        "You don't have a key!";
                log.info(result);
            }
        }
    }



    @Override
    public void execute(String arg) {
        var cardinalPoint = CardinalPoints.findByName(arg);
        var currentRoom = gameManager.getCurrentRoom();
        var player = gameManager.getPlayer();

        if (Objects.isNull(cardinalPoint)) {
            log.log(Level.SEVERE, "Not valid input");
            return;
        }

        if (currentRoom.adjacentRoomExists(cardinalPoint)) {
            var door = currentRoom.getAdjacentDoorByCardinalPoint(cardinalPoint);

            if (door.getLocked()){
                unlockDoor(player);
            }

            gameManager.setCurrentRoom(door.changeRoom());
            log.log(Level.INFO, "%s entered the room %s".formatted(player.getName(), gameManager.getCurrentRoom()));
        }
       log.log(Level.SEVERE, "Not existent room");

    }
}
