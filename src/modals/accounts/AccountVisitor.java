package modals.accounts;

import abstracts.AbstractLogger;
import interfaces.Visitor;

public class AccountVisitor implements Visitor {
    private AbstractLogger<String> logger;

    public AccountVisitor(AbstractLogger<String> logger) {
        this.logger = logger;
    }

    @Override
    public void visit(Account account) {}

    @Override
    public void visit(CreditAccount creditAccount) {
        creditAccount.displayCreditAccount(this.logger);
    }

    @Override
    public void visit(CarLoanAccount carLoanAccount) {
        carLoanAccount.displayCarLoan(this.logger);
    }

    @Override
    public void visit(HouseLoanAccount houseLoanAccount) {
        houseLoanAccount.displayHouseLoan(this.logger);
    }

    @Override
    public void visit(SavingsAccount savingsAccount) {
        savingsAccount.displaySaving(this.logger);
    }
}
