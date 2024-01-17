package it.alten.doublechargg.pawtropolis.animals;

import it.alten.doublechargg.pawtropolis.animals.model.abstracts.Animal;
import it.alten.doublechargg.pawtropolis.animals.model.abstracts.TailedAnimal;
import it.alten.doublechargg.pawtropolis.animals.model.abstracts.WingedAnimal;

import java.lang.reflect.Modifier;
import java.util.*;
import java.util.stream.Collectors;

public class ZooController {
    private final Map<Class<? extends Animal>, List<Animal>> animals = new HashMap<>();

    public Map<Class<? extends Animal>, List<Animal>> getAnimals() {
        return animals;
    }

    public void addAnimal(Animal animal) {
        if (!animals.containsKey(animal.getClass())) {
            animals.put(animal.getClass(), new ArrayList<>());
        }
        if (!animals.get(animal.getClass()).contains(animal)) {
            animals.get(animal.getClass()).add(animal);
        }
    }

    public void removeAnimal(Animal animal) {
        if (animals.get(animal.getClass()).remove(animal) && (animals.get(animal.getClass()).isEmpty())) {
            animals.remove(animal.getClass());
        }
    }

    public String showAnimals() {
        return animals.values()
                .stream()
                .flatMap(Collection::stream)
                .toList()
                .stream()
                .map(Animal::toString)
                .collect(Collectors.joining("\n"));
    }

    public <T extends Animal> List<Animal> getAnimalGroup(Class<T> tClass) {
        if (!Modifier.isAbstract(tClass.getModifiers())) {
            return animals.get(tClass);
        }
        return animals.entrySet()
                .stream()
                .filter(classListEntry -> tClass.isAssignableFrom(classListEntry.getKey()))
                .map(Map.Entry::getValue)
                .flatMap(List::stream)
                .toList();
    }

    public <T extends Animal> Optional<Animal> getTallestAnimalByClass(Class<T> tClass) {
        if (Objects.isNull(getAnimalGroup(tClass))) {
            return Optional.empty();
        }
        return getAnimalGroup(tClass)
                .stream()
                .max(Comparator.comparing(Animal::getWeight));
    }


    public <T extends Animal> Optional<Animal> getShortestAnimalByClass(Class<T> tClass) {
        if (Objects.isNull(getAnimalGroup(tClass))) {
            return Optional.empty();
        }
        return getAnimalGroup(tClass)
                .stream()
                .min(Comparator.comparing(Animal::getHeight));
    }

    public <T extends Animal> Optional<Animal> getHeaviestAnimalByClass(Class<T> tClass) {
        if (Objects.isNull(getAnimalGroup(tClass))) {
            return Optional.empty();
        }
        return getAnimalGroup(tClass)
                .stream()
                .max(Comparator.comparing(Animal::getWeight));
    }

    public <T extends Animal> Optional<Animal> getLightestAnimalByClass(Class<T> tClass) {
        if (Objects.isNull(getAnimalGroup(tClass))) {
            return Optional.empty();
        }
        return getAnimalGroup(tClass)
                .stream()
                .min(Comparator.comparing(Animal::getWeight));
    }

    public Optional<TailedAnimal> getLongestTailedAnimal() {
        if (Objects.isNull(getAnimalGroup(TailedAnimal.class))) {
            return Optional.empty();
        }
        return getAnimalGroup(TailedAnimal.class)
                .stream()
                .map(TailedAnimal.class::cast)
                .max(Comparator.comparing(TailedAnimal::getTailLength));
    }

    public Optional<WingedAnimal> getWidestWingspanAnimal() {
        if (Objects.isNull(getAnimalGroup(WingedAnimal.class))) {
            return Optional.empty();
        }
        return getAnimalGroup(WingedAnimal.class)
                .stream()
                .map(WingedAnimal.class::cast)
                .max(Comparator.comparing(WingedAnimal::getWingspan));
    }

}
