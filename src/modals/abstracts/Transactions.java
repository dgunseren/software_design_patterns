package modals.abstracts;

import modals.interfaces.TransactionAPI;

import java.sql.SQLException;

public abstract class Transactions {
    protected TransactionAPI transactionAPI;

    protected Transactions(TransactionAPI transactionAPI) {
        this.transactionAPI = transactionAPI;
    }

    public abstract boolean transfer() throws SQLException;
}
