package it.alten.gmaferri.pawtropolis.game;

public class MapController {
    private Room[][] rooms;

    public MapController(){

    }

    public static Room[][] createBoard(){
        RoomFactory instance = RoomFactory.getInstance();
        return new Room[][] { {instance.createRoom()},
                {instance.createRoom(), instance.createRoom(), instance.createRoom()},
                { },
                { }};

    }



}
