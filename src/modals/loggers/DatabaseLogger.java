package modals.loggers;

import modals.abstracts.AbstractLogger;
import modals.DBConnection;
import modals.loggers.levels.LevelType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseLogger extends AbstractLogger<String> {
    private final String LOG_QUERY = "INSERT INTO logs(operation) VALUES (?)";
    private Connection conn;

    public DatabaseLogger() {
        try {
            conn = DBConnection.DB_CONN.getDBConnection();
        } catch(SQLException sqlException) {
            System.err.println(sqlException.getMessage());
        }
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
