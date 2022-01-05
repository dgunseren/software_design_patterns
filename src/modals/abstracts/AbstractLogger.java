package modals.abstracts;

import modals.loggers.levels.LevelType;

public abstract class AbstractLogger<T> {
    private LevelType levelType = LevelType.INFO;

    protected abstract void log(LevelType type, T message);
    public void setLevelType(LevelType type) {
        this.levelType = type;
    }
    public final void Log(T message) {
        log(this.levelType, message);
    }
}
