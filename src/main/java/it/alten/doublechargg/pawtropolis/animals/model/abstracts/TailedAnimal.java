package it.alten.doublechargg.pawtropolis.animals.model.abstracts;
<<<<<<<< HEAD:src/it/alten/doublechargg/pawtropolis/animals/model/abstracts/TailedAnimal.java
========

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
>>>>>>>> FEAT/SpringRework:src/main/java/it/alten/doublechargg/pawtropolis/animals/model/abstracts/TailedAnimal.java

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class TailedAnimal extends Animal {
    private double tailLength;

    protected TailedAnimal(String name, String favoriteFood, int age, LocalDate entryDate, double weight, double height, double tailLength) {
        super(name, favoriteFood, age, entryDate, weight, height);
        this.tailLength = tailLength;
    }
}
