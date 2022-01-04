package modals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public enum DBConnection {
    DB_CONN;
    Connection conn;

    DBConnection() {}

    public void startConnection() {
        try {
            this.conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bankingapi", "postgres", "postgres");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Connection getDBConnection() throws SQLException {
        if(this.conn.isValid(1000)) {
            return this.conn;
        }
        return null;
    }
}


