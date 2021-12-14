package modals.loggers;

import abstracts.AbstractLogger;
import modals.loggers.levels.LevelType;

public class ConsoleLogger extends AbstractLogger<String> {
    @Override
    public void log(LevelType levelType, String message) {
        System.out.println(levelType + ": " + message);
    }
}
