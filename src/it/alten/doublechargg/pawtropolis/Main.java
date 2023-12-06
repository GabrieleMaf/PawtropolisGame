package it.alten.doublechargg.pawtropolis;

import it.alten.doublechargg.pawtropolis.game.controller.GameController;
import it.alten.doublechargg.pawtropolis.game.model.Player;

public class Main {
    public static void main(String[] args) {

        GameController gameController = new GameController();

        Player player1 = gameController.createPlayer();
        gameController.startGame(player1);

    }
}