package it.alten.gmaferri.pawtropolis.game;

import java.util.ArrayList;
import java.util.List;

public class Bag {
    private List<Item> items;

    private final int SLOT = 10;

    public Bag(){
        items = new ArrayList<>();
    }
}
