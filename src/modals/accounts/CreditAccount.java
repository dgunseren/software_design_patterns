package modals.accounts;

import interfaces.VisitableAccount;
import interfaces.Visitor;

public class CreditAccount implements VisitableAccount {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void CashAccountBalance() {}
    public void SavingAccountBalance() {}
    public void CarLoanAccountBalance() {}
    public void HouseLoanAccountBalance() {}

}
