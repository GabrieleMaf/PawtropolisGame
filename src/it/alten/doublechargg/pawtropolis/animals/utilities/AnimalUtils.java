package it.alten.doublechargg.pawtropolis.animals.utilities;

import it.alten.doublechargg.pawtropolis.animals.model.abstracts.Animal;

public class AnimalUtils {

    public static String getNameFormat(Animal animal) {
        return String.format("%s(%s)", animal.getName(), animal.getClass().getSimpleName());
    }
}
