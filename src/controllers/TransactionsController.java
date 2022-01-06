package controllers;

import modals.Customer;
import modals.abstracts.AbstractLogger;
import modals.abstracts.Transactions;
import modals.loggers.DatabaseLogger;
import modals.transactions.BulkTransaction;
import modals.transactions.FastTransaction;
import modals.transactions.Transaction;
import views.TransactionsView;

public class TransactionsController {
    AbstractLogger<String> logger = new DatabaseLogger();
    private Customer customer;
    private TransactionsView transactionsView;

    public TransactionsController(Customer customer, TransactionsView transactionsView) {
        this.customer = customer;
        this.transactionsView = transactionsView;
    }

    public boolean handleFastTransfer(String to, int amount) {
        Transactions fastTransaction = new Transaction(customer, to, amount, new FastTransaction(logger));
        return fastTransaction.transfer();

    }

    public boolean handleBulkTransfer(String to, int amount) {
        Transactions bulkTransaction = new Transaction(customer, to, amount, new BulkTransaction(logger));
        return bulkTransaction.transfer();
    }
}
