package modals.loggers;

import abstracts.AbstractLogger;
import modals.DBConnection;
import modals.loggers.levels.LevelType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseLogger extends AbstractLogger<String> {
    private final String LOG_QUERY = "INSERT INTO logs(operation) VALUES (?)";
    private final Connection conn = DBConnection.DB_CONN.getDBConnection();

    public DatabaseLogger() throws SQLException {
    }

    @Override
    protected void log(LevelType type, String message) {
        try {
            PreparedStatement statement = conn.prepareStatement(LOG_QUERY);
            statement.setString(1, message);
            statement.execute();
        } catch(Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
