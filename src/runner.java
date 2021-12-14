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
    public static void main(String args[]){
        System.out.println("Hello Java");
        MoneyReserve.MONEY_RESERVE.addToReserve(4000);
        System.out.println("total money in reserve " + MoneyReserve.MONEY_RESERVE.getTotalMoneyInReserve());
        MoneyReserve.MONEY_RESERVE.takeFromReserve(2000);
        System.out.println("total money in reserve " + MoneyReserve.MONEY_RESERVE.getTotalMoneyInReserve());

        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bankingapi", "postgres", "postgres")) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM people");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name") + " " + resultSet.getString("surname") + " " + resultSet.getString("address"));
            }

        }  catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
    }
}
