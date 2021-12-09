
public class Client {
    public static void main(String args[]) {

        calculateBalance();


    }




        public static void calculateBalance() {
              CreditAccount creditAccount = new CreditAccount();
            

            CreditAccountVisitor visitor = new CreditAccountVisitor();

            creditAccount.accept(visitor);

        }



}