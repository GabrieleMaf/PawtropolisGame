package it.alten.doublechargg.pawtropolis.animals.model;

import it.alten.doublechargg.pawtropolis.animals.model.abstracts.WingedAnimal;
import lombok.*;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
public class Eagle extends WingedAnimal {
    @Builder
    public Eagle(String name, String favoriteFood, int age, LocalDate entryDate, double weight, double height, double wingspan) {
        super(name, favoriteFood, age, entryDate, weight, height, wingspan);
    }
}



