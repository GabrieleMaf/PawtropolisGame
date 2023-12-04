package it.alten.gmaferri.pawtropolis.animals.model;

import it.alten.gmaferri.pawtropolis.animals.model.abstracts.TailedAnimal;

import java.time.LocalDate;

public class Lion extends TailedAnimal {

    public Lion(String name, String favoriteFood, int age, LocalDate entryDate, double weight, double height, double tailLength) {
        super(name, favoriteFood, age, entryDate, weight, height, tailLength);
    }

    @Override
    public String toString() {
        return String.format("Lion{%s} ", super.toString());
    }

}
