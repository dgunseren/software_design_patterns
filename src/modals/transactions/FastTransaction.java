package modals.transactions;

import interfaces.TransactionAPI;

public class FastTransaction implements TransactionAPI {
    @Override
    public boolean moneyTransfer(String from, String to, double amount) {
        if(amount > 1000) {
            return false;
        }
        System.out.println("FAST TRANSACTION OCCURED WITH " + amount + " Dollars.");
        return true;
    }
}
