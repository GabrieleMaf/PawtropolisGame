package it.alten.doublechargg.pawtropolis.game.command.impl;

import it.alten.doublechargg.pawtropolis.game.command.interfaces.CommandWithoutParam;
import it.alten.doublechargg.pawtropolis.game.controller.GameController;
import it.alten.doublechargg.pawtropolis.game.model.Player;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@Component
public class BagCommand implements CommandWithoutParam {

    private Player player;

    @Autowired
    public BagCommand(GameController gameController) {
        player = gameController.getPlayer();
    }

    @Override
    public String execute() {
        return player.showBagContent();
    }
}
