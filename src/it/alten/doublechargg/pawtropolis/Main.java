package it.alten.doublechargg.pawtropolis;

import it.alten.doublechargg.pawtropolis.animals.AnimalFactory;
import it.alten.doublechargg.pawtropolis.animals.ZooController;
import it.alten.doublechargg.pawtropolis.animals.model.Eagle;
import it.alten.doublechargg.pawtropolis.animals.model.Tiger;
import it.alten.doublechargg.pawtropolis.animals.model.Lion;

public class Main {
    public static void main(String[] args) {

        ZooController zoo = new ZooController();
        AnimalFactory animalFactory = AnimalFactory.getInstance();


        zoo.addAnimal(animalFactory.createEagle());
        zoo.addAnimal(animalFactory.createEagle());
        zoo.addAnimal(animalFactory.createEagle());

        zoo.addAnimal(animalFactory.createTiger());
        zoo.addAnimal(animalFactory.createTiger());
        zoo.addAnimal(animalFactory.createTiger());

        zoo.addAnimal(animalFactory.createLion());
        zoo.addAnimal(animalFactory.createLion());
        zoo.addAnimal(animalFactory.createLion());


        System.out.println(zoo.showAnimals());
        System.out.println();

        System.out.printf("The tallest Tiger in zoo is %s%n", zoo.getTallestAnimalByClass(Tiger.class).orElse(null));
        System.out.printf("The tallest Eagle in zoo is %s%n", zoo.getTallestAnimalByClass(Eagle.class).orElse(null));
        System.out.printf("The tallest Lion in zoo is %s%n", zoo.getTallestAnimalByClass(Lion.class).orElse(null));
        System.out.println();

        System.out.printf("The shortest Tiger in zoo is %s%n", zoo.getShortestAnimalByClass(Tiger.class).orElse(null));
        System.out.printf("The shortest Eagle in zoo is %s%n", zoo.getShortestAnimalByClass(Eagle.class).orElse(null));
        System.out.printf("The shortest Lion in zoo is %s%n", zoo.getShortestAnimalByClass(Lion.class).orElse(null));
        System.out.println();

        System.out.printf("The heaviest Tiger in zoo is %s%n", zoo.getHeaviestAnimalByClass(Tiger.class).orElse(null));
        System.out.printf("The heaviest Eagle in zoo is %s%n", zoo.getHeaviestAnimalByClass(Eagle.class).orElse(null));
        System.out.printf("The heaviest Lion in zoo is %s%n", zoo.getHeaviestAnimalByClass(Lion.class).orElse(null));
        System.out.println();

        System.out.printf("The lightest Tiger in zoo is %s%n", zoo.getLightestAnimalByClass(Tiger.class).orElse(null));
        System.out.printf("The lightest Eagle in zoo is %s%n",  zoo.getLightestAnimalByClass(Eagle.class).orElse(null));
        System.out.printf("The lightest Lion in zoo is %s%n", zoo.getLightestAnimalByClass(Lion.class).orElse(null));
        System.out.println();

        System.out.println(zoo.getLongestTailedAnimal());
        System.out.println(zoo.getWidestWingspanAnimal());

    }
}