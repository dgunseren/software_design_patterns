package abstracts;

import interfaces.TransactionAPI;

public abstract class Transactions {
    protected TransactionAPI transactionAPI;

    protected Transactions(TransactionAPI transactionAPI) {
        this.transactionAPI = transactionAPI;
    }

    public abstract boolean transfer();
}
