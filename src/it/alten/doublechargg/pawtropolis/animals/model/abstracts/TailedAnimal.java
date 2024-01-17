package it.alten.doublechargg.pawtropolis.animals.model.abstracts;

import java.time.LocalDate;

public abstract class TailedAnimal extends Animal {
    private double tailLength;

    protected TailedAnimal(String name, String favoriteFood, int age, LocalDate entryDate, double weight, double height, double tailLength) {
        super(name, favoriteFood, age, entryDate, weight, height);
        this.tailLength = tailLength;
    }

    public double getTailLength() {
        return tailLength;
    }

    public void setTailLength(double tailLength) {
        this.tailLength = tailLength;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", tailLength:" + tailLength;
    }
}
