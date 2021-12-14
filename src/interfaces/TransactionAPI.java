package interfaces;

public interface TransactionAPI {
    public boolean moneyTransfer(String from, String to, double amount);
}
