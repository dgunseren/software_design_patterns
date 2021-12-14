package modals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public enum Customer {
    CUSTOMER;
    String name;
    String surname;
    String address;
    double salary;
    int age;
    String email;
    String password;
    String INSERT_QUERY = "INSERT INTO people(name, surname, address, salary, age, password, email) VALUES (?, ?, ?, ?, ?, ?, ?)";
    String PASSWORD_QUERY = "SELECT * FROM people WHERE email = ?";

    Customer() {}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void signUp() throws SQLException {
        System.out.println("USER SIGNED UP");
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
        } catch(Exception e) {
           System.err.println(e.getMessage());
        }
    }

    public void signIn() throws SQLException {
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
                System.out.println("USER LOGGED IN SUCCESSFULLY.");
            } else {
                System.out.println("AUTHENTICATION FAILED.");
            }
        } catch(Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
