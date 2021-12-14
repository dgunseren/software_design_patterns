package modals;

import modals.loggers.ConsoleLogger;
import modals.loggers.levels.LevelType;

public enum MoneyReserve {

    MONEY_RESERVE;
    int totalMoneyInReserve = 1000000;
    ConsoleLogger logger = new ConsoleLogger();

    private MoneyReserve() {}

    public int getTotalMoneyInReserve() {
        return this.totalMoneyInReserve;
    }

    public void addToReserve(int amount) {
        this.totalMoneyInReserve += amount;
        this.logger.log(LevelType.INFO, amount + " TL has been transferred to the reserve.");
    }

    public void takeFromReserve(int amount) {
        this.totalMoneyInReserve -= amount;
        this.logger.log(LevelType.INFO, amount + " TL has been taken from the reserve.");
    }
}
