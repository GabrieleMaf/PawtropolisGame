package it.alten.doublechargg.pawtropolis.animals.model.abstracts;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class Animal {

    private String name;
    private String favoriteFood;
    private int age;
    private LocalDate entryDate;
    private double weight;
    private double height;

}