import abstracts.Transactions;
import modals.Customer;
import modals.DBConnection;
import modals.MoneyReserve;
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

        System.out.println("Hello Java");
        MoneyReserve.MONEY_RESERVE.addToReserve(4000);
        System.out.println("total money in reserve " + MoneyReserve.MONEY_RESERVE.getTotalMoneyInReserve());
        MoneyReserve.MONEY_RESERVE.takeFromReserve(2000);
        System.out.println("total money in reserve " + MoneyReserve.MONEY_RESERVE.getTotalMoneyInReserve());

//        Customer.CUSTOMER.setName("Atakan");
//        Customer.CUSTOMER.setSurname("Atik");
//        Customer.CUSTOMER.setAddress("Atasehir");
//        Customer.CUSTOMER.setAge(24);
//        Customer.CUSTOMER.setSalary(2400);
//        Customer.CUSTOMER.setPassword("mypass");
//        Customer.CUSTOMER.setEmail("ataman.atik@ozu.edu.tr");
//        Customer.CUSTOMER.signUp();


//        Customer.CUSTOMER.setName("Deniz");
//        Customer.CUSTOMER.setSurname("Gunseren");
//        Customer.CUSTOMER.setAddress("Besiktas");
//        Customer.CUSTOMER.setAge(24);
//        Customer.CUSTOMER.setSalary(3500);
//        Customer.CUSTOMER.setPassword("denizpass");
//        Customer.CUSTOMER.setEmail("deniz.gunseren@ozu.edu.tr");
//        Customer.CUSTOMER.signUp();

//        Customer.CUSTOMER.setEmail("ataman.atik@ozu.edu.tr");
//        Customer.CUSTOMER.setPassword("mypass");
//        Customer.CUSTOMER.signIn();
//        System.out.println(Customer.CUSTOMER.getName() + " " + Customer.CUSTOMER.getSurname() + " " + Customer.CUSTOMER.getAccountBalance());

        Transactions fastTransaction = new Transaction("ataman.atik@ozu.edu.tr", "deniz.gunseren@ozu.edu.tr", 1000, new FastTransaction());
        fastTransaction.transfer();

        Transactions bulkTransaction = new Transaction("ataman.atik@ozu.edu.tr", "deniz.gunseren@ozu.edu.tr", 200000, new BulkTransaction());
        bulkTransaction.transfer();
    }
}
