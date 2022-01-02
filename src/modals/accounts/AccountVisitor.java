package modals.accounts;

import abstracts.AbstractLogger;
import interfaces.Visitor;
import modals.Customer;

public class AccountVisitor implements Visitor {
    private AbstractLogger<String> logger;
    private Customer customer;

    public AccountVisitor(Customer customer, AbstractLogger<String> logger) {
        this.logger = logger;
        this.customer = customer;
    }

    @Override
    public void visit(Account account) {}

    @Override
    public void visit(CreditAccount creditAccount) {
        creditAccount.displayCreditAccount(this.customer, this.logger);
    }

    @Override
    public void visit(CarLoanAccount carLoanAccount) {
        carLoanAccount.displayCarLoan(this.customer, this.logger);
    }

    @Override
    public void visit(HouseLoanAccount houseLoanAccount) {
        houseLoanAccount.displayHouseLoan(this.customer, this.logger);
    }

    @Override
    public void visit(SavingsAccount savingsAccount) {
        savingsAccount.displaySaving(this.customer, this.logger);
    }
}
