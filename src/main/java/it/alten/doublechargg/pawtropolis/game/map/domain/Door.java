package it.alten.doublechargg.pawtropolis.game.map.domain;

import lombok.Data;
import lombok.NonNull;

@Data
public class Door {

    private final Room roomA;

    private final Room roomB;

    @NonNull
    private Boolean locked;

    private boolean used = false;

    public Room changeRoom(){
        used = !used;
        return used ? roomB : roomA;
    }

    public String showState(){
        return Boolean.TRUE.equals(locked) ? "[OPEN]" : "[CLOSED]";
    }

}
