package it.alten.doublechargg.pawtropolis;

import it.alten.doublechargg.pawtropolis.game.MapController;
import it.alten.doublechargg.pawtropolis.game.enums.CardinalPoints;
import it.alten.doublechargg.pawtropolis.game.factory.RoomFactory;
import it.alten.doublechargg.pawtropolis.game.model.Player;
import it.alten.doublechargg.pawtropolis.game.utilities.Utilities;

import java.io.Console;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Player player1 = Utilities.createPlayer();
        Utilities.startGame(player1);



    }
}