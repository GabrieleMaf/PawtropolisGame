package it.alten.doublechargg.pawtropolis.game.animals.utilities;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class FactoryUtils {

    public static final DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
    public static final DecimalFormat decimalFormat = new DecimalFormat("#.##", symbols);
    public static final Random randomizer = new Random();
    public static final List<String> names = List.of(
            "Jose", "Teixeira", "Denis", "Lian", "Luffy", "Titti",
            "Pippo", "Pluto", "Paperino", "Monkey", "Tabasco", "Shadow",
            "Mr Dirty", "Vanilla", "Pebbles", "Ashley", "Charcoal", "Puffin",
            "Stewie", "Nermal", "Cinder", "Stormy", "Pebble", "Sputnik", "Bagpuss",
            "Licorice", "Tiddles", "Dusty", "Ismael", "Abraham", "Ash", "Duncan");
    public static final List<String> favoriteFoods = List.of(
            "Humans", "Carrots", "Potatoes", "Chicken", "Fish",
            "Cheese", "Egg", "Butter", "Margarine", "Yogurt",
            "Sandwich", "Sausage", "Hamburger");

    private FactoryUtils() {
    }

    public static LocalDate between(LocalDate startInclusive, LocalDate endExclusive) {
        long startEpochDay = startInclusive.toEpochDay();
        long endEpochDay = endExclusive.toEpochDay();
        long randomDay = ThreadLocalRandom
                .current()
                .nextLong(startEpochDay, endEpochDay);

        return LocalDate.ofEpochDay(randomDay);
    }
}
