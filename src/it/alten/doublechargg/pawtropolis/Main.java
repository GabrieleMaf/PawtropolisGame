package it.alten.doublechargg.pawtropolis;

import it.alten.doublechargg.pawtropolis.game.controller.GameController;

public class Main {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.startGame();
    }
}