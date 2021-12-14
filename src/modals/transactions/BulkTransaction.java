package modals.transactions;

import interfaces.TransactionAPI;

public class BulkTransaction implements TransactionAPI {
    @Override
    public boolean moneyTransfer(String from, String to, double amount) {
        System.out.println("Bulk money transfer request taken. " + amount + " Dollars.");
        return true;
    }
}
