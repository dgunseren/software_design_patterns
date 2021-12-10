import java.util.Scanner;

public class Client {
    public static void main(String args[]) {


        Scanner user_preference_menu = new Scanner(System.in);
        System.out.print("What do you want to see\n1-Credit\n2-Debit : ");
        if (user_preference_menu.nextInt() == 1) {
            CreditAccountVisitor creditAccountVisitor = new CreditAccountVisitor();

            Scanner user_preference_submenu = new Scanner(System.in);
            System.out.print("What do you want to see\n1-Cash\n2-Saving\n3-Car Loan\n4-House Loan : ");

            if (user_preference_submenu.nextInt() == 1) {
                creditAccountVisitor.CashAccountBalance();
            }
            if (user_preference_submenu.nextInt() == 2) {
                creditAccountVisitor.SavingAccountBalance();
            }
            if (user_preference_submenu.nextInt() == 3) {
                creditAccountVisitor.CarLoanAccountBalance();
            }
            if (user_preference_submenu.nextInt() == 4) {
                creditAccountVisitor.HouseLoanAccountBalance();
            }




        }


    }
}