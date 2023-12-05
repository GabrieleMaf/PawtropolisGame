package it.alten.doublechargg.pawtropolis;

import it.alten.doublechargg.pawtropolis.game.model.Player;
import it.alten.doublechargg.pawtropolis.game.utilities.Utilities;

public class Main {
    public static void main(String[] args) {

        Player player1 = Utilities.createPlayer();
        Utilities.startGame(player1);

    }
}