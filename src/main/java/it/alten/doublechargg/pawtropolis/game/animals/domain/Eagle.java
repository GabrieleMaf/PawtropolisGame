package it.alten.doublechargg.pawtropolis.game.animals.domain;

import it.alten.doublechargg.pawtropolis.game.animals.domain.abstracts.WingedAnimal;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
public class Eagle extends WingedAnimal {
    @Builder
    public Eagle(String name, String favoriteFood, int age, LocalDate entryDate, double weight, double height, double wingspan) {
        super(name, favoriteFood, age, entryDate, weight, height, wingspan);
    }
}



