package it.alten.doublechargg.pawtropolis.game.command.impl;

import it.alten.doublechargg.pawtropolis.game.command.interfaces.CommandWithoutParam;
import it.alten.doublechargg.pawtropolis.game.controller.GameController;
import it.alten.doublechargg.pawtropolis.game.model.Player;
import it.alten.doublechargg.pawtropolis.game.model.Room;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
@Data
@Component
public class BagCommand implements CommandWithoutParam {

    private Player player;

    @Autowired
    public BagCommand(ApplicationContext context) {
        player = context.getBean(GameController.class).getPlayer();
    }

    @Override
    public String execute() {
        return player.showBagContent();
    }
}
