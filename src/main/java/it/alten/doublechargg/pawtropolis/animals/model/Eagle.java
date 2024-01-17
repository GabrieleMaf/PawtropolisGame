package it.alten.doublechargg.pawtropolis.animals.model;

import it.alten.doublechargg.pawtropolis.animals.model.abstracts.WingedAnimal;
<<<<<<<< HEAD:src/it/alten/doublechargg/pawtropolis/animals/model/Eagle.java
========
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
>>>>>>>> FEAT/SpringRework:src/main/java/it/alten/doublechargg/pawtropolis/animals/model/Eagle.java

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
public class Eagle extends WingedAnimal {
<<<<<<<< HEAD:src/it/alten/doublechargg/pawtropolis/animals/model/Eagle.java

========
    @Builder
>>>>>>>> FEAT/SpringRework:src/main/java/it/alten/doublechargg/pawtropolis/animals/model/Eagle.java
    public Eagle(String name, String favoriteFood, int age, LocalDate entryDate, double weight, double height, double wingspan) {
        super(name, favoriteFood, age, entryDate, weight, height, wingspan);
    }
}



