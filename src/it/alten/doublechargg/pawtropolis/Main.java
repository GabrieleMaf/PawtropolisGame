package it.alten.doublechargg.pawtropolis;

import it.alten.doublechargg.pawtropolis.game.controller.GameController;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args){
        GameController gameController = GameController.getInstance();
        gameController.startGame();
    }
}