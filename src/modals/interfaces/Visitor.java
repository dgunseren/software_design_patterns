package modals.interfaces;

import modals.accounts.*;

public interface Visitor {
    double visit(CreditAccount creditAccount);
    double visit(CarLoanAccount carLoanAccount);
    double visit(HouseLoanAccount houseLoanAccount);
    double visit(SavingsAccount savingsAccount);
}
