package it.alten.doublechargg.pawtropolis.game.animals.domain;

import it.alten.doublechargg.pawtropolis.game.animals.domain.abstracts.TailedAnimal;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
public class Tiger extends TailedAnimal {
    @Builder
    public Tiger(String name, String favoriteFood, int age, LocalDate entryDate, double weight, double height, double tailLength) {
        super(name, favoriteFood, age, entryDate, weight, height, tailLength);
    }
}
