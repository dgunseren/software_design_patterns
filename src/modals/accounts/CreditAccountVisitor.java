package modals.accounts;

import interfaces.Visitor;
import modals.Customer;
import modals.DBConnection;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CreditAccountVisitor implements Visitor {
    private final Customer customer = Customer.CUSTOMER;
    private final Connection conn = DBConnection.DB_CONN.getDBConnection();

    public CreditAccountVisitor() throws SQLException {
    }

    @Override
    public void visit(CreditAccount creditAccount) {
        creditAccount.accept(this);
    }

    public double CashAccountBalance() {
        final String BALANCE_QUERY = "SELECT account_balance FROM people WHERE email = ?";
        try {
            PreparedStatement receiverStatement = conn.prepareStatement(BALANCE_QUERY);
            receiverStatement.setString(1, customer.getEmail());
            ResultSet rs = receiverStatement.executeQuery();
            rs.next();
            return rs.getDouble(1);
        } catch(Exception e) {
            System.out.println("AN ERROR OCCURED DURING THE SERVICE. PLEASE TRY AGAIN LATER.");
            System.err.println(e.getMessage());
            return 0.0;
        }
    }
    public double SavingAccountBalance() {
        final String BALANCE_QUERY = "SELECT saving FROM people WHERE email = ?";
        try {
            PreparedStatement receiverStatement = conn.prepareStatement(BALANCE_QUERY);
            receiverStatement.setString(1, customer.getEmail());
            ResultSet rs = receiverStatement.executeQuery();
            rs.next();
            return rs.getDouble(1);
        } catch(Exception e) {
            System.out.println("AN ERROR OCCURED DURING THE SERVICE. PLEASE TRY AGAIN LATER.");
            System.err.println(e.getMessage());
            return 0.0;
        }
    }
    public double CarLoanAccountBalance() {
        final String BALANCE_QUERY = "SELECT car_loan FROM people WHERE email = ?";
        try {
            PreparedStatement receiverStatement = conn.prepareStatement(BALANCE_QUERY);
            receiverStatement.setString(1, customer.getEmail());
            ResultSet rs = receiverStatement.executeQuery();
            rs.next();
            return rs.getDouble(1);
        } catch(Exception e) {
            System.out.println("AN ERROR OCCURED DURING THE SERVICE. PLEASE TRY AGAIN LATER.");
            System.err.println(e.getMessage());
            return 0.0;
        }
    }
    public double HouseLoanAccountBalance() {
        final String BALANCE_QUERY = "SELECT house_loan FROM people WHERE email = ?";
        try {
            PreparedStatement receiverStatement = conn.prepareStatement(BALANCE_QUERY);
            receiverStatement.setString(1, customer.getEmail());
            ResultSet rs = receiverStatement.executeQuery();
            rs.next();
            return rs.getDouble(1);
        } catch(Exception e) {
            System.out.println("AN ERROR OCCURED DURING THE SERVICE. PLEASE TRY AGAIN LATER.");
            System.err.println(e.getMessage());
            return 0.0;
        }
    }

    public void visit(DebitAccount debitAccount) {
        //No action
    }
}
