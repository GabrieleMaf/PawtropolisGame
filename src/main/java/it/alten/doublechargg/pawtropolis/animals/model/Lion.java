package it.alten.doublechargg.pawtropolis.animals.model;

import it.alten.doublechargg.pawtropolis.animals.model.abstracts.TailedAnimal;
import lombok.*;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data

public class Lion extends TailedAnimal {
    @Builder
    public Lion(String name, String favoriteFood, int age, LocalDate entryDate, double weight, double height, double tailLength) {
        super(name, favoriteFood, age, entryDate, weight, height, tailLength);
    }
}
