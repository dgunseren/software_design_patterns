public class CreditAccountVisitor implements Visitor{


    @Override
    public void visit(CashAccount cashAccount) {
        int cash_balance = new CashAccount().cashAccountBalance();

        System.out.println(cash_balance);
    }
}
