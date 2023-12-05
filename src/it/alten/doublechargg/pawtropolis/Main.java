package it.alten.doublechargg.pawtropolis;

import it.alten.doublechargg.pawtropolis.game.factory.RoomFactory;
import it.alten.doublechargg.pawtropolis.game.model.Bag;
import it.alten.doublechargg.pawtropolis.game.model.Item;
import it.alten.doublechargg.pawtropolis.game.model.Player;
import it.alten.doublechargg.pawtropolis.game.model.Room;
import it.alten.doublechargg.pawtropolis.game.utilities.Utilities;

public class Main {
    public static void main(String[] args) {

        RoomFactory roomFactory = RoomFactory.getInstance();

        Player player1 = Utilities.createPlayer();
        Room room = roomFactory.createRoom();
        Room room2 = roomFactory.createRoom();
        player1.enterRoom(room);

        player1.getItem(room.getItemById(1L));
        player1.getItem(room.getItemById(2L));
        player1.getItem(room.getItemById(3L));
        player1.getItem(room.getItemById(4L));

        System.out.println(player1.getBag().showItems());

        player1.enterRoom(room2);



    }
}