package it.alten.doublechargg.pawtropolis.animals.model;

import it.alten.doublechargg.pawtropolis.animals.model.abstracts.TailedAnimal;

import java.time.LocalDate;

public class Tiger extends TailedAnimal {

    public Tiger(String name, String favoriteFood, int age, LocalDate entryDate, double weight, double height, double tailLength) {
        super(name, favoriteFood, age, entryDate, weight, height, tailLength);
    }

    @Override
    public String toString() {
        return String.format("Tiger{%s} ", super.toString());
    }
}
