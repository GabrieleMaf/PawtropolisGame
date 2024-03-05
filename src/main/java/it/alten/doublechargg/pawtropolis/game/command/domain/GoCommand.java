package it.alten.doublechargg.pawtropolis.game.command.domain;

import it.alten.doublechargg.pawtropolis.game.command.domain.abstracts.CommandWithParam;
import it.alten.doublechargg.pawtropolis.game.controller.GameManager;
import it.alten.doublechargg.pawtropolis.game.controller.utils.InputReader;
import it.alten.doublechargg.pawtropolis.game.map.enums.CardinalPoints;
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



    @Override
    public void execute(String arg) {
        var cardinalPoint = CardinalPoints.findByName(arg);
        var currentRoom = gameManager.getCurrentRoom();
        var player = gameManager.getCurrentRoom();

        if (Objects.isNull(cardinalPoint)) {
            log.log(Level.SEVERE, "Not valid input");
        }
        if (currentRoom.adjacentRoomExists(cardinalPoint)) {
            var door = currentRoom.getAdjacentDoorByCardinalPoint(cardinalPoint);

            if (door.getLocked()){
                log.info("The door is locked: would you like to use an item to unlock it?(y/n)");
                var answer = InputReader.readString();

                if (answer.equalsIgnoreCase("y")){
                    log.info("Type the name of the chosen item");
                    var answer2 = InputReader.readString();

                    if (answer2.equalsIgnoreCase("key")){
                        var result = player.removeItem(player.getItemByName("key").get()) ?
                                "You unlocked the door!" :
                                "You don't have a key!";
                            log.info(result);
                    }
                }
            }

            gameManager.setCurrentRoom(door.changeRoom());
            log.log(Level.INFO, STR."\{player.getName()} entered the room \{gameManager.getCurrentRoom()}\n" );
        }
       log.log(Level.SEVERE, "Not existant room");

    }
}
