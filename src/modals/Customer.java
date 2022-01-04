package modals;

import abstracts.AbstractLogger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Customer {

    private String name;
    private String surname;
    private String address;
    private String email;
    private String password;
    private double salary;
    private double accountBalance;
    private int age;
    String INSERT_QUERY = "INSERT INTO people(name, surname, address, salary, age, password, email) VALUES (?, ?, ?, ?, ?, ?, ?)";
    String PASSWORD_QUERY = "SELECT * FROM people WHERE email = ?";
    String UPDATE_ACCOUNT_BALANCE_QUERY = "UPDATE people SET account_balance = ? WHERE email = ?";

    private Customer(Builder builder) {
        this.name = builder.name;
        this.surname = builder.surname;
        this.address = builder.address;
        this.email = builder.email;
        this.password = builder.password;
        this.salary = builder.salary;
        this.accountBalance = builder.accountBalance;
        this.age = builder.age;
    }

    public String getEmail() { return this.email; }

    public double getAccountBalance() { return this.accountBalance; }
    public void setAccountBalance(double accountBalance) throws SQLException {
        this.accountBalance = accountBalance;
        Connection conn = DBConnection.DB_CONN.getDBConnection();
        try {
            PreparedStatement statement = conn.prepareStatement(UPDATE_ACCOUNT_BALANCE_QUERY);
            statement.setDouble(1, accountBalance);
            statement.setString(2,email);
            statement.execute();
        } catch(Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void signUp(AbstractLogger<String> logger) throws SQLException {
        Connection conn = DBConnection.DB_CONN.getDBConnection();
        try {
            PreparedStatement statement = conn.prepareStatement(INSERT_QUERY);
            statement.setString(1, name);
            statement.setString(2, surname);
            statement.setString(3, address);
            statement.setDouble(4, salary);
            statement.setInt(5, age);
            statement.setString(6, password);
            statement.setString(7, email);
            statement.execute();
            logger.Log("USER " + name + " " + surname + " SIGNED UP SUCCESSFULLY.");
        } catch(Exception e) {
           System.err.println(e.getMessage());
        }
    }

    public Customer signIn(AbstractLogger<String> logger) throws SQLException {
        Connection conn = DBConnection.DB_CONN.getDBConnection();
        try {
            PreparedStatement statement = conn.prepareStatement(PASSWORD_QUERY);
            statement.setString(1,email);
            ResultSet rs = statement.executeQuery();
            rs.next();
            if(rs.getString(7).equals(password)) {
                name = rs.getString(1);
                surname = rs.getString(2);
                address = rs.getString(3);
                salary = rs.getDouble(4);
                age = rs.getInt(5);
                accountBalance = rs.getDouble(9);
                logger.Log("USER WITH EMAIL " + email + " SIGNED IN SUCCESSFULLY.");
                return this;
            } else {
                System.out.println("AUTHENTICATION FAILED.");
                return null;
            }
        } catch(Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    public static class Builder {
        private String name;
        private String surname;
        private String address;
        private final String email;
        private final String password;
        private double salary;
        private double accountBalance;
        private int age;

        public Builder(String email, String password) {
            if(email == null || password == null) {
                throw new IllegalArgumentException("Please fill the mandatory fields correctly.");
            }
            this.email = email;
            this.password = password;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder withAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder withAge(int age) {
            this.age = age;
            return this;
        }

        public Builder withSalary(double salary) {
            this.salary = salary;
            return this;
        }

        public Builder withAccountBalance(double accountBalance) {
            this.accountBalance = accountBalance;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }
}
