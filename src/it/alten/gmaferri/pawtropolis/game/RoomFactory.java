package it.alten.gmaferri.pawtropolis.game;

import java.util.Objects;
import java.util.Random;

public class RoomFactory {
    private static RoomFactory instance = null;

    Random randomizer = new Random();

    private RoomFactory(){

    }

    public static synchronized RoomFactory getInstance(){
        if(Objects.isNull(instance)){
            instance = new RoomFactory();
        }
        return instance;
    }

    public Room createRoom(){
        return new Room(Integer.valueOf(randomizer.nextInt()).toString());
    }
}
