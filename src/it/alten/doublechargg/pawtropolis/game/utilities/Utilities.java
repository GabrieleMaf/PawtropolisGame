package it.alten.doublechargg.pawtropolis.game.utilities;

import it.alten.doublechargg.pawtropolis.game.model.Player;

import java.util.Scanner;

public class Utilities {

    static Scanner scanner = new Scanner(System.in);

    public static Player createPlayer(){
        System.out.println("Scegli il nome del tuo giocatore");
        return new Player(scanner.next());
    }

}
