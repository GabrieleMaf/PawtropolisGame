package it.alten.doublechargg.pawtropolis;

import it.alten.doublechargg.pawtropolis.game.model.Bag;
import it.alten.doublechargg.pawtropolis.game.model.Item;
import it.alten.doublechargg.pawtropolis.game.model.Player;
import it.alten.doublechargg.pawtropolis.game.model.Room;

public class Main {
    public static void main(String[] args) {

        Player player1 = new Player("Gioele", 20, new Bag());

        Room room1 = new Room("A1");
        room1.registerObserver(player1);
        room1.getItem(new Item("Torch", "A torch", 2), room1);
        room1.dropItem(room1.getItems().get(0), room1);



    }
}