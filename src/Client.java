
public class Client {
    public static void main(String args[]) {

        calculateBalance();


    }




        public static void calculateBalance() {
              CashAccount cashaccount = new CashAccount();
            

            CreditAccountVisitor visitor = new CreditAccountVisitor();

            cashaccount.accept(visitor);

        }



}