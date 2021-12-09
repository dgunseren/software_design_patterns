public class runner {
    public static CashAccount cashaccount;


    public static void calculateBalance() {

        CreditAccountVisitor visitor = new CreditAccountVisitor();
        cashaccount.accept(visitor);

    }
}
