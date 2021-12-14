import modals.Customer;
import modals.DBConnection;
import modals.MoneyReserve;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
    LET'S WRITE WHICH DESIGN PATTERN USED IN WHICH PART OF THE SYSTEM
    MoneyReserve -> Singleton
    Logger -> Template Method
* */

class runner{
    public static void main(String args[]) throws SQLException {
        DBConnection.DB_CONN.startConnection();

        System.out.println("Hello Java");
        MoneyReserve.MONEY_RESERVE.addToReserve(4000);
        System.out.println("total money in reserve " + MoneyReserve.MONEY_RESERVE.getTotalMoneyInReserve());
        MoneyReserve.MONEY_RESERVE.takeFromReserve(2000);
        System.out.println("total money in reserve " + MoneyReserve.MONEY_RESERVE.getTotalMoneyInReserve());

        Customer.CUSTOMER.setName("Atakan");
        Customer.CUSTOMER.setSurname("Atik");
        Customer.CUSTOMER.setAddress("Atasehir");
        Customer.CUSTOMER.setAge(24);
        Customer.CUSTOMER.setSalary(2400);
        Customer.CUSTOMER.setPassword("mypass");
        Customer.CUSTOMER.setEmail("ataman.atik@ozu.edu.tr");
        Customer.CUSTOMER.signUp();

        Customer.CUSTOMER.setEmail("ataman.atik@ozu.edu.tr");
        Customer.CUSTOMER.setPassword("1223423");
        Customer.CUSTOMER.signIn();
        System.out.println(Customer.CUSTOMER.getName() + " " + Customer.CUSTOMER.getSurname());
    }
}
