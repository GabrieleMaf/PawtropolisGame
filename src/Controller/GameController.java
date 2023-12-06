package Controller;

import it.alten.doublechargg.pawtropolis.game.model.Item;
import it.alten.doublechargg.pawtropolis.game.model.Player;
import it.alten.doublechargg.pawtropolis.game.model.Room;
import it.alten.doublechargg.pawtropolis.game.observer.Observer;

public class GameController implements Observer {
    @Override
    public void onEnterRoom(Room room, Player player) {
        room.setPlayer(player);
        System.out.printf("%s è entrato nella stanza %s%n", player.getName(),  room.getName());
    }

    @Override
    public void onObjectAdded(Item item, Room room, Player player) {
        System.out.printf("%s ha preso l'oggetto %s nella stanza %s%n", player.getName(), item.getName(), room.getName());
    }

    @Override
    public void onObjectRemove(Item item, Room room, Player player) {
        System.out.printf("%s ha lasciato l'oggetto %s nella stanza %s%n", player.getName(), item.getName(), room.getName());
    }
}
