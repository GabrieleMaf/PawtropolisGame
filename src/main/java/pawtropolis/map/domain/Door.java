package pawtropolis.map.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Door {
    private Room room1;
    private Room room2;
    private Boolean locked;

    //TERNARY OPERATOR USING
    public String showState(){
        return !locked ? "OPEN" : "CLOSED";
    }

}
