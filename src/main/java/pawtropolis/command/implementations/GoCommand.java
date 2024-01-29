package pawtropolis.command.implementations;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pawtropolis.game.GameController;
import pawtropolis.game.console.InputController;
import pawtropolis.game.domain.Player;
import pawtropolis.map.domain.Direction;
import pawtropolis.map.domain.Door;
import pawtropolis.map.domain.Room;

import java.util.Optional;

@Component
@Log
public class GoCommand extends AbstractParametrizedCommand {
    @Autowired
    private GoCommand(GameController gameController) {
        super(gameController);
    }



    @Override
    public void execute() {
        String selectedDirectionName = String.join(" ", parameters);

        Optional<Direction> directionOptional = Direction.getDirectionByString(selectedDirectionName);
        if (directionOptional.isEmpty()) {
            System.out.println("Invalid direction");
            return;
        }
        Direction direction = directionOptional.get();
        Door door = gameController.getCurrentRoom().getAdjacentDoorByDirection(direction);

        if (door.getLocked()) {
           if (!unlockDoor(door)){
               return;
           }
        }
        Room destinationRoom = door.changeRoom();
        System.out.println(destinationRoom);
        gameController.setCurrentRoom(destinationRoom);
    }

private boolean unlockDoor(Door door){

        System.out.println("The door is locked: would you like to use an item to unlock it?(y/n)");
        String answer = InputController.readString();
        Player player = gameController.getPlayer();

    if(answer.equalsIgnoreCase("y")) {
        System.out.println("Type the name of the chosen item");
        answer = InputController.readString();

        if (answer.equalsIgnoreCase("key") && player.getItemByName("key").isPresent()) {
            door.setLocked(false);
            player.removeItem(player.getItemByName("key").get());
            System.out.println("You unlocked the door!");
            return true;
            }
        else {
            System.out.println("You don't have a key!");
        }
        }
    return false;
    }
}