package modals.transactions;

import abstracts.Transactions;
import interfaces.TransactionAPI;

public class Transaction extends Transactions {
    private final String from;
    private final String to;
    private final Double amount;

    public Transaction(String from, String to, double amount, TransactionAPI transactionAPI) {
        super(transactionAPI);
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    @Override
    public boolean transfer() {
        return transactionAPI.moneyTransfer(from, to, amount);
    }
}
