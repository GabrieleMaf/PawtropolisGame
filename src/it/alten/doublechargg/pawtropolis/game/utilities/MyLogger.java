package it.alten.doublechargg.pawtropolis.game.utilities;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyLogger {
    private static final Logger logger = Logger.getLogger("MyLogger");
    private static MyLogger instance;

    private MyLogger() {

    }

    public static synchronized MyLogger getInstance() {
        if (Objects.isNull(instance)) {
            instance = new MyLogger();
        }
        return instance;
    }

    public void logInfo(String message) {
        logger.log(Level.INFO, "\u001B[37m" + "{0}" + "\u001B[0m", message);
    }

    public void logWarning(String message) {
        logger.log(Level.WARNING, "\u001B[33m" + "{0}" + "\u001B[0m", message);
    }

    public void logError(String message) {
        logger.log(Level.SEVERE, "\u001B[31m" + "{0}" + "\u001B[0m", message);
    }
}
