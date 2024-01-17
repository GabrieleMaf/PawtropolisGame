package it.alten.doublechargg.pawtropolis.animals.model.abstracts;
<<<<<<<< HEAD:src/it/alten/doublechargg/pawtropolis/animals/model/abstracts/WingedAnimal.java
========

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
>>>>>>>> FEAT/SpringRework:src/main/java/it/alten/doublechargg/pawtropolis/animals/model/abstracts/WingedAnimal.java

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class WingedAnimal extends Animal {
    private double wingspan;

    protected WingedAnimal(String name, String favoriteFood, int age, LocalDate entryDate, double weight, double height, double wingspan) {
        super(name, favoriteFood, age, entryDate, weight, height);
        this.wingspan = wingspan;
    }
}


