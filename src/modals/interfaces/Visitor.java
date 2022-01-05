package modals.interfaces;

import modals.accounts.*;

public interface Visitor {
    void visit(Account account);
    void visit(CreditAccount creditAccount);
    void visit(CarLoanAccount carLoanAccount);
    void visit(HouseLoanAccount houseLoanAccount);
    void visit(SavingsAccount savingsAccount);
}
