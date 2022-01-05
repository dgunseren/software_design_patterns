import modals.DBConnection;
import views.LoginView;
import views.SignUpView;

import javax.swing.*;
import java.sql.SQLException;

class runner extends JFrame{
    public static void main(String[] args) {
        DBConnection.DB_CONN.startConnection();
        new LoginView();


//        AbstractLogger<String> logger = new ConsoleLogger();
//
//        MoneyReserve.MONEY_RESERVE.addToReserve(4000, logger);
//        MoneyReserve.MONEY_RESERVE.takeFromReserve(2000, logger);
//
//        logger = new DatabaseLogger();
//        Customer atakan = new Customer.Builder("ataman.atik@ozu.edu.tr", "mypass")
//                .withName("Atakan").withSurname("Atik").withAddress("Atasehir").withSalary(2400).withAge(24).build();
//        atakan.signUp(logger);
//        Customer deniz = new Customer.Builder("deniz.gunseren@ozu.edu.tr", "denizpass")
//                .withName("Deniz").withSurname("Gunseren").withAddress("Besiktas").withSalary(3500).withAge(24).build();
//        deniz.signUp(logger);
//
//        logger = new ConsoleLogger();
//        Customer atakanLogsIn = new Customer.Builder("ataman.atik@ozu.edu.tr", "mypass").build().signIn(logger);
//
//        VisitableAccount account = new Account();
//        account.accept(new AccountVisitor(atakanLogsIn, logger));
//
//        logger = new DatabaseLogger();
//        Transactions fastTransaction = new Transaction(atakanLogsIn, "deniz.gunseren@ozu.edu.tr", 1000, new FastTransaction(logger));
//        fastTransaction.transfer();
//
//        Transactions bulkTransaction = new Transaction(atakanLogsIn, "deniz.gunseren@ozu.edu.tr", 2000, new BulkTransaction(logger));
//        bulkTransaction.transfer();
//
//        ATMDispenseChain atmDispenser = new ATMDispenseChain();
//        atmDispenser.c1.dispense(1560);
//        atakanLogsIn.setAccountBalance(atakanLogsIn.getAccountBalance() - 1560);
//
//        Capital capital = new Capital();
//        new EuroObserver(capital);
//        new DollarObserver(capital);
//
//        System.out.println("Your Balance :");
//        capital.setAmount(atakanLogsIn.getAccountBalance());
    }
}
