package modals.interfaces;

import modals.Customer;

import java.sql.SQLException;

public interface TransactionAPI {
    public boolean moneyTransfer(Customer customer, String to, double amount);
}
