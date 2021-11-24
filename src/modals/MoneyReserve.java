package modals;

public enum MoneyReserve {

    MONEY_RESERVE;
    int totalMoneyInReserve = 1000000;

    private MoneyReserve() {}

    public int getTotalMoneyInReserve() {
        return this.totalMoneyInReserve;
    }

    public void addToReserve(int amount) {
        this.totalMoneyInReserve += amount;
    }

    public void takeFromReserve(int amount) {
        this.totalMoneyInReserve -= amount;
    }
}
