package it.alten.doublechargg.pawtropolis.game.animals.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FactoryUtils {

    public static final DecimalFormatSymbols SYMBOLS = new DecimalFormatSymbols(Locale.US);
    public static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.##", SYMBOLS);
    public static final Random RANDOMIZER = new Random();
    public static final List<String> NAMES = List.of(
            "Jose", "Teixeira", "Denis", "Lian", "Luff", "Tutti",
            "Pippo", "Pluto", "Papering", "Monkey", "Tabasco", "Shadow",
            "Mr Dirty", "Vanilla", "Pebbles", "Ashley", "Charcoal", "Puffin",
            "Stew", "Normal", "Cinder", "Stormy", "Pebble", "Sputnik", "Bagpipes",
            "Licorice", "Middles", "Dusty", "Ismael", "Abraham", "Ash", "Duncan");
    public static final List<String> FAVORITE_FOODS = List.of(
            "Humans", "Carrots", "Potatoes", "Chicken", "Fish",
            "Cheese", "Egg", "Butter", "Margarine", "Yogurt",
            "Sandwich", "Sausage", "Hamburger");

    public static LocalDate between(LocalDate startInclusive, LocalDate endExclusive) {
        long startEpochDay = startInclusive.toEpochDay();
        long endEpochDay = endExclusive.toEpochDay();
        long randomDay = ThreadLocalRandom
                .current()
                .nextLong(startEpochDay, endEpochDay);

        return LocalDate.ofEpochDay(randomDay);
    }
}
