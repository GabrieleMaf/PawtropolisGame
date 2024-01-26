package pawtropolis.map.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Door {
    private Room startRoom;
    private Room destinationRoom;
    private Boolean locked;

    //TERNARY OPERATOR USING
    public String showState(){
        return !locked ? "OPEN" : "CLOSED";
    }

    /*public Room changeRoom(){
        //I use this variable to save the room1, otherwise the value would be lost.
        Room savedRoom = room1;
        room1 = room2;
        room2 = savedRoom;
        return room1;
    }*/

}
