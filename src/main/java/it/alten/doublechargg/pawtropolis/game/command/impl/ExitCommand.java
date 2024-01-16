package it.alten.doublechargg.pawtropolis.game.command.impl;

import it.alten.doublechargg.pawtropolis.game.command.interfaces.CommandWithParam;
import it.alten.doublechargg.pawtropolis.game.controller.GameController;
import it.alten.doublechargg.pawtropolis.game.model.Player;
import it.alten.doublechargg.pawtropolis.game.model.Room;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Data
@Component
public class ExitCommand implements CommandWithParam {


    private GameController gameController;
    @Autowired
    public ExitCommand(GameController gameController) {
        this.gameController = gameController;
    }

    @Override
    public String execute(String arg) {
        gameController.setGameEnded(true);
        return "Exiting game";
    }
}
