public class CreditAccountVisitor implements Visitor{


    @Override
    public void visit(CreditAccount creditAccount) {
        int cash_balance = new CreditAccount().cashAccountBalance();

        System.out.println(cash_balance);
    }
}
