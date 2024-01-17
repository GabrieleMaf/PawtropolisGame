package it.alten.doublechargg.pawtropolis.animals.model.abstracts;

import java.time.LocalDate;

public abstract class WingedAnimal extends Animal {
    private double wingspan;

    protected WingedAnimal(String name, String favoriteFood, int age, LocalDate entryDate, double weight, double height, double wingspan) {
        super(name, favoriteFood, age, entryDate, weight, height);
        this.wingspan = wingspan;
    }

    public double getWingspan() {
        return wingspan;
    }

    public void setWingspan(double wingspan) {
        this.wingspan = wingspan;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", wingspan:" + wingspan;
    }
}


