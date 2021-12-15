package interfaces;

import java.sql.SQLException;

public interface TransactionAPI {
    public boolean moneyTransfer(String from, String to, double amount) throws SQLException;
}
