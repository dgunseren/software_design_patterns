package modals.accounts;

import modals.abstracts.AbstractLogger;
import modals.interfaces.VisitableAccount;
import modals.interfaces.Visitor;
import modals.Customer;
import modals.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CreditAccount implements VisitableAccount {
    private Connection conn;

    public CreditAccount() {
        try {
            conn = DBConnection.DB_CONN.getDBConnection();
        } catch(SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public double accept(Visitor visitor) {
        return visitor.visit(this);
    }

    public double displayCreditAccount(Customer customer, AbstractLogger<String> logger) {
        final String BALANCE_QUERY = "SELECT account_balance FROM people WHERE email = ?";
        try {
            PreparedStatement receiverStatement = conn.prepareStatement(BALANCE_QUERY);
            receiverStatement.setString(1, customer.getEmail());
            ResultSet rs = receiverStatement.executeQuery();
            rs.next();
            double amount = rs.getDouble(1);
            logger.Log(amount + "$ IN THE CASH ACCOUNT.");
            return amount;
        } catch(Exception e) {
            System.out.println("AN ERROR OCCURED DURING THE SERVICE. PLEASE TRY AGAIN LATER.");
            System.err.println(e.getMessage());
            return 0.0;
        }
    }
}
