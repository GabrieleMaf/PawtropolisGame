package pawtropolis.map.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Door {

    @NonNull
    private Room roomA;
    @NonNull
    private Room roomB;
    @NonNull
    private Boolean locked;

    private boolean used;

    //TERNARY OPERATOR USING
    public String showState(){
        return !locked ? "OPEN" : "CLOSED";
    }

    public Room changeRoom(){
        used = !used;
        return !used ? roomB : roomA;
    }

}
