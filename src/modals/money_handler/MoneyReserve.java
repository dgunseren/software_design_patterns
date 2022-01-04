package modals.money_handler;

import abstracts.AbstractLogger;

public enum MoneyReserve {

    MONEY_RESERVE;
    int totalMoneyInReserve = 1000000;

    private MoneyReserve() {}

    public int getTotalMoneyInReserve() {
        return this.totalMoneyInReserve;
    }

    public void addToReserve(int amount, AbstractLogger<String> logger) {
        this.totalMoneyInReserve += amount;
        logger.Log(amount + " TL has been transferred to the reserve.");
        logger.Log("Now, total amount of money in the reserve is: " + this.totalMoneyInReserve);
    }

    public void takeFromReserve(int amount, AbstractLogger<String> logger) {
        this.totalMoneyInReserve -= amount;
        logger.Log(amount + " TL has been taken from the reserve.");
        logger.Log("Now, total amount of money in the reserve is: " + this.totalMoneyInReserve);
    }
}
