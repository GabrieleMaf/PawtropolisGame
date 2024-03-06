package it.alten.doublechargg.pawtropolis.game.controller.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class InputReader {
    public static String readString() {
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return inputReader.readLine();
        } catch (IOException e) {
            System.err.println("Error while reading user input");
            return "";
        }
    }
}
