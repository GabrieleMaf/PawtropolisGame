package it.alten.gmaferri.pawtropolis.game.model;

public class Door {
    private Room room1;
    private Room room2;

    public Door(Room room1, Room room2){
        this.room1 = room1;
        this.room2 = room2;
    }

    public Room getRoom1() {
        return room1;
    }

    public Room getRoom2() {
        return room2;
    }

    public Room connectRoom(Room currentRoom, Room room){
        if(currentRoom == room1){
            return room2;
        } else if(currentRoom == room2){
            return room1;
        } else{
            return null;
        }
    }
}
