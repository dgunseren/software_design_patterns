import java.io.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class CreditAccount implements VisitableAccount {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);

    }

    int cashAccount ;

    public int cashAccountBalance() {

        try {
            File myObj = new File("C:\\Users\\Deniz Günseren\\Desktop\\sdp\\cash_Account.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine().toLowerCase();
                 cashAccount =   Integer.valueOf(data);
                 System.out.println(cashAccount);


                 }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }



        return cashAccount;
    }
}
