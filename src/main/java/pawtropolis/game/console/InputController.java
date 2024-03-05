package pawtropolis.game.console;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class InputController {
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
