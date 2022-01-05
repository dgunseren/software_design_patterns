package modals.transactions;

import modals.abstracts.AbstractLogger;
import modals.interfaces.TransactionAPI;
import modals.Customer;
import modals.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FastTransaction implements TransactionAPI {
    private AbstractLogger<String> logger;
    private String BALANCE_QUERY = "SELECT account_balance FROM people WHERE email = ?";
    private String UPDATE_QUERY = "UPDATE people SET account_balance = ? WHERE email = ?";

    public FastTransaction(AbstractLogger<String> logger) {
        this.logger = logger;
    }

    @Override
    public boolean moneyTransfer(Customer customer, String to, double amount) throws SQLException {
        if(amount > 1000) {
            System.out.println("FAST TRANSACTION FAILED. CANNOT PASS 1000$ LIMIT.");
            return false;
        }
        Connection conn = DBConnection.DB_CONN.getDBConnection();
        try {
            double senderAmount = customer.getAccountBalance();

            if(amount > senderAmount) {
                System.out.println("NOT ENOUGH MONEY ON YOUR ACCOUNT TO SEND THIS AMOUNT.");
                return false;
            }

            PreparedStatement receiverStatement = conn.prepareStatement(BALANCE_QUERY);
            receiverStatement.setString(1, to);
            ResultSet rs = receiverStatement.executeQuery();
            rs.next();
            double receiverAmount = rs.getDouble(1);

            PreparedStatement updateStatement = conn.prepareStatement(UPDATE_QUERY);
            updateStatement.setDouble(1, receiverAmount + amount);
            updateStatement.setString(2, to);
            updateStatement.execute();

            PreparedStatement paymentStatement = conn.prepareStatement(UPDATE_QUERY);
            paymentStatement.setDouble(1, senderAmount - amount);
            paymentStatement.setString(2, customer.getEmail());
            paymentStatement.execute();

            customer.setAccountBalance(senderAmount - amount);

            this.logger.Log("From " + customer.getEmail() + " FAST TRANSACTION OCCURED WITH " + amount + " Dollars to " + to);
            return true;
        } catch(Exception e) {
            System.out.println("AN ERROR OCCURED DURING TRANSACTION.");
            System.err.println(e.getMessage());
            return false;
        }
    }
}
