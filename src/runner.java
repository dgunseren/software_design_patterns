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
    public static void main(String[] args) throws SQLException {
        DBConnection.DB_CONN.startConnection();
        AbstractLogger<String> logger = new ConsoleLogger();

        MoneyReserve.MONEY_RESERVE.addToReserve(4000, logger);
        MoneyReserve.MONEY_RESERVE.takeFromReserve(2000, logger);

        logger = new DatabaseLogger();
        Customer atakan = new Customer.Builder("ataman.atik@ozu.edu.tr", "mypass")
                .withName("Atakan").withSurname("Atik").withAddress("Atasehir").withSalary(2400).withAge(24).build();
        atakan.signUp(logger);
        Customer deniz = new Customer.Builder("deniz.gunseren@ozu.edu.tr", "denizpass")
                .withName("Deniz").withSurname("Gunseren").withAddress("Besiktas").withSalary(3500).withAge(24).build();
        deniz.signUp(logger);

        logger = new ConsoleLogger();
        Customer atakanLogsIn = new Customer.Builder("ataman.atik@ozu.edu.tr", "mypass").build().signIn(logger);

        VisitableAccount account = new Account();
        account.accept(new AccountVisitor(atakanLogsIn, logger));

        logger = new DatabaseLogger();
        Transactions fastTransaction = new Transaction(atakanLogsIn, "deniz.gunseren@ozu.edu.tr", 1000, new FastTransaction(logger));
        fastTransaction.transfer();

        Transactions bulkTransaction = new Transaction(atakanLogsIn, "deniz.gunseren@ozu.edu.tr", 2000, new BulkTransaction(logger));
        bulkTransaction.transfer();
    }
}
