import abstracts.AbstractLogger;
import abstracts.Transactions;
import interfaces.VisitableAccount;
import modals.Customer;
import modals.DBConnection;
import modals.MoneyReserve;
import modals.accounts.Account;
import modals.accounts.AccountVisitor;
import modals.loggers.ConsoleLogger;
import modals.loggers.DatabaseLogger;
import modals.transactions.BulkTransaction;
import modals.transactions.FastTransaction;
import modals.transactions.Transaction;
import java.sql.SQLException;

/*
    LET'S WRITE WHICH DESIGN PATTERN USED IN WHICH PART OF THE SYSTEM
    MoneyReserve -> Singleton
    Logger -> Template Method
    Customer -> Singleton
    Monetary Transactions -> Bridge
* */

class runner{
    public static void main(String args[]) throws SQLException {
        DBConnection.DB_CONN.startConnection();
        AbstractLogger<String> logger = new ConsoleLogger();

        MoneyReserve.MONEY_RESERVE.addToReserve(4000, logger);
        MoneyReserve.MONEY_RESERVE.takeFromReserve(2000, logger);

        logger = new DatabaseLogger();
        Customer.CUSTOMER.setName("Atakan");
        Customer.CUSTOMER.setSurname("Atik");
        Customer.CUSTOMER.setAddress("Atasehir");
        Customer.CUSTOMER.setAge(24);
        Customer.CUSTOMER.setSalary(2400);
        Customer.CUSTOMER.setPassword("mypass");
        Customer.CUSTOMER.setEmail("ataman.atik@ozu.edu.tr");
        Customer.CUSTOMER.signUp(logger);


        Customer.CUSTOMER.setName("Deniz");
        Customer.CUSTOMER.setSurname("Gunseren");
        Customer.CUSTOMER.setAddress("Besiktas");
        Customer.CUSTOMER.setAge(24);
        Customer.CUSTOMER.setSalary(3500);
        Customer.CUSTOMER.setPassword("denizpass");
        Customer.CUSTOMER.setEmail("deniz.gunseren@ozu.edu.tr");
        Customer.CUSTOMER.signUp(logger);

        logger = new ConsoleLogger();
        Customer.CUSTOMER.setEmail("ataman.atik@ozu.edu.tr");
        Customer.CUSTOMER.setPassword("mypass");
        Customer.CUSTOMER.signIn(logger);

        VisitableAccount account = new Account();
        account.accept(new AccountVisitor(logger));

        logger = new DatabaseLogger();
        Transactions fastTransaction = new Transaction("ataman.atik@ozu.edu.tr", "deniz.gunseren@ozu.edu.tr", 1000, new FastTransaction(logger));
        fastTransaction.transfer();

        Transactions bulkTransaction = new Transaction("ataman.atik@ozu.edu.tr", "deniz.gunseren@ozu.edu.tr", 2000, new BulkTransaction(logger));
        bulkTransaction.transfer();
    }
}
