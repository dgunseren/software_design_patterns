package modals.transactions;

import abstracts.Transactions;
import interfaces.TransactionAPI;
import modals.Customer;

import java.sql.SQLException;

public class Transaction extends Transactions {
    private final Customer customer;
    private final String to;
    private final Double amount;

    public Transaction(Customer customer, String to, double amount, TransactionAPI transactionAPI) {
        super(transactionAPI);
        this.customer = customer;
        this.to = to;
        this.amount = amount;
    }

    @Override
    public boolean transfer() throws SQLException {
        return transactionAPI.moneyTransfer(customer, to, amount);
    }
}
