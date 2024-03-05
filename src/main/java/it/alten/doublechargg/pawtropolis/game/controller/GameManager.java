package it.alten.doublechargg.pawtropolis.game.controller;

import it.alten.doublechargg.pawtropolis.game.command.CommandFactory;
import it.alten.doublechargg.pawtropolis.game.command.domain.abstracts.CommandWithoutParam;
import it.alten.doublechargg.pawtropolis.game.command.exceptions.CommandFailedException;
import it.alten.doublechargg.pawtropolis.game.controller.utils.InputReader;
import it.alten.doublechargg.pawtropolis.game.map.MapFactory;
import it.alten.doublechargg.pawtropolis.game.map.domain.Room;
import it.alten.doublechargg.pawtropolis.game.player.domain.Player;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Log
@Component
@RequiredArgsConstructor
public class GameManager implements CommandLineRunner {

    private final MapFactory mapFactory;
    private final InputHandler inputController;
    private final CommandFactory commandFactory;
    @Setter
    @Getter
    private boolean gameEnded = false;
    @Setter
    @Getter
    private Player player;
    @Setter
    @Getter
    private Room currentRoom;

    public Player createPlayer() {
        log.info("Choose your name");
        return new Player(InputReader.readString());
    }

    public void startGame() {
        mapFactory.createMap();
        setPlayer(createPlayer());
        setCurrentRoom(mapFactory.getRoomList().getFirst());
        try {
            ((CommandWithoutParam) commandFactory.createCommand("Help")).execute();
        } catch (CommandFailedException e) {
            e.printStackTrace();
        }
        while (!gameEnded) {
            log.info("Write your action");
            try {
                inputController.handleInput(InputReader.readString());
            } catch (CommandFailedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run(String... args) {
        startGame();
    }
}

